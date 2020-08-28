package com.david.giczi.tetris.listener;

import com.david.giczi.tetris.controller.TetrisGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GicziD
 */
public class Play implements ActionListener {

    private final TetrisGame tetris;

    public Play(TetrisGame tetris) {
        this.tetris = tetris;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            tetris.play();

        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
