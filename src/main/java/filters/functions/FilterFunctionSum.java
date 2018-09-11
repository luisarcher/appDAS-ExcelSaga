package filters.functions;

import model.Cell;
import utils.RegexMatcher;

public class FilterFunctionSum extends FilterFunction /*<Integer,Integer>*/ {

    public FilterFunctionSum(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    public String calc(String baseValue, String newValue) {

        Integer _result = (Integer.parseInt(baseValue) + Integer.parseInt(newValue));
        return _result.toString();
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isNumber(param);
    }
}
