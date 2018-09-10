import model.Cell;
import model.Sheet;
import org.junit.Test;
import utils.ExpressionParser;

import static org.junit.Assert.*;

public class FilterTest {

    @Test
    public void GetEvalFilterParamTest(){

        // Test parameters
        String cellVal = "25";

        Sheet sheet = new Sheet("Sheet");
        sheet.setValueAt(cellVal,0,0);

        Cell a1 = sheet.getValueById("a1");

        ExpressionParser ep = new ExpressionParser();

        a1.setFilters("pos");
        Cell decA1 = ep.parse(a1);

        assertEquals(decA1.getValue(),"0");

    }
}
