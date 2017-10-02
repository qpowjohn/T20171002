package taiwan.beginner.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by student on 2017/10/2.
 */

public class MySpinnerAdapter extends BaseAdapter {

    private Activity activity;

    public MySpinnerAdapter(Activity activity){
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return 4;
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
        View v = activity.getLayoutInflater().inflate(R.layout.spinner_layout,null);
        TextView textView =(TextView)v.findViewById(R.id.coffee_title);
        textView.setText("咖啡名稱"+i);
        return v;
    }
}
