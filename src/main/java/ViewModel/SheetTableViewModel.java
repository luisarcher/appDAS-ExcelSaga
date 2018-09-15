package ViewModel;

import controllers.command.CommandSetCellValue;
import events.EventDispatcher;
import model.Cell;
import model.Sheet;
import org.apache.log4j.Logger;

import javax.swing.table.AbstractTableModel;

public class SheetTableViewModel extends AbstractTableModel {

    private final static Logger logger = Logger.getLogger(SheetTableViewModel.class);

    protected IGetDataStrategy getDataStr;
    private Sheet sheetModel;

    private EventDispatcher setCellValueEventDispatcher;

    public SheetTableViewModel(Sheet model) {

        this.sheetModel = model;
        this.setCellValueEventDispatcher = new EventDispatcher();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {

        CommandSetCellValue cmd = new CommandSetCellValue((String)o,row,col);
        setCellValueEventDispatcher.notifyObservers(cmd);

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

    public EventDispatcher getSetCellValueEventDispatcher() {
        return setCellValueEventDispatcher;
    }
}
