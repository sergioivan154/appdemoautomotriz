package com.example.sergio.applealtad.home.secciones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;
import com.example.sergio.applealtad.register.VehiculoFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromocionesFragment extends BaseFragment {


    public static PromocionesFragment getInstance(){
        PromocionesFragment fragment=new PromocionesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promociones, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AdapterPromociones adapterPromociones = new AdapterPromociones(getContext(),5);

        RecyclerView rwPromos = (RecyclerView)findViewById(R.id.rwManual);
        rwPromos.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwPromos.setAdapter(adapterPromociones);
        adapterPromociones.notifyDataSetChanged();


    }
}
