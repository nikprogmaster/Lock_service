package com.example.lockservice;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

//интерфейс для получения информации от сервера
public interface LockApi {
    //запрос на получение списка замков
    @GET("/locks")
    Call<List<LocksPOJO>> getLocks();
    //запрос на получение даты запуска сервере
    @GET("/datestart")
    Call<String> getDate();
}
