package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

    public void goToTemplates(View v){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
        overridePendingTransition (R.anim.left_slide_in, R.anim.left_slide_out);//Enter new, Exit old
    }

    public void imageSwap(View v){
        ImageView importanceOpt = (ImageView)findViewById(R.id.imageView5);
        if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barmoderate).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barhigh);
        }
        else if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barhigh).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barlow);
        }
        else if(importanceOpt.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.barlow).getConstantState()){
            importanceOpt.setImageResource(R.drawable.barmoderate);
        }

    }
}
