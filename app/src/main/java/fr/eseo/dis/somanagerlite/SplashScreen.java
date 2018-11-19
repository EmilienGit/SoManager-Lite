package fr.eseo.dis.somanagerlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.source.TempData;
import fr.eseo.dis.somanagerlite.utils.LoadData;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 5000;

    public static final String USER_EXTRA_ID = "user_extra_id";
    public static final String USER_EXTRA_USERNAME = "user_extra_username";

    public User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        this.user = new User(String.valueOf(data.get(LoginActivity.USER_EXTRA_ID)), String.valueOf(data.get(LoginActivity.USER_EXTRA_USERNAME)));
        initData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MenuActivity.class);
                intent.putExtra(USER_EXTRA_ID, user.getId());
                intent.putExtra(USER_EXTRA_USERNAME, user.getUsername());
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
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
