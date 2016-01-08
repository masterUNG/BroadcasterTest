package appewtc.masterung.broadcastertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class DetailListView extends AppCompatActivity {

    //Explicit
    private String[] titleStrings;
    private int iconAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        //Receive Value From Intent
        receiveValue();

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        MyAdapter objMyAdapter = new MyAdapter(DetailListView.this, titleStrings, iconAnInt);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

    }   // createListView

    private void receiveValue() {

        titleStrings = getIntent().getStringArrayExtra("Title");
        iconAnInt = getIntent().getIntExtra("Icon", R.drawable.nameread);

        for (int i = 0; i < titleStrings.length; i++) {
            Log.d("Test", "titleString[" + Integer.toString(i) + "] = " + titleStrings[i]);
        }   // for

    }   // receiveValue

}   // Main Class
