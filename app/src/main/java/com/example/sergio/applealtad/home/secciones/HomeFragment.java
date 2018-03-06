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
import com.example.sergio.applealtad.home.secciones.adapters.AdapterHome;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;
import com.example.sergio.applealtad.register.RegisterFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    public static HomeFragment getInstance(){
        HomeFragment fragment=new HomeFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AdapterHome adapterHome = new AdapterHome(getContext(), 5, new AdapterHome.clickListener() {
            @Override
            public void onClickListener(int position) {
                addFragmentToBackStack(PromocionesFragment.getInstance(),"promociones",R.id.content_home);
            }
        });

        RecyclerView rwHome = (RecyclerView)findViewById(R.id.rwHome);
        rwHome.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rwHome.setAdapter(adapterHome);

        adapterHome.notifyDataSetChanged();


    }

}
