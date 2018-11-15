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
import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.source.TempData;
import fr.eseo.dis.somanagerlite.utils.LoadData;

public class MenuMarkAdapter extends RecyclerView.Adapter<MenuMarkAdapter.MarkViewHolder> {

    private MenuMarkActivity activity;

    private List<Mark> markList;

    private User realUser;

    private LoadData loadData;

    public MenuMarkAdapter(MenuMarkActivity activity, User user){
        this.activity = activity;
        this.realUser = user;
        this.loadData = new LoadData();
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
        markViewHolder.avgnote.setText(String.valueOf(mark.getAvgNote()));
        markViewHolder.avgnote.setTextColor(Color.rgb(238,173,14));

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

                        /* Set Mark */
                        final String urlSetMark = "https://192.168.4.248/pfe/webservice.php?q=NEWNT&user=" + realUser.getUsername() +
                                "&proj=" + mark.getProjectId() + "&student=" + mark.getUserId() + "&note=" + Double.parseDouble(markViewHolder.note.getText().toString()) + "&token=" + realUser.getId();

                        loadData.setMarks(activity.getApplicationContext(), urlSetMark);
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
        private final TextView avgnote;

        public MarkViewHolder(View view){
            super(view);
            this.view = view;

            forname = view.findViewById(R.id.mark_forname);
            surname = view.findViewById(R.id.mark_surname);
            note = view.findViewById(R.id.mark_value);
            avgnote = view.findViewById(R.id.mark_avg);
        }
    }
}
