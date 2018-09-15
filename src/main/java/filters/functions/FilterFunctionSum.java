package filters.functions;

import model.Cell;
import filters.RegexMatcher;

public class FilterFunctionSum extends FilterFunction /*<Integer,Integer>*/ {

    public FilterFunctionSum(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    public boolean acceptedParams(String expression) {

        // Accept an infinite sequence
        return expression.matches(RegexMatcher.REGEX_N_NUMBER_CELL_RANGE);
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isNumber(param);
    }

    @Override
    public String calc(String baseValue, String newValue) {

        Integer _result = (Integer.parseInt(baseValue) + Integer.parseInt(newValue));
        return _result.toString();
    }
}
