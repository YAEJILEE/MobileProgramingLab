package com.example.xnote.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect View Variables and Views and Set onClickListener.

        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.btnAdd);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get received data from intent.
                String name = Name.getText().toString();
                String age = Age.getText().toString();

                // Get received intent from previous activity.
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("UserName",name);
                intent.putExtra("UserAge",age);
                startActivity(intent);
            }
        });
    }
}

