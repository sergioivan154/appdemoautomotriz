package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergio.applealtad.Entities.DirectorioPojo;
import com.example.sergio.applealtad.R;

import java.util.List;

/**
 * Created by sergio on 05/03/18.
 */

public class AdapterDirectorio extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  int num;
    List<DirectorioPojo> lDirectorio;
    public AdapterDirectorio(Context context, List<DirectorioPojo> lDirectorio){
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


        private ViewHolderItemMenu(View itemView){
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);




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
