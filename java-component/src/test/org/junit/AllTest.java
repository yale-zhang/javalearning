package org.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {CalculatorTest.class,ParameterizedTest.class})
public class AllTest {
}
