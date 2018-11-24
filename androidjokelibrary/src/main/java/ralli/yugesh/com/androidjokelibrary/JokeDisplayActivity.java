package ralli.yugesh.com.androidjokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private TextView jokeTextView;
    private String jokeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        jokeString = getIntent().getStringExtra(getString(R.string.joke));
        jokeTextView = findViewById(R.id.jokeDisplay);
        jokeTextView.setText(jokeString);
    }
}
