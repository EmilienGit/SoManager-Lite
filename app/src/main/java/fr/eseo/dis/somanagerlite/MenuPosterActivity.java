package fr.eseo.dis.somanagerlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.eseo.dis.somanagerlite.data.adapters.MenuPosterAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

public class MenuPosterActivity extends AppCompatActivity {

    private MenuPosterAdapter menuPosterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_poster);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        loadOptionSelectedData();

        RecyclerView recycler = findViewById(R.id.posterList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuPosterAdapter = new MenuPosterAdapter(this);
        recycler.setAdapter(menuPosterAdapter);
        loadOptionSelectedData();

    }

    private void loadOptionSelectedData(){
        menuPosterAdapter.setPosters(DummyData.getPoster());
    }
}
