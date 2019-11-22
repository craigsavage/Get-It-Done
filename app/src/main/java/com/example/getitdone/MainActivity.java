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
    public void goToNewTask(View v){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }
}
