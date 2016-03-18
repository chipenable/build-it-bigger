package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.lang.ref.WeakReference;

import ru.chipenable.jokeapp.backend.myApi.MyApi;

/**
 * Created by Pashgan on 25.02.2016.
 */
public class EndpointsAsyncTask extends AsyncTask<MainActivity, Void, String> {

    private WeakReference<MainActivity> mActivity;
    private static MyApi mApiService = null;

    @Override
    protected String doInBackground(MainActivity... params) {
        if (mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            mApiService = builder.build();
        }

        mActivity = new WeakReference<>(params[0]);

        try {
            return mApiService.sayJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        MainActivity activity = mActivity.get();
        if (activity != null){
            activity.startJokeActivity(result);
        }
    }
}
