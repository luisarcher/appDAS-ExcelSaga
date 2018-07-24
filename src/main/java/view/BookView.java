package view;

import model.Book;

import javax.swing.*;

public class BookView extends JPanel{

    private Book bookModel;

    public BookView(Book model){

        this.bookModel = model;

    }

}
