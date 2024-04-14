import java.awt.*;

public class FunctionColor {
    Gui gui;
    public FunctionColor(Gui gui) {
        this.gui = gui;
    }
    public void changeColor(String color) {
        switch (color) {
            case "light" -> {
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
            }
            case "semi" -> {
                gui.window.getContentPane().setBackground(new Color(0, 0, 47));
                gui.textArea.setBackground(new Color(0, 0, 47));
                gui.textArea.setForeground(Color.YELLOW);

            }
            case "dark" -> {
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.WHITE);

            }
        }
    }
}
