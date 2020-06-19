package org.junit;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        double add = calculator.add(1, 1);
        assertEquals(2,add,0);
    }
}
