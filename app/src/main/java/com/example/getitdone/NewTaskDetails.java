package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewTaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_details);
    }

    public void goToTaskList(View v){
        Intent intent = new Intent(this, TaskList.class);
        startActivity(intent);
        overridePendingTransition (R.anim.left_slide_in, R.anim.left_slide_out);//Enter new, Exit old
    }
}
