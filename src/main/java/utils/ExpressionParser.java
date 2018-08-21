package utils;

public class ExpressionParser {

    public ExpressionParser(){

    }

    public ExpressionParser(String expression){

        this.parse(expression);
    }

    public void parse(String expression){

    }

    private boolean isCell(String expression){

        return expression.matches("[a-z]{1,2}[0-9]{1,2}");
    }
}
