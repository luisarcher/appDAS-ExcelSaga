package filters.eval;

import filters.Filter;
import model.Cell;
import org.apache.log4j.Logger;
import utils.Constants;
import utils.ExpressionParser;
import utils.RegexMatcher;

public abstract class FilterEval extends Filter{

    private final static Logger logger = Logger.getLogger(FilterEval.class);

    FilterEval(Cell decoratedCell){
        super(decoratedCell);
    }

    abstract String eval(String cellValue, String filterParam);
    abstract String getFilterId();

    @Override
    protected boolean acceptedParams(String expression) {
        return true;
    }

    @Override
    public String apply(String decoratedCellValue) {

        String filterParam = getFilterParam(this.decoratedCell.getFilters());

        if (!filterParam.equalsIgnoreCase("")){
            if (RegexMatcher.isFormula(filterParam)){
                ExpressionParser ep = new ExpressionParser(new Cell(getModel(),filterParam));
                filterParam = ep.parse().getValue();
            }
        }

        // Base class will decide if it wants to accept "" or not.
        if (isAcceptedParam(filterParam)){
            return eval(decoratedCellValue, filterParam);
        }

        return Constants.ERROR_FILTER;
    }

    public String getFilterParam(String filterVector){

        // We can't split the filterVector right way,
        // as filters may contain params with white spaces.
        // Since we can't apply a split pattern, we'll get the param in ( ) of this filter.

        logger.debug("'" + getFilterId() + "' in Filters: '" + filterVector + "'");

        int indexOfFilterId = filterVector.toLowerCase().indexOf(getFilterId().toLowerCase());
        int indexStartOfParam = indexOfFilterId + getFilterId().length() + 1;
        int indexEndOfParam = -1;

        if (indexStartOfParam > filterVector.length()){
            return Constants.ERROR_FILTER;
        }

        // If char after filter is '(', we have a param
        if (filterVector.charAt(indexStartOfParam-1) == '('){

            // Lets find the right 'close' param char in order to get the index
            indexEndOfParam = filterVector.substring(indexStartOfParam).indexOf(')') + indexStartOfParam;

            if (indexEndOfParam == -1){
                return Constants.ERROR_FILTER;
            }

            logger.debug("fi: " + indexOfFilterId + " start: " + indexStartOfParam + " end: " + indexEndOfParam);

            // Get the param between brackets
            String param = filterVector.substring(indexStartOfParam, indexEndOfParam);
            logger.debug("Filter: '" + getFilterId() + "' param: '" + param + "'");

            // Make sure there is no extra brackets in param
            if (param.indexOf('(') == -1){
                return param;
            }
        }
        return Constants.ERROR_FILTER;
    }
}
