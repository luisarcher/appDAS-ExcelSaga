package filters.eval;

import filters.Constants;
import filters.RegexMatcher;
import model.ICell;

public class FilterEvalLowerThan extends FilterEval {

    public FilterEvalLowerThan(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    String eval(String cellValue, String filterParam) {

        if (!(cellValue.equalsIgnoreCase("") || filterParam.equalsIgnoreCase(""))){
            if (Integer.parseInt(cellValue) < Integer.parseInt(filterParam)){
                return cellValue;
            }
        }

        return "";
    }

    @Override
    String getFilterId() {
        return Constants.FILTER_EVAL_LOWERTHAN;
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isNumber(param);
    }
}
