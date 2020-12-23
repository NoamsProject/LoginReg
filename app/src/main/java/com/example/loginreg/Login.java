package com.example.loginreg;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity
        implements View.OnClickListener{

    DBHelper my_db;
    SQLiteDatabase sqdb;
    Button btnGolog;
    EditText etNickLog, etPassLog;
    String[] infa=new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        my_db=new DBHelper(this); //calling DBHelper Constructor method
        sqdb=my_db.getWritableDatabase(); //calling DBHelper onCreate method witch create the table
        sqdb.close();

        btnGolog= (Button) findViewById(R.id.btnGolog);
        btnGolog.setOnClickListener(this);
        etNickLog= (EditText) findViewById(R.id.etNickLog);
        etPassLog= (EditText) findViewById(R.id.etPassLog);
    }

    @Override
    public void onClick(View view) {
        infa[0] = etNickLog.getText().toString();
        infa[1] = etPassLog.getText().toString();
        etNickLog.setText("");
        etPassLog.setText("");

        if (is_found(infa[0], infa[1])) {
            Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
            Intent goStart=new Intent(this, Start.class);
            startActivity(goStart);
        }
        else {
            Intent goReg=new Intent(this, Registration.class);
            startActivity(goReg);
        }
    }

    private boolean is_found(String s1, String s2) { //query - option 2
        sqdb=my_db.getWritableDatabase();
        String whereFind=DBHelper.NICKNAME+"=? AND "+DBHelper.PASS+"=?";
        //String[] whatFind=new String[] {s1,s2};
        String[] whatFind = {s1,s2};
        Cursor c=sqdb.query(DBHelper.TABLE_NAME, null, whereFind, whatFind, null,null,null);
        boolean flag = c.moveToFirst(); //will return false if the cursor is empty / not found
        c.close();
        sqdb.close();
        return flag;
    }
}

