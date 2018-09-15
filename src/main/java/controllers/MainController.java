package controllers;

import viewmodel.FunctionalViewMode;
import viewmodel.NormalViewMode;
import viewmodel.SheetTableViewModel;
import persistence.file.export.FileExport;
import model.Sheet;
import org.apache.log4j.Logger;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final static Logger logger = Logger.getLogger(MainController.class);

    private Sheet sheetModel;
    private MainWindow view;
    private SheetTableViewModel sheetViewModel;

    TableController tableController;

    public MainController(Sheet model, MainWindow view){

        this.sheetModel = model;
        this.view = view;

        tableController = new TableController(view, model);

        this.init();
    }

    private void init(){

        this.setNormalView();

        this.setupFileMenuHandlers();
        this.setupEditMenuHandlers();
        this.setupViewMenuHandlers();
        this.setupAboutMenuHandlers();
    }

    private void setupFileMenuHandlers(){

        view.openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // save book
            }
        });

        view.saveAsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FileExport(sheetModel);
            }
        });

        view.closeSheetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // go to book and close this sheet
            }
        });

        view.exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // we will prompt the user if there is any unsaved changes,
                //for now we'll just quit
                System.exit(1);
            }
        });
    }

    private void setupEditMenuHandlers(){
    }

    private void setupViewMenuHandlers(){

        view.normalViewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setNormalView();
            }
        });

        view.functionalViewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setFunctionalView();
            }
        });
    }

    private void setupAboutMenuHandlers(){
        view.about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showAbout();
            }
        });
    }

    private void setNormalView(){

        this.sheetViewModel = new NormalViewMode(sheetModel);

        view.getSheetView().setModel(this.sheetViewModel);
        view.normalViewMenuItem.setEnabled(false);
        view.functionalViewMenuItem.setEnabled(true);

        this.tableController.setTableViewModel(this.sheetViewModel);
    }

    private void setFunctionalView(){

        this.sheetViewModel = new FunctionalViewMode(sheetModel);

        view.getSheetView().setModel(this.sheetViewModel);
        view.normalViewMenuItem.setEnabled(true);
        view.functionalViewMenuItem.setEnabled(false);

        this.tableController.setTableViewModel(this.sheetViewModel);
    }
}
