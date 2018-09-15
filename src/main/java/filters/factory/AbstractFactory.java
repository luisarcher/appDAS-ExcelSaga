package filters.factory;

import filters.Filter;
import model.Cell;
import filters.Constants;
import model.ICell;

public abstract class AbstractFactory {

    public static AbstractFactory getFactory(String filterType){
        if (filterType.equalsIgnoreCase(Constants.FUNCTION_FILTER_TYPE)){
            return new FactoryFilterFunction();
        }

        if (filterType.equalsIgnoreCase(Constants.EVAL_FILTER_TYPE)){
            return new FactoryFilterEval();
        }
        return null;
    }

    public abstract Filter getFilter(String filterType, ICell cell);

}
