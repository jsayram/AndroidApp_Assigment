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
public class NotesActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test   /*Given I have a meal I’d like append it’s cooking
                when I push the add meal note button
                   then it takes me to a user input screen*/
    public void CheckNotesButton() {
        //given Im in the current activity
        onView(withId(R.id.noteButton)).check(matches(isDisplayed()));
        // when press the button for notes
        onView(withId(R.id.noteButton)).perform(click());
        // This make sure that the noteIcon is visible with current item
        // This is a different activity no need to tell espresso , check what should be showing
        onView(withId(R.id.noteImage)).check(matches(isDisplayed()));
    }
}
