package fr.eseo.dis.somanagerlite.utils;

import android.content.Context;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class LoadData {

    public LoadData(){
    }

    public void loadProjects(Context context, String url, final boolean touteslesdonnees) {

        final SSLUtil sslUtil = new SSLUtil(context, "root");

        RequestQueue rq = Volley.newRequestQueue(context, new HurlStack(null, sslUtil.getSslSocketFactory()));

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
                                    boolean booleanPoster = project.getBoolean("poster");

                                    JSONObject supervisorJSON = project.getJSONObject("supervisor");
                                    String forename = supervisorJSON.getString("forename");
                                    String surname = supervisorJSON.getString("surname");
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

                                if(touteslesdonnees){
                                    TempData.setListProject(listProject);
                                } else {
                                    TempData.setListMyProject(listProject);
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

    public void loadJuries(Context context, String url, final boolean touteslesdonnees) {

        final SSLUtil sslUtil = new SSLUtil(context, "root");

        RequestQueue rq = Volley.newRequestQueue(context, new HurlStack(null, sslUtil.getSslSocketFactory()));

        JsonObjectRequest s = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject s) {

                        Log.e("RESULT", String.valueOf(s));
                        try {
                            if(s.getString("result").equals("OK")) {

                                List<Jury> listJury = new ArrayList<>();
                                JSONArray array = s.getJSONArray("juries");

                                for(int i = 0; i < array .length(); i++) {
                                    JSONObject jury = array.getJSONObject(i);

                                    String idJury = jury.getString("idJury");
                                    String date = jury.getString("date");

                                    List<Project> listProject = new ArrayList<>();

                                    JSONObject infoJSON = jury.getJSONObject("info");
                                    JSONArray projectJSON = infoJSON.getJSONArray("projects");

                                    for(int j = 0; j < projectJSON .length(); j++) {
                                        JSONObject project = projectJSON.getJSONObject(i);

                                        String projectId = project.getString("projectId");
                                        String title = project.getString("title");
                                        String confidential = project.getString("confid");
                                        boolean booleanPoster = project.getBoolean("poster");

                                        JSONObject supervisorJSON = project.getJSONObject("supervisor");
                                        String forename = supervisorJSON.getString("forename");
                                        String surname = supervisorJSON.getString("surname");
                                        User supervisor = new User("Unknown", forename, surname);

                                        listProject.add(new Project(projectId, title, confidential, booleanPoster,
                                                supervisor));
                                    }
                                    listJury.add(new Jury(idJury, date, listProject));
                                }

                                if(touteslesdonnees){
                                    TempData.setListJury(listJury);
                                } else {
                                    TempData.setListMyJury(listJury);
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

}
