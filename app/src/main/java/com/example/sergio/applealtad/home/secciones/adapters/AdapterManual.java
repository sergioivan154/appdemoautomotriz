package com.example.sergio.applealtad.home.secciones.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergio.applealtad.Entities.ManualPojo;
import com.example.sergio.applealtad.Entities.Memoria;
import com.example.sergio.applealtad.R;
import com.example.sergio.applealtad.home.VideoYoutubeActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by sergio on 05/03/18.
 */

public class AdapterManual extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private List<ManualPojo> lManual;
    public AdapterManual(Context context, List<ManualPojo> lManual){
        this.context=context;
        this.lManual = lManual;

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

        TextView txtTitulo;
        public ManualPojo manual;
        ProgressBar progressBar;

        public static final String API_KEY = "AIzaSyCsycvfw2xyoNXWXiWBUYEyOB2TZkBziaI";

        private YouTubeThumbnailView thumb;

        private ViewHolderItemMenu(View itemView){
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.tituloManual);
            thumb = itemView.findViewById(R.id.yt_thumbnail);
            progressBar = itemView.findViewById(R.id.progressBar);

        }

        @Override
        public void onClick(View view) {

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final AdapterManual.ViewHolderItemMenu aforeHolder;



        aforeHolder =(AdapterManual.ViewHolderItemMenu) holder;
        configureViewHolderItemMenu(aforeHolder,position);
        aforeHolder.progressBar.setVisibility(View.VISIBLE);


        aforeHolder.thumb.initialize(aforeHolder.API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(lManual.get(position).getUrlVideo());

                aforeHolder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                aforeHolder.progressBar.setVisibility(View.GONE);
                aforeHolder.txtTitulo.setText("No se pudo cargar el video");
            }});

        aforeHolder.thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Memoria.getInstance().videoManual = lManual.get(position).getUrlVideo();
                Intent i = new Intent(context, VideoYoutubeActivity.class);
                context.startActivity(i);
            }
        });


    }
    private void configureViewHolderItemMenu(final AdapterManual.ViewHolderItemMenu holder, final int position) {



    }
    @Override
    public int getItemCount() {
        return lManual.size();
    }
    @Override
    public  int getItemViewType(int position) {


        return position;
    }
}
