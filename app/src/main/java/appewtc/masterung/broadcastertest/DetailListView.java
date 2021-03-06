package appewtc.masterung.broadcastertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DetailListView extends AppCompatActivity {

    //Explicit
    private String[] titleStrings, detailStrings;
    private int iconAnInt;
    private int[] videoInts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        //Receive Value From Intent
        receiveValue();

        //Create ListView
        createListView();

    }   // Main Method

    public void clickBackListView(View view) {
        finish();
    }

    private void createListView() {

        MyAdapter objMyAdapter = new MyAdapter(DetailListView.this, titleStrings, iconAnInt);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Intent to ShowVideoActivity
                Intent objIntent = new Intent(DetailListView.this, ShowVideoActivity.class);
                objIntent.putExtra("Title", titleStrings[i]);
                objIntent.putExtra("Detail", detailStrings[i]);
                objIntent.putExtra("Video", videoInts[i]);
                startActivity(objIntent);


            }   // event
        });

    }   // createListView

    private void receiveValue() {

        titleStrings = getIntent().getStringArrayExtra("Title");
        detailStrings = getIntent().getStringArrayExtra("Detail");
        iconAnInt = getIntent().getIntExtra("Icon", R.drawable.nameread);
        videoInts = getIntent().getIntArrayExtra("Video");

        for (int i = 0; i < titleStrings.length; i++) {
            Log.d("Test", "titleString[" + Integer.toString(i) + "] = " + titleStrings[i]);
        }   // for

    }   // receiveValue

}   // Main Class
