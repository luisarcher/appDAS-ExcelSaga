import model.RowCol;
import model.Sheet;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetDataFromSheet {

    @Test
    public void getCellValueById(){

        Sheet sheet = new Sheet("Sheet");
        String cellVal = "25";

        sheet.setValueAt(cellVal,0,0);

        String _out = sheet.getValueById("a1").getValue();

        assertEquals(cellVal,_out);

    }
    @Test
    public void TestCoordsConverting(){

        assertEquals("C3", RowCol.getCoordsAsId(2,2));
    }

}
