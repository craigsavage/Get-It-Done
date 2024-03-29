package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileMetric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }

    public void editProfile(View v) {
        Intent intent = new Intent(ProfileMetric.this, ProfileSettings.class);
        startActivity(intent);
        finish();
    }

    public void saveProfile(View v) {
        Intent intent = new Intent(ProfileMetric.this, Calendar.class);
        startActivity(intent);
        finish();
    }
}
