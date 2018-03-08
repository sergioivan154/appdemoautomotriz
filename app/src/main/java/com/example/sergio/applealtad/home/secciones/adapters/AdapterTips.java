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
 * Created by LENOVO on 08/03/2018.
 */

public class AdapterTips extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  int num;
    private List<Integer> lImgTips;
    private List<String>lTxtTips;
    public AdapterTips(Context context, List<Integer> lImgTips,List<String>lTxtTips){
        this.context=context;
        this.lImgTips = lImgTips;
        this.lTxtTips = lTxtTips;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View headerView=inflater.inflate(R.layout.row_tips,parent,false);
        viewHolder= new AdapterTips.ViewHolderItemMenu(headerView);
        return viewHolder;
    }

    private class ViewHolderItemMenu extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtTip;
        ImageView imgTip;


        private ViewHolderItemMenu(View itemView){
            super(itemView);
            txtTip = itemView.findViewById(R.id.txtTip);
            imgTip = itemView.findViewById(R.id.imgTip);



        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterTips.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterTips.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);


    }
    private void configureViewHolderItemMenu(final AdapterTips.ViewHolderItemMenu holder, final int position) {

        holder.txtTip.setText(lTxtTips.get(position));
        holder.imgTip.setImageResource(lImgTips.get(position));

    }
    @Override
    public int getItemCount() {
        return lImgTips.size();
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
