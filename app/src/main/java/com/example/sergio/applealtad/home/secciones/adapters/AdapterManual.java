package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergio.applealtad.R;

/**
 * Created by sergio on 05/03/18.
 */

public class AdapterManual extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  int num;
    public AdapterManual(Context context,int num){
        this.context=context;
        this.num = num;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_manual,parent,false);
        viewHolder= new AdapterManual.ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtAportacion, txtPatron, txtFecha,txtSueldo;


        private ViewHolderItemMenu(View itemView){
            super(itemView);




        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterManual.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterManual.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);


    }
    private void configureViewHolderItemMenu(final AdapterManual.ViewHolderItemMenu holder, final int position) {



    }
    @Override
    public int getItemCount() {
        return num;
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
