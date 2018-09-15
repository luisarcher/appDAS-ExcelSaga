package filters;

import model.Coords;
import model.ICell;
import model.Sheet;

public class ICellAdapter implements ICell {

    protected ICell decoratedCell;

    public ICellAdapter(ICell decoratedCell) {
        this.decoratedCell = decoratedCell;
    }

    @Override
    public Sheet getModel() {
        return this.decoratedCell.getModel();
    }

    @Override
    public String getFilters() {
        return this.decoratedCell.getFilters();
    }

    @Override
    public Coords getCoords() {
        return this.decoratedCell.getCoords();
    }

    @Override
    public String getValue() {
        return this.decoratedCell.getValue();
    }
}
