package com.example.iq.drawerlayoutexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.color.holo_blue_dark;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener mDrawerListener;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
//        final DrawerLayout.DrawerListener DrawerListener;
        mLinearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        final ArrayList<VariableClass> arrayList = new ArrayList<VariableClass>();
        String data[] = {"Class 1", "Class 2", "Class 3", "Class 4"};
        for (int i = 0; i < data.length; i++) {
            arrayList.add(new VariableClass(data[i]));
        }
        AdapterClass adapterClass = new AdapterClass(MainActivity.this,arrayList);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapterClass);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VariableClass variableClass = arrayList.get(position);
                Toast.makeText(MainActivity.this, variableClass.getData(), Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();

                switch(variableClass.getData().toString())
                {
                    case "Class 1":
                        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                        fm.beginTransaction().replace(R.id.frameChanger,new class_1()).commit();
                        break;
                    case "Class 2":
                        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.orange));
                        fm.beginTransaction().add(R.id.frameChanger,new class_2()).commit();
                        break;
                    case "Class 3":
                        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.darkGreen));
                        fm.beginTransaction().add(R.id.frameChanger,new class_3()).commit();
                        break;
                    case "Class 4":
                        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.red));
                        fm.beginTransaction().add(R.id.frameChanger,new class_4()).commit();
                        break;
                }
                mDrawerLayout.closeDrawers();
            }
        });
//        mDrawerLayout.setDrawerListener(mDrawerListener);
//
//        DrawerLayout.DrawerListener mDrawerListener= new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        };
    }



}
