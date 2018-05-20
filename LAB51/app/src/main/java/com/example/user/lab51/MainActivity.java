package com.example.user.lab51;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.btn_change);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread thread1=new DogThread(0); //create thread1
                thread1.start();
                DogThread thread2 = new DogThread(1); //create thread2
                thread2.start();
            }
        });
    }
    //new thread
    class DogThread extends Thread {
        int dogIndex;
        int stateIndex;
        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index) {
            // insert 3 images to array list.
            dogIndex = index;
            images.add(R.drawable.image1);
            images.add(R.drawable.image2);
            images.add(R.drawable.image3);
        }

        public int getRandomTime(int min, int max) {
            return min + (int) (Math.random() * (max - min));
        }
        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;

                //Execute run() in new Runnable() to control UI
                handler.post(new Runnable() {
                    public void run() {
                        editText.append(msg + "\n");
                        if (dogIndex == 0) {
                            imageView1.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });
                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime); // Thread sleeps randomly.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //add stateIndex
                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }
            }
        }
    }
}
