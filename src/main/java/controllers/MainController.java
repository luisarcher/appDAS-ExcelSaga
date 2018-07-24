package controllers;

import model.Book;
import view.MainWindow;

public class MainController {

    private Book model;
    private MainWindow view;

    public MainController(Book model, MainWindow view){

        this.model = model;
        this.view = view;
    }
}
