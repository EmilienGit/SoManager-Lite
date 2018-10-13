package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.MenuProjectActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Project;

public class MenuProjectAdapter extends RecyclerView.Adapter<MenuProjectAdapter.ProjectViewHolder> {

    private MenuProjectActivity activity;

    private List<Project> projectList;

    public MenuProjectAdapter(MenuProjectActivity activity) {
        this.activity = activity;
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
    public MenuProjectAdapter.ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View projectView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_project, parent, false);
        return new MenuProjectAdapter.ProjectViewHolder(projectView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuProjectAdapter.ProjectViewHolder projectViewHolder, int position) {
        final Project project = projectList.get(position);
        projectViewHolder.projectTitle.setText(project.getTitle());
        projectViewHolder.projectResume.setText(project.getResume());
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        private final TextView projectTitle;
        private final TextView projectResume;

        public ProjectViewHolder(View view) {
            super(view);
            projectTitle = view.findViewById(R.id.tv_project_title);
            projectResume = view.findViewById(R.id.tv_project_resume);

        }
    }
}