package controllers;

import viewmodel.SheetTableViewModel;
import controllers.command.CommandManager;
import controllers.command.CommandSetCellFilter;
import controllers.command.ICommand;
import utils.events.IEventHandler;
import model.Sheet;
import org.apache.log4j.Logger;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableController implements IEventHandler{

    private final static Logger logger = Logger.getLogger(TableController.class);

    private MainWindow view;
    private SheetTableViewModel tableViewModel;
    private Sheet sheetModel;

    private CommandManager commandManager;

    private int selectedRow;
    private int selectedColumn;

    public TableController(MainWindow view, Sheet sheetModel) {

        this.view = view;

        this.sheetModel = sheetModel;
        this.commandManager = new CommandManager(this.sheetModel);

        setupToolbarHandlers();
        setupSelectionListener();

    }

    public void setTableViewModel(SheetTableViewModel tableViewModel){

        this.tableViewModel = tableViewModel;
        this.tableViewModel.getSetCellValueEventDispatcher().register(this);
    }

    @Override
    public void handle(ICommand command) {
        this.commandManager.apply(command);
    }

    private void setupToolbarHandlers(){

        view.btnUndo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                commandManager.undo();
                tableViewModel.fireTableDataChanged();
            }
        });

        view.btnRedo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                commandManager.redo();
                tableViewModel.fireTableDataChanged();
            }
        });

        view.btnSetFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                commandManager.apply(new CommandSetCellFilter(view.formulaBar.getText(),selectedRow,selectedColumn));
                tableViewModel.fireTableCellUpdated(selectedRow,selectedColumn);
            }
        });
    }

    private void setupSelectionListener(){

        view.getSheetView().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                selectedRow = view.getSheetView().getSelectedRow();
                selectedColumn = view.getSheetView().getSelectedColumn();

                view.formulaBar.setText(sheetModel.getValueAt(selectedRow,selectedColumn).getFilters());

                logger.debug("Selected ("+ selectedRow + "," + selectedColumn +")");
            }
        });

    }
}
