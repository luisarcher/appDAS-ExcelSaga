package filters.functions;

import model.ICell;

public class FilterFunctionSub extends FilterFunction {

    public FilterFunctionSub(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    String calc(String baseValue, String newValue) {
        Integer _res = Integer.parseInt(baseValue) - Integer.parseInt(newValue);
        return _res.toString();
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return true;
    }
}
