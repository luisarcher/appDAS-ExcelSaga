package filters;

import model.Cell;
import model.ICell;

public class FilterError implements ICell{

    protected Cell decoratedCell;

    public FilterError(Cell decoratedCell) {
        this.decoratedCell = decoratedCell;
    }

    @Override
    public String getValue() {
        return null;
    }
}
