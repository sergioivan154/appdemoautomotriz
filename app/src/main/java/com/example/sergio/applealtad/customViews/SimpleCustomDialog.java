package com.example.sergio.applealtad.customViews;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergio.applealtad.R;


/**
 * Created by DRM on 03/10/16.
 */
public class SimpleCustomDialog extends AlertDialog implements View.OnClickListener{

    String title;
    String message;
    OnButtonClickListener listener;

    Context context;




    public SimpleCustomDialog(Context context,  OnButtonClickListener lister){
        super(context);

        this.listener = lister;

        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setContentView(R.layout.alert);


        findViewById(R.id.accept).setOnClickListener(this);



        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            if (view.getId() == R.id.accept)
                listener.onAcceptClickListener((Button) view, this);

        }else {
            dismiss();
        }
    }

    public interface OnButtonClickListener{
         void onAcceptClickListener(Button button, AlertDialog dialog);
    }


}
