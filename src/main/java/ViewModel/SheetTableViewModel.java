package ViewModel;

import model.Cell;
import model.Sheet;
import org.apache.log4j.Logger;

import javax.swing.table.AbstractTableModel;

public class SheetTableViewModel extends AbstractTableModel {

    private final static Logger logger = Logger.getLogger(SheetTableViewModel.class);

    protected IGetDataStrategy getDataStr;
    private Sheet sheetModel;

    public SheetTableViewModel(Sheet model) {

        this.sheetModel = model;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        //logger.debug("Setting '" + o.toString() + "' at row: " + row + " col: " + col);
        sheetModel.setValueAt(o,row,col);
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


}
