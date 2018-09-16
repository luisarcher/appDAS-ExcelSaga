package filters.functions;

import filters.*;
import model.Cell;
import model.Coords;
import model.ICell;
import org.apache.log4j.Logger;

public abstract class FilterFunction /*<T,K>*/ extends Filter{

    private final static Logger logger = Logger.getLogger(FilterFunction.class);

    //abstract T calc(K baseValue, K newValue);
    abstract String calc(String baseValue, String newValue);

    public FilterFunction(ICell decoratedCell) {
        super(decoratedCell);
    }

    @Override
    protected boolean acceptedParams(String expression) {
        return true;
    }

    @Override
    public String apply(String expression) {

        logger.debug("Applying " + this.getClass().getName() + " to '" + expression + "'");

        String cellResult = "";
        String[] _parts = expression.split("\\s");

        for (String _part : _parts){

            // Jumps formula Id
            if (_part.startsWith("="))
                continue;

            cellResult = calculateParameterValue(cellResult,_part);

            if (RegexMatcher.isError(cellResult)){
                return cellResult;
            }
        }

        return cellResult;
    }

    public String calculateParameterValue(String baseValue, String _part){

        if (_part.isEmpty() || _part.equalsIgnoreCase(""))
            return baseValue;

        String newValue = paramParser(_part);

        if ((baseValue.length() < 1) || (RegexMatcher.isError(newValue)))
            return newValue;

        return calc(baseValue,newValue);

    }

    public String paramParser(String _part){

        logger.debug("Parsing: '" + _part + "'");

        if (RegexMatcher.isCell(_part)){

            ExpressionParser ep = new ExpressionParser();
            return paramParser(ep.parse(this.decoratedCell.getModel().getValueById(_part)).getValue());
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
                Coords.parseCoords(_limits[0]),
                Coords.parseCoords(_limits[1])
        );

        if (this.isInRange(range)){
            return Constants.ERROR_CYCLIC;
        }

        for (int i = range.getMinimumRow(); i <= range.getMaximumRow(); i++){
            for (int j = range.getMinimumColumn(); j <= range.getMaximumColumn(); j++){

                ExpressionParser ep = new ExpressionParser(this.decoratedCell.getModel().getValueAt(i,j));
                rangeResult = calculateParameterValue(rangeResult, ep.parse().getValue());
            }
        }

        return rangeResult;
    }

    private boolean isInRange(CellRange range){

        return (this.decoratedCell.getCoords().getRow() >= range.getMinimumRow()
                || this.decoratedCell.getCoords().getRow() <= range.getMaximumRow())
                &&
                (this.decoratedCell.getCoords().getColumn() >= range.getMinimumColumn()
                || this.decoratedCell.getCoords().getColumn() <= range.getMaximumColumn());
    }
}
