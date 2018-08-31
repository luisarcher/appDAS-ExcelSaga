package filters.text;

import filters.AbstractFactory;
import filters.ConstFilters;
import filters.Filter;
import model.Cell;

public class TextFilterFactory implements AbstractFactory {
    public Filter getFilter(String filterType, Cell cell) {

        if (filterType.equalsIgnoreCase(ConstFilters.UPPERCASE_FILTER)) {
            return new FilterUppercase(cell);
        }

        return null;
    }
}
