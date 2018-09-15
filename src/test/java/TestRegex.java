import filters.RegexMatcher;
import org.junit.Assert;
import org.junit.Test;

public class TestRegex {

    /*@Test
    public void TestFilterFunctionSumParams(){

        // "=sum " + ...
        String exp = "a2 a2";

        System.out.println(RegexMatcher.REGEX_N_NUMBER_CELL_RANGE);
        boolean res = exp.matches(RegexMatcher.REGEX_N_NUMBER_CELL_RANGE);

        assertEquals(true, res);
    }*/

    @Test
    public void TestOneCellParamRegex(){

        String oneCell = "a1";
        String nCells = "a1 a2 a3";
        String number = "10";
        String word = "aa";
        String range = "a1:b5";

        Assert.assertEquals(true, RegexMatcher.isCell(oneCell));
        Assert.assertEquals(false, RegexMatcher.isCell(nCells));
        Assert.assertEquals(false, RegexMatcher.isCell(number));
        Assert.assertEquals(false, RegexMatcher.isCell(word));
        Assert.assertEquals(false, RegexMatcher.isCell(range));

    }
}
