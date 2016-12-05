package com.chefd.mealprep.mealprep;

/**
 * Created by Brad on 12/4/2016.
*/


import org.junit.Test;
import static org.junit.Assert.*;


public class CaloriesCalculatorTest {

    @Test
    public void testheightIn(){

        double heightF = 5;
        double heightI = 9;

        double Expected = 69;
        double Actual = (heightF * 12) + heightI;
        double Epsilon = 0;

        assertEquals (Expected, Actual, Epsilon);
    }

    @Test
    public void testweightK(){

        double weight = 220;

        double Expected = 100;
        double Actual =  weight / 2.20;
        double Epsilon = .1;

        assertEquals (Expected, Actual, Epsilon);
    }

    @Test
    public void testheightCm(){
        double heightIn = 69;

        double Expected = 175.26;
        double Actual =  heightIn * 2.54;
        double Epsilon = 0;

        assertEquals (Expected, Actual, Epsilon);

    }

    @Test
    public void testfemalecalories(){
        double heightCm = 156;
        double weightK = 65;
        int age = 22;

        double Expected = 1470.79;
        double Actual =  (665.09 + (9.56 * weightK)
                + (1.84 * heightCm) - (4.67 * age));
        double Epsilon = 0;

        assertEquals (Expected, Actual, Epsilon);

    }

   @Test
    public void testmalecalories(){
        double heightCm = 180;
        double weightK = 80;
        int age = 22;

        double Expected = 1917.97;
        double Actual =  (66.47 + (13.75 * weightK)
                + (5.0 * heightCm) - (6.75 * age));
        double Epsilon = 0.1;

        assertEquals (Expected, Actual, Epsilon);

    }

}
