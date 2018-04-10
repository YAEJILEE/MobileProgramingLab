package com.example.xnote.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // Get received intent from previous activity.
        Intent passedIntent = getIntent();

        if (passedIntent != null) {
            // Get received data from intent.
            String loginName = passedIntent.getStringExtra("UserName");
            String loginAge = passedIntent.getStringExtra("UserAge");

            Toast.makeText(getApplicationContext(),"Student info: "+loginName+","+loginAge,Toast.LENGTH_LONG).show();
        }

        // Connect View Variables and Views and Set onClickListener.
        button2=(Button)findViewById(R.id.btnclose);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}









