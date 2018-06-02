package com.example.user.lab62;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText s_number;
    EditText s_name;
    Button arise;
    Button save;
    Button initial;
    String userName;
    String userNumber;

    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_number=(EditText)findViewById(R.id.s_number);
        s_name=(EditText)findViewById(R.id.s_name);
        arise=(Button)findViewById(R.id.btn_arise);
        save=(Button)findViewById(R.id.btn_save);
        initial=(Button)findViewById(R.id.btn_initial);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=s_name.getText().toString();
                userNumber=s_number.getText().toString();
                sharedPrefernces(); //call sharedPrefernces
            }
        });
        arise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });
        initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String init="";
                s_name.setText(init);
                s_number.setText(init);
            }
        });
    }
    //Save name and class in key value form to shardPreference using editor object
    public void sharedPrefernces(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();// Gets Editor Objects
        toEdit.putString("Username", userName);
        toEdit.putString("UserNumber", userNumber);
        toEdit.commit();

    }
    //Get name and class straight from sharedprefernce
    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Username")) {
            String name = sh_Pref.getString("Username", "noname");
            s_name.setText(name);
        }
        if (sh_Pref!=null && sh_Pref.contains("Username")) {
            String number = sh_Pref.getString("UserNumber", "nonNumber");
            s_number.setText(number);
        }
    }
}
