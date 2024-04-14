import java.awt.*;

public class FunctionFormat {
    Gui gui;
    Font arial, comicSansMS, timeNewRoman;
    String selectedFont;
    public FunctionFormat(Gui gui) {
        this.gui = gui;
    }
    public void wordWrap() {
        if (!gui.wordWrap) {
            gui.wordWrap = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word wrap: On");

        } else if (gui.wordWrap){
            gui.wordWrap = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word wrap: Off");
        }
    }
    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timeNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }
    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial" -> {
                gui.textArea.setFont(arial);
            }
            case "Comic Sans MS" -> {
                gui.textArea.setFont(comicSansMS);
            }
            case "Times New Roman" -> {
                gui.textArea.setFont(timeNewRoman);
            }
        }
    }
}
