package com.chefd.mealprep.mealprep;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jose Ramirez
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalorieActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test   /*Given the user is on the main activity
                When the user press the calorie calculator button
                    Then the user will see a calorie calculator screen*/

                /*Given I am trying to have a certain amount of
                                calories from a certain food group
                  when I press the calorie counter button
                  then I will receive a list of calories from certain food groups*/

    public void CalorieActivityTest() {
        //given Im in the current activity check if wanted button is displayed
        onView(withId(R.id.CalorieButton)).check(matches(isDisplayed()));
        // when press the button CalorieButton button
        onView(withId(R.id.CalorieButton)).perform(click());
        // This make sure that the calculator is visible with current item
        // This is a different activity no need to tell espresso ,
        // check what should be showing
        onView(withId(R.id.textBmr)).check(matches(isDisplayed()));

        //edit text fields with testing information
        onView(withId(R.id.editAge)).perform(clearText(),
                typeText("25")).check(matches(isDisplayed()));
        onView(withId(R.id.editWeight)).perform(clearText(),
                typeText("130")).check(matches(isDisplayed()));
        onView(withId(R.id.editHeightf)).perform(clearText(),
                typeText("5")).check(matches(isDisplayed()));
        onView(withId(R.id.editHeighti)).perform(clearText(),
                typeText("4")).check(matches(isDisplayed()));

        //closes soft keyboard so that buttons can be clicked
        closeSoftKeyboard();
        // see if submit button is displayed
        onView(withId(R.id.submitButton)).check(matches(isDisplayed()));
        // when press the button
        onView(withId(R.id.submitButton)).perform(click());

        //check calorie view screen
        onView(withId(R.id.calorieviewButton)).check(matches(isDisplayed()));
        // when press the button
        onView(withId(R.id.calorieviewButton)).perform(click());

        //check if listView is displayed
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

        //swipe through list see if it scrolls efficiently
        onView(withId(R.id.listView)).perform(swipeUp());
        onView(withId(R.id.listView)).perform(swipeDown());
        onView(withId(R.id.listView)).perform(swipeUp());
    }
}
