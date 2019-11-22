package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity {
    public float touchStart;
    public float touchEnd;
    TaskAdapter adapter;
    ArrayList<TaskObject> tasks;
    ListView taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);


        tasks = new ArrayList<>();
        TaskObject midterm = new TaskObject("Midterm", "Mobile App Dev", "11:00am", "November 29th", 0);
        TaskObject party = new TaskObject("Party", "Social", "9:00pm", "November 30th", 1);
        tasks.add(midterm);
        tasks.add(party);

//        ArrayList<String> titles = new ArrayList<>();
        taskList = (ListView) findViewById(R.id.listView);
//        titles.add("Midterm");
//        titles.add("Assignment");
//        titles.add("Party");

        adapter = new TaskAdapter(this, tasks);
        taskList.setAdapter(adapter);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                touchStart = 0;
                touchEnd = 0;
                Log.d("Ryuji","Action was DOWN");
                touchStart = event.getY();
//                String str = Float.toString(touchStart);
//                Log.d("Ryuji",str);
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.d("Ryuji","Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Log.d("Ryuji","Action was UP");
                touchEnd = event.getY();
                if(touchStart-touchEnd < -200){
                    swipeDown();
                }
//                String str2 = Float.toString(touchStart);
//                Log.d("Ryuji",str2);
//                String str3 = Float.toString(touchStart-touchEnd);
//                Log.d("Ryuji",str3);
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.d("Ryuji","Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d("Ryuji","Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }

    public void goToCal(View v){
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_out);//Enter new, Exit old
    }
    public void swipeDown(){
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_out);//Enter new, Exit old
    }
}
