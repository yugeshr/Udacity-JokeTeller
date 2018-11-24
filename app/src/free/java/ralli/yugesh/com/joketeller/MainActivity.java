package ralli.yugesh.com.joketeller;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

//Google AdMob
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ralli.yugesh.com.androidjokelibrary.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements OnJokeReceiver {

    private Button btnJoke;
    private ProgressBar progressBar;

    //Google AdMob Object
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get deviceId to show ad
        String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        btnJoke = findViewById(R.id.btn_joke);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJoke();
            }
        });

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        //Google AdMob Loader
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(android_id).build();
        mAdView.loadAd(adRequest);
    }

    private void showJoke() {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void Joke(String joke) {
        Intent intentJoke = new Intent(getApplicationContext(), JokeDisplayActivity.class);
        intentJoke.putExtra(getString(R.string.joke),joke);
        startActivity(intentJoke);
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.INVISIBLE);
    }
}
