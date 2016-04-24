package appewtc.masterung.broadcastertest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListScoreActivity extends AppCompatActivity {

    //Explicit
    private ListView scoreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_score);

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.test_table, null);
        cursor.moveToFirst();

        String[] dateStrings = new String[cursor.getCount()];
        String[] scoreStrings = new String[cursor.getCount()];
        String[] timesStrings = new String[cursor.getCount()];
        String[] showScoreStrings = new String[cursor.getCount()];
        String[] nameStrings = new String[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i++) {

            dateStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Date));
            scoreStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Score));
            timesStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Times));
            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_name));
            showScoreStrings[i] = scoreStrings[i] + "/" + timesStrings[i];

            cursor.moveToNext();

        }   // for
        cursor.close();

        scoreListView = (ListView) findViewById(R.id.listView2);
        ScoreAdapter scoreAdapter = new ScoreAdapter(ListScoreActivity.this,
                nameStrings, dateStrings, showScoreStrings);
        scoreListView.setAdapter(scoreAdapter);

    }   // createListView

}   // Main Class
