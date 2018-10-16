package fr.eseo.dis.somanagerlite.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuMarkActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

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
    public void onBindViewHolder(@NonNull final MarkViewHolder markViewHolder, final int position) {
        final Mark mark = markList.get(position);
        markViewHolder.nom.setText(mark.getNom());
        markViewHolder.prenom.setText(mark.getPrenom());
        markViewHolder.note.setText(String.valueOf(mark.getNote()));
        Log.d("---------------------",markViewHolder.note.getText().toString());

        markViewHolder.note.addTextChangedListener(new TextWatcher() {
            String noteTemp = markViewHolder.note.getText().toString();;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!markViewHolder.note.getText().toString().equals("")){
                    mark.setNote(Integer.parseInt(markViewHolder.note.getText().toString()));
                } else {
                    mark.setNote(Integer.parseInt(noteTemp));
                }
            }
        });

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
            note = view.findViewById(R.id.mark_value);
        }
    }
}
