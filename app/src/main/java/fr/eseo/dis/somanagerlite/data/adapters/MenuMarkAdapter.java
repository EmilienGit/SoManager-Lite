package fr.eseo.dis.somanagerlite.data.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
    public void onBindViewHolder(@NonNull final MarkViewHolder markViewHolder, final int position) {
        final Mark mark = markList.get(position);
        markViewHolder.forname.setText(mark.getForename());
        markViewHolder.surname.setText(mark.getSurname());
        markViewHolder.note.setText(String.valueOf(mark.getMyNote()));
        markViewHolder.note.setTextColor(Color.rgb(0,184,230));

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
                    if(Double.parseDouble(markViewHolder.note.getText().toString()) >= 0
                            && Double.parseDouble(markViewHolder.note.getText().toString()) <= 20){
                        mark.setMyNote(Double.parseDouble(markViewHolder.note.getText().toString()));
                    }
                    else {
                        mark.setMyNote(Double.parseDouble(noteTemp));
                        markViewHolder.note.setError("Notes are out of bound !");
                    }
                } else {
                    mark.setMyNote(Double.parseDouble(noteTemp));
                }
            }
        });
    }

    class MarkViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView forname;
        private final TextView surname;
        private final TextView note;

        public MarkViewHolder(View view){
            super(view);
            this.view = view;

            forname = view.findViewById(R.id.mark_forname);
            surname = view.findViewById(R.id.mark_surname);
            note = view.findViewById(R.id.mark_value);
        }
    }
}
