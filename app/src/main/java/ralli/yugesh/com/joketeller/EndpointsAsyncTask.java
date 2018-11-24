package ralli.yugesh.com.joketeller;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import ralli.yugesh.com.joketeller.backend.myApi.MyApi;

class EndpointsAsyncTask extends AsyncTask<OnJokeReceiver,Void,String> {

    private MyApi myApi=null;
    private OnJokeReceiver onJokeReceiver;

    public EndpointsAsyncTask(OnJokeReceiver onJokeReceiver){
        this.onJokeReceiver = onJokeReceiver;
    }

    @Override
    protected String doInBackground(OnJokeReceiver... onJokeReceivers) {
        if (myApi==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp
                    .newCompatibleTransport(), new AndroidJsonFactory(),null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
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
