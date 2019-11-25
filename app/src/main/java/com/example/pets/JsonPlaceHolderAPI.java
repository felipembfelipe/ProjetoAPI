package com.example.pets;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("pets")
    Call<List<Pets>> getPets();
}
