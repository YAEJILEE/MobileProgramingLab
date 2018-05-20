package com.example.user.lab52;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText EditInput;
    TextView Textview1,Textview2; // equation part and result part.
    Button sendBtn;

    String input;
    String equation=""; // contains equation.
    int num; //input number.
    int total=1; // sum of factorial
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditInput=(EditText) findViewById(R.id.inputEdit);
        Textview1 = (TextView) findViewById(R.id.Textview1);
        Textview2 = (TextView) findViewById(R.id.Textview2);
        sendBtn = (Button) findViewById(R.id.btn_send);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input= EditInput.getText().toString();
                num=Integer.parseInt(input);  //Store input number.
                new CalculFacto().execute();   //start the calculate factorial task.
            }
        });
    }
    private class CalculFacto extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            Textview1.setText(""); //Clear equation(n, n-1 ,n-2,,,,) part.
            total=1; //Clear total.
        }
        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = num; i > 0; i--) {
                try {
                    Thread.sleep(500);
                    total*=i; //calculate factorial
                    publishProgress(i); // activate OnProgressUpdate()
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            equation=" "+Integer.toString(values[0].intValue());
            String temp= Textview1.getText().toString() + equation; //add equation to current number.
            Textview1.setText(temp);
        }
        @Override
        protected void onPostExecute(Void avoid) {
            Textview2.setText(Integer.toString(total)); //show result
        }
    }
}
