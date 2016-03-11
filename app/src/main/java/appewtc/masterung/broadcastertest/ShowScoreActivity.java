package appewtc.masterung.broadcastertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowScoreActivity extends AppCompatActivity {

    //Explicit
    private TextView showScoreTextView, showDateTextView;
    private int scoreAnInt, timesAnInt;
    private String currentDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Show Score
        showScore();

        //Show Date
        showDate();


    }   // Main Method

    private void showDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        currentDateString = dateFormat.format(date);
        showDateTextView = (TextView) findViewById(R.id.textView7);
        showDateTextView.setText(currentDateString);

    }   // showDate

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
