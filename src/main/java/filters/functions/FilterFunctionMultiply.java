package filters.functions;

import model.Cell;
import org.apache.log4j.Logger;
import utils.RegexMatcher;

public class FilterFunctionMultiply extends FilterFunction {

    private final static Logger logger = Logger.getLogger(FilterFunctionMultiply.class);

    public FilterFunctionMultiply(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    public String calc(String baseValue, String newValue) {

        if (baseValue.length() < 1) {
             return newValue;
        }

        Integer _result = (Integer.parseInt(baseValue) * Integer.parseInt(newValue));
        logger.debug(baseValue + " * " + newValue + " = " + _result);

        return _result.toString();
    }

    @Override
    boolean isAcceptedParam(String param) {
        return RegexMatcher.isNumber(param);
    }
}
