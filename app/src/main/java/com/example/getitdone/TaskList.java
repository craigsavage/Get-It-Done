package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().hide();
    }

    public void goToCal(View v){
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_out);//Enter new, Exit old
    }
}
