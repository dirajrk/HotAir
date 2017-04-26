package com.example.jc346295.hotair;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.SharedPreferences;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton reportButton;
    SharedPreferences preferences;
    TextView welcomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeUser = (TextView) findViewById(R.id.userWelcome);
        String userID = preferences.getString("pass",null);
        String userPass = preferences.getString("id", null);
        welcomeUser.setText(getString(R.string.welcome_messages, userID));


    }

    public void onClick(View view){
        reportButton = (ImageButton) findViewById(R.id.reportButton);
        if (view == reportButton){
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        }
    }
}
