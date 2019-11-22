package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void signUp(View v){
        Intent intent = new Intent(loginPage.this, signUp.class);
        startActivity(intent);
    }

    public void login(View v){
        Intent intent = new Intent(loginPage.this, Calendar.class);
        startActivity(intent);
    }

}
