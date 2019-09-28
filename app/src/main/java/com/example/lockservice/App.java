package com.example.lockservice;

import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class App extends Application {

    private static LockApi lockApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        //создание объекта retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.18.198.31:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //создание класса на основе интерфейса
        lockApi = retrofit.create(LockApi.class);
    }
    //обыкновенный геттер для private переменной
    public static LockApi getApi() {
        return lockApi;
    }
}
