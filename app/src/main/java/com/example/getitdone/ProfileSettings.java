package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);
    }

    public void saveProfileInfo(View v) {
        Intent intent = new Intent(ProfileSettings.this, ProfilePage.class);
        startActivity(intent);
        finish();
    }
}
