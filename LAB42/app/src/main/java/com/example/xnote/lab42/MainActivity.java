package com.example.xnote.lab42;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout1,layout2;
    Button btn_open,btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout) findViewById(R.id.first);
        layout2 = (LinearLayout) findViewById(R.id.second);
        btn_open=(Button)findViewById(R.id.btn_open);
        btn_close=(Button)findViewById(R.id.btn_close);

        // when btn_open clicked,a Layout2 appears with animation on the leftside sliding .
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_left);
                layout2.startAnimation(animation);
                layout2.setVisibility(View.VISIBLE);
            }
        });
        // when btn_close clicked,a Layout1 appears with animation on the rightside sliding .
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_right);
                layout2.startAnimation(animation);
                layout2.setVisibility(View.GONE);
            }
        });
    }
}
