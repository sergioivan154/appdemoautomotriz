package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergio.applealtad.R;

import java.util.List;

/**
 * Created by LENOVO on 05/03/2018.
 */

public class AdapterRefac extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context context;
    private List<Integer> lImagenesRefacciones;
    public AdapterRefac(Context context,List<Integer> lImagenesRefacciones){
        this.context=context;
        this.lImagenesRefacciones =lImagenesRefacciones;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_refacciones,parent,false);
        viewHolder= new AdapterRefac.ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterRefac.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterRefac.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);


    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgPrincipal, imgSecundaria;


        private ViewHolderItemMenu(View itemView){
            super(itemView);

            imgPrincipal = itemView.findViewById(R.id.imagenPrincipal);
            imgSecundaria = itemView.findViewById(R.id.imagenSecundaria);


        }

        @Override
        public void onClick(View view) {

        }
    }
    private void configureViewHolderItemMenu(final AdapterRefac.ViewHolderItemMenu holder, final int position) {

        holder.imgPrincipal.setImageResource(lImagenesRefacciones.get(position));
        if(position + 1 < lImagenesRefacciones.size())
            holder.imgSecundaria.setImageResource(lImagenesRefacciones.get(position + 1));
    }
    @Override
    public int getItemCount() {
        return lImagenesRefacciones.size();
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
