package filters;

import model.Cell;

public class FilterSpecialChars extends Filter {

    public FilterSpecialChars(Cell decoratedCell) {
        super(decoratedCell);
    }

    public String removeFilterName(String expression) {
        return expression.replaceAll(ConstFilters.FORMULA_CHAR_FILTER, "");
    }

    public String apply(String expression) {
        return expression;
    }

}
