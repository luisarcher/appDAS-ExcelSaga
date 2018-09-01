package filters.numeric;

import filters.ConstFilters;
import filters.Filter;
import model.Cell;
import org.apache.log4j.Logger;
import utils.RegexMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterSum extends Filter {

    private final static Logger logger = Logger.getLogger(FilterSum.class);

    public FilterSum(Cell decoratedCell) {
        super(decoratedCell);
    }

    public String removeFilterName(String expression) {
        return expression.replaceAll("(?i)" + ConstFilters.SUM_FILTER,"");
    }

    public String apply(String expression) {

        logger.debug("Applying " + this.getClass().getName() + " to " + expression);

        //Expression myExpression = new Expression();

        //myExpression.setFormula(ConstFilters.SUM_FILTER);
        //myExpression.setParams(RegexMatcher.getParams(ConstFilters.SUM_FILTER,expression));

        String thisFilterFormula = expression;

        // Get numeric operation
        if (expression.contains("(") && expression.contains(")")){
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find())
            {
                thisFilterFormula = matcher.group(1);
            }
        }

        logger.debug("Expression: " + expression);

        if (thisFilterFormula.contains(":")){

        } else {
            return expression.replaceAll(thisFilterFormula, parseSimpleParams(Arrays.asList(thisFilterFormula.split(" "))));
        }

        /*String result = parseSimpleParams(myExpression.getParams());
        logger.debug("Converting '" + myExpression.toString() + "' into '" + result + "'");*/


        return expression;

    }

    public String parseSimpleParams(List<String> params){

        Integer result = 0;

        for(String _part : params){

            logger.debug("Parsing '" + _part + "'");
            if (RegexMatcher.isCell(_part)){
                _part = getModel().getValueById(_part).getValue();
            }
            if (RegexMatcher.isNumber(_part) ){
                result = result + Integer.parseInt(_part);
            }
            else {
                logger.debug("Error while trying to calc '" + _part + "' in '" + params + "'");
            }
            logger.debug("Result: "+ result.toString());
        }
        return result.toString();
    }

    @Override
    public boolean acceptedParams(String expression){
        return (RegexMatcher.matchesSimpleParams(ConstFilters.SUM_FILTER,expression)
                || RegexMatcher.matchesRange(ConstFilters.SUM_FILTER,expression));
    }
}
