package com.example.sergio.applealtad.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.sergio.applealtad.R;


/**
 * Created by DRM on 06/01/17.
 */

public class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbarTitle;
    String title;
    //CustomProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  progress = new CustomProgressDialog(this);

    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            setBackButton(true);
        }

        if (toolbar!=null){
            for (int i = 0; i < toolbar.getChildCount(); ++i) {
                View child = toolbar.getChildAt(i);

                // assuming that the title is the first instance of TextView
                // you can also check if the title string matches
                if (child instanceof TextView) {
                    toolbarTitle = (TextView)child;
                    if(title!=null && toolbar!=null){
                        toolbarTitle.setText(title);
                    }
                    break;
                }
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
             //   if (!(BaseActivity.this instanceof MainActivity))
                    onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTitleToolbar(String title){
        this.title=title;

    }

    public void setBackButton(boolean isActive){

    }

    public Toolbar getToolbar(){
        return toolbar;
    }

    public void showingProgress(boolean isShowing) {
        /*if (progress != null) {
            if (isShowing) progress.show(); else progress.dismiss();
        }*/
    }
}
