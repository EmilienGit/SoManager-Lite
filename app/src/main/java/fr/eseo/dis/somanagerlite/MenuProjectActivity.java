package fr.eseo.dis.somanagerlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.eseo.dis.somanagerlite.data.adapters.MenuJuryAdapter;
import fr.eseo.dis.somanagerlite.data.adapters.MenuProjectAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

public class MenuProjectActivity extends AppCompatActivity {

    private MenuProjectAdapter menuProjectAdapter;

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
}
