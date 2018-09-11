package filters.functions;

import filters.Filter;
import model.Cell;
import org.apache.log4j.Logger;
import utils.CellRange;
import utils.Constants;
import utils.ExpressionParser;
import utils.RegexMatcher;

public abstract class FilterFunction /*<T,K>*/ extends Filter{

    private final static Logger logger = Logger.getLogger(FilterFunction.class);

    //abstract T calc(K baseValue, K newValue);
    abstract String calc(String baseValue, String newValue);

    public FilterFunction(Cell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean acceptedParams(String expression) {
        return true;
    }


    @Override
    public String apply(String expression) {

        logger.debug("Applying " + this.getClass().getName() + " to " + expression);

        String cellResult = "";
        String[] _parts = expression.split("\\s");

        for (String _part : _parts){
            if (_part.startsWith("="))
                continue;

            cellResult = calculateParameterValue(cellResult,_part);

        }

        return cellResult;
    }

    public String calculateParameterValue(String baseValue, String _part){

        if (_part.isEmpty() || _part.equalsIgnoreCase(""))
            return baseValue;

        String newValue = paramParser(_part);
        if (newValue.equalsIgnoreCase(Constants.ERROR_PARAM)){
            return Constants.ERROR_PARAM;
        }

        if (baseValue.length() < 1)
            return newValue;

        return calc(baseValue,newValue);

    }

    public String paramParser(String _part){

        logger.debug("Parsing: '" + _part + "'");

        if (RegexMatcher.isCell(_part)){

            ExpressionParser ep = new ExpressionParser();
            return paramParser(ep.parse(this.getModel().getValueById(_part)).getValue());
        }

        if (RegexMatcher.isRange(_part)){
            return calculateRange(_part);
        }

        if (isAcceptedParam(_part)){

            return _part;
        }

        logger.debug("Error parsing '" + _part + "' as number!");
        return Constants.ERROR_PARAM;
    }

    private String calculateRange(String param){

        String rangeResult = "";
        String[] _limits = param.toUpperCase().split(":");

        CellRange range = new CellRange(
                getModel().convertToCoords(_limits[0]),
                getModel().convertToCoords(_limits[1])
        );

        for (int i = range.getMinimumRow(); i <= range.getMaximumRow(); i++){
            for (int j = range.getMinimumColumn(); j <= range.getMaximumColumn(); j++){

                ExpressionParser ep = new ExpressionParser(getModel().getValueAt(i,j));
                rangeResult = calculateParameterValue(rangeResult, ep.parse().getValue());
            }
        }

        return rangeResult;
    }
}
