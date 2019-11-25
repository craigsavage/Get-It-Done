package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TaskList extends AppCompatActivity {
    public float touchStart;
    public float touchEnd;
    TaskAdapter adapterT;
    ArrayList<TaskObject> tasks;
    ListView taskList;
    String sortBy;

    TaskObject task1 = new TaskObject("Midterm", "Mobile App Dev", "11:00am", "November 27th", 3, 0);
    TaskObject task2 = new TaskObject("Party", "Social", "9:00pm", "November 26th", 1, 1);
    TaskObject task3 = new TaskObject("Assignment 2", "Embedded Systems", "11:59pm", "November 24th", 2, 2);
    TaskObject task4 = new TaskObject("Project part 3a", "User Interfaces", "11:59pm", "November 25th", 3, 3);
    TaskObject task5 = new TaskObject("App Presentation", "Mobile App Dev", "2:00pm", "November 28th", 2, 4);
    TaskObject task6 = new TaskObject("Midterm", "Distributed Systems", "1:00pm", "November 27th", 3, 5);
    TaskObject task7 = new TaskObject("Visit Parents", "Social", "4:00pm", "November 26th", 1, 6);
    TaskObject task8 = new TaskObject("Study Session", "Social", "9:00am", "November 26th", 1, 7);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        taskList = (ListView) findViewById(R.id.listView);

        //Initialize spinner and spinner adapter for the list view
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sortBy, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Add a listener so that every time a topping is selected it is set as the "current topping"
        //This will be used later in "submit" function to add to the total price
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String mSelected = (String) parent.getItemAtPosition(pos);
                sortBy = mSelected;
                chooseSort(sortBy, taskList);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                sortBy = "Date";
            }
        });
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
                    goToCal();
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

    public void goToCal(){
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        overridePendingTransition (R.anim.down_slide_in, R.anim.down_slide_out);//Enter new, Exit old
    }
    public void goToTemplates(View v){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
        overridePendingTransition (R.anim.right_slide_in, R.anim.right_slide_out);//Enter new, Exit old
    }

    public void chooseSort(String sorter, ListView list){
        switch(sorter){
            case "Name":
                sortByName(list);
                break;
            case "Category":
                sortByCategory(list);
                break;
            case "Date":
                sortByDate(list);
                break;
            default:
                break;
        }
    }
    public void sortByName(ListView list){
        tasks = new ArrayList<>();

        tasks.add(task5);
        tasks.add(task3);
        tasks.add(task6);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task4);
        tasks.add(task8);
        tasks.add(task7);

        adapterT = new TaskAdapter(this, tasks);
        setThisAdapter(list, adapterT);
    }

    public void sortByDate(ListView list){
        tasks = new ArrayList<>();

        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task1);
        tasks.add(task6);
        tasks.add(task2);
        tasks.add(task8);
        tasks.add(task7);
        tasks.add(task5);

        adapterT = new TaskAdapter(this, tasks);
        setThisAdapter(list, adapterT);
    }

    public void sortByCategory(ListView list){
        tasks = new ArrayList<>();

        tasks.add(task3);
        tasks.add(task1);
        tasks.add(task5);
        tasks.add(task2);
        tasks.add(task7);
        tasks.add(task8);
        tasks.add(task4);

        adapterT = new TaskAdapter(this, tasks);
        setThisAdapter(list, adapterT);
    }

    public void setThisAdapter(ListView list, TaskAdapter adapter){
        list.setAdapter(adapterT);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TaskObject curTask = (TaskObject) parent.getItemAtPosition(position);
                String name = (String) curTask.getName();
                Intent intent = new Intent(getApplicationContext(), TaskDetails.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }

}
