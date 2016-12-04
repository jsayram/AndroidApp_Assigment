package com.chefd.mealprep.mealprep;


import org.junit.Test;

import static org.junit.Assert.*;


 /* To work on unit tests, switch the Test Artifact in the Build Variants view.
*/
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
       // assertEquals(4, 2 + 2);
        double Expected = 69;
        double Actual = (5 * 12) + 9;
        double Epsilon = 0;

        assertEquals (Expected, Actual, Epsilon);
    }
}