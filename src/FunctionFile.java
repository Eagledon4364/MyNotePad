import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

public class FunctionFile {
    Gui gui;
    String fileName;
    String fileAdress;

    public FunctionFile(Gui gui) {
        this.gui = gui;

    }
    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New File");
        fileName = null;
        fileAdress = null;
    }
    public void openFile() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileAdress + fileName));
                gui.textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    gui.textArea.append(line + "\n");

                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
                newFile();
            }
        }
    }
    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAdress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile()!= null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAdress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
