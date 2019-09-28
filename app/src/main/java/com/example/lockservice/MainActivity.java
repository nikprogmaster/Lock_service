package com.example.lockservice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    //Список замков
    List<LocksPOJO> locks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locks = new ArrayList<>();
        //ListView - для отображения списка замков
        final ListView l= findViewById(R.id.lw);
        //Отправляем запрос на сервер
        App.getApi().getLocks().enqueue(new Callback<List<LocksPOJO>>() {
            //Метод обработки ответа
            @Override
            public void onResponse(Response<List<LocksPOJO>> response, Retrofit retrofit) {
                //Если есть ответ
                if (response.isSuccess()) {
                    // добавляем все элементы в список
                    locks.addAll(response.body());
                    //устанавливаем для listview адаптер
                    l.setAdapter(new ListAdapter(MainActivity.this, locks));
                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }
            //метод обработки ошибок интернет-соединения
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        /*App.getApi().getDate().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    String date = response.body();
                    TextView dateView = findViewById(R.id.date);
                    dateView.setText(date);
                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    //Метод, вызывающийся при нажатии на значок "замок"
    public void onLockClick(View view) {
        Intent intent = new Intent(MainActivity.this, Locks.class);
        startActivity(intent);
    }

    //метод, вызывающийся при нажатии на кнопку "пользователь"
    public void onFaceClick(View view) {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }

    public void onHomeClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
