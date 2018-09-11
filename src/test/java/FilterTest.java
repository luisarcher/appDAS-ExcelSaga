import model.Cell;
import model.Sheet;
import org.junit.Test;
import utils.ExpressionParser;

import static org.junit.Assert.*;

public class FilterTest {

    @Test
    public void PositiveEvalFilterTest(){

        // Test parameters
        String cellVal = "-25";

        Sheet sheet = new Sheet("Sheet");
        sheet.setValueAt(cellVal,0,0);

        Cell a1 = sheet.getValueById("a1");
        a1.setFilters("pos");

        ExpressionParser ep = new ExpressionParser();
        Cell decA1 = ep.parse(a1);

        assertEquals("",decA1.getValue());

    }

    @Test
    public void NegativeEvalFilterTest(){

        // Test parameters
        String cellVal = "25";

        Sheet sheet = new Sheet("Sheet");
        sheet.setValueAt(cellVal,0,0);

        Cell a1 = sheet.getValueById("a1");
        a1.setFilters("neg");

        ExpressionParser ep = new ExpressionParser();
        Cell decA1 = ep.parse(a1);

        assertEquals("",decA1.getValue());

    }

    @Test
    public void GreaterThanEvalFilterTest(){

        // Test parameters
        String cellVal = "25";

        Sheet sheet = new Sheet("Sheet");
        sheet.setValueAt(cellVal,0,0);

        Cell a1 = sheet.getValueById("a1");
        //a1.setFilters("robert de niro gt(=sum 20 10)");
        a1.setFilters("joe pesci gt(=mul 10 3)");

        ExpressionParser ep = new ExpressionParser();
        Cell decA1 = ep.parse(a1);

        assertEquals("",decA1.getValue());

    }
}
