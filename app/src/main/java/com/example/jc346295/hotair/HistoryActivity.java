package com.example.jc346295.hotair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    ArrayAdapter<Java> stringArray;
    SharedPreferences preferences;
    TextView welcomeUser;
    String username;
    ImageButton reportButton;
    ImageButton historyButton;
    ImageButton trackButton;
    ImageButton notifButton;
    ImageButton navButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void onClick(View view) {
        reportButton = (ImageButton) findViewById(R.id.reportButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        trackButton = (ImageButton) findViewById(R.id.trackButton);
        notifButton = (ImageButton) findViewById(R.id.notifButton);
        navButton = (ImageButton) findViewById(R.id.navButton);
        if (view == navButton) {
            Intent intent = new Intent(this, NavActivity.class);
            startActivity(intent);
        } else if (view == historyButton) {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        } else if (view == trackButton) {
            Intent intent = new Intent(this, TrackActivity.class);
            startActivity(intent);
        } else if (view == notifButton) {
            Intent intent = new Intent(this, NotifActivity.class);
            startActivity(intent);
        }
    }

    protected void onStart(){
        super.onStart();

        stringArray = new ArrayAdapter<Java>(this, android.R.layout.simple_list_item_1);

        stringArray.add(new Java("Order ID : 13251882","Without lactose"));
        stringArray.add(new Java("Order ID : 12245923","Without milk"));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(stringArray);


    }
}
