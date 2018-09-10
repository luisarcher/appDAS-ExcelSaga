package filters.factory;

import filters.Filter;
import model.Cell;
import utils.Constants;

public abstract class AbstractFactory {

    public static AbstractFactory getFactory(String filterType){
        if (filterType.equalsIgnoreCase(Constants.FUNCTION_FILTER_TYPE)){
            return new FactoryFilterFunction();
        }
        return null;
    }

    public abstract Filter getFilter(String filterType, Cell cell);

}
