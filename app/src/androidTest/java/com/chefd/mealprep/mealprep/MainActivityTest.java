package com.chefd.mealprep.mealprep;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jose Ramirez
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test   /*Given the user is on the main activity
                When the user press the breakfast button
                    Then the user will see a breakfast meal*/
    public void CheckBreakfastButton() {
        //given Im in the current activity
        onView(withId(R.id.breakfast)).check(matches(isDisplayed()));
        // when press the button breakfast button
        onView(withId(R.id.breakfast)).perform(click());

        // This make sure that the recycler view is vissible with current item
        // This is a different activity no need to tell espresso , check what should be showing
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }
}
