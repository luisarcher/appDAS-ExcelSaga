package ViewModel.command;

import model.Sheet;

public class SetCellValueCommand implements ICommand {

    private String newValue;
    private String oldValue;
    private int row;
    private int column;

    public SetCellValueCommand(String value, int row, int column) {

        this.newValue = value;
        this.row = row;
        this.column = column;
    }

    @Override
    public void doCommand(Sheet model) {

        this.oldValue = model.getValueAt(this.row, this.column).getValue();
        model.setValueAt(newValue, this.row, this.column);

    }

    @Override
    public void undoCommand(Sheet model) {

        model.setValueAt(oldValue, this.row, this.column);

    }
}
