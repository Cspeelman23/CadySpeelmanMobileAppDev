package com.example.cadyproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar sauceSeekBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sauceSeekBar = (SeekBar)findViewById(R.id.seekBar);
        sauceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValueSauce = 0;
            public void onProgressChanged(SeekBar sauceSeekBar, int progress, boolean fromUser) {

                progressValueSauce = progress;
                Log.i("progress", Integer.toString(progressValueSauce));
            }
            public void onStartTrackingTouch(SeekBar seekBar){
              //required abstract method
            };
            public void onStopTrackingTouch(SeekBar seekBar){
                //required abstract method

            };
        });
    }
}
