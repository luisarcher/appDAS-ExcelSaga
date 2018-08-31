package filters;

import model.Cell;

public class FilterSum extends Filter {
    public FilterSum(Cell decoratedCell) {
        super(decoratedCell);
    }

    public String removeFilterName(String expression) {
        return expression.replaceAll(ConstFilters.SUM_FILTER,"");
    }

    public String apply(String expression) {
        return expression;
    }
}
