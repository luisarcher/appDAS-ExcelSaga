package filters;

import filters.text.TextFilterFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String filterType){
        if (filterType.equalsIgnoreCase(ConstFilters.NUMERIC_FILTERS)){

            return new NumericFilterFactory();

        } else if (filterType.equalsIgnoreCase(ConstFilters.TEXT_FILTERS)){

            return new TextFilterFactory();

        } else if (filterType.equalsIgnoreCase(ConstFilters.EVALUATION_FILTERS)){

            return new EvaluationFilterFactory();

        } else if (filterType.equalsIgnoreCase(ConstFilters.SPECIAL_FILTERS)){

            return new SpecialFilterFactory();
        }
        return null;
    }
}