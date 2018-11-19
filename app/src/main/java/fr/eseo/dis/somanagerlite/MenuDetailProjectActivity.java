package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.google.gson.Gson;

import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.Project;

public class MenuDetailProjectActivity extends AppCompatActivity {

    private MenuProjectActivity menuProjectActivity;
    private Project project;
    private Poster poster;
    private ImageView imageView;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail_project);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        //project = (Project) data.getParcelable(MenuProjectActivity.PROJECT_EXTRA);
        project = gson.fromJson(getIntent().getStringExtra(MenuProjectActivity.PROJECT_EXTRA),Project.class);
        imageView = findViewById(R.id.image_poster);
        if(project.getTitle().equals("Titre 1")){
            imageView.setImageResource(R.drawable.image1);
            project.setDescription(project.getDescription());
        }
        if(project.getTitle().equals("Titre 2")){
            imageView.setImageResource(R.drawable.image2);
        }
        if(project.getTitle().equals("Titre 3")){
            imageView.setImageResource(R.drawable.image3);
        }
//        loadOptionSelectedData();
    }

    private void loadOptionSelectedData(){

    }
}