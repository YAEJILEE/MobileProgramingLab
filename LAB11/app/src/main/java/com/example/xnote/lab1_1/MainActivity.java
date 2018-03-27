package com.example.xnote.lab1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int imageIndex=0;  //to recognise images.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView); //import the object
        imageView2=(ImageView)findViewById(R.id.imageView2);
    }
    public void onButton1Clicked(View v){
        changeImage();
    }
    private void changeImage(){

        /* If First ImageView's visibility is visible,
     change First ImageView's visibility to invisible
      and Second ImageView's visibility to visible. */

        if(imageIndex==0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex=1;
        }

        /* If Second ImageView's visibility is visible,
     change First ImageView's visibility to visible
      and Second ImageView's visibility to invisible. */

        else if(imageIndex==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex=0;
        }
    }

}
