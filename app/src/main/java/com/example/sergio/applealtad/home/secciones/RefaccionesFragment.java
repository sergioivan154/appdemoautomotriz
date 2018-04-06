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
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterRefac;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RefaccionesFragment extends BaseFragment {


    public static RefaccionesFragment getInstance(){
        RefaccionesFragment fragment=new RefaccionesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_refacciones, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<Integer> imgRefacciones = new ArrayList<>();

        imgRefacciones.add(R.drawable.refacciones01);
        imgRefacciones.add(R.drawable.refacciones02);
        imgRefacciones.add(R.drawable.refacciones03);
        imgRefacciones.add(R.drawable.refacciones04);
        imgRefacciones.add(R.drawable.refacciones05);
        imgRefacciones.add(R.drawable.refacciones06);
        List<String> txtPromociones = new ArrayList<>();

        txtPromociones.add("Balatas");
        txtPromociones.add("Rines");
        txtPromociones.add("Aleron");
        txtPromociones.add("Faros");
        txtPromociones.add("Playera");
        txtPromociones.add("Gorra");


        AdapterRefac adapterRefac = new AdapterRefac(getContext(),imgRefacciones,txtPromociones);
        RecyclerView rwRefac = (RecyclerView)findViewById(R.id.rwRefact);
        rwRefac.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwRefac.setAdapter(adapterRefac);
        adapterRefac.notifyDataSetChanged();


    }

}
