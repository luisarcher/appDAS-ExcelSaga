package filters.functions;

import filters.RegexMatcher;
import model.ICell;

public class FilterFunctionCopy extends FilterFunction {

    public FilterFunctionCopy(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean acceptedParams(String expression) {
        return /*RegexMatcher.isCell(expression);*/ true;
    }

    @Override
    String calc(String baseValue, String newValue) {
        return newValue;
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return /*RegexMatcher.isCell(param);*/ true;
    }


}
