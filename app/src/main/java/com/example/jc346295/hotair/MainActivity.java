package com.example.jc346295.hotair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton reportButton;
    ImageButton historyButton;
    ImageButton trackButton;
    ImageButton notifButton;
    TextView welcomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getExtras().getString("username");
        welcomeUser = (TextView) findViewById(R.id.userWelcome);
        welcomeUser.setText(getString(R.string.welcome_messages, username));

        reportButton = (ImageButton) findViewById(R.id.reportButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        trackButton = (ImageButton) findViewById(R.id.trackButton);
        notifButton = (ImageButton) findViewById(R.id.notifButton);

    }

    public void onClick(View view){
        if (view == reportButton) {
            Intent intent = new Intent(this, Report.class);
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

}
