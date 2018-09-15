package filters;

import model.Cell;
import model.ICell;
import model.Sheet;

public class FilterError implements ICell{

    private Cell decoratedCell;
    private String errorMessage;

    public FilterError(Cell decoratedCell, String errorMessage) {
        this.decoratedCell = decoratedCell;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getValue() {
        return this.decoratedCell.getValue().replaceAll(
                decoratedCell.getValue(), this.errorMessage
        );
    }

    @Override
    public Sheet getModel() {
        return this.decoratedCell.getModel();
    }

    @Override
    public String getFilters() {
        return this.decoratedCell.getFilters();
    }
}
