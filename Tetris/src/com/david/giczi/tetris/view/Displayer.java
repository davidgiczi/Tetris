package com.david.giczi.tetris.view;

import com.david.giczi.tetris.shape.AbstractShape;
import com.david.giczi.tetris.model.ShapePosition;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author GicziD
 */
public class Displayer {

    private final Terminal terminal;
    private final Screen screen;
    private final TextGraphics tg;
    private KeyStroke keyPress;
    public static final int WIDTH_OF_BOARD = 10;
    public static final int LENGTH_OF_BOARD = 20;

    public Terminal getTerminal() {
        return terminal;
    }

    public Screen getScreen() {
        return screen;
    }

    public KeyStroke getKeyPress() {
        return keyPress;
    }

    public void setKeyPress(KeyStroke keyPress) {
        this.keyPress = keyPress;
    }

    public Displayer() throws IOException {

        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.startScreen();
    }

    public void displayGameBoard(int x, int y) throws IOException {

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);

        tg.drawLine(x, y, x, y + 19, Symbols.BLOCK_SOLID);
        tg.drawLine(x + 21, y, x + 21, y + 19, Symbols.BLOCK_SOLID);
        tg.drawLine(x, y + 20, x + 21, y + 20, Symbols.BLOCK_SOLID);

        screen.refresh();

    }

    public void displayShape(AbstractShape shape) throws IOException {

        tg.setForegroundColor(shape.shapeColor);

        shape.shapeComponent.forEach(component
                -> tg.drawLine(component.getDisplayer_x(), component.getDisplayer_y(),
                        component.getDisplayer_x() + 1,
                        component.getDisplayer_y(), Symbols.BLOCK_SOLID));

        screen.refresh();
    }

    public void displayNumberShape(AbstractShape shape) throws IOException {

        tg.setForegroundColor(shape.shapeColor);

        shape.shapeComponent.forEach(component
                -> tg.drawLine(component.getDisplayer_x(), component.getDisplayer_y(),
                        component.getDisplayer_x(),
                        component.getDisplayer_y(), Symbols.BLOCK_SOLID));

        screen.refresh();
    }

    public void displayGameOver() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.putString(27, 1, "Vége a játéknak!".toUpperCase(), SGR.BOLD, SGR.BLINK);

        screen.refresh();

    }

    public void clearScreen(List<ShapePosition> deletedShapePosition) throws IOException {

        tg.setForegroundColor(TextColor.ANSI.BLACK);
        deletedShapePosition.forEach(component
                -> tg.drawLine(component.getDisplayer_x(), component.getDisplayer_y(),
                        component.getDisplayer_x() + 1, component.getDisplayer_y(),
                        Symbols.BLOCK_SOLID));

        screen.refresh();
    }

    public void displayKeyOption(int x, int y) throws IOException {

        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(x - 1, y + 2, String.valueOf(Symbols.TRIANGLE_UP_POINTING_BLACK), SGR.BOLD);
        tg.putString(x - 10, y + 4, String.valueOf(Symbols.TRIANGLE_LEFT_POINTING_BLACK), SGR.BOLD);
        tg.putString(x + 8, y + 4, String.valueOf(Symbols.TRIANGLE_RIGHT_POINTING_BLACK), SGR.BOLD);
        tg.putString(x - 1, y + 6, String.valueOf(Symbols.TRIANGLE_DOWN_POINTING_BLACK), SGR.BOLD);
        tg.putString(x - 15, y + 8, "Enter", SGR.BOLD);
        tg.putString(x - 15, y + 10, "Tab", SGR.BOLD);
        tg.putString(x - 15, y + 12, "Esc", SGR.BOLD);
        tg.putString(x - 58, y + 12, "PgUp/PgDown", SGR.BOLD);
        tg.putString(x - 15, y + 14, "Pontszám:", SGR.BOLD);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(x - 5, y + 3, "forgatás");
        tg.putString(x - 8, y + 4, "balra");
        tg.putString(x + 1, y + 4, "jobbra");
        tg.putString(x - 2, y + 5, "le");
        tg.putString(x - 10, y + 8, " - Új játék");
        tg.putString(x - 10, y + 10, " - Stop/Start");
        tg.putString(x - 10, y + 12, " - Kilépés");
        tg.putString(x - 58, y + 14, "Tempó fel/le");

        screen.refresh();
    }

    public void displayStarterPage() throws IOException {
        get_T();
        get_E();
        get__T();
        get_R();
        get_I();
        get_S();

        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString(32, 17, "by Dávid Giczi, 2020");
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(4, 20, "Esc", SGR.BOLD);
        tg.putString(64, 20, "Enter", SGR.BOLD);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(7, 20, " - Kilépés");
        tg.putString(69, 20, " - Start");

        screen.refresh();
    }

    private void get_T() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(5, 2, 11, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 12, 6, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 13, 6, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 14, 6, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 15, 6, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(7, 12, 8, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 13, 8, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 14, 8, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 15, 8, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(2, 3, 6, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 7, 6, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 8, 6, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 8, 8, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 9, 6, 9, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(7, 5, 8, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 6, 8, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 7, 8, 7, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(9, 3, 11, 3, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(2, 2, 4, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 3, 8, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 4, 8, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 5, 6, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(7, 9, 8, 9, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);

        tg.drawLine(5, 10, 8, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(5, 11, 8, 11, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

    private void get_E() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(14, 5, 17, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 6, 15, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 7, 15, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(20, 8, 21, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(18, 9, 23, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 10, 17, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 11, 17, 11, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(18, 2, 23, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(22, 3, 23, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 9, 15, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 10, 17, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 11, 17, 11, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(14, 2, 17, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 3, 15, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 4, 15, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 11, 15, 11, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 12, 17, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 13, 17, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(16, 6, 17, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 7, 17, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 8, 19, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 9, 17, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(22, 14, 23, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(18, 15, 23, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(16, 3, 21, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(16, 4, 17, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(22, 8, 23, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 13, 15, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 14, 15, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(14, 15, 17, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);
        tg.drawLine(16, 14, 21, 14, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

    private void get__T() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(29, 2, 30, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 3, 33, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 4, 30, 4, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(31, 4, 32, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 5, 32, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 6, 32, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 12, 32, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 13, 32, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(29, 6, 30, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 7, 30, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 7, 32, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 8, 30, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 9, 30, 9, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(31, 2, 35, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(34, 3, 35, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 11, 32, 11, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 12, 30, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 13, 30, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(29, 14, 32, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 15, 32, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);

        tg.drawLine(26, 2, 28, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(26, 3, 28, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 8, 32, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(31, 9, 32, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(29, 10, 32, 10, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

    private void get_R() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(38, 9, 41, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 10, 41, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 13, 49, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 14, 49, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 15, 51, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(38, 4, 39, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 5, 41, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 6, 40, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(46, 8, 47, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(46, 9, 47, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(46, 10, 47, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(46, 11, 47, 11, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(38, 2, 39, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 3, 41, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 8, 45, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 12, 51, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(40, 4, 41, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(50, 13, 51, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(50, 14, 51, 14, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);

        tg.drawLine(46, 2, 47, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(44, 3, 47, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 6, 51, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 7, 51, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 13, 39, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 14, 39, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 15, 41, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(40, 2, 45, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(42, 3, 43, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 11, 41, 11, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 12, 41, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(40, 13, 41, 13, Symbols.BLOCK_SOLID);
        tg.drawLine(40, 14, 41, 14, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(48, 4, 51, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(48, 5, 51, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(40, 6, 41, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(38, 7, 41, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(42, 9, 45, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(44, 10, 45, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(44, 11, 45, 11, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

    private void get_I() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(54, 15, 61, 15, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 5, 59, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 6, 57, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 7, 57, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 8, 57, 8, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(54, 2, 55, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(54, 14, 57, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 12, 57, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 13, 57, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);

        tg.drawLine(58, 14, 61, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 12, 59, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 13, 59, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(56, 2, 57, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(54, 3, 57, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 4, 57, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 9, 59, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 10, 59, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 11, 57, 11, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(58, 2, 59, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 6, 59, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 7, 59, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 8, 59, 8, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(60, 2, 61, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 3, 61, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 4, 59, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(56, 9, 57, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(58, 11, 59, 11, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

    private void get_S() throws IOException {

        tg.setForegroundColor(TextColor.ANSI.RED);

        tg.drawLine(68, 2, 69, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(68, 3, 73, 3, Symbols.BLOCK_SOLID);
        tg.drawLine(68, 14, 71, 14, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.BLUE);

        tg.drawLine(70, 2, 73, 2, Symbols.BLOCK_SOLID);
        tg.drawLine(66, 4, 67, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(66, 5, 67, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(66, 6, 67, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(66, 7, 67, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(72, 14, 73, 14, Symbols.BLOCK_SOLID);
        tg.drawLine(68, 15, 73, 15, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.drawLine(64, 4, 65, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(64, 5, 65, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(68, 9, 69, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(72, 9, 73, 9, Symbols.BLOCK_SOLID);
        tg.drawLine(64, 6, 65, 6, Symbols.BLOCK_SOLID);
        tg.drawLine(64, 7, 65, 7, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 4, 77, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 5, 77, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(64, 12, 67, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(64, 13, 67, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.MAGENTA);

        tg.drawLine(74, 10, 75, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 11, 75, 11, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 12, 75, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 13, 75, 13, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.YELLOW);

        tg.drawLine(74, 4, 77, 4, Symbols.BLOCK_SOLID);
        tg.drawLine(74, 5, 77, 5, Symbols.BLOCK_SOLID);
        tg.drawLine(68, 8, 73, 8, Symbols.BLOCK_SOLID);
        tg.drawLine(70, 9, 71, 9, Symbols.BLOCK_SOLID);

        tg.setForegroundColor(TextColor.ANSI.CYAN);

        tg.drawLine(76, 10, 77, 10, Symbols.BLOCK_SOLID);
        tg.drawLine(76, 11, 77, 11, Symbols.BLOCK_SOLID);
        tg.drawLine(76, 12, 77, 12, Symbols.BLOCK_SOLID);
        tg.drawLine(76, 13, 77, 13, Symbols.BLOCK_SOLID);

        screen.refresh();
    }

}
