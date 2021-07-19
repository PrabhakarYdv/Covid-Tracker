package com.prabhakar.covidtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenActivity extends AppCompatActivity {
    private EditText enterDate;
    private Button fetchButton;
    private TrackerAdapter trackerAdapter;
    private ArrayList<TrackerModel> trackerModelsList;
    private RecyclerView recyclerView;
    private ResponseModel responseModel = new ResponseModel();
    private TextView date;
    private TextView positiveCase;
    private TextView negativeCase;
    private TextView currentlyHospitlize;
    private TextView onVentilator;
    private Text death;
    private TextView dateChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        buildDataList();
        setRecyclerView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        enterDate = findViewById(R.id.enter_date);
        fetchButton = findViewById(R.id.fetch_btn);
        date = findViewById(R.id.date);
        positiveCase = findViewById(R.id.positive);
        negativeCase = findViewById(R.id.negative);
        currentlyHospitlize = findViewById(R.id.hospitalizedCurrently);
        onVentilator = findViewById(R.id.onVentilatorCurrently);
//        death = findViewById(R.id.death);
        dateChecked = findViewById(R.id.dateChecked);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CallApi();
            }
        });
    }

    private void buildDataList() {
        trackerModelsList = new ArrayList<>();
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 50",
                "Negative Case : 100500", "Hospitalized Currently : 55",
                "On Ventialator", "Death : 054542", "Date Checked : 20"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 56220",
                "Negative Case : 100454500", "Hospitalized Currently : 55644",
                "On Ventialator", "Death : 05451", "Date Checked : 55546550"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 656560",
                "Negative Case : 10545454000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0451", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 54650",
                "Negative Case : 10005456540", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 05451", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Dat54e : 20-0754-2021", "Positive Case : 50",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0544541", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 506",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 05451", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 5560",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 01", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 5056565",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 54501", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 650",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 5401", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 5550",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0541", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 5054",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 5545401", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 50655",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0545451", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 5000",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0541", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 58700",
                "Negative Case : 10000", "Hospitalized Currently : 545",
                "On Ventialator", "Death : 5401", "Date Checked : 5540"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 554645",
                "Negative Case : 10000", "Hospitalized Currently : 455",
                "On Ventialator", "Death : 014", "Date Checked : 50454"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 50",
                "Negative Case : 10000", "Hospitalized Currently : 545",
                "On Ventialator", "Death : 041", "Date Checked : 5455450"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-2021", "Positive Case : 50000",
                "Negative Case : 10000", "Hospitalized Currently : 4",
                "On Ventialator", "Death : 01574545", "Date Checked : 50"));
        trackerModelsList.add(new TrackerModel("Date : 20-07-25021", "Positive Case : 50000",
                "Negative Case : 10000", "Hospitalized Currently : 5",
                "On Ventialator", "Death : 0546551", "Date Checked : 50"));
    }

    public void setRecyclerView() {
        TrackerAdapter trackerAdapter = new TrackerAdapter(trackerModelsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(trackerAdapter);
    }

    private void CallApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int dateId = Integer.parseInt(enterDate.getText().toString());
        apiService.getUser(dateId).enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                ArrayList<ResponseModel> responseModel = response.body();


            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {

            }
        });
    }
}