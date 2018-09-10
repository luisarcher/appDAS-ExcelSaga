package filters.eval;

import model.Cell;
import utils.Constants;

public class FilterEvalPositive extends FilterEval {

    public FilterEvalPositive(Cell decoratedCell) {
        super(decoratedCell);
    }

    public String getFilterId(){
        return Constants.FILTER_EVAL_POSITIVE;
    }
}
