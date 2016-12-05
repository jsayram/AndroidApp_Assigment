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
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jose Ramirez
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DinnerActivityTest {
    @Rule
    public ActivityTestRule<DinnerActivity> mActivityRule = new ActivityTestRule(DinnerActivity.class);

    @Test  /*Given the user is on the main activity
            When the user press the dinner button
            Then the user will see a dinner meal*/
    public void CheckDinnerProteinButton(){
        //find button on current activity.
        onView(withId(R.id.protein_dinner)).check(matches(isDisplayed()));
        //  press the button on current activity
        onView(withId(R.id.protein_dinner)).perform(click());
        // This is a different activity no need to tell espresso , check what should be showing
        onView(withId(R.id.protein_text)).check(matches(withText("MADE")));
    }
}
