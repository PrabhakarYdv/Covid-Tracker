package com.prabhakar.covidtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerViewHolder> {
    private List<TrackerModel> trackerModels;

    public TrackerAdapter(List<TrackerModel> trackerModels) {
        this.trackerModels = trackerModels;
    }

    @NonNull
    @Override
    public TrackerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new TrackerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackerViewHolder holder, int position) {
        TrackerModel model = trackerModels.get(position);
        holder.setCovidData(model);
    }

    @Override
    public int getItemCount() {
        return trackerModels.size();
    }
}
