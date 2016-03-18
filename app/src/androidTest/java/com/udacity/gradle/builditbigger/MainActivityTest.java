package com.udacity.gradle.builditbigger;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import ru.chipenable.jokeactivity.JokeActivity;


/**
 * Created by Pashgan on 10.03.2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Test
    public void testMainActivityExists() {
        MainActivity mainActivity = getActivity();
        assertNotNull(mainActivity);
        mainActivity.finish();
    }

    @Test
    public void testJokeActivityExists() {
        Instrumentation.ActivityMonitor activityMonitor =
                getInstrumentation().addMonitor(JokeActivity.class.getName(), null, false);
        MainActivity mainActivity = getActivity();
        assertNotNull(mainActivity);

        Button button = (Button)mainActivity.findViewById(R.id.tell_joke_button);
        TouchUtils.clickView(this, button);

        JokeActivity jokeActivity = (JokeActivity)getInstrumentation().waitForMonitor(activityMonitor);
        assertNotNull(jokeActivity);

        jokeActivity.finish();
        mainActivity.finish();
    }

}
