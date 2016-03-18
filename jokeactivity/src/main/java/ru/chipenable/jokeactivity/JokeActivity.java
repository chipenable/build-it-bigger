package ru.chipenable.jokeactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String KEY_JOKE = "key_joke";

    public static Intent makeIntent(Context context, String joke){
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(KEY_JOKE, joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(KEY_JOKE);

        TextView textView = (TextView)findViewById(R.id.joke_text_view);
        textView.setText(joke);

        setResult(Activity.RESULT_OK);
    }
}
