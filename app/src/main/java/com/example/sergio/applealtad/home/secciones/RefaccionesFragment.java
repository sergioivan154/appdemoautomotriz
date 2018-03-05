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

        AdapterRefac adapterRefac = new AdapterRefac(getContext(),3);

        RecyclerView rwRefac = (RecyclerView)findViewById(R.id.rwRefact);
        rwRefac.setLayoutManager(new LinearLayoutManager(getActivity()));
        rwRefac.setAdapter(adapterRefac);
        adapterRefac.notifyDataSetChanged();


    }

}
