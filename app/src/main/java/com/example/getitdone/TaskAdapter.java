package com.example.getitdone;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TaskAdapter extends ArrayAdapter<TaskObject> {

    Context cont;

    public TaskAdapter(@NonNull Context context, ArrayList<TaskObject> items) {
        super(context, 0, items);
        this.cont = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final TaskObject task = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_tile, parent, false);
        }
        TextView taskName = convertView.findViewById(R.id.title);
        ImageView importance = convertView.findViewById(R.id.imageView6);
        taskName.setText(task.getName());//////////////
        TextView category = convertView.findViewById(R.id.category);
        String peopleAttending = "";

        category.setText(task.getCategory());//////////
        TextView datetime = convertView.findViewById(R.id.datetime);
        String date = task.getDate();
        String time = task.getTime();
        datetime.setText(date + " @ " + time);
        if(task.getImportance() == 3){
            importance .setVisibility(View.VISIBLE);
        }
        else{
            importance .setVisibility(View.GONE);
        }

        return convertView;
    }
}