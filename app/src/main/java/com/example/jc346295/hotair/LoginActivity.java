package com.example.jc346295.hotair;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Database userCred;
    private Button button;
    private EditText userName;
    private EditText userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    @Override
    protected void onStart() {
        super.onStart();
        userCred = new Database(this);
        SQLiteDatabase db = userCred.getReadableDatabase();


        userName = (EditText) findViewById(R.id.userEmail);
        userPass = (EditText) findViewById(R.id.userPassword);

        final String input1 = userName.getText().toString();
        String input2 = userPass.getText().toString();
        String[] names = {"Jack Smith"};


        String selection = Database.USERNAME + " = ?";
        String[] selectionArgs = {"Jack Smith"};

        Cursor cursor = getContentResolver().query();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(Database.USERNAME_COLUMN);
                    if (name.equals(input1)) {
                        cursor.close();
                        userCred.close();
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        new AlertDialog.Builder(view.getContext())
                                .setTitle("No username")
                                .setMessage("You'e not cool enough to be in the database!")
                                .show();
                    }
                }

            }
        });

    }
}