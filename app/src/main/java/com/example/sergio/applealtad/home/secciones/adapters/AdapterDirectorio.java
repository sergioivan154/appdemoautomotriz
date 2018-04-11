package com.example.sergio.applealtad.home.secciones.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergio.applealtad.Entities.DirectorioPojo;
import com.example.sergio.applealtad.R;

import java.util.List;

import static butterknife.internal.Utils.arrayOf;

/**
 * Created by sergio on 05/03/18.
 */

public class AdapterDirectorio extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity context;
    private  int num;
    List<DirectorioPojo> lDirectorio;
    public AdapterDirectorio(Activity context, List<DirectorioPojo> lDirectorio){
        this.lDirectorio = lDirectorio;
        this.context=context;
        this.num = num;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_directorio,parent,false);
        viewHolder = new AdapterDirectorio.ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtNombre, txtTelefono;
        Activity activity;


        private ViewHolderItemMenu(View itemView){
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    Log.d("boton","Entra el fun Call");

                    callIntent.setData( Uri.parse("tel:"+txtTelefono));
                    if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(context, arrayOf(android.Manifest.permission.CALL_PHONE), 105);
                    } else {
                        context.startActivity(callIntent);
                    }
                }
            });


        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterDirectorio.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterDirectorio.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);


    }
    private void configureViewHolderItemMenu(final AdapterDirectorio.ViewHolderItemMenu holder, final int position) {

        holder.txtNombre.setText(lDirectorio.get(position).getNombre());
        holder.txtTelefono.setText(lDirectorio.get(position).getTelefono());

    }
    @Override
    public int getItemCount() {
        return lDirectorio.size();
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
