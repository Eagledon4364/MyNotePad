import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrap = false;
    Image icon = new ImageIcon("src/icon.png").getImage();
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    //FILE
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //EDIT
    JMenuItem iUndo, iRedo;

    //FORMAT
    JMenu menuFont, menuFontSize;
    JMenuItem iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenuItem iWrap;

    //COLOR
    JMenuItem color1, color2, color3;


    FunctionFile functionFile = new FunctionFile(this);
    FunctionEdit functionEdit = new FunctionEdit(this);
    FunctionFormat functionFormat = new FunctionFormat(this);
    FunctionColor functionColor = new FunctionColor(this);
    UndoManager um = new UndoManager();
    MyKeyHandler keyHandler = new MyKeyHandler(this);

    public Gui() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();


        functionFormat.selectedFont = "Arial";
        functionFormat.createFont(12);
        functionFormat.wordWrap();
        functionColor.changeColor("light");
        window.setVisible(true);
    }
    public void createWindow() {
        window = new JFrame("Java Note Pad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setIconImage(icon);
    }
    public void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
                e -> um.addEdit(e.getEdit()));
        textArea.addKeyListener(keyHandler);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void createFileMenu() {
        iNew = new JMenuItem("New");
        menuFile.add(iNew);
        iNew.addActionListener(this);
        iNew.setActionCommand("New");

        iOpen = new JMenuItem("Open");
        menuFile.add(iOpen);
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");

        iSave = new JMenuItem("Save");
        menuFile.add(iSave);
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");

        iSaveAs = new JMenuItem("Save As");
        menuFile.add(iSaveAs);
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");

        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");

    }
    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

    }
    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("WordWrap");
        menuFormat.add(iWrap);

        //FONT
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        //FONT SIZE
        menuFontSize = new JMenu("Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menuFontSize.add(iFontSize28);

    }
    public void createColorMenu() {
        color1 = new JMenuItem("light");
        color1.addActionListener(this);
        color1.setActionCommand("light");
        menuColor.add(color1);

        color2 = new JMenuItem("semi");
        color2.addActionListener(this);
        color2.setActionCommand("semi");
        menuColor.add(color2);

        color3 = new JMenuItem("dark");
        color3.addActionListener(this);
        color3.setActionCommand("dark");
        menuColor.add(color3);

    }
    public static void main(String[] args) {
        new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New" -> functionFile.newFile();
            case "Open" -> functionFile.openFile();
            case "Save" -> functionFile.save();
            case "SaveAs" -> functionFile.saveAs();
            case "Exit" -> System.exit(0);
            case "WordWrap" -> functionFormat.wordWrap();
            case "8" -> functionFormat.createFont(8);
            case "12" -> functionFormat.createFont(12);
            case "16" -> functionFormat.createFont(16);
            case "24" -> functionFormat.createFont(24);
            case "28" -> functionFormat.createFont(28);
            case "Arial", "Times New Roman", "Comic Sans MS" -> functionFormat.setFont(command);
            case "light" -> functionColor.changeColor("light");
            case "semi" -> functionColor.changeColor("semi");
            case "dark" -> functionColor.changeColor("dark");
            case "Undo" -> functionEdit.undo();
            case "Redo" -> functionEdit.redo();

        }
    }
}