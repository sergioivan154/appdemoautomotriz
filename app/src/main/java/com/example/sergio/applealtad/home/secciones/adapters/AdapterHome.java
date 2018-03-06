package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergio.applealtad.R;

/**
 * Created by mac on 06/03/18.
 */

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  int num;
    public AdapterHome(Context context,int num,clickListener listener){
        this.context=context;
        this.num = num;
        this.clickListener = listener;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_home,parent,false);
        viewHolder= new AdapterHome.ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtAportacion, txtPatron, txtFecha,txtSueldo;


        private ViewHolderItemMenu(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if(clickListener != null){
                clickListener.onClickListener(getAdapterPosition());
            }

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterHome.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterHome.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);


    }
    private void configureViewHolderItemMenu(final AdapterHome.ViewHolderItemMenu holder, final int position) {



    }
    @Override
    public int getItemCount() {
        return num;
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
    public clickListener clickListener;
    public interface clickListener{
        void onClickListener(int position);



    }
}