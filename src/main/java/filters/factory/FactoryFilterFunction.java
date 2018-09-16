package filters.factory;

import filters.Filter;
import filters.functions.*;
import filters.Constants;
import model.ICell;

public class FactoryFilterFunction extends AbstractFactory{

    @Override
    public Filter getFilter(String filterType, ICell cell) {

        if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_SUM)){

            return new FilterFunctionSum(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_SUB)){
            return new FilterFunctionSub(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_MUL)){

            return new FilterFunctionMultiply(cell);
        }
        else if (filterType.equalsIgnoreCase(Constants.FILTER_FUNCTION_DIV)){
            return new FilterFunctionDiv(cell);
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
