package ViewModel;

import ViewModel.command.CommandManager;
import ViewModel.command.SetCellValueCommand;
import model.Cell;
import model.Sheet;
import org.apache.log4j.Logger;

import javax.swing.table.AbstractTableModel;

public class SheetTableViewModel extends AbstractTableModel {

    private final static Logger logger = Logger.getLogger(SheetTableViewModel.class);

    protected IGetDataStrategy getDataStr;
    private Sheet sheetModel;

    private CommandManager cm;

    public SheetTableViewModel(Sheet model) {

        this.sheetModel = model;
        cm = new CommandManager(this.sheetModel);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {

        /*logger.debug("Setting '" + o.toString() + "' at row: " + row + " col: " + col);
        sheetModel.setValueAt((String)o,row,col);*/

        SetCellValueCommand cmd = new SetCellValueCommand((String)o,row,col);
        cm.apply(cmd);

    }

    public int getRowCount() {
        return sheetModel.getRowCount();
    }

    public int getColumnCount() {
        return sheetModel.getColumnCount();
    }

    public Cell getValueAt(int row, int col) {
        return getDataStr.getValueAt(row,col);
    }

    public CommandManager getCommandManager() {
        return cm;
    }
}
