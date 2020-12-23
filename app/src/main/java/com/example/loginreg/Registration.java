package com.example.loginreg;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity
        implements View.OnClickListener{

    DBHelper my_db;
    SQLiteDatabase sqdb;
    Button btnGoreg;
    EditText etNick, etPass, etEmail, etPhone;
    String[] infa=new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        my_db=new DBHelper(this); //calling DBHelper Constructor method
        sqdb=my_db.getWritableDatabase(); //calling DBHelper onCreate method witch create the table
        sqdb.close();

        btnGoreg= (Button) findViewById(R.id.btnGoreg);
        btnGoreg.setOnClickListener(this);
        etNick= (EditText) findViewById(R.id.etNick);
        etPass= (EditText) findViewById(R.id.etPass);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPhone= (EditText) findViewById(R.id.etPhone);

    }

    @Override
    public void onClick(View view) {
        infa[0] = etNick.getText().toString();
        infa[1] = etPass.getText().toString();
        infa[2] = etEmail.getText().toString();
        infa[3] = etPhone.getText().toString();
        etNick.setText("");
        etPass.setText("");
        etEmail.setText("");
        etPhone.setText("");

        if (is_found(infa[0], infa[1])) {
            Toast.makeText(this,
                    "This name and pass is found",
                    Toast.LENGTH_LONG).show();
            finish();
        } else
            go_regist();
    }

    private boolean is_found(String s1, String s2) { //query - option 1
        boolean flag=false;
        sqdb=my_db.getWritableDatabase();
        Cursor c=sqdb.query(DBHelper.TABLE_NAME,
                null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String t1=c.getString(0);
            //String t1=c.getString(c.getColumnIndex(DBHelper.NICKNAME));
            String t2=c.getString(1);
            if (s1.equals(t1)&&s2.equals(t2))
                flag=true;
            c.moveToNext();
        }
        c.close();
        sqdb.close();
        return flag;
    }

    private void go_regist() {
        ContentValues cv=new ContentValues();
        cv.put(my_db.NICKNAME, infa[0]);
        cv.put(my_db.PASS, infa[1]);
        cv.put(my_db.EMAIL, infa[2]);
        cv.put(my_db.PHONE, infa[3]);

        sqdb=my_db.getWritableDatabase();
        sqdb.insert(my_db.TABLE_NAME, null, cv);
        sqdb.close();
        Intent goStart=new Intent(this, Start.class);
        startActivity(goStart);
    }

}
