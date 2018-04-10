package com.example.xnote.lab22;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // Connect View Variables and Views by findViewBId
        textView=(TextView)findViewById(R.id.received);
        goBtn=(Button)findViewById(R.id.Go);
        backBtn=(Button)findViewById(R.id.Back);

        // Get received intent from previous activity.
        final Intent passedIntent=getIntent();
        // Get received URL data from intent.
        final String passedUrl=passedIntent.getStringExtra("inputUrl");
        textView.setText(passedUrl);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If URL value not contains 'http://', append 'http://' to URL value.
                if(!passedUrl.isEmpty()){
                    // Start activity with URL(Web View).
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요",Toast.LENGTH_LONG).show();
                }
            }

        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"뒤로가기버튼을 눌렀습니다",Toast.LENGTH_LONG).show();
                finish();
            }

        });

    }
}
