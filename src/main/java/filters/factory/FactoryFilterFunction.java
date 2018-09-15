package filters.factory;

import filters.Filter;
import filters.functions.FilterFunctionConcat;
import filters.functions.FilterFunctionCopy;
import filters.functions.FilterFunctionMultiply;
import filters.functions.FilterFunctionSum;
import filters.Constants;
import model.ICell;

public class FactoryFilterFunction extends AbstractFactory{

    @Override
    public Filter getFilter(String filterType, ICell cell) {

        if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_SUM)){

            return new FilterFunctionSum(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_MUL)){

            return new FilterFunctionMultiply(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_CONCAT)){

            return new FilterFunctionConcat(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_COPY)){

            return new FilterFunctionCopy(cell);
        }

        return null;
    }
}
