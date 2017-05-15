package com.example.jc346295.hotair;

/**
 * Created by Fadni Harisyam Daeng Rani on 12/5/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String USER_TABLE_NAME = "user";
    public static final int ID_COLUMN = 0;
    public static final int USERNAME_COLUMN = 1;
    public static final int PASS_COLUMN = 2;
    public static final int ORDERS_COLUMN = 3;
    public static final String ID = "_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "pass";
    public static final String ORDERS = "order";
    private final static int VERSION = 6;


    public Database(Context context) {
        super(context, "userCred.db", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        setup(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME + ";");
        setup(db);
    }

    private void setup(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + USER_TABLE_NAME
                + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT, "
                + PASSWORD + " TEXT" + ");";
        db.execSQL(sql);

        sql = "INSERT INTO user (username,pass) VALUES (USER,baygon1);";
        db.execSQL(sql);

        sql = "INSERT INTO user (username,pass) VALUES (fadnihdr,1234);";
        db.execSQL(sql);

        sql = "INSERT INTO user (username,pass) VALUES (dirajrk,9999);";
        db.execSQL(sql);
    }

}

