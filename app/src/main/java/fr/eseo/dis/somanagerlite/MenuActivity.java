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

        final Button posterButton = findViewById(R.id.Posters);
        final Button juriesButton = findViewById(R.id.Juries);
        final Button marksButton = findViewById(R.id.Marks);
        final Button subjectsButton = findViewById(R.id.Subject);

        posterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuPosterActivity.class));
            }
        });

        juriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuJuryActivity.class));
            }
        });

        marksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuMarkActivity.class));
            }
        });

        subjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuProjectActivity.class));
            }
        });
    }

}