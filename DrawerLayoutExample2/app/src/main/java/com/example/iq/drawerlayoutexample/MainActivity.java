package com.example.iq.drawerlayoutexample;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        fm.beginTransaction().replace(R.id.frameChanger,new class_1()).commit();
                        break;
                    case "Class 2":
                        fm.beginTransaction().add(R.id.frameChanger,new class_2()).commit();
                        break;
                    case "Class 3":
                        fm.beginTransaction().add(R.id.frameChanger,new class_3()).commit();
                        break;
                    case "Class 4":
                        fm.beginTransaction().add(R.id.frameChanger,new class_4()).commit();
                        break;
                }

            }
        });
    }


}
