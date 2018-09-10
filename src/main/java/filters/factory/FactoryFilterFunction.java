package filters.factory;

import filters.Filter;
import filters.functions.FilterFunctionMultiply;
import filters.functions.FilterFunctionSum;
import model.Cell;
import utils.Constants;

public class FactoryFilterFunction extends AbstractFactory{

    @Override
    public Filter getFilter(String filterType, Cell cell) {

        if (filterType.equalsIgnoreCase(Constants.SUM_FILTER)){

            return new FilterFunctionSum(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.MUL_FILTER)){

            return new FilterFunctionMultiply(cell);
        }

        return null;
    }
}
