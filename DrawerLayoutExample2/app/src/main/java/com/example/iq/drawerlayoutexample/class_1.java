package com.example.iq.drawerlayoutexample;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class class_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_class_1,container,false);

        return v;
    }
    public void showToast(){

        Toast.makeText(getActivity(), "we Are on Class_1 Activity", Toast.LENGTH_SHORT).show();
    }
}
