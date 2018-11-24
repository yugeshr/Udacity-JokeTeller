package ralli.yugesh.com.joketeller;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ralli.yugesh.com.androidjokelibrary.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements OnJokeReceiver{

    Button btnJoke;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        btnJoke = findViewById(R.id.btn_joke);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJoke();
            }
        });
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
