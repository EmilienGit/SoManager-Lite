package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.source.TempData;
import fr.eseo.dis.somanagerlite.utils.LoadData;


public class MenuActivity extends AppCompatActivity {

    private User user;

    public static final String USER_EXTRA_ID = "user_extra_id";
    public static final String USER_EXTRA_USERNAME = "user_extra_username";

    public static int NEW_CARD_COUNTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        NEW_CARD_COUNTER = 0;
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        this.user = new User(String.valueOf(data.get(LoginActivity.USER_EXTRA_ID)), String.valueOf(data.get(LoginActivity.USER_EXTRA_USERNAME)));

        initData();

        final Button juriesButton = findViewById(R.id.Juries);
        juriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuJuryActivity.class));
            }
        });

        final Button posterButton = findViewById(R.id.Posters);
        posterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuPosterActivity.class));
            }
        });

        final Button marksButton = findViewById(R.id.Marks);
        marksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),MenuMarkActivity.class);
                intent.putExtra(USER_EXTRA_ID, user.getId());
                intent.putExtra(USER_EXTRA_USERNAME, user.getUsername());
                startActivity(intent);
            }
        });

        final Button subjectsButton = findViewById(R.id.Subject);
        subjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuProjectActivity.class));
            }
        });
    }

    public void initData(){
        /* Projects */
        final String urlAllProject = "https://192.168.4.248/pfe/webservice.php?q=LIPRJ&user="+this.user.getUsername()+
                "&token="+this.user.getId();
        final String urlMyProject = "https://192.168.4.248/pfe/webservice.php?q=MYPRJ&user="+this.user.getUsername()+
                "&token="+this.user.getId();

        /* Juries */
        final String urlAllJury = "https://192.168.4.248/pfe/webservice.php?q=LIJUR&user="+this.user.getUsername()+
                "&token="+this.user.getId();
        final String urlMyJury = "https://192.168.4.248/pfe/webservice.php?q=MYJUR&user="+this.user.getUsername()+
                "&token="+this.user.getId();

        LoadData loadAllProject = new LoadData();
        if(TempData.getProject().isEmpty()) {
            loadAllProject.loadProjectsMarksPosters(this.getApplicationContext(), urlAllProject, true, user);
            loadAllProject.loadProjectsMarksPosters(this.getApplicationContext(), urlMyProject, false, user);
            loadAllProject.loadJuries(this.getApplicationContext(), urlAllJury, true);
            loadAllProject.loadJuries(this.getApplicationContext(), urlMyJury, false);
        }
    }
}