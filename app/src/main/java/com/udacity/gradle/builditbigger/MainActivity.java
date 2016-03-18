package com.udacity.gradle.builditbigger;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import ru.chipenable.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity {

    public static final int JOKE_REQUEST = 1;
    private static final String ASYNC_TASK_RUN = "async_task_run";
    private boolean mAsyncTaskRun;
    private ProgressBar mProgressBar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == JOKE_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                mAsyncTaskRun = false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        if (savedInstanceState != null) {
            mAsyncTaskRun = savedInstanceState.getBoolean(ASYNC_TASK_RUN);
            if (mAsyncTaskRun) {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ASYNC_TASK_RUN, mAsyncTaskRun);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (!mAsyncTaskRun){
            new EndpointsAsyncTask().execute(this);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    public void startJokeActivity(String joke){
        mProgressBar.setVisibility(View.GONE);
        Intent intent = JokeActivity.makeIntent(this, joke);
        startActivityForResult(intent, MainActivity.JOKE_REQUEST);
    }

}
