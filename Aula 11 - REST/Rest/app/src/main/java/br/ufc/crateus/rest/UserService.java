package br.ufc.crateus.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users/{id}")
    Call<User> getUser(@Path("id") Integer id);

    @POST("/users")
    Call<User> postUser(@Body User user);

    @PUT("/users/{id}")
    Call<User> putUser(@Body User user, @Path("id") Integer id);

    @DELETE("/users/{id}")
    Call<User> deleteUser(@Path("id") Integer id);
}
