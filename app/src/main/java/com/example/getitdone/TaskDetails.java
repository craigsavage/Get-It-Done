package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {
    ImageView taskGraph;
    TextView nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        Intent intent = getIntent();

        taskGraph = (ImageView)findViewById(R.id.taskGraph);
        nameField = (TextView)findViewById(R.id.nameField);

        nameField.setText(intent.getStringExtra("name"));
    }

    public void goToTaskList(View v){
        Intent intent = new Intent(this, TaskList.class);
        startActivity(intent);
        overridePendingTransition (R.anim.left_slide_in, R.anim.left_slide_out);//Enter new, Exit old
    }

    public void nextStep(View v){

        if(taskGraph.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.task_progress_0).getConstantState()){
            taskGraph.setImageResource(R.drawable.task_progress_1);
        }
        else if(taskGraph.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.task_progress_1).getConstantState()){
            taskGraph.setImageResource(R.drawable.task_progress_2);
        }
    }
}
