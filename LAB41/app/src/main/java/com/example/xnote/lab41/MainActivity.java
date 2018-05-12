package com.example.xnote.lab41;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Set layout that combines views , then add my Draw 'View' to relative layout rlayout.

        RelativeLayout rlayout=new RelativeLayout(this);
        MyDraw v=new MyDraw(this);
        rlayout.addView(v);
        setContentView(rlayout);

    }
    public class MyDraw extends View {
        float curX; //current x location
        float curY; //current y location

        Path path=new Path();
        Paint pnt=new Paint();

        public MyDraw(Context c)
        {
            super(c);
        }
        public MyDraw(Context c, AttributeSet a) {
            super(c, a);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.WHITE);
            pnt.setColor(Color.RED);
            pnt.setStrokeWidth(16);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path,pnt); //draw path on canvas

        }
        public boolean onTouchEvent(MotionEvent event){

            curX=event.getX();
            curY=event.getY();
            int action= event.getAction();
            // when press screen, move curX, curY .
            if(action == MotionEvent.ACTION_DOWN){
                path.moveTo(curX,curY);

            }
            // when moving touch screen, draw linesegmet based on the path.
            else if(action==MotionEvent.ACTION_MOVE){
                path.lineTo(curX,curY);
            }
            invalidate();
            return true;
        }
    }



}
