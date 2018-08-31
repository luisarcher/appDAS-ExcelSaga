package filters.text;

import filters.ConstFilters;
import filters.Filter;
import model.Cell;

public class FilterUppercase extends Filter {

    public FilterUppercase(Cell decoratedCell){

        super(decoratedCell);
    }

    public String removeFilterName(String expression) {

        // Regex to find this filter in the formula and hide it (case insensitive).
        return expression.replaceAll("(?i)"+ConstFilters.UPPERCASE_FILTER,"");
    }

    public String apply(String expression) {
        return expression.toUpperCase();
    }

}
