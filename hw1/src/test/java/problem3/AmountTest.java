package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private Amount amount, amount2;
    @Before
    public void setUp() throws Exception {
        amount = new Amount(99, 99);
        amount2 = new Amount(64, 34);
    }

    @Test
    public void getDollar() {
        assertEquals(99, amount.getDollar());
        assertEquals(64, amount2.getDollar());
    }

    @Test
    public void getCents() {
        assertEquals(99, amount.getCents());
        assertEquals(34, amount2.getCents());
    }
}