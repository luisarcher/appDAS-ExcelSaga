package controllers;

import ViewModel.command.CommandManager;
import model.Sheet;
import view.MainWindow;

public class TableController {

    private CommandManager cm;
    private Sheet sheetModel;
    private MainWindow view;

    public TableController(Sheet sheetModel, MainWindow view) {
        this.sheetModel = sheetModel;
        this.view = view;
    }


}
