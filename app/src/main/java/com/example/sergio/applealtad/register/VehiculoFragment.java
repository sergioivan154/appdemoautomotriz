package com.example.sergio.applealtad.register;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.customViews.SimpleCustomDialog;
import com.example.sergio.applealtad.storage.DemoPreference;

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

        final NumberPicker npDigito1 = (NumberPicker)findViewById(R.id.npDigito1);
        final NumberPicker npDigito2 = (NumberPicker)findViewById(R.id.npDigito2);
        final NumberPicker npDigito3 = (NumberPicker)findViewById(R.id.npDigito3);
        final NumberPicker npDigito4 = (NumberPicker)findViewById(R.id.npDigito4);
        final  NumberPicker npDigito5 = (NumberPicker)findViewById(R.id.npDigito5);
        final  NumberPicker npDigito6 = (NumberPicker)findViewById(R.id.npDigito6);
        npDigito1.setMinValue(0);
        npDigito1.setMaxValue(9);
        npDigito2.setMinValue(0);
        npDigito2.setMaxValue(9);
        npDigito2.setValue(5);
        npDigito3.setMinValue(0);
        npDigito3.setMaxValue(9);
        npDigito4.setMinValue(0);
        npDigito4.setMaxValue(9);
        npDigito4.setValue(1);
        npDigito5.setMinValue(0);
        npDigito5.setMaxValue(9);
        npDigito5.setValue(7);
        npDigito6.setMinValue(0);
        npDigito6.setMaxValue(9);
        npDigito6.setValue(3);



        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleCustomDialog dialog = new SimpleCustomDialog(getContext(), new SimpleCustomDialog.OnButtonClickListener() {
                    @Override
                    public void onAcceptClickListener(Button button, AlertDialog dialog) {
                        DemoPreference.getInstance(getContext()).setKilometraje(npDigito1.getValue(),npDigito2.getValue(),npDigito3.getValue(),npDigito4.getValue(),npDigito5.getValue(),npDigito6.getValue());
                        getActivity().finish();
                    }
                });
                dialog.show();

            }
        });

    }

}
