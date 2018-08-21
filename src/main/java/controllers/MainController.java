package controllers;

import ViewModel.FunctionalViewMode;
import ViewModel.NormalViewMode;
import model.Sheet;
import org.apache.log4j.Logger;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private final static Logger logger = Logger.getLogger(MainController.class);

    private Sheet sheetModel;
    private MainWindow view;

    public MainController(Sheet model, MainWindow view){

        this.sheetModel = model;
        this.view = view;

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
                // open book
            }
        });

        view.saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // save book
            }
        });

        view.saveAsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //save book as
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
                //TODO use a factory
                setNormalView();
            }
        });

        view.functionalViewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //todo use a factory
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
        view.getSheetView().setModel(new NormalViewMode(sheetModel));
        view.normalViewMenuItem.setEnabled(false);
        view.functionalViewMenuItem.setEnabled(true);
    }

    private void setFunctionalView(){
        view.getSheetView().setModel(new FunctionalViewMode(sheetModel));
        view.normalViewMenuItem.setEnabled(true);
        view.functionalViewMenuItem.setEnabled(false);
    }
}
