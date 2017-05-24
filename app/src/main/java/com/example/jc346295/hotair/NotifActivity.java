package com.example.jc346295.hotair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotifActivity extends AppCompatActivity {
    ImageButton locationButton;
    ImageButton historyButton;
    ImageButton trackButton;
    ImageButton notifButton;
    ImageButton reportButton;
    ImageButton navButton;
    String username;
    TextView welcomeText;
    ArrayAdapter<Java> stringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        username = getIntent().getExtras().getString("username");
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome_messages, username));
    }

    public void onClick(View view) {
        reportButton = (ImageButton) findViewById(R.id.reportButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        trackButton = (ImageButton) findViewById(R.id.trackButton);
        notifButton = (ImageButton) findViewById(R.id.notifButton);
        navButton = (ImageButton) findViewById(R.id.navButton);
        if (view == locationButton) {
            Intent intent = new Intent(this, NavActivity.class);
            startActivity(intent);
        } else if (view == historyButton) {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        } else if (view == trackButton) {
            Intent intent = new Intent(this, TrackActivity.class);
            startActivity(intent);
        } else if (view == reportButton) {
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        } else if (view == notifButton) {
            Intent intent = new Intent(this, NotifActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        stringArray = new ArrayAdapter<Java>(this, android.R.layout.simple_list_item_1);

        stringArray.add(new Java("ID13251882 Delivered!",""));
        stringArray.add(new Java("ID12245923 Delivered!",""));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(stringArray);
    }
}
