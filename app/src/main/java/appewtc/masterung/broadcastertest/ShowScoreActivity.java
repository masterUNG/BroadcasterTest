package appewtc.masterung.broadcastertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {

    //Explicit
    private TextView showScoreTextView;
    private int scoreAnInt, timesAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Show Score
        showScore();


    }   // Main Method

    private void showScore() {

        scoreAnInt = getIntent().getIntExtra("Score", 0);
        timesAnInt = getIntent().getIntExtra("Times", 0);

        showScoreTextView = (TextView) findViewById(R.id.textView8);
        showScoreTextView.setText(Integer.toString(scoreAnInt) + "/" +
                Integer.toString(timesAnInt));

    }   // showScore

    public void clickReadScore(View view) {

    }   // clickReadScore

}   // Main Class
