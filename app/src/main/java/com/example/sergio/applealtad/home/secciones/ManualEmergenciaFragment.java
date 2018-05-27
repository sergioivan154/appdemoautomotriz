package com.example.sergio.applealtad.home.secciones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergio.applealtad.Entities.ManualPojo;
import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterManual;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;

import java.util.ArrayList;
import java.util.List;

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

        List<ManualPojo> lManual = new ArrayList<>();
        lManual.add(new ManualPojo("P6BwpGbD9pc", "¿Cómo cambiar una llanta? | Volkswagen México"));
        lManual.add(new ManualPojo("i8b_P1Nr6N8", "¿Cómo deben viajar los niños en el auto? | VW"));
        lManual.add(new ManualPojo("B4xY1OFgtis", "¿Cómo hacer más seguro mi auto? | Volkswagen México"));
        lManual.add(new ManualPojo("GgfGS8WSj0Y", "¿Sabes qué presión deben tener tus llantas? | VW"));
        lManual.add(new ManualPojo("_3b8tWcTKvg", "¿Qué se recomienda al estacionar tu auto? | VW"));
        lManual.add(new ManualPojo("1cFhLR6yOMo", "¿Cómo viajar con tu mascota en el auto? | Volkswagen México"));
        lManual.add(new ManualPojo("5VKwE47PxXI", "¿Cómo ahorrar gasolina? | Volkswagen México"));
        AdapterManual adapterPromociones = new AdapterManual(getContext(),lManual);

        RecyclerView rwManual = (RecyclerView)findViewById(R.id.rwMenuEmergencia);
        rwManual.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwManual.setAdapter(adapterPromociones);
        adapterPromociones.notifyDataSetChanged();


    }
}
