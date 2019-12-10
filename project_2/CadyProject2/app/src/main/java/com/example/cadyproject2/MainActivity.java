package com.example.cadyproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //random nums
    float sauceGuessVal = (float)Math.random()+(float).1; //float .01 - 1.0
    boolean mozzGuessVal = (Math.random() < 0.5); // random true/false
    boolean parmGuessVal = (Math.random() < 0.5);
    boolean chedGuessVal = (Math.random() < 0.5);
    //end random nums

    //progress checkers  //win if all true
    boolean sauceModule = false;
    boolean cheeseModulePart1 = false;
    boolean cheeseModulePart2 = false;
    boolean cheeseModulePart3 = false;
    boolean cheeseModuleWon = false;
    // end progress checkers



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //begin sauce module
        SeekBar sauceSeekBar = (SeekBar)findViewById(R.id.seekBar);
        final ImageView confirmSauceFace = findViewById(R.id.SauceFaceWin);
        final View sauceImg = findViewById(R.id.sauce);
        sauceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar sauceSeekBar, int progress, boolean fromUser) {
                float div = (float)100.0; //cast double to float
                float progressValueSauce = progress/div;
                Log.i("progress", Float.toString(progressValueSauce));
                Log.i("rng val", Float.toString(sauceGuessVal));
                //takes 0.0 to 1.0
                sauceImg.setAlpha(progressValueSauce);
                if(progressValueSauce > sauceGuessVal-.05 && progressValueSauce < sauceGuessVal+.05){ //within 10%
                    sauceModule = true;
                    confirmSauceFace.setVisibility(View.VISIBLE);//happy face
                    //call check for winGame ftn
                }else{//outside desired range
                    sauceModule = false;
                    confirmSauceFace.setVisibility(View.INVISIBLE);//hide happy face

                }
                Log.i("Module",Boolean.toString(sauceModule));
            }
            public void onStartTrackingTouch(SeekBar seekBar){
              //required abstract method
            };
            public void onStopTrackingTouch(SeekBar seekBar){
                //required abstract method

            };
        });
        //end sauce module
        //begin cheese module

        CheckBox mozzCheckBox;
        CheckBox parmCheckBox;
        CheckBox chedCheckBox;
        mozzCheckBox = findViewById(R.id.checkBox1);
        parmCheckBox = findViewById(R.id.checkBox2);
        chedCheckBox = findViewById(R.id.checkBox3);
        final ImageView mozzarella = findViewById(R.id.mozz);
        final ImageView parmesan = findViewById(R.id.parm);
        final ImageView cheddar = findViewById(R.id.ched);

        mozzCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                 if(isChecked){
                     mozzarella.setVisibility(View.VISIBLE);//show cheese
                 }else{
                     mozzarella.setVisibility(View.INVISIBLE);//hide cheese
                 }
                 if(isChecked == mozzGuessVal){ // if checked bool matches desired checked bool
                     cheeseModulePart1 = true;
                    // Log.i("test","matched 1");
                 }else{
                     cheeseModulePart1 = false;// does not match
                     //Log.i("test"," NOT matched 1");
                 }
                 checkCheeseTruth();//call ftn to check if all are true
             }
        });
        parmCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    parmesan.setVisibility(View.VISIBLE);//show cheese
                }else{
                    parmesan.setVisibility(View.INVISIBLE);//hide cheese
                }
                if(isChecked == parmGuessVal){// if checked bool matches desired checked bool
                    cheeseModulePart2 = true;
                   // Log.i("test","matched 2");
                }else{
                    cheeseModulePart2 = false;// does not match
                    //Log.i("test"," NOT matched 2");
                }
                checkCheeseTruth();//call ftn to check if all are true
            }
        });
        chedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    cheddar.setVisibility(View.VISIBLE);//show cheese
                }else{
                    cheddar.setVisibility(View.INVISIBLE);//hide cheese
                }
                if(isChecked == chedGuessVal){// if checked bool matches desired checked bool
                    cheeseModulePart3 =true;
                    //Log.i("test","matched 3");
                }else{
                    cheeseModulePart3 = false;// does not match
                    //Log.i("test"," NOT matched 3");
                }
                checkCheeseTruth();//call ftn to check if all are true
            }
        });
        //end cheese module

    }//end onCreate

    public void checkCheeseTruth(){
        ImageView confirmCheeseFace = findViewById(R.id.CheeseFaceWin);
        if(cheeseModulePart1 && cheeseModulePart2 && cheeseModulePart3){
            cheeseModuleWon = true;
            confirmCheeseFace.setVisibility(View.VISIBLE);//happy face

        }else{
            cheeseModuleWon = false;
            confirmCheeseFace.setVisibility(View.INVISIBLE);//hide happy face
        }
        Log.i("test", Boolean.toString(cheeseModuleWon));
        //call check for winGame ftn
    }
}
