package view;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements Runnable{

    private JToolBar toolbar;
    private JMenuBar menuBar;

    private Book book;

    public MainWindow(Book model){

        this.book = model;
        this.prepareView();

    }

    private void prepareView(){

        setName("Excel Saga");
        setTitle("Excel Saga");

        this.createViewComponents();



        this.initFileMenu();
        this.initEditMenu();
        this.initAbout();

        this.initToolbar();
        this.initFormulaBar();

        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);

        add(toolbar, BorderLayout.NORTH);
    }

    private void initToolbar(){

        JTextField formulaBar = new JTextField(70);
        formulaBar.setText("Click on a cell");
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

    }

    private void initFileMenu(){

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        menuBar.add(fileMenu);
    }

    private void initAbout(){

        JButton about = new JButton("About");
        about.setBorderPainted(false);
        about.setFocusPainted(false);
        about.setContentAreaFilled(false);

        menuBar.add(about);
    }

    private void initEditMenu(){

        JMenu editMenu = new JMenu("Edit");
        JMenuItem brushMenuItem = new JMenuItem("Brush", KeyEvent.VK_B);
        editMenu.add(brushMenuItem);
        editMenu.setMnemonic(KeyEvent.VK_E);

        menuBar.add(editMenu);
    }

    private void initFormulaBar(){


    }

    public void run() {

        setPreferredSize(new Dimension(850, 600));
        pack();
        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
