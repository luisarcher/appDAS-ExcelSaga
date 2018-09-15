import controllers.command.CommandManager;
import controllers.command.CommandSetCellValue;
import model.Sheet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Test
    public void CommandOperationsTest(){

        Sheet sheet = new Sheet("Sheet");
        CommandManager cm = new CommandManager(sheet);

        CommandSetCellValue cmd = new CommandSetCellValue("5",0,0);
        cm.apply(cmd);

        CommandSetCellValue cmd2 = new CommandSetCellValue("10",0,0);
        cm.apply(cmd2);

        System.out.println("Sheet value before undo: " + sheet.getValueAt(0,0));

        cm.undo();

        assertEquals("5", sheet.getValueById("a1").getValue());

    }
}
