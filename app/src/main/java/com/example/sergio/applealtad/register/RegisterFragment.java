package com.example.sergio.applealtad.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 04/03/18.
 */

public class RegisterFragment extends BaseFragment {
    public static RegisterFragment getInstance(){
        RegisterFragment fragment=new RegisterFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btnNext = (Button) findViewById(R.id.btnNetx);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragmentToBackStack(VehiculoFragment.getInstance(),"vehiculo",R.id.content_register);
            }
        });

    }





}
