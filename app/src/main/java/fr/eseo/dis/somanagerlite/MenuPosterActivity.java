package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.adapters.MenuPosterAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

public class MenuPosterActivity extends AppCompatActivity {

    private MenuPosterAdapter menuPosterAdapter;

    public static final String POSTER_EXTRA = "poster_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items_poster);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.posterList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuPosterAdapter = new MenuPosterAdapter(this);
        recycler.setAdapter(menuPosterAdapter);

        loadOptionSelectedData();
    }

    private void loadOptionSelectedData(){
        menuPosterAdapter.setPosters(DummyData.getPoster());
    }

    public void clickDetailPosterCard(Poster poster){
        Intent intent = new Intent(this, MenuDetailPosterActivity.class);
        intent.putExtra(POSTER_EXTRA, poster);
        startActivity(intent);
    }
}
