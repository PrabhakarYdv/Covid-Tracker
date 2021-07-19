package com.prabhakar.covidtracker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class TrackerViewHolder extends RecyclerView.ViewHolder {
    private TextView date;
    private TextView positiveCase;
    private TextView negativeCase;
    private TextView currentlyHospitlize;
    private TextView onVentilator;
    private Text death;
    private TextView dateChecked;

    public TrackerViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        date = itemView.findViewById(R.id.date);
        positiveCase = itemView.findViewById(R.id.positive);
        negativeCase = itemView.findViewById(R.id.negative);
        currentlyHospitlize = itemView.findViewById(R.id.hospitalizedCurrently);
        onVentilator = itemView.findViewById(R.id.onVentilatorCurrently);
//        death = itemView.findViewById(R.id.death);
        dateChecked = itemView.findViewById(R.id.dateChecked);

    }

    public void setCovidData(TrackerModel covidData) {
        date.setText(covidData.getDate());
        positiveCase.setText(covidData.getPositiveCase());
        negativeCase.setText(covidData.getNegativeCase());
        currentlyHospitlize.setText(covidData.getCurrentlyHospitlize());
        onVentilator.setText(covidData.getOnVentilator());
//        death.setData(covidData.getDeath());
        dateChecked.setText(covidData.getDateChecked());
    }
}
