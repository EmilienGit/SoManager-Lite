package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.adapters.MenuJuryAdapter;
import fr.eseo.dis.somanagerlite.data.adapters.MenuPosterAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

public class MenuJuryActivity extends AppCompatActivity {

    private MenuJuryAdapter menuJuryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items_jury);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.juryList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuJuryAdapter = new MenuJuryAdapter(this);
        recycler.setAdapter(menuJuryAdapter);

        loadOptionSelectedData();

    }

    private void loadOptionSelectedData(){
        menuJuryAdapter.setJuries(DummyData.getJury());
        menuJuryAdapter.setProjects(DummyData.getProject());
    }
}
