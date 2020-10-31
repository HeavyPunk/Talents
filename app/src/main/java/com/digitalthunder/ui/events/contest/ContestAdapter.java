package com.digitalthunder.ui.events.contest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalthunder.R;

import java.util.ArrayList;

public class ContestAdapter extends RecyclerView.Adapter<ContestAdapter.OlimpiadesViewHolder> {

    ArrayList<Contest> contests;
    public ContestAdapter(ArrayList<Contest> contests) {
        this.contests = contests;
    }

    @NonNull
    @Override
    public OlimpiadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.olimpiades_list_items, parent, false);
        return new OlimpiadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OlimpiadesViewHolder holder, int position) {
        holder.classes.setText(contests.get(position).classes);
        holder.title.setText(contests.get(position).title);
        holder.subTilte.setText(contests.get(position).subTitle);
        holder.description.setText(contests.get(position).description);
        holder.link = contests.get(position).link;
    }

    @Override
    public int getItemCount() {
        return contests.size();
    }

    public static class OlimpiadesViewHolder extends RecyclerView.ViewHolder {
        TextView classes;
        TextView title;
        TextView subTilte;
        TextView description;
        String link;

        public OlimpiadesViewHolder(@NonNull View itemView) {
            super(itemView);
            classes = (TextView) itemView.findViewById(R.id.classes);
            title = (TextView) itemView.findViewById(R.id.title);
            subTilte = (TextView) itemView.findViewById(R.id.subtitle);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
