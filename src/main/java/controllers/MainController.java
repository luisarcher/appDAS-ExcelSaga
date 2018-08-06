package controllers;

import model.Book;
import org.apache.log4j.Logger;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class MainController {

    private final static Logger logger = Logger.getLogger(Book.class);

    private Book bookModel;
    private MainWindow view;

    public MainController(Book model, MainWindow view){

        this.bookModel = model;
        this.view = view;

        this.init();
    }

    private void init(){

        this.setupHandlers();
    }

    private void setupHandlers(){

        view.newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.debug("Adding sheet...");
                bookModel.addNewSheet();
                logger.debug("Number of sheets: " + bookModel.getSheets().size());

                // just for debug purposes
                view.getBookView().onNewSheet();
            }
        });

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
                //for new we'll just quit
                exit(1);
            }
        });

        view.about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showAbout();
            }
        });
    }
}
