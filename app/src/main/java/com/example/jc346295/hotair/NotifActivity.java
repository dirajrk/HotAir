package com.example.jc346295.hotair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotifActivity extends AppCompatActivity {
    String username;
    TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome_messages, username));
    }
}
