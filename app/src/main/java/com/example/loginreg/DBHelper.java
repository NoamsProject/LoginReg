package com.example.loginreg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "all_users";
    public static final String NICKNAME = "Nickname";
    public static final String PASS = "Pass";
    public static final String EMAIL = "Email";
    public static final String PHONE = "Phone";

    String SQL_Create="";
    String SQL_Delete="";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DBHelper", "DBHelper constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("DBHelper", "onCreate");
        //SQL_Create="CREATE TABLE all_users (Nickname TEXT, Pass TEXT, Email TEXT, Phone TEXT);"
        SQL_Create="CREATE TABLE "+TABLE_NAME+" (";
        SQL_Create+=NICKNAME+" TEXT, ";
        SQL_Create+=PASS+" TEXT, ";
        SQL_Create+=EMAIL+" TEXT, ";
        SQL_Create+=PHONE+" TEXT);";
        sqLiteDatabase.execSQL(SQL_Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQL_Delete = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_Delete);
        onCreate(sqLiteDatabase);
    }
}
