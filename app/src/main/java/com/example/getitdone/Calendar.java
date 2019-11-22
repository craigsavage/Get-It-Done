package com.example.getitdone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Calendar extends AppCompatActivity {
    public float touchStart;
    public float touchEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
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
                if(touchStart-touchEnd > 200){
                    swipeUp();
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

    public void swipeUp(View v){
        Intent intent = new Intent(this, TaskList.class);
        startActivity(intent);
        overridePendingTransition (R.anim.up_slide_in, R.anim.up_slide_out);//Enter new, Exit old
    }
    public void swipeUp(){
        Intent intent = new Intent(this, TaskList.class);
        startActivity(intent);
        overridePendingTransition (R.anim.up_slide_in, R.anim.up_slide_out);//Enter new, Exit old
    }
}
