package fr.eseo.dis.somanagerlite;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.utils.SSLUtil;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private Button connexionButton;
    private EditText loginEdit;
    private EditText passwdEdit;

    private User user;

    public static final String USER_EXTRA_ID = "user_extra_id";
    public static final String USER_EXTRA_USERNAME = "user_extra_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("ERROR CEATION","creation fail !");

        loginEdit = (EditText)findViewById(R.id.login);
        passwdEdit = (EditText)findViewById(R.id.password);

        connexionButton = (Button) findViewById(R.id.login_sign_in_button);
        connexionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickConnexion();
            }
        });
    }

    public void clickConnexion() {
        final String username = loginEdit.getText().toString();
        final String password = passwdEdit.getText().toString();

        final String url = "https://192.168.4.248/pfe/webservice.php?q=LOGON&user="+username+
                "&pass="+password;

        final SSLUtil sslUtil = new SSLUtil(this.getApplicationContext(), "root");

        RequestQueue rq = Volley.newRequestQueue(this, new HurlStack(null, sslUtil.getSslSocketFactory()));

        JsonObjectRequest s = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject s) {

                        Log.e("RESULT", String.valueOf(s));
                        try {
                            if(s.getString("result").equals("OK")) {
                                String token = s.getString("token");
                                user = new User(token, username);
                                Intent intent = new Intent (getApplicationContext(),MenuActivity.class);
                                intent.putExtra(USER_EXTRA_ID, user.getId());
                                intent.putExtra(USER_EXTRA_USERNAME, user.getUsername());
                                startActivity(intent);
                            }else{
                                passwdEdit.setError("KO");
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