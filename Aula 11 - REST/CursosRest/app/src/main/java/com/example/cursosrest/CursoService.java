package com.example.cursosrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("/api/cursos")
    Call<List<Curso>> getCursos();

    @GET("/api/cursos/{id}")
    Call<Curso> getCurso(@Path("id")Integer id);

    @POST("/api/cursos")
    Call<Curso> postCurso(@Body Curso curso);

    @PUT("/api/cursos/{id}")
    Call<Curso> putCurso(@Body Curso curso, @Path("id")Integer id);

    @DELETE("/api/cursos/{id}")
    Call<Curso> deleteCurso(@Path("id")Integer id);
}