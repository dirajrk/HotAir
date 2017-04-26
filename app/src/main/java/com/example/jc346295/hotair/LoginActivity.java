package com.example.jc346295.hotair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.SharedPreferences;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View view){
        Button button = (Button) findViewById(R.id.button);
        //both these values are placeholders
        String userID = "";
        String userPass = "";
        if (view == button){
            Intent intent = new Intent(this, MainActivity.class);
            preferences.edit().clear().putString("id",userID).putString("pass",userPass).apply();
            startActivity(intent);
        }
    }
}

