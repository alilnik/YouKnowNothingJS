package com.inno.ilyadmt.youknownothingjs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inno.ilyadmt.youknownothingjs.Activities.CharInfoActivity;
import com.inno.ilyadmt.youknownothingjs.Models.CharacterDAO;
import com.inno.ilyadmt.youknownothingjs.R;

import java.util.ArrayList;

/**
 * Created by mjazz on 21.07.2017.
 */

public class CharListAdapter extends RecyclerView.Adapter<CharListAdapter.Holder>{

    private ArrayList<CharacterDAO> characterDAOs;
    Context context;

    public CharListAdapter(ArrayList<CharacterDAO> characterDAOs, Context context) {
        this.characterDAOs = characterDAOs;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.charlist_row, parent, false);
        return new CharListAdapter.Holder(view, context, characterDAOs);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.name.setText(characterDAOs.get(position).getName());
        String aliases = characterDAOs.get(position).getAliases().toString();
        if(aliases.equals("[]")) aliases = "Unknown";
        holder.aliases.setText(aliases);
    }

    @Override
    public int getItemCount() {
        return characterDAOs.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView aliases;
        private ArrayList<CharacterDAO> characterDAOs;
        Context context;

        public Holder(View itemView, Context context, ArrayList<CharacterDAO> characterDAOs) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView)itemView.findViewById(R.id.tv_row_name);
            aliases = (TextView)itemView.findViewById(R.id.tv_row_aliaces);
            this.context = context;
            this.characterDAOs = characterDAOs;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            String name = characterDAOs.get(position).getName();
            String born = characterDAOs.get(position).getBorn();
            String died = characterDAOs.get(position).getDied();
            String culture = characterDAOs.get(position).getCulture();
            String aliases = characterDAOs.get(position).getAliases().toString();
            String titles = characterDAOs.get(position).getTitles().toString();


            Intent intent = new Intent(context, CharInfoActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("date", born + "-" + died);
            intent.putExtra("culture", culture);
            intent.putExtra("aliases", aliases);
            intent.putExtra("titles", titles);

            this.context.startActivity(intent);
        }
    }
}
