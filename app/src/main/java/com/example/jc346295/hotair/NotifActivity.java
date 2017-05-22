package com.example.jc346295.hotair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotifActivity extends AppCompatActivity {
    ImageButton locationButton;
    ImageButton historyButton;
    ImageButton trackButton;
    ImageButton notifButton;
    ImageButton homeButton;
    String username;
    TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        username = getIntent().getExtras().getString("username");
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome_messages, username));
    }

    public void onClick(View view) {
        if (view == locationButton) {
            Intent intent = new Intent(this, NavActivity.class);
            startActivity(intent);
        } else if (view == historyButton) {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        } else if (view == trackButton) {
            Intent intent = new Intent(this, TrackActivity.class);
            startActivity(intent);
        } else if (view == homeButton) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (view == notifButton) {
            Intent intent = new Intent(this, NotifActivity.class);
            startActivity(intent);
        }
    }
    public void notif(View view){
        Intent intent = new Intent(this,NotifActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void report(View view){
        Intent intent = new Intent(this,Report.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void track(View view){
        Intent intent = new Intent(this,TrackActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void history(View view){
        Intent intent = new Intent(this,HistoryActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
