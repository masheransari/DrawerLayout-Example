package com.example.iq.drawerlayoutexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iQ on 2/20/2017.
 */

public class AdapterClass extends ArrayAdapter<VariableClass> {

    public AdapterClass(Activity activity, ArrayList<VariableClass> arrayList) {
        super(activity, 0, arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        VariableClass CurrentWOrd = getItem(position);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(CurrentWOrd.getData());

        return v;
    }
}
