package appewtc.masterung.broadcastertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView talkNameImageView, newTestMaleImageView, newTestFemaleImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Image Controller
        imageController();

    }   // Main Method

    private void imageController() {
        talkNameImageView.setOnClickListener(this);
        newTestMaleImageView.setOnClickListener(this);
        newTestFemaleImageView.setOnClickListener(this);
    }

    private void bindWidget() {
        talkNameImageView = (ImageView) findViewById(R.id.imageView2);
        newTestMaleImageView = (ImageView) findViewById(R.id.imageView3);
        newTestFemaleImageView = (ImageView) findViewById(R.id.imageView4);
    }

    @Override
    public void onClick(View view) {

        String[] resultStrings = null;
        int[] sourceVideo;
        int intIcon = R.drawable.nameread;

        switch (view.getId()) {
            case R.id.imageView2:
                resultStrings = getResources().getStringArray(R.array.talkname);
                intIcon = R.drawable.nameread;
                sourceVideo = new int[resultStrings.length];
                sourceVideo[0] = R.raw.talkname1;
                sourceVideo[1] = R.raw.talkname2;
                sourceVideo[2] = R.raw.talkname3;
                sourceVideo[3] = R.raw.talkname4;
                sourceVideo[4] = R.raw.talkname5;
                sourceVideo[5] = R.raw.talkname6;
                sourceVideo[6] = R.raw.talkname7;
                sourceVideo[7] = R.raw.talkname8;
                sourceVideo[8] = R.raw.talkname9;
                sourceVideo[9] = R.raw.talkname10;
                sourceVideo[10] = R.raw.talkname11;
                sourceVideo[11] = R.raw.talkname12;
                sourceVideo[12] = R.raw.talkname13;
                sourceVideo[13] = R.raw.talkname14;
                sourceVideo[14] = R.raw.talkname15;
                break;
            case R.id.imageView3:
                resultStrings = getResources().getStringArray(R.array.testmale);
                intIcon = R.drawable.testboy;
                sourceVideo = new int[resultStrings.length];
                sourceVideo[0] = R.raw.testmale1;
                sourceVideo[1] = R.raw.testmale2;
                sourceVideo[2] = R.raw.testmale3;
                sourceVideo[3] = R.raw.testmale4;
                sourceVideo[4] = R.raw.testmale5;
                break;
            case R.id.imageView4:
                resultStrings = getResources().getStringArray(R.array.testfemale);
                intIcon = R.drawable.gtest;
                sourceVideo = new int[resultStrings.length];
                sourceVideo[0] = R.raw.testfemale1;
                sourceVideo[1] = R.raw.testfemale2;
                sourceVideo[2] = R.raw.testfemale3;
                sourceVideo[3] = R.raw.testfemale4;
                sourceVideo[4] = R.raw.testfemale5;
                break;
            default:
                sourceVideo = new int[1];
                sourceVideo[0] = R.raw.talkname1;
                break;
        }   // switch


        //Intent to Detail ListView
        Intent objIntent = new Intent(MainActivity.this, DetailListView.class);
        objIntent.putExtra("Title", resultStrings);
        objIntent.putExtra("Icon", intIcon);
        objIntent.putExtra("Video", sourceVideo);
        startActivity(objIntent);

    }   // onClick

}   // Main Class
