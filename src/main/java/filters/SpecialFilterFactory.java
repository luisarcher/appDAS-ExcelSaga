package filters;

import filters.text.FilterUppercase;
import model.Cell;

public class SpecialFilterFactory implements AbstractFactory {

    public Filter getFilter(String filterType, Cell cell) {

        if (filterType.equalsIgnoreCase(ConstFilters.FORMULA_CHAR_FILTER)) {
            return new FilterSpecialChars(cell);
        }

        return null;
    }
}
