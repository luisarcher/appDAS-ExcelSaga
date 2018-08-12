package ViewModel;

import model.Cell;
import model.Sheet;

import javax.swing.table.AbstractTableModel;

public class SheetTableViewModel extends AbstractTableModel {

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
