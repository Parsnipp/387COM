package com.example.callum.cookbook;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.anything;

/**
 * Created by Callum on 07/12/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class RecipeDatabaseActivityTests {

    @Rule
    public ActivityTestRule<RecipeDatabaseActivity> activityTestRule = new ActivityTestRule<>(
            RecipeDatabaseActivity.class);

    @Test
    public void changeActivity() throws InterruptedException {
        onData(anything()).inAdapterView(withId(R.id.listView2)).atPosition(1).perform(click());
        sleep(1000);
        onView(withId(R.id.nameTextView)).check(matches(withText("Curry")));
    }
}
