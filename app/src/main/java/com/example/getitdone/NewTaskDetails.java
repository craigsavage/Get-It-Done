package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NewTaskDetails extends AppCompatActivity {

    ImageView importanceOpt;
    ImageView taskGraph;
    EditText newName;
    EditText newDate;
    EditText subTask1Name;
    int importanceVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_details);

        importanceOpt = (ImageView)findViewById(R.id.imageView5);
        taskGraph = (ImageView)findViewById(R.id.taskGraph);
        newName = (EditText)findViewById(R.id.newName);
        newDate = (EditText)findViewById(R.id.newDate);
        subTask1Name = (EditText) findViewById(R.id.subTask1Name);
        subTask1Name.setVisibility(View.GONE);
        importanceVal= 2;

    }

    public void goToTaskList(View v){
        Intent intent = new Intent(this, TaskList.class);
        startActivity(intent);
        overridePendingTransition (R.anim.left_slide_in, R.anim.left_slide_out);//Enter new, Exit old
    }

    public void goToTemplates(View v){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
        overridePendingTransition (R.anim.left_slide_in, R.anim.left_slide_out);//Enter new, Exit old
    }

    public void imageImportanceSwap(View v){

        if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barmoderate).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barhigh);
            importanceVal = 3;
        }
        else if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barhigh).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barlow);
            importanceVal = 1;
        }
        else if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barlow).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barmoderate);
            importanceVal = 2;
        }

    }

    public void imageGraphSwap(View v){
        if(taskGraph.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.taskgraph0).getConstantState()){
            taskGraph.setImageResource(R.drawable.taskgraph1);
            subTask1Name.setVisibility(View.VISIBLE);
        }
    }
}
