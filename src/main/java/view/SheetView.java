package view;

import model.Sheet;

import javax.swing.*;

public class SheetView extends JTable {

    public SheetView(Sheet model){

        this.setModel(model);

    }
}
