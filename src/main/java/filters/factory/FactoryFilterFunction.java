package filters.factory;

import filters.Filter;
import filters.functions.FilterFunctionConcat;
import filters.functions.FilterFunctionMultiply;
import filters.functions.FilterFunctionSum;
import model.Cell;
import utils.Constants;

public class FactoryFilterFunction extends AbstractFactory{

    @Override
    public Filter getFilter(String filterType, Cell cell) {

        if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_SUM)){

            return new FilterFunctionSum(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_MUL)){

            return new FilterFunctionMultiply(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_CONCAT)){

            return new FilterFunctionConcat(cell);
        }

        return null;
    }
}
