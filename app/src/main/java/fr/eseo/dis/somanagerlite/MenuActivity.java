package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public static int NEW_CARD_COUNTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        NEW_CARD_COUNTER = 0;
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        final Button posterButton = (Button) findViewById(R.id.Posters);
        posterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuPosterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MenuPosterActivity.class);
        startActivity(intent);
    }


}