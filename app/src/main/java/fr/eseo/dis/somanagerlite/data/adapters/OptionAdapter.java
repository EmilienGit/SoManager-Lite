package fr.eseo.dis.somanagerlite.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.OptionActivity;
import fr.eseo.dis.somanagerlite.R;
import fr.eseo.dis.somanagerlite.data.Option;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionViewHolder>{

    private OptionActivity activity;

    private List<Option> options;

    public List<Integer> positionsExpanded;

    public OptionAdapter(OptionActivity optionActivity){
        this.activity = optionActivity;
        setOptions(new ArrayList<Option>());
    }

    public void setOptions(List<Option> options){
        this.options = options;
    }

    @Override
    public int getItemCount(){
        return options.size();
    }

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View optionView = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_card_layout, parent, false);
        CardView optionCardView = (CardView)optionView;
        optionCardView.setCardElevation(3 * OptionActivity.NEW_CARD_COUNTER++);
        return new OptionViewHolder(optionView);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, final int position) {
        final Option option = options.get(position);
        holder.optionName.setText(option.getName());

        /**
         *
         * @TODO
         *
         * */

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.clickOptionPoster(option);
            }
        });

    }

    class OptionViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView optionName;

        public OptionViewHolder(View view){
            super(view);
            this.view = view;
            optionName = view.findViewById(R.id.tv_option_name);
        }
    }
}
