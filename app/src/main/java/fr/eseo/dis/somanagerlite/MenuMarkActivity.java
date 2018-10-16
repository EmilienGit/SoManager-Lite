package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.adapters.MenuMarkAdapter;
import fr.eseo.dis.somanagerlite.data.source.DummyData;

public class MenuMarkActivity extends AppCompatActivity {

    private MenuMarkAdapter menuMarkAdapter;
    private int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items_mark);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.markList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuMarkAdapter = new MenuMarkAdapter(this);
        recycler.setAdapter(menuMarkAdapter);

        loadOptionSelectedData();
    }

    private void loadOptionSelectedData(){
        menuMarkAdapter.setMarks(DummyData.getMark());
    }
}
