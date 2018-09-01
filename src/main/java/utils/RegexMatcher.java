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

    // Single val - Example A1, CB67
    public static final String CELL_REGEX = "(?i)[A-Za-z]{1,2}[0-9]{1,2}";

    // Two param - Example "A1 87", "a1 b6", "10 24"
    //public static final String TWO_CELL_REGEX = "([0-9]+|[a-z]{1,2}[0-9]{1,2})\\s([0-9]+|[a-z]{1,2}[0-9]{1,2})";

    // Simple params - A set of cells or numbers are provided - Example SUM a1 d3 g5 45 56
    public static final String SIMPLE_PARAMS_REGEX = "(([0-9]+|[a-z]{1,2}[0-9]{1,2})[\\s\\)]?){2,}";
    //public static final String SIMPLE_PARAMS_REGEX = "(([0-9]+|[a-z]{1,2}[0-9]{1,2})(\\s|\\))?){3,}";

    // Range - Example "a1:b1"
    public static final String RANGE_CELL_REGEX = "([A-Za-z]{1,2}[0-9]{1,2}):([a-z]{1,2}[0-9]{1,2})";


    public static boolean isCell(String expression){

        return expression.matches(CELL_REGEX);
    }

    public static boolean isNumber(String expression){

        return expression.matches("[0-9]+");
    }

    public static boolean isText(String expression){

        return expression.matches("[A-Za-z]+");
    }

    /*public static boolean matchesTwoParams(String func, String expression){

        logger.debug("Attempting to match '" + expression + "' against '" + "(i?)"+ func +"\\s" + TWO_CELL_REGEX + "'");
        return (expression.matches("(?i)"+ func +"\\s" + TWO_CELL_REGEX));
    }*/

    public static boolean matchesSimpleParams(String func, String expression){

        final String regex = "(?i)(.*?)" + func + "\\s" + SIMPLE_PARAMS_REGEX;
        logger.debug("Attempting to match: '" + expression + "' against '" + regex + "'");
        return (expression.matches(regex));
    }

    public static boolean matchesRange(String func, String expression){

        final String regex = "(?i)(.*?)" + func + "\\s" + RANGE_CELL_REGEX;
        logger.debug("Attempting to match: '" + expression + "' against '" + regex + "'");
        return (expression.matches(regex));
    }

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
