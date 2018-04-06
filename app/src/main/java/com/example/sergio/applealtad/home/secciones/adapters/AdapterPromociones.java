package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergio.applealtad.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 05/03/2018.
 */

public class AdapterPromociones extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Integer> lImagenesPromociones;
    public AdapterPromociones(Context context,List<Integer> lImagenesPromociones){
        this.context=context;
        this.lImagenesPromociones = lImagenesPromociones;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_promociones,parent,false);
        viewHolder= new ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{


        public ImageView imagenPrincipal;
        public ImageView imagenSecundaria;


        private ViewHolderItemMenu(View itemView){
            super(itemView);
            imagenPrincipal = itemView.findViewById(R.id.imagePrincipal);
            imagenSecundaria = itemView.findViewById(R.id.imageSecundaria);


        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderItemMenu aforeHolder;



                aforeHolder =(ViewHolderItemMenu) holder;
                configureViewHolderItemMenu(aforeHolder,position);


    }
    private void configureViewHolderItemMenu(final ViewHolderItemMenu holder, final int position) {


       // if(position%2 != 0) {
            holder.imagenPrincipal.setImageResource(lImagenesPromociones.get(position));
            if(position + 1 < lImagenesPromociones.size())
                holder.imagenSecundaria.setImageResource(lImagenesPromociones.get(position + 1));
       // }

    }
    @Override
    public int getItemCount() {
        return lImagenesPromociones.size();
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
