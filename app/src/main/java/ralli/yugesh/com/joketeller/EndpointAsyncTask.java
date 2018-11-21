package ralli.yugesh.com.joketeller;

import android.os.AsyncTask;

import ralli.yugesh.com.joketeller.backend.myApi.MyApi;

public class EndpointAsyncTask extends AsyncTask<OnJokeReceiver,Void,String> {

    MyApi myApi=null;
    OnJokeReceiver onJokeReceiver;

    @Override
    protected String doInBackground(OnJokeReceiver... onJokeReceivers) {
        return null;
    }
}
