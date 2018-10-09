package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.eseo.dis.somanagerlite.data.Option;
import fr.eseo.dis.somanagerlite.data.adapters.OptionAdapter;
import fr.eseo.dis.somanagerlite.data.source.OptionData;

public class OptionActivity extends AppCompatActivity {

    public static  int NEW_CARD_COUNTER;

    private OptionAdapter optionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        NEW_CARD_COUNTER = 0;
        RecyclerView recycler = (RecyclerView)findViewById(R.id.optionList);
        recycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        optionAdapter = new OptionAdapter(this);
        recycler.setAdapter(optionAdapter);
        loadAllOptionsData();
    }

    private void loadAllOptionsData(){
        optionAdapter.setOptions(OptionData.getOptions());
    }

    public void clickOptionPoster(Option option) {
        startActivity(new Intent(this, OptionPosterActivity.class));
    }
}