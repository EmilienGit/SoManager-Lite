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
import fr.eseo.dis.somanagerlite.MenuProjectActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Project;

public class MenuJuryAdapter extends RecyclerView.Adapter<MenuJuryAdapter.JuryViewHolder> {

    private MenuJuryActivity activity;

    private List<Jury> juryList;
    private List<Project> projectList;

    public List<Integer> positionsExpanded = new ArrayList<>();

    public MenuJuryAdapter(MenuJuryActivity activity){
        this.activity = activity;
        setJuries(new ArrayList<Jury>());
        setProjects(new ArrayList<Project>());
    }

    public void setJuries(List<Jury> juries){
        this.juryList = juries;
    }

    public void setProjects(List<Project> projects){
        this.projectList = projects;
    }

    @Override
    public int getItemCount(){
        return juryList.size();
    }

    @Override
    public MenuJuryAdapter.JuryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View juryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_jury, parent, false);
        return new MenuJuryAdapter.JuryViewHolder(juryView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuJuryAdapter.JuryViewHolder juryViewHolder, final int position) {
        final Jury jury = juryList.get(position);
        final Project project = projectList.get(position);
        juryViewHolder.dateJury.setText(jury.getDate());
        juryViewHolder.projectTitle.setText(project.getTitle());
        juryViewHolder.projectResume.setText(project.getResume());

        if (positionsExpanded.contains(position)) {
            juryViewHolder.projectResume.setVisibility(View.VISIBLE);
        } else {
            juryViewHolder.projectResume.setVisibility(View.GONE);
        }

        juryViewHolder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView description = (TextView) v.findViewById(R.id.tv_project_resume);
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
    }

    class JuryViewHolder extends RecyclerView.ViewHolder{

        private final View view;
        private final TextView dateJury;
        private final TextView projectTitle;
        private final TextView projectResume;

        public JuryViewHolder(View view){
            super(view);
            this.view = view;
            dateJury = view.findViewById(R.id.tv_jury_date);
            projectTitle = view.findViewById(R.id.tv_project_title);
            projectResume = view.findViewById(R.id.tv_project_resume);

        }
    }

}