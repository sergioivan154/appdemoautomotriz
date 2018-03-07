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
 * Created by mac on 06/03/18.
 */

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Integer> lImagenesPromociones;

    public AdapterHome(Context context,List<Integer> lImagenesPromociones,clickListener listener){
        this.context=context;
        this.lImagenesPromociones = lImagenesPromociones;
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
        public ImageView imagenPromo;

        private ViewHolderItemMenu(View itemView){
            super(itemView);

            imagenPromo = itemView.findViewById(R.id.imagenPromo);
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

        holder.imagenPromo.setImageResource(lImagenesPromociones.get(position));

    }
    @Override
    public int getItemCount() {
        return lImagenesPromociones.size();
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