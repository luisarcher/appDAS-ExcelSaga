import model.Sheet;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetDataFromSheet {

    @Test
    public void getCellValueById(){

        Sheet sheet = new Sheet("Sheet");

        String cellVal = "25";
        sheet.setValueAt(cellVal,0,0);

        String _out = sheet.getValueById("A1").getValue();

        assertEquals(cellVal,_out);

    }

}
