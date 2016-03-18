package com.udacity.gradle.builditbigger;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import org.junit.runner.RunWith;

import ru.chipenable.jokeactivity.JokeActivity;

import static org.junit.Assert.*;

/**
 * Created by Pashgan on 10.03.2016.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public EndpointsAsyncTaskTest() {
        super(MainActivity.class);
    }

    public void testEndpointAsyncTask(){
        Instrumentation.ActivityMonitor activityMonitor =
                getInstrumentation().addMonitor(JokeActivity.class.getName(), null, false);
        MainActivity mainActivity = getActivity();
        assertNotNull(mainActivity);

        Button button = (Button)mainActivity.findViewById(R.id.tell_joke_button);
        TouchUtils.clickView(this, button);

        JokeActivity jokeActivity = (JokeActivity)getInstrumentation().waitForMonitor(activityMonitor);
        assertNotNull(jokeActivity);

        TextView textView = (TextView)jokeActivity.findViewById(R.id.joke_text_view);
        String joke = textView.getText().toString();
        assertTrue(joke.length() > 0);

        jokeActivity.finish();
        mainActivity.finish();
    }



}