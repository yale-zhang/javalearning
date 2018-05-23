package com.google.common.base;

import junit.framework.TestCase;

public class OptionalTest extends TestCase {

    public void testToJavaUtil_static() {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
        assertTrue(possible.isPresent());
        //assertEquals(possible.get(),5);
    }

}
