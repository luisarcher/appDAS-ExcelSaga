package filters.functions;

import filters.RegexMatcher;
import model.Cell;

public class FilterFunctionCopy extends FilterFunction {

    public FilterFunctionCopy(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean acceptedParams(String expression) {
        return RegexMatcher.isCell(expression);
    }

    @Override
    String calc(String baseValue, String newValue) {
        return newValue;
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isCell(param);
    }


}
