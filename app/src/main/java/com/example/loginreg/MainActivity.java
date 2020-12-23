package com.example.loginreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnReg, btnLog;
    Intent go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLog= (Button) findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);
        btnReg= (Button) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btnLog) {
            go=new Intent(this, Login.class);
            startActivity(go);
        }

        if (view==btnReg) {
            go=new Intent(this, Registration.class);
            startActivity(go);
        }
    }
}
