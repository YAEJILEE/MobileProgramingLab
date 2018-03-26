package com.example.xnote.lab1_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        edit_name=(EditText)findViewById(R.id.edit);
        btn_print=(Button)findViewById(R.id.print);
        btn_clear=(Button)findViewById(R.id.clear);
        view_print=(TextView)findViewById(R.id.printText);
    }
    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("contents");// print string "contents" after

    }
    public void printClicked(View v){
        String text="";
        text=edit_name.getText().toString();
        view_print.setText(text);
    }
}
