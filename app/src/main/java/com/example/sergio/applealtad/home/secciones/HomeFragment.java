package com.example.sergio.applealtad.home.secciones;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.bases.BaseFragment;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterHome;
import com.example.sergio.applealtad.home.secciones.adapters.AdapterPromociones;
import com.example.sergio.applealtad.register.RegisterFragment;
import com.example.sergio.applealtad.storage.DemoPreference;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> lImgPromociones = new ArrayList<>();

        lImgPromociones.add(R.drawable.promocion1);




        AdapterHome adapterHome = new AdapterHome(getContext(), lImgPromociones, new AdapterHome.clickListener() {
            @Override
            public void onClickListener(int position) {
                addFragmentToBackStack(PromocionesFragment.getInstance(),"promociones",R.id.content_home);
            }
        });

        RecyclerView rwHome = (RecyclerView)findViewById(R.id.rwHome);
        rwHome.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rwHome.setAdapter(adapterHome);

        adapterHome.notifyDataSetChanged();

        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.tips02), 4000);
        animation.addFrame(getResources().getDrawable(R.drawable.tips03), 4000);
        animation.addFrame(getResources().getDrawable(R.drawable.tips04), 4000);
        animation.addFrame(getResources().getDrawable(R.drawable.tips01), 4000);
        animation.setEnterFadeDuration(500);
        animation.setExitFadeDuration(500);

        animation.setOneShot(false);

        ImageView imageAnim =  (ImageView) findViewById(R.id.imgTips);
        imageAnim.setBackgroundDrawable(animation);


        // start the animation!
        animation.start();
        imageAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              addFragmentToBackStack(TipsFragment.getInstance(),"tips",R.id.content_home);
            }
        });

        int [] kilometraje = DemoPreference.getInstance(getContext()).getKilometraje();
        TextView txtKilometraje = (TextView)findViewById(R.id.txtKilometraje);

        txtKilometraje.setText(""+kilometraje[0]+""+kilometraje[1]+""+kilometraje[2]+""+kilometraje[3]+""+kilometraje[4]+""+kilometraje[5]);
    }

}
