
package com.david.giczi.tetris.numbershape;

import com.david.giczi.tetris.model.ShapePosition;
import com.david.giczi.tetris.shape.AbstractShape;
import com.googlecode.lanterna.TextColor;
import java.util.List;

/**
 *
 * @author GicziD
 */
public class ZeroNumberShape extends AbstractShape{

    
     public ZeroNumberShape(ShapePosition starterPosition, TextColor shapeColor) {
        this.shapeColor = shapeColor;
        createShape(starterPosition);
    }
    
    
    @Override
    public final void createShape(ShapePosition starterPosition) {
        
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 1,
                starterPosition.getDisplayer_y()));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 2,
                starterPosition.getDisplayer_y()));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 3,
                starterPosition.getDisplayer_y()));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x(),
                starterPosition.getDisplayer_y() + 1));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x(),
                starterPosition.getDisplayer_y() + 2));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x(),
                starterPosition.getDisplayer_y() + 3));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x() + 4,
                starterPosition.getDisplayer_y() + 1));
         shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x() + 4,
                starterPosition.getDisplayer_y() + 2));
         shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x() + 4,
                starterPosition.getDisplayer_y() + 3));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 1,
                starterPosition.getDisplayer_y() + 4));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 2,
                starterPosition.getDisplayer_y() + 4));
        shapeComponent.add(new ShapePosition(starterPosition.getDisplayer_x()+ 3,
                starterPosition.getDisplayer_y() + 4));
    }

    @Override
    public List<ShapePosition> rotateShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ShapePosition> moveToLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ShapePosition> moveToRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ShapePosition> moveToDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
