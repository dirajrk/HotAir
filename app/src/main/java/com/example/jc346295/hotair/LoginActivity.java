package com.example.jc346295.hotair;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view){
        EditText userName = (EditText) findViewById(R.id.userEmail);
        EditText userPass = (EditText) findViewById(R.id.userPassword);
        String input1 = userName.getText().toString();
        String input2 = userPass.getText().toString();
        Map<String, String> users = new HashMap<>();
        users.put("fadni", "123456");
        users.put("nathanael", "baygon");
        users.put("diraj", "1234");
        if(view == button){
            if (users.containsKey(input1) && users.get(input1).equals(input2)){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("username", input1);
                startActivity(intent);
                finish();
            }
            else{
                new AlertDialog.Builder(view.getContext())
                        .setTitle("No username")
                        .setMessage("You're not cool enough to be in the database!")
                        .show();
            }
        }
    }
}