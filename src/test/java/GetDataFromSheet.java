import model.Sheet;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetDataFromSheet {

    @Test
    public void getCellValueById(){

        Sheet sheet = new Sheet("Sheet");

        String cellVal = "25";
        sheet.setValueAt(cellVal,1,1);

        String _out = sheet.getValueById("A1").getValue();

        System.out.println("Val A1: " + _out);
        System.out.println("Val 0,0: " + sheet.getValueAt(0,0).getValue());
        System.out.println("Val 1,1: " + sheet.getValueAt(1,1).getValue());

        assertEquals(cellVal,_out);

    }

}
