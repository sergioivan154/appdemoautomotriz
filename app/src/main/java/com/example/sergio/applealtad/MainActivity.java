package com.example.sergio.applealtad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergio.applealtad.bases.BaseActivity;
import com.example.sergio.applealtad.home.HomeActivity;
import com.example.sergio.applealtad.register.RegisterActivity;

public class MainActivity extends BaseActivity {


    TextView txtRegister;
    Button btnIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRegister = (TextView)findViewById(R.id.txtRegister);

       txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnIniciar= (Button)findViewById(R.id.btnIngresar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }



}
