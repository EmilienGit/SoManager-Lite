package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.eseo.dis.somanagerlite.data.User;
import fr.eseo.dis.somanagerlite.data.adapters.MenuMarkAdapter;
import fr.eseo.dis.somanagerlite.data.source.TempData;

public class MenuMarkActivity extends AppCompatActivity {

    private MenuMarkAdapter menuMarkAdapter;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items_mark);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        this.user = new User(String.valueOf(data.get(MenuActivity.USER_EXTRA_ID)), String.valueOf(data.get(MenuActivity.USER_EXTRA_USERNAME)));


        RecyclerView recycler = (RecyclerView)findViewById(R.id.markList);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);
        menuMarkAdapter = new MenuMarkAdapter(this, this.user);
        recycler.setAdapter(menuMarkAdapter);

        loadOptionSelectedData();
    }

    private void loadOptionSelectedData(){
        menuMarkAdapter.setMarks(TempData.getMark());
    }
}
