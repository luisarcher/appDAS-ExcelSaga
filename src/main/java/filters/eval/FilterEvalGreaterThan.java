package filters.eval;

import model.Cell;
import filters.Constants;
import filters.RegexMatcher;

public class FilterEvalGreaterThan extends FilterEval {

    public FilterEvalGreaterThan(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return RegexMatcher.isNumber(param);
    }

    @Override
    public String getFilterId(){
        return Constants.FILTER_EVAL_GREATERTHAN;
    }

    @Override
    String eval(String cellValue, String filterParam) {

        if (Integer.parseInt(cellValue) > Integer.parseInt(filterParam)){
            return cellValue;
        }

        return "";
    }
}
