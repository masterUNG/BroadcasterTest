package appewtc.masterung.broadcastertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class ShowVideoActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private TextView titleTextView;
    private VideoView showVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        //Show Title
        showTitle();

    }   // Main Method

    private void showTitle() {

        String strTitle = getIntent().getStringExtra("Title");
        TextView titleTextView = (TextView) findViewById(R.id.txtShowTitleVideo);
        titleTextView.setText(strTitle);

    }

    public void clickBackShowVideo(View view) {
        finish();
    }

    public void clickTest(View view) {

    }

}   // Main Class
