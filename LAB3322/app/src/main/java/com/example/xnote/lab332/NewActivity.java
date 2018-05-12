package com.example.xnote.lab332;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();

    
        TextView txtName = (TextView)findViewById(R.id.txtName);
        TextView txtSex = (TextView)findViewById(R.id.txtSex);
        TextView txtCheck = (TextView)findViewById(R.id.txtCheck);

       
        txtName.setText(intent.getStringExtra("name"));
        txtSex.setText(intent.getStringExtra("sex"));
        txtCheck.setText(intent.getStringExtra("check"));

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnBack:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}
