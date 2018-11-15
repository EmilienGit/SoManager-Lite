package fr.eseo.dis.somanagerlite.data.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuActivity;
import fr.eseo.dis.somanagerlite.MenuDetailPosterActivity;
import fr.eseo.dis.somanagerlite.MenuPosterActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Poster;

public class MenuPosterAdapter extends RecyclerView.Adapter<MenuPosterAdapter.PosterViewHolder> {

    private MenuPosterActivity activity;

    private List<Poster> posterList;

    public MenuPosterAdapter(MenuPosterActivity activity){
        this.activity = activity;
        setPosters(new ArrayList<Poster>());
    }

    public void setPosters(List<Poster> posters){
        this.posterList = posters;
    }

    @Override
    public int getItemCount(){
        return posterList.size();
    }

    @Override
    public MenuPosterAdapter.PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View posterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_poster, parent, false);
        return new PosterViewHolder(posterView);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder posterViewHolder, final int position) {
        final Poster poster = posterList.get(position);
        posterViewHolder.image.setImageDrawable(poster.getImage());

        posterViewHolder.buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.clickDetailPosterCard(poster);
            }
        });
    }

    class PosterViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final ImageView image;
        private final Button buttonDetail;

        public PosterViewHolder(View view){
            super(view);
            this.view = view;
            image = view.findViewById(R.id.poster_image);
            buttonDetail = view.findViewById(R.id.button_detail_poster);
        }
    }

}
