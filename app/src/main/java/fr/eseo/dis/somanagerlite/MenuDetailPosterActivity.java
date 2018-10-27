package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.adapters.MenuPosterAdapter;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class MenuDetailPosterActivity  extends AppCompatActivity {

    private MenuPosterAdapter menuPosterAdapter;
    private Poster poster;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail_poster);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        poster = (Poster) data.getParcelable(MenuPosterActivity.POSTER_EXTRA);
        imageView = findViewById(R.id.image_poster);
        if(poster.getName().equals("Excalibur II")){
            imageView.setImageResource(R.drawable.image1);
        }
        if(poster.getName().equals("Animal Tracker")){
            imageView.setImageResource(R.drawable.image2);
        }
        if(poster.getName().equals("NO IDEA")){
            imageView.setImageResource(R.drawable.image3);
        }
//        loadOptionSelectedData();
    }

    private void loadOptionSelectedData(){
        menuPosterAdapter.setPosters(TempData.getPoster());
    }
}