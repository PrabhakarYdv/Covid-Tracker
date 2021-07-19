package com.prabhakar.covidtracker;

public class TrackerModel {
    private String date;
    private String positiveCase;
    private String negativeCase;
    private String currentlyHospitlize;
    private String onVentilator;
    private String death;
    private String dateChecked;

    public TrackerModel(String date, String positiveCase, String negativeCase,
                        String currentlyHospitlize, String onVentilator, String death, String dateChecked) {
        this.date = date;
        this.positiveCase = positiveCase;
        this.negativeCase = negativeCase;
        this.currentlyHospitlize = currentlyHospitlize;
        this.onVentilator = onVentilator;
        this.death = death;
        this.dateChecked = dateChecked;
    }

    public String getDate() {
        return date;
    }

    public String getPositiveCase() {
        return positiveCase;
    }

    public String getNegativeCase() {
        return negativeCase;
    }

    public String getCurrentlyHospitlize() {
        return currentlyHospitlize;
    }

    public String getOnVentilator() {
        return onVentilator;
    }

    public String getDeath() {
        return death;
    }

    public String getDateChecked() {
        return dateChecked;
    }
}
