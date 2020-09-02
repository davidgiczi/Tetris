package com.david.giczi.tetris.controller;

import com.david.giczi.tetris.listener.Play;
import com.david.giczi.tetris.shape.AbstractShape;
import com.david.giczi.tetris.model.GameLogic;
import com.david.giczi.tetris.numbershape.NumberShape;
import com.david.giczi.tetris.model.ShapeFactory;
import com.david.giczi.tetris.model.ShapePosition;
import com.david.giczi.tetris.view.Displayer;
import java.io.IOException;
import java.util.List;
import javax.swing.Timer;


/**
 *
 * @author GicziD
 */
public class TetrisGame {

    private final Displayer board;
    private final GameLogic logic;
    private AbstractShape nextShape;
    private AbstractShape actualShape;
    private NumberShape score;
    private NumberShape level;
    private final Timer timer = new Timer(1000, new Play(this));
   

    public TetrisGame() throws IOException {

        board = new Displayer();
        board.displayStarterPage();
        logic = new GameLogic();
    }

    public void playGame() throws IOException {

        boolean isKeyPressed = true;

        while (isKeyPressed) {

            board.setKeyPress(board.getTerminal().pollInput());

            if (board.getKeyPress() != null) {

                switch (board.getKeyPress().getKeyType()) {

                    case Escape:
                        System.exit(0);
                        break;
                    case Enter:
                        initGame();
                        break;
                    case ArrowLeft:
                        stepShapeLeft();
                        break;
                    case ArrowRight:
                        stepShapeRight();
                        break;
                    case ArrowDown:
                        stepShapeDown();
                        break;
                    case ArrowUp:
                        rotateShape();
                        break;
                    case PageUp:
                        increaseLevel();
                        break;
                    case PageDown:
                        decreaseLevel();
                        break;
                    case Tab:
                        stopGame();
                        break;

                }

            }

        }

    }

    private void initGame() throws IOException {

        board.getScreen().clear();
        logic.initGame();
        board.displayGameBoard(23, 2);
        board.displayKeyOption(63, 0);
        score = new NumberShape(-10, new ShapePosition(72, 17));
        board.displayNumberShape(score);
        nextShape = ShapeFactory.getShape();
        board.displayShape(nextShape);
        actualShape = ShapeFactory.getShape();
        logic.addShapeToLogicBoard(actualShape);
        actualShape.addShapeToGameBoard();
        board.displayShape(actualShape);
        level = new NumberShape(logic.getLevel() + 1,
                new ShapePosition(10, 17));
        board.displayNumberShape(level);
        logic.addShapeToStore(actualShape);
        timer.setDelay(logic.getDelay());
        timer.start();
    }

    private synchronized void displayLevel() throws IOException {
        board.clearScreen(level.shapeComponent);
        level = new NumberShape(logic.getLevel() + 1,
                new ShapePosition(10, 17));
        board.displayNumberShape(level);
    }

    private synchronized void stepShapeLeft() throws IOException {

        if (logic.canShapeBeMovedToLeft(actualShape) && timer.isRunning()) {
            List<ShapePosition> deletedPosition = actualShape.moveToLeft();
            logic.clearLogicBoard(deletedPosition);
            logic.moveLogicShape(actualShape);
            board.clearScreen(deletedPosition);
            board.displayShape(actualShape);
           
        }

    }

    private synchronized void stepShapeRight() throws IOException {

        if (logic.canShapeBeMovedToRight(actualShape) && timer.isRunning()) {
            List<ShapePosition> deletedPosition = actualShape.moveToRight();
            logic.clearLogicBoard(deletedPosition);
            logic.moveLogicShape(actualShape);
            board.clearScreen(deletedPosition);
            board.displayShape(actualShape);
        }

    }

    private synchronized void stepShapeDown() throws IOException {

        if (logic.canShapeBeMovedToDown(actualShape) && timer.isRunning()) {
            List<ShapePosition> deletedPosition = actualShape.moveToDown();
            logic.clearLogicBoard(deletedPosition);
            logic.moveLogicShape(actualShape);
            board.clearScreen(deletedPosition);
            board.displayShape(actualShape);
        }

    }

    private synchronized void rotateShape() throws IOException {

        if (logic.canShapeBeRotated(actualShape) && timer.isRunning()) {
            List<ShapePosition> deletedPosition = actualShape.rotateShape();
            logic.clearLogicBoard(deletedPosition);
            logic.moveLogicShape(actualShape);
            board.clearScreen(deletedPosition);
            board.displayShape(actualShape);
        }

    }

    private void increaseLevel() throws IOException {

        logic.increaseLevelValue();
        timer.setDelay(logic.getDelay());
        displayLevel();

    }

    private void decreaseLevel() throws IOException {

        logic.decreaseLevelValue();
        timer.setDelay(logic.getDelay());
        displayLevel();
    }

    public void play() throws IOException {

        if (logic.canShapeBeMovedToDown(actualShape)) {

            stepShapeDown();
            
        } else {

            List<Integer> completeTrueRowsIndex = logic.getCompleteTrueRowsIndex();

            if (!completeTrueRowsIndex.isEmpty()) {
                runCompleteTrueRowProcess(completeTrueRowsIndex);

            } else {
                displayScore();
            }

            increaseLevelValueByScoreValue();

            if (!logic.isTheEndOfTheGame()) {

                actualShape = nextShape;
                logic.addShapeToStore(nextShape);
                board.clearScreen(nextShape.shapeComponent);
                actualShape.addShapeToGameBoard();
                logic.addShapeToLogicBoard(actualShape);
                board.displayShape(actualShape);
                nextShape = ShapeFactory.getShape();                                            
                board.displayShape(nextShape);
                
            } else {

                timer.stop();
                board.displayGameOver(27, 1);
            }
          
        }

    }

    private void increaseLevelValueByScoreValue() throws IOException {

        logic.increaseLevelValueByScoreValue();
        timer.setDelay(logic.getDelay());
        displayLevel();
    }
    
    private void displayScore() throws IOException {
        logic.calcScore(actualShape);
        board.clearScreen(score.shapeComponent);
        if (logic.getScore() == 0) {
            score = new NumberShape(-10, new ShapePosition(72, 17));
        } else {
            score = new NumberShape(logic.getScore(), new ShapePosition(72, 17));
        }
        board.displayNumberShape(score);
    }

    private void runCompleteTrueRowProcess(List<Integer> completeTrueRowsIndex) throws IOException {

        logic.setScore(logic.getScore() + completeTrueRowsIndex.size() * 100);
        board.clearScreen(score.shapeComponent);
        score = new NumberShape(logic.getScore(), new ShapePosition(72, 17));
        board.displayNumberShape(score);
        clearGameBoard(logic.getShapeStore());
        logic.deleteCompleteTrueRowsFromShapeComponent(completeTrueRowsIndex);
        logic.increaseRowNumberForShapeComponentInShapeStore(completeTrueRowsIndex);
        logic.refreshLogicBoard();
        refreshGameBoard(logic.getShapeStore());
    }

    private void clearGameBoard(List<AbstractShape> shapeStore) throws IOException {

        for (AbstractShape shape : shapeStore) {
            board.clearScreen(shape.shapeComponent);
        }
    }

    private void refreshGameBoard(List<AbstractShape> shapeStore) throws IOException {

        for (AbstractShape shape : shapeStore) {
            board.displayShape(shape);
        }

    }
                            
    private void stopGame(){
        
        if(timer.isRunning()){
            timer.stop();
        }
        else{
            timer.start();
        }
        
    }

}
