package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCal(View v){
        Intent intent = new Intent(this, Calendar.class);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_in);
        startActivity(intent);
    }

    public void splash(View v) {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    public void profilePage(View v) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    public void goToNewTask(View v){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }

    public void goToLogin(View v){
        Intent intent = new Intent(this, loginPage.class);
        startActivity(intent);
    }
    public void goToSignup(View v){
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }
}
