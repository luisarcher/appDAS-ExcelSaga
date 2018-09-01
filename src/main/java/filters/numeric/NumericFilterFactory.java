package filters.numeric;

import filters.AbstractFactory;
import filters.ConstFilters;
import filters.Filter;
import model.Cell;

public class NumericFilterFactory implements AbstractFactory {

    public Filter getFilter(String filterType, Cell cell) {

        if (filterType.equalsIgnoreCase(ConstFilters.SUM_FILTER)) {
            return new FilterSum(cell);
        }

        return null;
    }
}