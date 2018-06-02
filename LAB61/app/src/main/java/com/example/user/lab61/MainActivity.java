package com.example.user.lab61;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText txtData;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private String pathname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pathname = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File directory = new File (pathname+"/");
        directory.mkdirs();

        txtData = (EditText) findViewById(R.id.txtData);
        txtData.setHint("Enter some lines of data here...");
        btn1 = (Button) findViewById(R.id.btnWrite);

        //btn1, IOStream을 이용하여 파일에 txtData에 있는 텍스트를 저장한다.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File myFile = new File(directory, "mysdfile.txt");
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(
                            new FileOutputStream(myFile));
                    myOutWriter.append(txtData.getText());
                    myOutWriter.close();
                    Toast.makeText(getApplicationContext(),
                            "Done writing SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }// onClick
        });
        //btn2, txtData에 있는 텍스트를 지운다.
        btn2 = (Button) findViewById(R.id.btnRead);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(directory,"mysdfile.txt"))));
                    String DataRow = " ";
                    String Buffer = "";
                    while ((DataRow = myReader.readLine()) != null) {
                        Buffer += DataRow + "\n";
                    }
                    txtData.setText(Buffer);
                    myReader.close();
                    Toast.makeText(getApplicationContext(), "Done reading SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //btn3, IOStream을 이용하여 파일에 저장된 텍스트를 한줄씩 읽어온다.
        btn3 = (Button) findViewById(R.id.btnClear);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
            }
        });
        //btn4, 앱을 종료시킨다.
        btn4 = (Button) findViewById(R.id.btnFinish);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}