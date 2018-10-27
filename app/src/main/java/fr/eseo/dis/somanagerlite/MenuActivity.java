package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.utils.LoadData;

public class MenuActivity extends AppCompatActivity {

    private User user;
//    private List<Project> projects = new ArrayList<>();

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
        this.user = data.getParcelable(LoginActivity.USER_EXTRA);

        initData();

        /*
        String url = "https://192.168.4.248/pfe/webservice.php?q=LIPRJ&user="+this.user.getUsername()+
                "&token="+this.user.getId();
        loadProjectData(url, false);*/

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
                startActivity(new Intent(getApplicationContext(), MenuMarkActivity.class));
            }
        });

    /*    final String urlMyProject = "https://192.168.4.248/pfe/webservice.php?q=MYPRJ&user="+this.user.getUsername()+
                "&token="+this.user.getId();*/
        final Button subjectsButton = findViewById(R.id.Subject);
        subjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadProjectData(urlMyProject, true);
                startActivity(new Intent(getApplicationContext(), MenuProjectActivity.class));
            }
        });
    }
/*
    public void loadProjectData(String url, final boolean buttonOnClick) {

        final SSLUtil sslUtil = new SSLUtil(this.getApplicationContext(), "root");

        RequestQueue rq = Volley.newRequestQueue(this, new HurlStack(null, sslUtil.getSslSocketFactory()));

        JsonObjectRequest s = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject s) {

                        Log.e("RESULT", String.valueOf(s));
                        try {
                            if(s.getString("result").equals("OK")) {

                                List<Project> listProject = new ArrayList<>();
                                JSONArray array = s.getJSONArray("projects");

                                for(int i = 0; i < array .length(); i++) {
                                    JSONObject project = array.getJSONObject(i);

                                    String projectId = project.getString("projectId");
                                    String title = project.getString("title");
                                    String description = project.getString("descrip");
                                    boolean booleanPoster = project.getBoolean("poster");;

                                    JSONObject superviseurJSON = project.getJSONObject("supervisor");
                                    String forename = superviseurJSON.getString("forename");
                                    String surname = superviseurJSON.getString("surname");
                                    User supervisor = new User("Unknown", forename, surname);

                                    String confidentail = project.getString("confid");

                                    List<User> listStudent = new ArrayList<>();
                                    JSONArray studentsJSON = project.getJSONArray("students");

                                    for(int j = 0; j < studentsJSON .length(); j++) {
                                        JSONObject student = studentsJSON.getJSONObject(i);
                                        String userId = student.getString("userId");
                                        String studentForename = student.getString("forename");
                                        String studentSurename = student.getString("surname");
                                        listStudent.add(new User(userId, studentForename, studentSurename));
                                    }

                                    listProject.add(new Project(projectId, title, description,
                                            booleanPoster, supervisor, confidentail, listStudent));
                                }

                                if(buttonOnClick) {
                                    TempData.setListMyproject(projects);
                                    projects = new ArrayList<>();
                                } else {
                                    TempData.setListProject(projects);
                                    projects = new ArrayList<>();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("KO",volleyError.getMessage()); }
                } );
        rq.add(s);
    }
*/

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

        loadAllProject.loadProjects(this.getApplicationContext(), urlAllProject, true);
        loadAllProject.loadProjects(this.getApplicationContext(), urlMyProject, false);
        loadAllProject.loadJuries(this.getApplicationContext(), urlAllJury, true);
        loadAllProject.loadJuries(this.getApplicationContext(), urlMyJury, false);
    }
}