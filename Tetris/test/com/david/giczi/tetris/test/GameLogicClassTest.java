package com.david.giczi.tetris.test;

import com.david.giczi.tetris.shape.AbstractShape;
import com.david.giczi.tetris.model.GameLogic;
import com.david.giczi.tetris.shape.LeftGunShape;
import com.david.giczi.tetris.shape.LeftStairShape;
import com.david.giczi.tetris.shape.PillarShape;
import com.david.giczi.tetris.shape.RightGunShape;
import com.david.giczi.tetris.shape.RightStairShape;
import com.david.giczi.tetris.model.ShapePosition;
import com.david.giczi.tetris.shape.SquareShape;
import com.david.giczi.tetris.shape.TShape;
import com.david.giczi.tetris.view.Displayer;
import com.googlecode.lanterna.TextColor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GicziD
 */
public class GameLogicClassTest {

    @Test
    public void testAddShapeToLogicBoard1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        for (int i = 0; i < logic.getLogicBoard().size(); i++) {

            if (i < 3 || i == 11) {
                assertTrue(logic.getLogicBoard().get(i));
            } else {

                assertFalse(logic.getLogicBoard().get(i));
            }
        }

    }

    @Test
    public void testAddShapeToLogicBoard2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        for (int i = 0; i < logic.getLogicBoard().size(); i++) {

            assertFalse(logic.getLogicBoard().get(i));

        }

    }

    @Test
    public void testCanPillarShapeBeMovedToLeft1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToLeft(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToLeft2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(30, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToLeft(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToLeft3() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToLeft(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToLeft4() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(30, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToLeft(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToRight1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(40, 21), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToRight(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToRight2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(38, 21), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToRight(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToRight3() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToRight(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToRight4() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.moveToRight();
        shape.moveToRight();
        shape.moveToRight();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToRight(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToDown1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToDown(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToDown2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(40, 21), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToDown(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToDown3() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToDown(shape));

    }

    @Test
    public void testCanPillarShapeBeMovedToDown4() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(36, 18), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToDown(shape));

    }

    @Test
    public void testCanPillarShapeBeRotated1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeRotated(shape));

    }

    @Test
    public void testCanPillarShapeBeRotated2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeRotated(shape));

    }

    @Test
    public void testCanPillarShapeBeRotated3() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new PillarShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeRotated(shape));

    }

    @Test
    public void testCanSquareShapeBeMovedToLeft1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }

    @Test
    public void testCanSquareShapeBeMovedToLeft2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }

    @Test
    public void testCanSquareShapeBeMovedToRight1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToRight(shape));
    }

    @Test
    public void testCanSquareShapeBeMovedToRight2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertFalse(logic.canShapeBeMovedToRight(shape));
    }

    @Test
    public void testCanSquareShapeBeMovedToDown1() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(30, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();

        assertTrue(logic.canShapeBeMovedToDown(shape));

    }
    
    @Test
    public void testCanSquareShapeBeMovedToDown2() {

        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new SquareShape(new ShapePosition(30, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());

        assertFalse(logic.canShapeBeMovedToDown(shape));

    }
    
    @Test
    public void testCanTShapeBeMovedToLeft1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToLeft2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToLeft3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToLeft4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToLeft5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
       
    }
    
     @Test
    public void testCanTShapeBeMovedToLeft6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
       
    }
    
     @Test
    public void testCanTShapeBeMovedToLeft7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToLeft8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(42, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToRight8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
       
    }
     
    @Test
    public void testCanTShapeBeMovedToDown5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanTShapeBeMovedToDown6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeMovedToDown8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(24, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
       
    }
    
    @Test
    public void testCanTShapeBeRotated1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanTShapeBeRotated2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    
     @Test
    public void testCanTShapeBeRotated3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanTShapeBeRotated4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(42, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
     @Test
    public void testCanTShapeBeRotated5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
     @Test
    public void testCanTShapeBeRotated6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(40, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
         
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanTShapeBeRotated7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
         
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanTShapeBeRotated8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new TShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
       // displayLogicBoard(logic.getLogicBoard());
         
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToLeft1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToLeft2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    
    @Test
    public void testCanLeftGunShapeBeMovedToLeft3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    
     @Test
    public void testCanLeftGunShapeBeMovedToLeft4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
     @Test
    public void testCanLeftGunShapeBeMovedToLeft5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToLeft6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
     @Test
    public void testCanLeftGunShapeBeMovedToLeft7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToLeft8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(42, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
   
    @Test
    public void testCanLeftGunShapeBeMovedToRight7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToRight8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeMovedToDown8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeRotated1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeRotated2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeRotated3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeRotated4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(42, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
     @Test
    public void testCanLeftGunShapeBeRotated5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
     @Test
    public void testCanLeftGunShapeBeRotated6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftGunShapeBeRotated7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
     @Test
    public void testCanLeftGunShapeBeRotated8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftGunShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToLeft1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    
     @Test
    public void testCanRightGunShapeBeMovedToLeft2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToLeft3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToLeft4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToLeft5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToLeft6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToLeft7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
   
     @Test
    public void testCanRightGunShapeBeMovedToLeft8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToRight1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToRight2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToRight3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
   
    @Test
    public void testCanRightGunShapeBeMovedToRight4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(42, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToRight5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToRight6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToRight7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToRight8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToDown1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
  
    @Test
    public void testCanRightGunShapeBeMovedToDown2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
  
    @Test
    public void testCanRightGunShapeBeMovedToDown3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToDown4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToDown5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
     @Test
    public void testCanRightGunShapeBeMovedToDown6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToDown7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeMovedToDown8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(40, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(42, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated5(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated6(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(40, 20), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated7(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightGunShapeBeRotated8(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightGunShape(new ShapePosition(24, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        shape.rotateShape();
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToLeft1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToLeft2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
     
    @Test
    public void testCanLeftStairShapeBeMovedToLeft3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToLeft4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToRight1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
     @Test
    public void testCanLeftStairShapeBeMovedToRight2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToRight3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToRight4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToDown1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToDown2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToDown3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeMovedToDown4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(24, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeRotated1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeRotated2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeRotated3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanLeftStairShapeBeRotated4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new LeftStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    
    @Test
    public void testCanRightStairShapeBeMovedToLeft1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToLeft2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(28, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToLeft3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToLeft4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToLeft(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToRight1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToRight2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToRight3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToRight(shape));
    }
    
     @Test
    public void testCanRightStairShapeBeMovedToRight4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(40, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToRight(shape));
    }
    
     @Test
    public void testCanRightStairShapeBeMovedToDown1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToDown2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToDown3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertTrue(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeMovedToDown4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(24, 19), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
        
        assertFalse(logic.canShapeBeMovedToDown(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeRotated1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
          
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeRotated2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 20), TextColor.ANSI.MAGENTA);
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
          
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeRotated3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(26, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
          
        assertTrue(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCanRightStairShapeBeRotated4(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        AbstractShape shape = new RightStairShape(new ShapePosition(24, 2), TextColor.ANSI.MAGENTA);
        shape.rotateShape();
        logic.addShapeToLogicBoard(shape);
        //logic.displayLogicBoard();
          
        assertFalse(logic.canShapeBeRotated(shape));
    }
    
    @Test
    public void testCompleteRowsIndex1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        List<Integer> completeRowsIndex = logic.getCompleteTrueRowsIndex();
        assertTrue(completeRowsIndex.isEmpty());
    }
    
    @Test
    public void testCompleteRowsIndex2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        for(int i = 0; i < 10; i++){
            logic.getLogicBoard().set(i, Boolean.TRUE);
        }
        
        List<Integer> completeRowsIndex = logic.getCompleteTrueRowsIndex();
        
        assertTrue(0 == completeRowsIndex.get(0));
        
        for(int i = 100; i < 110; i++){
            logic.getLogicBoard().set(i, Boolean.TRUE);
        }
        
        completeRowsIndex = logic.getCompleteTrueRowsIndex();
        
        assertTrue(0 == completeRowsIndex.get(0) &&
                  10 == completeRowsIndex.get(1));
        
        for(int i = 190; i < 200; i++){
            logic.getLogicBoard().set(i, Boolean.TRUE);
        }
        
        completeRowsIndex = logic.getCompleteTrueRowsIndex();
        
        assertTrue(0 == completeRowsIndex.get(0) &&
                  10 == completeRowsIndex.get(1) &&
                  19 == completeRowsIndex.get(2));
        
       //logic.displayLogicBoard();
      
    }
    
    @Test
    public void testCompleteRowsIndex3(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        for(int i = 30; i < 39; i++){
            logic.getLogicBoard().set(i, Boolean.TRUE);
        }
       // displayLogicBoard(logic.getLogicBoard());
        List<Integer> completeRowsIndex = logic.getCompleteTrueRowsIndex();
        
        assertTrue(completeRowsIndex.isEmpty());
        
    }
    
   
    @Test
    public void testIsEndOfTheGame1(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        assertFalse(logic.isTheEndOfTheGame());
    }
    
    @Test
    public void testIsEndOfTheGame2(){
        
        GameLogic logic = new GameLogic();
        logic.initGame();
        
        for(int i = 0; i < Displayer.WIDTH_OF_BOARD; i++){
       
        logic.getLogicBoard().set(Displayer.WIDTH_OF_BOARD + i, Boolean.TRUE);
            
        //logic.displayLogicBoard();
        assertTrue(logic.isTheEndOfTheGame());
        logic.initGame();
        
        }
        
    }
    
    
   

}
