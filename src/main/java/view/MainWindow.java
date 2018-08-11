package view;

import ViewModel.NormalViewMode;
import model.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements Runnable{

    private JToolBar toolbar;
    private JMenuBar menuBar;

    private SheetView sheetView;
    private Sheet sheetModel;

    public MainWindow(Sheet sheet){

        this.sheetModel = sheet;
        this.prepareView();

    }

    private void prepareView(){

        setName("Excel Saga");
        setTitle("Excel Saga");

        this.createViewComponents();

        this.initFileMenu();
        this.initEditMenu();
        this.initViewMenu();
        this.initAbout();

        this.initToolbar();

        setJMenuBar(menuBar);

        add(toolbar, BorderLayout.NORTH);
    }

    private void initToolbar(){

        JTextField formulaBar = new JTextField(70);
        formulaBar.setText("");
        JPanel fbar = new JPanel();
        fbar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        fbar.setLayout(new GridBagLayout());
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.gridy = 0;

        layoutConstraints.gridx = 0;
        JButton btnUndo = new JButton("Undo");
        fbar.add(btnUndo,layoutConstraints);

        layoutConstraints.gridx = 1;
        JButton btnRedo = new JButton("Redo");
        fbar.add(btnRedo,layoutConstraints);

        layoutConstraints.gridx = 2;
        JLabel barCaption = new JLabel(" Formula :", SwingConstants.CENTER);
        barCaption.setBorder(BorderFactory.createCompoundBorder(barCaption.getBorder(), BorderFactory.createEmptyBorder(0, 17, 0, 17)));
        fbar.add(btnRedo,layoutConstraints);

        layoutConstraints.gridx = 3;
        layoutConstraints.weightx = 0.5;
        fbar.add(formulaBar,layoutConstraints);

        toolbar.add(fbar);
        toolbar.setFloatable(false);
    }

    private void createViewComponents(){

        menuBar = new JMenuBar();
        toolbar = new JToolBar();
        sheetView = new SheetView();

    }

    public JMenuItem openMenuItem;
    public JMenuItem saveMenuItem;
    public JMenuItem saveAsMenuItem;
    public JMenuItem closeSheetMenuItem;
    public JMenuItem exitMenuItem;

    private void initFileMenu(){

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fileMenu.add(openMenuItem);

        saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        fileMenu.add(saveMenuItem);

        saveAsMenuItem = new JMenuItem("Save As", KeyEvent.VK_A);
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
        fileMenu.add(saveAsMenuItem);

        closeSheetMenuItem = new JMenuItem("Close sheet", KeyEvent.VK_C);
        fileMenu.add(closeSheetMenuItem);

        fileMenu.addSeparator();

        exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

    }

    public JMenuItem brushMenuItem;

    private void initEditMenu(){

        JMenu editMenu = new JMenu("Edit");
        brushMenuItem = new JMenuItem("NA", KeyEvent.VK_B);
        editMenu.add(brushMenuItem);
        editMenu.setMnemonic(KeyEvent.VK_E);

        menuBar.add(editMenu);
    }

    public JMenuItem normalViewMenuItem;
    public JMenuItem functionalViewMenuItem;

    private void initViewMenu(){

        JMenu viewMenu = new JMenu("View");
        normalViewMenuItem = new JMenuItem("Normal View", KeyEvent.VK_B);
        viewMenu.add(normalViewMenuItem);

        functionalViewMenuItem = new JMenuItem("Functional View", KeyEvent.VK_B);
        viewMenu.add(functionalViewMenuItem);

        viewMenu.setMnemonic(KeyEvent.VK_V);
        menuBar.add(viewMenu);
    }

    public JButton about;
    private void initAbout(){

        about = new JButton("About");
        about.setBorderPainted(false);
        about.setFocusPainted(false);
        about.setContentAreaFilled(false);

        menuBar.add(about);
    }

    public void run() {

        add(this.sheetView, BorderLayout.CENTER);
        setPreferredSize(new Dimension(850, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this, "Excel Saga 1.0 \n Developed by: Luís Jordão and Ilídio Martins.\nnAluno and nAluno\n\nIsec - 2017/2018");

    }

    public SheetView getSheetView(){
        return this.sheetView;
    }
}
