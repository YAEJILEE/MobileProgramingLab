package com.example.xnote.lab22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect View Variables and Views and Set onClickListener.
        Url=(EditText)findViewById(R.id.editText);
        nextBtn=(Button)findViewById(R.id.next);

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String myUrl=Url.getText().toString();
                // Start new activity. (intent contains URL value)
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("inputUrl",myUrl);
                startActivity(intent);
            }
        });
    }
}
