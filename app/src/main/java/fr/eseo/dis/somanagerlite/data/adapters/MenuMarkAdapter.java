package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuMarkActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Mark;

public class MenuMarkAdapter extends RecyclerView.Adapter<MenuMarkAdapter.MarkViewHolder> {

    private MenuMarkActivity activity;

    private List<Mark> markList;

    public MenuMarkAdapter(MenuMarkActivity activity){
        this.activity = activity;
        setMarks(new ArrayList<Mark>());
    }

    public void setMarks(List<Mark> marks){
        this.markList = marks;
    }

    @Override
    public int getItemCount(){
        return markList.size();
    }

    @Override
    public MenuMarkAdapter.MarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View markView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_mark, parent, false);
        return new MarkViewHolder(markView);
    }

    @Override
    public void onBindViewHolder(@NonNull MarkViewHolder markViewHolder, final int position) {
        final Mark mark = markList.get(position);
        markViewHolder.nom.setText(mark.getNom());
        markViewHolder.prenom.setText(mark.getPrenom());
        markViewHolder.note.setText(String.valueOf(mark.getNote()));
    }

    class MarkViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView nom;
        private final TextView prenom;
        private final TextView note;

        public MarkViewHolder(View view){
            super(view);
            this.view = view;

            nom = view.findViewById(R.id.mark_nom);
            prenom = view.findViewById(R.id.mark_prenom);
            note = view.findViewById(R.id.mark_velue);
        }
    }

}
