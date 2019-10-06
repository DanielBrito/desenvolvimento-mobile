package com.example.teste2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/api/users")
    Call<List<User>> getUsers();

    @GET("/api/users/{id}")
    Call<User> getUser(@Path("id") Integer id);

    @POST("/api/users")
    Call<User> postUser(@Body User user);

    @PUT("/api/users/{id}")
    Call<User> putUser(@Body User user, @Path("id") Integer id);

    @DELETE("/api/users/{id}")
    Call<User> deleteUser(@Path("id") Integer id);
}
