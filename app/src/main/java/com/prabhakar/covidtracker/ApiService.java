package com.prabhakar.covidtracker;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("v1/us/daily.json{date}")
    Call<ArrayList<ResponseModel>> getUser(@Path("date") int date);
}
