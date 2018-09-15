package viewmodel.strategy;

import model.Cell;
import model.Sheet;

public class GetRawData implements IGetDataStrategy {

    private Sheet model;

    public GetRawData(Sheet model){

        this.model = model;
    }

    public Cell getValueAt(int row, int column) {
        return model.getValueAt(row,column);
    }
}
