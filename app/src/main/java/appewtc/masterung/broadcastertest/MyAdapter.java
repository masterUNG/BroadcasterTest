package appewtc.masterung.broadcastertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 1/8/16 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context objContext;
    private String[] listStrings;
    private int iconAnInt;

    public MyAdapter(Context objContext, String[] listStrings, int iconAnInt) {
        this.objContext = objContext;
        this.listStrings = listStrings;
        this.iconAnInt = iconAnInt;
    }   // Constructor

    @Override
    public int getCount() {
        return listStrings.length;
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

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView listTextView = (TextView) objView1.findViewById(R.id.txtList);
        listTextView.setText(listStrings[i]);

        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconAnInt);

        return objView1;
    }
}   // Main Class
