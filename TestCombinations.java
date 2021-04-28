import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCombinations {
    private static Dice[] d ;
    private CombinationCalculator cc = new CombinationCalculator();


    @Before
    public void setUp() throws Exception {
        d = new Dice[5];
        for (int j =0;j<5;j++) {
            d[j] = new Dice();
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int j =0;j<5;j++) {
            d[j] = null;
        }
    }

    @Test
    public final void testScoreForOnes() {
        int[] dval = {1,2,3,4,5}; for (int j=0;j<5;j++) d[j].setFaceValue(dval[j]);
        assertEquals(1, cc.checkMatches(d,1));

        dval = new int[] {2,3,4,5,6}; for (int j=0;j<5;j++) d[j].setFaceValue(dval[j]);
        assertEquals(0, cc.checkMatches(d,1));

        dval = new int[] {5,5,6,2,3}; for (int j=0;j<5;j++) d[j].setFaceValue(dval[j]);
        assertEquals(0, cc.checkMatches(d,1));

        dval = new int[] {5,1,6,2,1}; for (int j=0;j<5;j++) d[j].setFaceValue(dval[j]);
        assertEquals(2, cc.checkMatches(d,1));

        dval = new int[] {1,5,1,1,1}; for (int j=0;j<5;j++) d[j].setFaceValue(dval[j]);
        assertEquals(4, cc.checkMatches(d,1));

    }

}