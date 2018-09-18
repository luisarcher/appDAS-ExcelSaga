package filters;

import model.IModel;
import model.RowCol;
import model.ICell;

public class ICellAdapter implements ICell {

    protected ICell decoratedCell;

    public ICellAdapter(ICell decoratedCell) {
        this.decoratedCell = decoratedCell;
    }

    @Override
    public IModel getModel() {
        return this.decoratedCell.getModel();
    }

    @Override
    public String getFilters() {
        return this.decoratedCell.getFilters();
    }

    @Override
    public RowCol getCoords() {
        return this.decoratedCell.getCoords();
    }

    @Override
    public String getValue() {
        return this.decoratedCell.getValue();
    }
}
