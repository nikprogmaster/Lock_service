package com.example.lockservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
    }

    //Аналогичные методы, как в MainActivity.java
    public void onLockClick(View view) {
        Intent intent = new Intent(this, Locks.class);
        startActivity(intent);
    }
    public void onFaceClick(View view) {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }
    public void onHomeClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
