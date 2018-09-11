package filters.functions;

import model.Cell;

public class FilterFunctionConcat extends FilterFunction {

    public FilterFunctionConcat(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    String calc(String baseValue, String newValue) {
        return null;
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return true;
    }
}
