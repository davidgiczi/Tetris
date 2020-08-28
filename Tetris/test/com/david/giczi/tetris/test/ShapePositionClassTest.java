package com.david.giczi.tetris.test;

import com.david.giczi.tetris.model.ShapePosition;
import com.david.giczi.tetris.view.Displayer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GicziD
 */
public class ShapePositionClassTest {

    @Test
    public void testConvertDisplayerCoordsToLogicBoardIndexMethod() {

        List<ShapePosition> posiStore = new ArrayList<>();

        for (int y = ShapePosition.VR_SHIFT; 
                y < ShapePosition.VR_SHIFT + Displayer.LENGTH_OF_BOARD; y++) {

            for (int x = ShapePosition.HR_SHIFT;
                x < ShapePosition.HR_SHIFT + Displayer.LENGTH_OF_BOARD; x += 2) {

                posiStore.add(new ShapePosition(x, y));
            }
        }

        //posiStore.forEach(p -> System.out.println(p));

        int logicBoardIndex = 0;

        for (ShapePosition shapePosition : posiStore) {
            assertEquals(logicBoardIndex++, shapePosition.getLogicBoardIndex());
        }

    }

    @Test
    public void negativeTestConvertDisplayerCoordsToLogicBoardIndexMethod() {

        List<ShapePosition> posiStore = new ArrayList<>();

        for (int y = 0; y < ShapePosition.VR_SHIFT; y++) {

            for (int x = 0; x < ShapePosition.HR_SHIFT; x += 2) {

                posiStore.add(new ShapePosition(x, y));
            }
        }

        for (int y = ShapePosition.VR_SHIFT + Displayer.LENGTH_OF_BOARD; y < 100; y++) {

            for (int x = ShapePosition.HR_SHIFT + Displayer.LENGTH_OF_BOARD; x < 100; x += 2) {

                posiStore.add(new ShapePosition(x, y));
            }
        }

        int logicBoardIndex = -1;

        posiStore.forEach((shapePosition) -> {
            assertEquals(logicBoardIndex, shapePosition.getLogicBoardIndex());
        });

    }

    @Test
    public void testConvertLogicBoardIndexToDisplayerCoords() {

        List<ShapePosition> posiStore1 = new ArrayList<>();

        for (int index = 0; 
            index < Displayer.LENGTH_OF_BOARD * Displayer.WIDTH_OF_BOARD; index++) {
            posiStore1.add(new ShapePosition(index));
        }

        //posiStore1.forEach(p -> System.out.println(p));

        List<ShapePosition> posiStore2 = new ArrayList<>();

        for (int y = ShapePosition.VR_SHIFT; 
                 y < ShapePosition.VR_SHIFT + Displayer.LENGTH_OF_BOARD; y++) {

            for (int x = ShapePosition.HR_SHIFT; 
                 x < ShapePosition.HR_SHIFT + Displayer.LENGTH_OF_BOARD; x += 2) {

                posiStore2.add(new ShapePosition(x, y));
            }
        }

        for (int i = 0; i < posiStore1.size(); i++) {

            assertEquals(posiStore2.get(i).getDisplayer_x(),
                    posiStore1.get(i).getDisplayer_x());
            assertEquals(posiStore2.get(i).getDisplayer_y(),
                    posiStore1.get(i).getDisplayer_y());
        }

    }

    @Test
    public void negativeTestConvertLogicBoardIndexToDisplayerCoords() {

       for(int index = 200; index < 300; index++){
           
           assertEquals(-1, new ShapePosition(index).getDisplayer_x());
           assertEquals(-1, new ShapePosition(index).getDisplayer_y());
       }
    }
    
    
}
