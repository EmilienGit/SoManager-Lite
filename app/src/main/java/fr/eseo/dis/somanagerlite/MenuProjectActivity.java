package fr.eseo.dis.somanagerlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.adapters.MenuProjectAdapter;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class MenuProjectActivity extends AppCompatActivity {

    private MenuProjectAdapter menuProjectAdapter;

    public static final String PROJECT_EXTRA = "project_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items_project);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        RecyclerView recycler = (RecyclerView)findViewById(R.id.projectList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuProjectAdapter = new MenuProjectAdapter(this);
        recycler.setAdapter(menuProjectAdapter);

        loadOptionSelectedData();

        /*final Button sendVisitorProject = findViewById(R.id.SendVisitorProject);
        List<Project> projects = new ArrayList<>();
        sendVisitorProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 4; i++){
                    projects.add(TempData.getProject().get((int)(Math.random()*(TempData.getProject().size()-0))));
                }
                TempData.setListVisitorProject(projects);

            }
        });*/

    }

    private void loadOptionSelectedData(){
        menuProjectAdapter.setProjects(TempData.getProject());
        List<Project> projects = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            projects.add(TempData.getProject().get((int)(Math.random()*(TempData.getProject().size()-0))));
        }
        TempData.setListVisitorProject(projects);
    }
}
