package com.example.jc346295.hotair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    private EditText userEmail;
    private EditText userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
    public void onClick(View view){
    userPass = (EditText) findViewById(R.id.userPassword);
    Button button = (Button) findViewById(R.id.button);
    if (view == button){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }}
}

    /***Intent i = new Intent(getApplicationContext(), NewActivity.class);

     i.putExtra("key","value");
     startActivity(i);
     ***/

