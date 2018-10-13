package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    public void onBindViewHolder(@NonNull PosterViewHolder posterViewHolder, int position) {
        final Poster poster = posterList.get(position);
        posterViewHolder.nom.setText(poster.getName());
        posterViewHolder.description.setText(poster.getDescription());
    }

    class PosterViewHolder extends RecyclerView.ViewHolder{

        private final TextView nom;
        private final TextView description;

        public PosterViewHolder(View view){
            super(view);
            nom = view.findViewById(R.id.poster_name);
            description = view.findViewById(R.id.poster_description);
        }
    }

}
