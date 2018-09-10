package filters.eval;

import filters.Filter;
import model.Cell;
import org.apache.log4j.Logger;

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

        return eval(decoratedCellValue, getFilterParam(this.decoratedCell.getFilters()));
        // Se o valore retornado de getFilter Param for uma formula, passar para um parseFunctionFilter(new Cell(resultado de getFilterParam)
    }

    public String getFilterParam(String filterVector){

        // We can't split the filterVector right way,
        // as filters may contain params with white spaces.
        // Since we can't apply a split pattern, we'll get the param in ( ) of this filter.

        /*if (expression.contains("(") && expression.contains(")")){
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find())
            {
                thisFilterFormula = matcher.group(1);
            }
        }*/

        logger.debug(getFilterId() + "in Filters: " + filterVector);

        int indexOfFilterId = filterVector.indexOf(getFilterId());
        int indexStartOfParam = indexOfFilterId + getFilterId().length();
        int indexEndOfParam = -1;

        // If char after filter is '(', we have a param
        if (filterVector.charAt(indexOfFilterId) == '('){

            // Lets find the right 'close' param char in order to get the index
            indexEndOfParam = filterVector.substring(indexStartOfParam).indexOf(')');

            // Get the param between brackets
            String param = filterVector.substring(indexStartOfParam, indexEndOfParam-1);
            logger.debug("Filter: " + getFilterId() + " param: '" + param + "'");

            // Make sure there is no extra brackets in param
            if (param.indexOf('(') == -1){
                return param;
            }
        }
        return "";
    }
}
