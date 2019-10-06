package com.example.teste2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    static Retrofit retrofit = null;

    static String BASE_URL = "https://almada-app-server.herokuapp.com";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
