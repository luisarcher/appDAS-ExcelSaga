package filters.eval;

import model.Cell;
import filters.Constants;
import filters.RegexMatcher;
import model.ICell;

public class FilterEvalGreaterThan extends FilterEval {

    public FilterEvalGreaterThan(ICell decoratedCell) {
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

        if (!(cellValue.equalsIgnoreCase("") || filterParam.equalsIgnoreCase(""))){
            if (Integer.parseInt(cellValue) > Integer.parseInt(filterParam)){
                return cellValue;
            }
        }

        return "";
    }
}
