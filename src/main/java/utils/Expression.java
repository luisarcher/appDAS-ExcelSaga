package utils;

import java.util.ArrayList;
import java.util.List;

public class Expression{

    private String formula;
    private List<String> params;

    public Expression(String formula, List params){
        this.formula = formula;
        this.params = new ArrayList<String>(params);
    }

    public Expression(){

    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = new ArrayList<String>(params);
    }

    @Override
    public String toString() {

        String _out = this.formula;

        for (String _part : this.params){
            _out = _out + " " + _part;
        }
        return _out;
    }
}
