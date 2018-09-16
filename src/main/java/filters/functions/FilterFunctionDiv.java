package filters.functions;

import filters.Constants;
import filters.RegexMatcher;
import model.ICell;

public class FilterFunctionDiv extends FilterFunction {

    public FilterFunctionDiv(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    String calc(String baseValue, String newValue) {

        if (baseValue.length() < 1) {
            return newValue;
        }

        if (baseValue.equalsIgnoreCase("0") || newValue.equalsIgnoreCase("0")){
            return Constants.ERROR_DIV0;
        }

        Float _result = (Float.parseFloat(baseValue) / Float.parseFloat(newValue));
        return _result.toString();

    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isFloat(param);
    }
}
