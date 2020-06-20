package org.junit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUpList(){
        values = new ArrayList<String>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void testWithoutHamcrest(){
        assertTrue(values.contains("1")||values.contains("2")||values.contains("3"));
    }

    @Test
    public void testWithHamcrest(){
       //assertThat(values,hasItems("one","two","three"));

    }

}
