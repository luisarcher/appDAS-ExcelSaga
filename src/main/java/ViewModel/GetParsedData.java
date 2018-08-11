package ViewModel;

import model.Cell;
import model.Sheet;

public class GetParsedData implements IGetDataStrategy{

    private Sheet model;

    GetParsedData(Sheet model){

        this.model = model;
    }

    public Cell getValueAt(int row, int column) {
        //TODO
        // Parsed Value with expression parser and decorators/filters applied
        Cell myNewCell = new Cell("#");
        return myNewCell;
        //return model.getValueAt(row,column);
    }
}
