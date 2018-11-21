package ralli.yugesh.com.androidjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    TextView jokeTextView;
    String jokeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        jokeString = getIntent().getStringExtra(getString(R.string.joke));
        jokeTextView = findViewById(R.id.jokeDisplay);
    }
}
