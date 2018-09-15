package controllers.command;

import model.Sheet;

public class CommandSetCellFilter implements ICommand{

    private String newValue;
    private String oldValue;
    private int row;
    private int column;

    public CommandSetCellFilter(String newValue, int row, int column) {

        this.newValue = newValue;
        this.row = row;
        this.column = column;
    }

    @Override
    public void doCommand(Sheet model) {

        this.oldValue = model.getValueAt(row,column).getFilters();
        model.getValueAt(row,column).setFilters(newValue);

    }

    @Override
    public void undoCommand(Sheet model) {

        model.getValueAt(row,column).setFilters(oldValue);

    }
}
