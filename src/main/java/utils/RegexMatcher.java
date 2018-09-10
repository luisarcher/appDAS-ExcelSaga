package utils;

import org.apache.log4j.Logger;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {

    private final static Logger logger = Logger.getLogger(RegexMatcher.class);

    // Ignore case
    public static final String REGEX_IGNORE_CASE = "(?i)";

    //One or more number
    public static final String REGEX_NUMBER = "[0-9]+";

    // Single val - Example A1, CB67
    public static final String REGEX_CELL = "([A-Za-z]{1,2}[0-9]{1,2})";

    // Range - Example "a1:b1"
    public static final String REGEX_RANGE = "("+ REGEX_CELL +"):("+ REGEX_CELL +")";

    // Simple params - A set of cells or numbers are provided - Example SUM a1 d3 g5 45 56
    // Numbers or cell_id
    public static final String REGEX_NUMBER_OR_CELL = "(("+ REGEX_NUMBER +"|"+ REGEX_CELL +" )[\\s\\)]?){2,}";

    // Two param - Example "A1 87", "a1 b6", "10 24"
    //public static final String TWO_CELL_REGEX = "([0-9]+|[a-z]{1,2}[0-9]{1,2})\\s([0-9]+|[a-z]{1,2}[0-9]{1,2})";
    //public static final String SIMPLE_PARAMS_REGEX = "(([0-9]+|[a-z]{1,2}[0-9]{1,2})(\\s|\\))?){3,}";


    public static boolean isFormula(String expression){
        return expression.charAt(0) == '=';
    }

    public static boolean isCell(String expression){

        return expression.matches(REGEX_IGNORE_CASE + REGEX_CELL);
    }

    public static boolean isRange(String expression){

        return expression.matches(REGEX_RANGE);
    }

    public static boolean isNumber(String expression){

        return expression.matches(REGEX_NUMBER);
    }

    /*public static boolean isText(String expression){

        return expression.matches("[A-Za-z]+");
    }*/

    /*public static boolean matchesTwoParams(String func, String expression){

        logger.debug("Attempting to match '" + expression + "' against '" + "(i?)"+ func +"\\s" + TWO_CELL_REGEX + "'");
        return (expression.matches("(?i)"+ func +"\\s" + TWO_CELL_REGEX));
    }*/

    /*public static boolean matchesSimpleParams(String func, String expression){

        final String regex = "(?i)(.*?)" + func + "\\s" + SIMPLE_PARAMS_REGEX;
        logger.debug("Attempting to match: '" + expression + "' against '" + regex + "'");
        return (expression.matches(regex));
    }*/

    /*public static boolean matchesRange(String func, String expression){

        final String regex = "(?i)(.*?)" + func + "\\s" + RANGE_CELL_REGEX;
        logger.debug("Attempting to match: '" + expression + "' against '" + regex + "'");
        return (expression.matches(regex));
    }*/

    /*public static List<String> getParams(String func, String expression){

        String paramRegexType;
        if (matchesSimpleParams(func,expression)){

            paramRegexType = SIMPLE_PARAMS_REGEX;
            logger.debug("Simple params found!");

        } else if (matchesRange(func,expression)){

            paramRegexType = RANGE_CELL_REGEX;
            logger.debug("Range param found!");

        } else {
            logger.debug("Error while trying to get params! " + expression);
            return null;
        }

        /*Pattern pattern = Pattern.compile("(?i)" + func + "\\s" + paramRegexType);
        Matcher matcher = pattern.matcher(expression);

        List<String> _out = new ArrayList<String>();
        // todo Not sure if a "While" is necessary here...
        while (matcher.find()) {
            _out.add(matcher.group(2));
            logger.debug("Param string capture: " + _out);
            return _out;
        }*/
/*
        String[] _parts = expression.split("[\\s\\)]");
        return Arrays.asList(_parts);

    }*/
}
