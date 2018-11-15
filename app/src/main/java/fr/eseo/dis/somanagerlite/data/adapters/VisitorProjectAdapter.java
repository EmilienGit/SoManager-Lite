package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuProjectActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.VisitorProjectActivity;
import fr.eseo.dis.somanagerlite.data.Project;

public class VisitorProjectAdapter extends RecyclerView.Adapter<VisitorProjectAdapter.VisitorProjectViewHolder> {


    private VisitorProjectActivity acitivVisitorProject;

    private List<Project> projectList;

    public List<Integer> positionsExpanded = new ArrayList<>();


    public VisitorProjectAdapter(VisitorProjectActivity activity) {
        this.acitivVisitorProject = activity;
        setProjects(new ArrayList<Project>());
    }


    public void setProjects(List<Project> projects) {
        this.projectList = projects;
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    @Override
    public VisitorProjectAdapter.VisitorProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View projectView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activiry_visitor_projects, parent, false);
        return new VisitorProjectAdapter.VisitorProjectViewHolder(projectView);
    }

    public void onBindViewHolder(@NonNull VisitorProjectAdapter.VisitorProjectViewHolder projectViewHolder, final int position) {
        final Project project = projectList.get(position);
        projectViewHolder.projectTitle.setText(project.getTitle());
        projectViewHolder.projectResume.setText(project.getDescription());

        if (positionsExpanded.contains(position)) {
            projectViewHolder.projectResume.setVisibility(View.VISIBLE);
        } else {
            projectViewHolder.projectResume.setVisibility(View.GONE);
        }
        projectViewHolder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView description = (TextView) v.findViewById(R.id.tv_visitor_project_resume);
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
        projectViewHolder.buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //acitivVisitorProject.clickDetailProjectCard(project);
            }
        });
    }

    class VisitorProjectViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final TextView projectTitle;
        private final TextView projectResume;
        private final Button buttonDetail;

        public VisitorProjectViewHolder(View view) {
            super(view);
            this.view = view;
            projectTitle = view.findViewById(R.id.tv_visitor_project_title);
            projectResume = view.findViewById(R.id.tv_visitor_project_resume);
            buttonDetail = view.findViewById(R.id.visitor_button_details);

        }
    }

}
