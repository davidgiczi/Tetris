
package com.david.giczi.tetris.model;

import com.david.giczi.tetris.shape.RightGunShape;
import com.david.giczi.tetris.shape.AbstractShape;
import com.david.giczi.tetris.shape.TShape;
import com.david.giczi.tetris.shape.LeftGunShape;
import com.david.giczi.tetris.shape.PillarShape;
import com.david.giczi.tetris.shape.LeftStairShape;
import com.david.giczi.tetris.shape.RightStairShape;
import com.david.giczi.tetris.shape.SquareShape;
import com.googlecode.lanterna.TextColor;

/**
 *
 * @author GicziD
 */
public class ShapeFactory {
    
    private static final TextColor[] SHAPE_COLOR = {TextColor.ANSI.BLUE,
                                                    TextColor.ANSI.CYAN,
                                                    TextColor.ANSI.DEFAULT,
                                                    TextColor.ANSI.GREEN,
                                                    TextColor.ANSI.MAGENTA,
                                                    TextColor.ANSI.RED,
                                                    TextColor.ANSI.YELLOW
    };
    
    public static AbstractShape getShape(){
        
        AbstractShape shape;
        int percentValue = (int) (Math.random() * 105);
        ShapePosition starterPosition = new ShapePosition(10, 6);

            if(0 <= percentValue && percentValue < 15) {
                
                shape = new PillarShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }
            else if(15 <= percentValue && percentValue < 30) {
                
                shape = new SquareShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }   
            else if(30 <= percentValue && percentValue < 45) {
                
                shape = new TShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }   
            else if(45 <= percentValue && percentValue < 60) {
                
                shape = new LeftGunShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }   
            else if(60 <= percentValue && percentValue < 75) {
                
                shape = new RightGunShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }   
            else if(75 <= percentValue && percentValue < 90) {
                
                shape = new LeftStairShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }
            else{
                
                shape = new RightStairShape(starterPosition,
                        SHAPE_COLOR[(int) (Math.random() * SHAPE_COLOR.length)]);
            }
            
        return shape;
    }
    
    
}
