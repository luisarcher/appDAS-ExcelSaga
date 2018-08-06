package view;

import model.Book;
import model.Sheet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookView extends JPanel{

    private Book bookModel;
    private List<SheetView> viewCollectionSheets;

    private JTabbedPane sheetCollection;

    public BookView(Book model){

        this.bookModel = model;
        this.create();

        this.viewCollectionSheets = new ArrayList<SheetView>();

    }

    private void create(){

        //Add a new tabbedPane to the layout

        sheetCollection = new JTabbedPane();
        sheetCollection.setTabPlacement(JTabbedPane.BOTTOM);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(sheetCollection, BorderLayout.CENTER);

    }

    public void onNewSheet(){

        // We can check if we can get this sheet by model notification
        Sheet lastInsertedSheet = this.bookModel.getLastSheet();

        SheetView newSheet = new SheetView(lastInsertedSheet);
        this.viewCollectionSheets.add(newSheet);

        this.sheetCollection.add(lastInsertedSheet.getSheetName(),newSheet);
    }

}
