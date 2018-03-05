package com.example.sergio.applealtad.register;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.customViews.SimpleCustomDialog;

import butterknife.ButterKnife;

/**
 * Created by mac on 04/03/18.
 */

public class VehiculoFragment extends BaseFragment {

    public static VehiculoFragment getInstance(){
        VehiculoFragment fragment=new VehiculoFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vehiculo_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnFinish = (Button)findViewById(R.id.btnNetx);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleCustomDialog dialog = new SimpleCustomDialog(getContext(), new SimpleCustomDialog.OnButtonClickListener() {
                    @Override
                    public void onAcceptClickListener(Button button, AlertDialog dialog) {
                        getActivity().finish();
                    }
                });
                dialog.show();

            }
        });

    }

}
