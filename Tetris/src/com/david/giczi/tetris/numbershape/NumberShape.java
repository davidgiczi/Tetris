
package com.david.giczi.tetris.numbershape;

import com.david.giczi.tetris.model.ShapePosition;
import com.david.giczi.tetris.shape.AbstractShape;
import com.googlecode.lanterna.TextColor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GicziD
 */
public class NumberShape extends AbstractShape{
    
    private int displayedValue;
    public List<Integer> digitValue;
   

    public NumberShape(int displayedValue, ShapePosition starterPosition) {
        
        this.displayedValue = displayedValue;
        this.shapeColor = TextColor.ANSI.CYAN;
        this.digitValue = getDigitValues();
        createShape(starterPosition);
    }

    public void setNumberShapeColor(TextColor numberShapeColor) {
        this.shapeColor = numberShapeColor;
    }
    
    private List<Integer> getDigitValues(){
        
        digitValue = new ArrayList<>();
        
        while(displayedValue != 0){
            
            digitValue.add(displayedValue % 10);
            displayedValue /= 10;
        }
        
        return digitValue;
        
    }

    @Override
    public final void createShape(ShapePosition starterPosition) {
        
        for (Integer digit : digitValue) {
            
            switch(digit){
                
                case 0 :
                  new ZeroNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 1 :
                    new OneNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
         
                case 2 :
                    new TwoNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 3 :
                    new ThreeNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 4 :
                    new FourNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 5:
                    new FiveNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 6:
                    new SixNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 7:
                    new SevenNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 8:
                    new EightNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component));
                    break;
                    
                case 9:
                    new NineNumberShape(starterPosition, shapeColor)
                          .shapeComponent.forEach(component -> shapeComponent.add(component)); 
                       
            }
            
            
            starterPosition = new ShapePosition(starterPosition.getDisplayer_x() - 6,
                    starterPosition.getDisplayer_y());
        }
 
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
