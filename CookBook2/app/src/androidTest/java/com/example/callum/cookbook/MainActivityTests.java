package com.example.callum.cookbook;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Callum on 08/12/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTests {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void testOne() throws InterruptedException {
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        sleep(1000);
        intended(hasComponent(equalTo(new ComponentName(getTargetContext(), RecipeDatabaseActivity.class))));
    }
}
