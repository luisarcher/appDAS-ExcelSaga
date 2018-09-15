package filters;

import model.ICell;

public class FilterError extends ICellAdapter implements ICell{

    private String errorMessage;

    public FilterError(ICell decoratedCell, String errorMessage) {

        super(decoratedCell);
        this.errorMessage = errorMessage;
    }

    @Override
    public String getValue() {
        return this.decoratedCell.getValue().replaceAll(
                decoratedCell.getValue(), this.errorMessage
        );
    }
}
