package br.ufc.crateus.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    static Retrofit retrofit = null;

    static String BASE_URL = "https://jsonplaceholder.typicode.com";

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
