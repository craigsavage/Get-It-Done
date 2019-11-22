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
        getSupportActionBar().hide();
    }

    public void goToCal(View v){
        Intent intent = new Intent(this, Calendar.class);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_in);
        startActivity(intent);
    }
<<<<<<< HEAD

    public void splash(View v) {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    public void profilePage(View v) {
        Intent intent = new Intent(this, ProfilePage.class);
=======
    public void goToNewTask(View v){
        Intent intent = new Intent(this, NewTask.class);
>>>>>>> daf69f62d132a6ea7f8a7a816d8d283baf472764
        startActivity(intent);
    }
}
