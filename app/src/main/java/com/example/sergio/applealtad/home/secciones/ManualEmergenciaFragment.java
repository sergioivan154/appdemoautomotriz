package com.example.sergio.applealtad.home.secciones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterManual;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManualEmergenciaFragment extends BaseFragment {


    public static ManualEmergenciaFragment getInstance(){
        ManualEmergenciaFragment fragment=new ManualEmergenciaFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_emergencia, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AdapterManual adapterPromociones = new AdapterManual(getContext(),5);

        RecyclerView rwManual = (RecyclerView)findViewById(R.id.rwMenuEmergencia);
        rwManual.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwManual.setAdapter(adapterPromociones);
        adapterPromociones.notifyDataSetChanged();


    }
}
