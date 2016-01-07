package appewtc.masterung.broadcastertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailListView extends AppCompatActivity {

    //Explicit
    private String[] titleStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        //Receive Value From Intent
        receiveValue();

    }   // Main Method

    private void receiveValue() {

        titleStrings = getIntent().getStringArrayExtra("Title");

        for (int i=0;i<titleStrings.length;i++) {
            Log.d("Test", "titleString[" + Integer.toString(i) + "] = " + titleStrings[i]);
        }   // for

    }   // receiveValue

}   // Main Class
