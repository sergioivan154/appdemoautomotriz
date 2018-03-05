package com.example.sergio.applealtad.bases;

/**
 * Created by lenovo on 16/05/2017.
 */


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.sergio.applealtad.R;


/**
 * Created by DRM on 30/09/16.
 */

public class BaseFragment extends Fragment {

   // CustomProgressDialog progress;

    public View findViewById(int resource){
        try{return getView().findViewById(resource);}catch (Exception e){return null;}
    }

    public void addFragmentToBackStack(Fragment fragment, String tag, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);//, R.anim.pop_enter, R.anim.pop_exit);
        transaction.addToBackStack(tag);
        transaction.replace(container, fragment, tag).commit();
    }

    public void addFragment(Fragment fragment, String tag, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);//, R.anim.pop_enter, R.anim.pop_exit);
        transaction.replace(container, fragment, tag).commit();
    }


    public void replaceFragment(Fragment fragment, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
        transaction.replace(container, fragment).commit();
    }


    public void removeFragment(Fragment fragment){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove(fragment);
        trans.commit();
        manager.popBackStack();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
       // progress = new CustomProgressDialog(getActivity());
    }

   /* public void showingProgress(boolean isShowing) {
        if (progress != null) {
            if (isShowing) progress.show(); else progress.dismiss();
        }
    }

    public void showError(String msg) {
        SimpleCustomDialog dialog=new SimpleCustomDialog(getActivity(), "Alerta", msg, new SimpleCustomDialog.OnButtonClickListener() {
            @Override
            public void onAcceptClickListener(Button button, AlertDialog dialog) {
                dialog.dismiss();
            }

        });
        dialog.show();*/
   // }
}

