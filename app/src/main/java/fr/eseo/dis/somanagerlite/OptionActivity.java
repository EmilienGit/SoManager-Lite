package fr.eseo.dis.somanagerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.eseo.dis.somanagerlite.data.Option;
import fr.eseo.dis.somanagerlite.data.adapters.OptionAdapter;
import fr.eseo.dis.somanagerlite.data.source.OptionData;

public class OptionActivity extends AppCompatActivity {

    public static final String OPTION_EXTRA = "option_extra";
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

    /**
     *
     * @TODO La page suivante quand tu cliqueras sera la classe OptionDetailsActivity
     *
     * */


    public void clickOptionCard(Option option) {

        Intent intent = new Intent(this, OptionDetailsActivity.class);
        intent.putExtra(OPTION_EXTRA, option);
        startActivity(intent);
    }

}