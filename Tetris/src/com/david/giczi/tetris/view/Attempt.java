
package com.david.giczi.tetris.view;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

/**
 *
 * @author GicziD
 */
public class Attempt {

    public Attempt() throws IOException {
        
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.ANSI.BLUE);
        screen.startScreen();

        tg.drawLine(29, 21, 36, 21, Symbols.BLOCK_SOLID);
        
        tg.drawLine(41, 21, 42, 21, Symbols.BLOCK_SOLID);
        tg.drawLine(41, 20, 42, 20, Symbols.BLOCK_SOLID);
        tg.drawLine(41, 19, 42, 19, Symbols.BLOCK_SOLID);
        tg.drawLine(41, 18, 42, 18, Symbols.BLOCK_SOLID);
        
        
        tg.setForegroundColor(TextColor.ANSI.MAGENTA);
        
        tg.drawLine(45, 20, 48, 20, Symbols.BLOCK_SOLID);
        tg.drawLine(45, 21, 48, 21, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.RED);
        
        tg.drawLine(29, 20, 34, 20, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 19, 32, 19, Symbols.BLOCK_SOLID);
        
        tg.drawLine(43, 18, 44, 18, Symbols.BLOCK_SOLID);
        tg.drawLine(43, 17, 46, 17, Symbols.BLOCK_SOLID);
        tg.drawLine(43, 16, 44, 16, Symbols.BLOCK_SOLID);
        
         tg.drawLine(29, 2, 30, 2, Symbols.BLOCK_SOLID);
         
         tg.drawLine(47, 21, 48, 21, Symbols.BLOCK_SOLID);
        
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        
        tg.drawLine(29, 19, 30, 19, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 18, 32, 18, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 17, 32, 17, Symbols.BLOCK_SOLID);
        
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        
        tg.drawLine(35, 20, 38, 20, Symbols.BLOCK_SOLID);
        tg.drawLine(37, 19, 40, 19, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);
        
        tg.drawLine(43, 19, 48, 19, Symbols.BLOCK_SOLID);
        tg.drawLine(43, 20, 44, 20, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.YELLOW);
        
        tg.drawLine(45, 18, 48, 18, Symbols.BLOCK_SOLID);
        tg.drawLine(47, 17, 48, 17, Symbols.BLOCK_SOLID);
        tg.drawLine(47, 16, 48, 16, Symbols.BLOCK_SOLID);
        
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        
        tg.drawLine(28, 2, 28, 21, Symbols.BLOCK_SOLID);
        tg.drawLine(49, 2, 49, 21, Symbols.BLOCK_SOLID);
        tg.drawLine(28, 22, 49, 22, Symbols.BLOCK_SOLID);

        screen.refresh();
        
    }
    
    
}
