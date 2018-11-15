package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import fr.eseo.dis.somanagerlite.data.adapters.VisitorProjectAdapter;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class VisitorProjectActivity  extends AppCompatActivity {

    private VisitorProjectAdapter visitorProjectAdapter;

    public static final String PROJECT_EXTRA = "project_extra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_items_project);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.VisitorProjectList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        visitorProjectAdapter = new VisitorProjectAdapter(this);
        recycler.setAdapter(visitorProjectAdapter);

        loadOptionSelectedData();

    }

    private void loadOptionSelectedData(){
        visitorProjectAdapter.setProjects(TempData.getVisitorProject());
    }
}
