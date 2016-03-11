package appewtc.masterung.broadcastertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 3/11/16 AD.
 */
public class ScoreAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] dateStrings, scoreStrings;

    public ScoreAdapter(Context context, String[] dateStrings, String[] scoreStrings) {
        this.context = context;
        this.dateStrings = dateStrings;
        this.scoreStrings = scoreStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return dateStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.score_listview, viewGroup, false);

        TextView dateTextView = (TextView) view1.findViewById(R.id.textView9);
        dateTextView.setText(dateStrings[i]);

        TextView scoreTextView = (TextView) view1.findViewById(R.id.textView10);
        scoreTextView.setText(scoreStrings[i]);

        return view1;
    }
}   // Main Class
