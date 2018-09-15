package filters;

// make the class non-extendable by adding final
public final class Constants {

    // Functions
    public static final String FUNCTION_FILTER_TYPE = "func";

    public static final String FILTER_FUNCTION_SUM = "sum";
    public static final String FILTER_FUNCTION_MUL = "mul";
    public static final String FILTER_FUNCTION_CONCAT = "concat";


    // Eval
    public static final String EVAL_FILTER_TYPE = "eval";

    public static final String FILTER_EVAL_POSITIVE = "pos";
    public static final String FILTER_EVAL_NEGATIVE = "neg";
    public static final String FILTER_EVAL_GREATERTHAN = "gt";

    // Special
    public static final String ERROR_PARAM = "#PARAM";
    public static final String ERROR_FILTER = "#FILTER";


    // this class is non-instantiable
    private Constants(){}

}