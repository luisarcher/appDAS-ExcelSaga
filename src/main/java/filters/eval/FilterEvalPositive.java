package filters.eval;

import filters.Constants;
import model.ICell;

public class FilterEvalPositive extends FilterEval {

    public FilterEvalPositive(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean isAcceptedParam(String param) {
        return true; /*RegexMatcher.isNumber(param);*/
    }

    @Override
    public String getFilterId(){
        return Constants.FILTER_EVAL_POSITIVE;
    }

    @Override
    String eval(String cellValue, String filterParam) {

        if (Integer.parseInt(cellValue) > 0){
            return cellValue;
        }

        return "";
    }
}
