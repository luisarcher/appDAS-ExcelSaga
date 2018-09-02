package view;

import ViewModel.NormalViewMode;
import model.Sheet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements Runnable{

    private JToolBar toolbar;
    private JMenuBar menuBar;

    private SheetView sheetView;
    private Sheet sheetModel;

    private JScrollPane sheetPane;

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
        addViewPort();
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
    public JMenu saveAsMenuItem;
    public JMenuItem closeSheetMenuItem;
    public JMenuItem exitMenuItem;

    //Save as
    public JMenuItem saveAsCSV;

    private void initFileMenu(){

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fileMenu.add(openMenuItem);

        saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        fileMenu.add(saveMenuItem);

        saveAsMenuItem = new JMenu("Save As");
        //saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));

        saveAsCSV = new JMenuItem("CSV");
        saveAsMenuItem.add(saveAsCSV);

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

        add(this.sheetPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(850, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void addViewPort(){

        JPanel pnl = new JPanel(null);
        Dimension dim = new Dimension(50, 200);
        pnl.setPreferredSize(dim);

        dim.height = sheetModel.getRowCount();

        for (int ii = 0; ii < sheetModel.getRowCount(); ii++) {
            JLabel lbl = new JLabel(Integer.toString(ii + 1), SwingConstants.CENTER);

            lbl.setFont(sheetView.getTableHeader().getFont());
            lbl.setBorder((Border) UIManager.getDefaults().get("TableHeader.cellBorder"));
            lbl.setBounds(0, ii * dim.height, dim.width, dim.height);
            pnl.add(lbl);
        }

        // CHANGE THIS VALUE to dynamic val
        int rowHeight = sheetView.getRowHeight();
        dim.height = rowHeight * sheetModel.getRowCount();



        JViewport vp = new JViewport();
        vp.setViewSize(dim);
        vp.setView(pnl);

        sheetPane = new JScrollPane(this.sheetView);
        sheetPane.setRowHeader(vp);

        Dimension dimScpViewport = sheetView.getPreferredScrollableViewportSize();
        if (sheetModel.getRowCount() > 30) {
            dimScpViewport.height = 30 * rowHeight;
        } else {
            dimScpViewport.height = sheetModel.getRowCount() * rowHeight;
        }
        if (sheetModel.getColumnCount() > 15) {
            dimScpViewport.width = 15 * sheetView.getColumnModel().getTotalColumnWidth() / sheetModel.getColumnCount();
        } else {
            dimScpViewport.width = sheetView.getColumnModel().getTotalColumnWidth();
        }
        sheetView.setPreferredScrollableViewportSize(dimScpViewport);

        sheetView.setup();
    }

    public void showAbout(){

        JOptionPane.showMessageDialog(this, "Excel Saga 1.0 \n Developed by: Luís Jordão and Ilídio Martins.\nnAluno and nAluno\n\nIsec - 2017/2018");

    }

    public SheetView getSheetView(){
        return this.sheetView;
    }
}
