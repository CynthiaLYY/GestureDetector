package com.example.liuyueyue.gesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.view.GestureDetector.*;
import static com.example.liuyueyue.gesturedetector.R.id.img;

public class MainActivity extends AppCompatActivity {

   ImageView img;
    GestureDetector myGestureDetector;
    class myGestureListener extends SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           if(e1.getX()-e2.getX()>50){
               Toast.makeText(MainActivity.this,"从右往左滑动！",Toast.LENGTH_SHORT).show();
           } else if(e2.getX()-e1.getX()>50){
               Toast.makeText(MainActivity.this,"从左往右滑动！",Toast.LENGTH_SHORT).show();

           }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        myGestureDetector = new GestureDetector(new myGestureListener());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            //可以捕获到触摸屏幕发生的Event事件
            public boolean onTouch(View view, MotionEvent motionEvent) {
                myGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });


    }

}
