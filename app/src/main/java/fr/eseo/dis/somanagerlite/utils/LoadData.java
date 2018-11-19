package fr.eseo.dis.somanagerlite.utils;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Base64;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.Project;
import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class LoadData {

    public LoadData(){
    }

    public void loadProjectsMarksPosters(final Context context, String url, final boolean touteslesdonnees, User user) {

        final User realUser = user;
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
                                        JSONObject student = studentsJSON.getJSONObject(j);
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
                                    for(int i = 0; i < TempData.getProject().size(); i++) {
                                        /* Poster */
                                        final String urlAllPosters = "https://192.168.4.248/pfe/webservice.php?q=POSTR&user=" + realUser.getUsername() +
                                                "&proj=" + TempData.getProject().get(i).getId() + "&style=" + "THB64" + "&token=" + realUser.getId();

                                        loadPosters(context, urlAllPosters, true);
                                    }
                                } else {
                                    TempData.setListMyProject(listProject);
                                    for(int i = 0; i < TempData.getMyProject().size(); i++) {
                                        /* Mark */
                                        final String urlAllMarks = "https://192.168.4.248/pfe/webservice.php?q=NOTES&user=" + realUser.getUsername() +
                                                "&proj==" + TempData.getMyProject().get(i).getId() + "&token=" + realUser.getId();

                                        loadMarks(context, urlAllMarks, TempData.getMyProject().get(i).getId());

                                        /* Poster */
                                        final String urlAllPosters = "https://192.168.4.248/pfe/webservice.php?q=POSTR&user=" + realUser.getUsername() +
                                                "&proj=" + TempData.getMyProject().get(i).getId() + "&style=" + "THB64" + "&token=" + realUser.getId();

                                        loadPosters(context, urlAllPosters, false);
                                    }
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

    public void loadJuries(final Context context, String url, final boolean touteslesdonnees) {

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
                                        JSONObject project = projectJSON.getJSONObject(j);

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

    public void loadPosters(final Context context, final String url, final boolean touteslesdonnees) {
        final SSLUtil sslUtil = new SSLUtil(context, "root");

        RequestQueue rq = Volley.newRequestQueue(context, new HurlStack(null, sslUtil.getSslSocketFactory()));

        /*StringRequest s = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        String encodedImage = response;
                        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
                        Log.e("========--------", decodedString.toString());
                        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                        Log.e("-----------------", bitmap.toString());

                        if(touteslesdonnees){
                            TempData.addPoster(new Poster(bitmap));
                        } else {
                            TempData.addMyPoster(new Poster(bitmap));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
        });
        rq.add(s);*/
    }

    public void loadMarks(Context context, String url, final String projectId) {

        final SSLUtil sslUtil = new SSLUtil(context, "root");

        RequestQueue rq = Volley.newRequestQueue(context, new HurlStack(null, sslUtil.getSslSocketFactory()));

        JsonObjectRequest s = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject s) {

                        Log.e("RESULT", String.valueOf(s));
                        try {
                            if(s.getString("result").equals("OK")) {

                                List<Mark> listMark = new ArrayList<>();
                                JSONArray array = s.getJSONArray("notes");

                                for(int i = 0; i < array .length(); i++) {
                                    JSONObject project = array.getJSONObject(i);

                                    String id = project.getString("userId");
                                    String forename = project.getString("forename");
                                    String surname = project.getString("surname");
                                    double mynote = project.getDouble("mynote");
                                    double avgnote = project.getDouble("avgNote");

                                    listMark.add(new Mark(id, forename, surname,
                                            mynote, avgnote, projectId));
                                }

                                TempData.setListMark(listMark);
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

    public void setMarks(Context context, String url) {

        final SSLUtil sslUtil = new SSLUtil(context, "root");

        RequestQueue rq = Volley.newRequestQueue(context, new HurlStack(null, sslUtil.getSslSocketFactory()));

        JsonObjectRequest s = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject s) {

                        Log.e("RESULT", String.valueOf(s));
                        try {
                            if(s.getString("result").equals("OK")) {
                                Log.e("RESULT", "La nouvelle note a été prise en compte !");
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
