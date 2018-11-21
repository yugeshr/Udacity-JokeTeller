package ralli.yugesh.com.joketeller;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import ralli.yugesh.com.joketeller.backend.myApi.MyApi;

public class EndpointsAsyncTask extends AsyncTask<OnJokeReceiver,Void,String> {

    MyApi myApi=null;
    OnJokeReceiver onJokeReceiver;

    public EndpointsAsyncTask(OnJokeReceiver onJokeReceiver){
        this.onJokeReceiver = onJokeReceiver;
    }

    @Override
    protected String doInBackground(OnJokeReceiver... onJokeReceivers) {
        if (myApi==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp
                    .newCompatibleTransport(), new AndroidJsonFactory(),null)
                    .setRootUrl("https://udacity-jokes-223111.appspot.com/_ah/api/");
            myApi =  builder.build();
        }

        try {
            return myApi.sayHi("Joke").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        onJokeReceiver.Joke(s);
    }
}
