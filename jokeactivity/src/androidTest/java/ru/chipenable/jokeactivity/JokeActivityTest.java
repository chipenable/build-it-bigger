package ru.chipenable.jokeactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.AndroidTestCase;
import android.test.UiThreadTest;
import android.widget.TextView;

import junit.framework.TestCase;


/**
 * Created by Pashgan on 08.03.2016.
 */
public class JokeActivityTest extends ActivityInstrumentationTestCase2<JokeActivity> {

    public JokeActivityTest() {
        super(JokeActivity.class);
    }


    public void testMakeIntent() {
        Context context = getInstrumentation().getContext();
        String joke = "it's a test joke";
        Intent intent = JokeActivity.makeIntent(context, joke);
        assertNotNull(intent);

        /*getInstrumentation().start
        JokeActivity jokeActivity = getActivity();
        assertNotNull(jokeActivity);*/

        /*context.startActivity(intent);
        Activity activity = getActivity();
        TextView jokeView = (TextView)activity.findViewById(R.id.joke_text_view);
        assertEquals(jokeView.getText().toString(), joke);*/
    }



}