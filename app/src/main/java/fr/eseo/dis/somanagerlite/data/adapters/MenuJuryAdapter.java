package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuJuryActivity;
import fr.eseo.dis.somanagerlite.data.Jury;

public class MenuJuryAdapter {
/*
    private MenuJuryActivity activity;

    private List<Jury> juries;

    public List<Integer> positionsExpanded;

    public MenuJuryAdapter(MenuJuryActivity filmographyActivity){
        this.activity = filmographyActivity;
        this.positionsExpanded = new ArrayList<>();
        setJuries(new ArrayList<Jury>());
    }

    public void setJuries(List<Jury> juries){
        this.juries = juries;
    }

    @Override
    public int getItemCount(){
        return juries.size();
    }

    @Override
    public FilmographyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View filmView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmography_card_layout, parent, false);
        return new FilmographyViewHolder(filmView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmographyViewHolder holder, final int position) {
        final Jury film = juries.get(position);
        holder.filmTitre.setText(film.getTitre());
        holder.filmGenre.setText(film.getGenre());
        holder.filmAnnee.setText(String.valueOf(film.getAnnee()));
        holder.filmResume.setText(film.getResume());
        if (positionsExpanded.contains(position)) {
            holder.filmResume.setVisibility(View.VISIBLE);
        } else {
            holder.filmResume.setVisibility(View.GONE);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.clickFilmCard(film);
            }
        });
        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView resume = (TextView) v.findViewById(R.id.tv_film_resume);
                TextView resumeLabel = (TextView) v.findViewById(R.id.tv_film_resume_label);
                if (positionsExpanded.contains(position)) {
                    resume.setVisibility(View.GONE);
                    resumeLabel.setVisibility(View.GONE);
                    positionsExpanded.remove(new Integer(position));
                } else {
                    resume.setVisibility(View.VISIBLE);
                    resumeLabel.setVisibility(View.VISIBLE);
                    positionsExpanded.add(position);
                }
                return true;
            }
        });
    }


    class FilmographyViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView juryTitre;
        private final TextView juryNumber;
        private final TextView juryDate;
        private final TextView juryResume;

        public FilmographyViewHolder(View view){
            super(view);
            this.view = view;
            juryTitre = view.findViewById(R.id.tv_film_title);
            juryNumber = view.findViewById(R.id.tv_film_genre);
            juryDate = view.findViewById(R.id.tv_film_annee);
            juryResume = view.findViewById(R.id.tv_film_resume);



        }
    }*/
}
