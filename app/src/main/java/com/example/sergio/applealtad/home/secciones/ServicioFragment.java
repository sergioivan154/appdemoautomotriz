package com.example.sergio.applealtad.home.secciones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.storage.DemoPreference;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicioFragment extends BaseFragment {


    public static ServicioFragment getInstance() {
        ServicioFragment fragment=new ServicioFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servicio, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int [] kilometraje = DemoPreference.getInstance(getContext()).getKilometraje();

        NumberPicker npDigito1 = (NumberPicker)findViewById(R.id.npDigito1);
        NumberPicker npDigito2 = (NumberPicker)findViewById(R.id.npDigito2);
        NumberPicker npDigito3 = (NumberPicker)findViewById(R.id.npDigito3);
        NumberPicker npDigito4 = (NumberPicker)findViewById(R.id.npDigito4);
        NumberPicker npDigito5 = (NumberPicker)findViewById(R.id.npDigito5);
        NumberPicker npDigito6 = (NumberPicker)findViewById(R.id.npDigito6);

        npDigito1.setMaxValue(kilometraje[0]);
        npDigito1.setMinValue(kilometraje[0]);
        npDigito2.setMaxValue(kilometraje[1]);
        npDigito2.setMinValue(kilometraje[1]);
        npDigito3.setMaxValue(kilometraje[2]);
        npDigito3.setMinValue(kilometraje[2]);
        npDigito4.setMaxValue(kilometraje[3]);
        npDigito4.setMinValue(kilometraje[3]);
        npDigito5.setMaxValue(kilometraje[4]);
        npDigito5.setMinValue(kilometraje[4]);
        npDigito6.setMaxValue(kilometraje[5]);
        npDigito6.setMinValue(kilometraje[5]);

        npDigito1.setValue(kilometraje[0]);
        npDigito2.setValue(kilometraje[1]);
        npDigito3.setValue(kilometraje[2]);
        npDigito4.setValue(kilometraje[3]);
        npDigito5.setValue(kilometraje[4]);
        npDigito6.setValue(kilometraje[5]);
    }
}
