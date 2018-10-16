package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.adapters.MenuProjectAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

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

    }

    private void loadOptionSelectedData(){
        menuProjectAdapter.setProjects(DummyData.getProject());
    }

    public void clickDetailProjectCard(Project project){
        Intent intent = new Intent(this, MenuDetailProjectActivity.class);
        Gson gson = new Gson();
        String myJson = gson.toJson(project);
        intent.putExtra(PROJECT_EXTRA, myJson);
        startActivity(intent);
    }
}
