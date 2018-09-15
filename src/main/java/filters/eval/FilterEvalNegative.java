package filters.eval;

import model.Cell;
import filters.Constants;

public class FilterEvalNegative extends FilterEval {

    public FilterEvalNegative(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return true;/*RegexMatcher.isNumber(param);*/
    }

    @Override
    String eval(String cellValue, String filterParam) {

        if (Integer.parseInt(cellValue) < 0){
            return cellValue;
        }

        return "";
    }

    @Override
    String getFilterId() {
        return Constants.FILTER_EVAL_NEGATIVE;
    }
}
