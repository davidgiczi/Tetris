package com.david.giczi.tetris.shape;

import com.david.giczi.tetris.model.ShapePosition;
import com.googlecode.lanterna.TextColor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GicziD
 */
public abstract class AbstractShape {

    public TextColor shapeColor;
    public List<ShapePosition> shapeComponent;
    public List<Boolean> shapeRotationPosition;

    public AbstractShape() {
        this.shapeComponent = new ArrayList<>();
    }

    public void addShapeToGameBoard() {

        shapeComponent.clear();
        createShape(new ShapePosition(randStarterXPositionForGameBoard(), 2));

    }

    ;
    
    private int randStarterXPositionForGameBoard() {

        return 2 * ((int) (Math.random() * 7)) + 28;
    }

    public List<Boolean> initShapeRotationPosition() {
        List<Boolean> temp = new ArrayList<>();
        temp.add(Boolean.TRUE);
        for (int i = 0; i < 3; i++) {
            temp.add(Boolean.FALSE);
        }
        return temp;
    }

    public abstract void createShape(ShapePosition starterPosition);

    public abstract List<ShapePosition> rotateShape();

    public abstract List<ShapePosition> moveToLeft();

    public abstract List<ShapePosition> moveToRight();

    public abstract List<ShapePosition> moveToDown();

}
