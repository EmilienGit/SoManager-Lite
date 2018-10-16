package fr.eseo.dis.somanagerlite.data.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    public List<Integer> positionsExpanded = new ArrayList<>();

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
        posterViewHolder.nom.setText(poster.getName());
        posterViewHolder.description.setText(poster.getDescription());

        if (positionsExpanded.contains(position)) {
            posterViewHolder.description.setVisibility(View.VISIBLE);
        } else {
            posterViewHolder.description.setVisibility(View.GONE);
        }

        posterViewHolder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView description = (TextView) v.findViewById(R.id.poster_description);
                if (positionsExpanded.contains(position)) {
                    description.setVisibility(View.GONE);
                    positionsExpanded.remove(new Integer(position));
                } else {
                    description.setVisibility(View.VISIBLE);
                    positionsExpanded.add(position);
                }
                return true;
            }
        });

        posterViewHolder.buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.clickDetailPosterCard(poster);
            }
        });
    }

    class PosterViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView nom;
        private final TextView description;
        private final Button buttonDetail;

        public PosterViewHolder(View view){
            super(view);
            this.view = view;
            nom = view.findViewById(R.id.poster_name);
            description = view.findViewById(R.id.poster_description);
            buttonDetail = view.findViewById(R.id.button_detail_poster);
        }
    }

}
