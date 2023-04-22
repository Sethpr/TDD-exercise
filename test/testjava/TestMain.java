package testjava;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized;
import sourcejava.Main;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestMain {
    Main main;

    /**
     * Given: an array of numbers as strings, i.e., {"1", "5", "15", "9", "4"}
     * Task: sort the numbers
     * Restriction: the numbers must stay strings - no converting to integers
     * Edge Cases:
     *  -negative numbers
     *  -decimals
     *  -empty string
     *  -decimal without leading 0
     *  -infinity
     *  -incorrectly formatted numbers
     *  -includes commas or such //maybe more important
     *  -spelled out numbers e.g. "one" instead of "1"
     *  -non-numeric word  e.g. "cat" instead of "1"
     */

    @Parameters
    public static Iterable<String[][]> data() {
        return Arrays.asList(new String[][][] {
                //basic test
                { {"1", "5", "15", "9", "4"}, {"1", "4", "5", "9", "15"} },
                //test with single negative
                { {"1", "5", "15", "9", "-4"}, {"-4", "1", "5", "9", "15"} },
                //test with multiple negatives
                { {"1", "5", "-15", "9", "-4"}, {"-15","-4", "1", "5", "9"} },
                //test with all negatives
                { {"-1", "-5", "-15", "-9", "-4"}, {"-15","-9", "-5", "-4", "-1"} },
                //test with decimals
                { {"1", "4.5", "15", "9", "4"}, {"1", "4", "4.5", "9", "15"} },
                //test with complex decimals
                { {"1", "4.22", "15", "9", "4.5"}, {"1", "4.22", "4.5", "9", "15"} },
                //test with negative decimals
                { {"1", "-4.22", "15", "9", "4.5"}, {"-4.22", "1", "4.5", "9", "15"} },
        });
    }

    @Parameter(0)
    public String[] input;

    @Parameter(1)
    public String[] expected;

    @Before
    public void setup(){
        main = new Main();
    }

    @Test
    public void test() {
        String[] actual = main.sortStringsAsNumbers(input);
        Assert.assertEquals(expected, actual);
    }

}
