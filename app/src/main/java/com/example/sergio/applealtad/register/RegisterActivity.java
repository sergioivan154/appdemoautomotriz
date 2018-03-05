package com.example.sergio.applealtad.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseActivity;
import com.example.sergio.applealtad.register.RegisterFragment;
import com.example.sergio.applealtad.register.VehiculoFragment;

/**
 * Created by mac on 04/03/18.
 */

public class RegisterActivity extends BaseActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
        ft.replace(R.id.content_register, RegisterFragment.getInstance());
        ft.commit();
    }
}
