package com.example.jc346295.hotair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    ArrayAdapter<Java> stringArray;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        preferences = getSharedPreferences("values",MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public void Home(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    protected void onStart(){
        super.onStart();

        stringArray = new ArrayAdapter<Java>(this, android.R.layout.simple_list_item_1);

        stringArray.add(new Java("Order ID : 13251882","Without lactose"));
        stringArray.add(new Java("Order ID : 12245923","Without milk"));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(stringArray);

        Map<String,?> keys = preferences.getAll();
        for (Map.Entry<String,?> entry : keys.entrySet())
        {
            stringArray.add(new Java(entry.getKey(),entry.getValue().toString()));
        }

    }
}
