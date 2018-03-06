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
import com.example.sergio.applealtad.home.secciones.adapters.AdapterSeminuevo;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeminuevoFragment extends BaseFragment {


    public static SeminuevoFragment getInstance(){
        SeminuevoFragment fragment=new SeminuevoFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seminuevos, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AdapterSeminuevo adapterSeminuevo = new AdapterSeminuevo(getContext(),5);

        RecyclerView rwManual = (RecyclerView)findViewById(R.id.rwSeminuevos);
        rwManual.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwManual.setAdapter(adapterSeminuevo);
        adapterSeminuevo.notifyDataSetChanged();


    }
}
