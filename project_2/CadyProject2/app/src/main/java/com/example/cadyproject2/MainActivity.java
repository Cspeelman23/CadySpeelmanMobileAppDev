package com.example.cadyproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar sauceSeekBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //seekBar
        SeekBar sauceSeekBar = (SeekBar)findViewById(R.id.seekBar);
        final View sauceImg = findViewById(R.id.sauce);
        sauceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar sauceSeekBar, int progress, boolean fromUser) {
                float div = (float)100.0; //cast double to float
                float progressValueSauce = progress/div;
                Log.i("progress", Float.toString(progressValueSauce));
                //takes 0.0 to 1.0
                sauceImg.setAlpha(progressValueSauce);

            }
            public void onStartTrackingTouch(SeekBar seekBar){
              //required abstract method
            };
            public void onStopTrackingTouch(SeekBar seekBar){
                //required abstract method

            };
        });
        //end seekBar
    }
}
