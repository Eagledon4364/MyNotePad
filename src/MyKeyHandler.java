
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyHandler implements KeyListener {
    Gui gui;

    public MyKeyHandler(Gui gui) {
        this.gui = gui;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode()== KeyEvent.VK_S) {
            gui.functionFile.save();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
            gui.menuFile.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E) {
            gui.menuEdit.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_G) {
            gui.menuFormat.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_C) {
            gui.menuColor.doClick();
        }
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_D) {
            gui.functionColor.changeColor("dark");
        }
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_L) {
            gui.functionColor.changeColor("light");
        }
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_B) {
            gui.functionColor.changeColor("semi");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
