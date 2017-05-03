package com.example.jc346295.hotair;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton reportButton;
    ImageButton historyButton;
    TextView welcomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeUser = (TextView) findViewById(R.id.userWelcome);
        welcomeUser.setText(getString(R.string.welcome_messages));


    }

    public void onClick(View view){
        reportButton = (ImageButton) findViewById(R.id.reportButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        if (view == reportButton){
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        }
        else if (view == historyButton){
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        }

    }

}
