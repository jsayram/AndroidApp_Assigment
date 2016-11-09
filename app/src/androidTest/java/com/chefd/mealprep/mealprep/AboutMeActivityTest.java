package com.chefd.mealprep.mealprep;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Jose Ramirez
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AboutMeActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test   /*Given I am on the home screen
                When I click the about me button
                    Then I am taken to the about page*/
    public void CheckAboutMeButton() {
        //given Im in the current activity check if wanted button is displayed
        onView(withId(R.id.aboutButton)).check(matches(isDisplayed()));
        // when press the button CalorieButton button
        onView(withId(R.id.aboutButton)).perform(click());
        // This make sure that the about me is visible with current item
        // This is a different activity no need to tell espresso , check what should be showing
        onView(withId(R.id.content_aboutme)).check(matches(isDisplayed()));
    }
}
