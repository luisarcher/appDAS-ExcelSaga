package filters.functions;

import model.ICell;

public class FilterFunctionConcat extends FilterFunction {

    public FilterFunctionConcat(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    String calc(String baseValue, String newValue) {
        return baseValue + " " + newValue;
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return true;
    }
}
