package filters.factory;

import filters.Filter;
import filters.eval.FilterEvalGreaterThan;
import filters.eval.FilterEvalNegative;
import filters.eval.FilterEvalPositive;
import model.Cell;
import filters.Constants;
import model.ICell;

public class FactoryFilterEval extends AbstractFactory {

    @Override
    public Filter getFilter(String filterType, ICell cell) {
        if (filterType.equalsIgnoreCase(Constants.FILTER_EVAL_POSITIVE)){
            return new FilterEvalPositive(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_EVAL_NEGATIVE)){
            return new FilterEvalNegative(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_EVAL_GREATERTHAN)){
            return new FilterEvalGreaterThan(cell);
        }

        return null;
    }
}
