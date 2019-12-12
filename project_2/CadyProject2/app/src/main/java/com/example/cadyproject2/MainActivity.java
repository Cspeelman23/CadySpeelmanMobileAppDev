package com.example.cadyproject2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //random nums
    float sauceGuessVal = (float)Math.random()+(float).1; //float .01 - 1.0
    boolean mozzGuessVal = (Math.random() < 0.5); // random true/false
    boolean parmGuessVal = (Math.random() < 0.5);
    boolean chedGuessVal = (Math.random() < 0.5);
    int toppings1Val = (int)Math.floor(Math.random() * 3) + 1; //1-3 where 1=light,2=regular,3=extra  //pepperoni
    int toppings2Val = (int)Math.floor(Math.random() * 3) + 1; //mushroom
    int toppings3Val = (int)Math.floor(Math.random() * 3) + 1; //peppers
    boolean slicesGuessVal = (Math.random() < 0.5);
    //end random nums

    //progress checkers  //win if all true
    boolean sauceModuleWon = false;
    boolean cheeseModulePart1 = false;
    boolean cheeseModulePart2 = false;
    boolean cheeseModulePart3 = false;
    boolean cheeseModuleWon = false;
    boolean toppingsModulePart1 = false; //pepperoni
    boolean toppingsModulePart2 = false; //mushroom
    boolean toppingsModulePart3 = false; //peppers
    boolean toppingsModuleWon = false;
    boolean slicesModuleWon = false;
    // end progress checkers





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //begin sauce module
        SeekBar sauceSeekBar = findViewById(R.id.seekBar);
        final ImageView confirmSauceFace = findViewById(R.id.SauceFaceWin); //Android Studio told me it needs to be final
        final View sauceImg = findViewById(R.id.sauce); //Android Studio demands commitment
        sauceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar sauceSeekBar, int progress, boolean fromUser) {
                float div = (float)100.0; //cast double to float
                float progressValueSauce = progress/div;
                Log.i("progress", Float.toString(progressValueSauce));
                Log.i("rng val", Float.toString(sauceGuessVal));
                //takes 0.0 to 1.0
                sauceImg.setAlpha(progressValueSauce);
                if(progressValueSauce > sauceGuessVal-.05 && progressValueSauce < sauceGuessVal+.05){ //within 10%
                    sauceModuleWon = true;
                    confirmSauceFace.setVisibility(View.VISIBLE);//happy face
                    //call check for winGame ftn
                    checkWinGame();
                }else{//outside desired range
                    sauceModuleWon = false;
                    confirmSauceFace.setVisibility(View.INVISIBLE);//hide happy face

                }
                //Log.i("Module",Boolean.toString(sauceModuleWon));
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

        //begin toppings module
        //pepperoni
        final ImageView light = findViewById(R.id.pponiL);
        final ImageView regular = findViewById(R.id.pponiR);
        final ImageView extra = findViewById(R.id.pponiE);
        RadioGroup pepperoniGroup = findViewById(R.id.pepperoni);
        pepperoniGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup Pgroup, int checkedId) {
                RadioButton checkedRadioButton = Pgroup.findViewById(checkedId);
                boolean checked = checkedRadioButton.isChecked();

                // Check which radio button was clicked
                switch(checkedRadioButton.getId()) {
                    case R.id.light:
                        if (checked){
                            light.setVisibility(View.VISIBLE);//show light pepperoni
                            regular.setVisibility(View.INVISIBLE);//hide regular pepperoni
                            extra.setVisibility(View.INVISIBLE);//hide extra pepperoni
//                            Log.i("radio","light");
//                            Log.i("radio1",Integer.toString(toppings1Val));
//                            Log.i("radio2",Integer.toString(toppings2Val));
//                            Log.i("radio3",Integer.toString(toppings3Val));
                            if(toppings1Val == 1){ //1 means light is true
                                toppingsModulePart1 = true;
                            }else{
                                toppingsModulePart1 = false;
                            }

                            break;
                        }//else statement wont work here
                    case R.id.regular:
                        if (checked){
                            light.setVisibility(View.INVISIBLE);//hide light pepperoni
                            regular.setVisibility(View.VISIBLE);//show regular pepperoni
                            extra.setVisibility(View.INVISIBLE);//show extra pepperoni
                            //Log.i("radio","regular");
                            if(toppings1Val == 2){ //2 when regular is true
                                toppingsModulePart1 = true;
                            }else{
                                toppingsModulePart1 = false;
                            }
                            break;
                        }
                    case R.id.extra:
                        if (checked){
                            light.setVisibility(View.INVISIBLE);//hide light pepperoni
                            regular.setVisibility(View.INVISIBLE);//hide regular pepperoni
                            extra.setVisibility(View.VISIBLE);//show extra pepperoni
                            //Log.i("radio","extra");
                            if(toppings1Val == 3){ //3 when extra is true
                                toppingsModulePart1 = true;
                            }else{
                                toppingsModulePart1 = false;
                            }
                            break;
                        }

                }
                //Log.i("radio","outside");//call check module parts here
                Log.i("radioFinal1", Boolean.toString(toppingsModulePart1));
                checkToppingsTruth();

            }
        });
        //mushrooms
        final ImageView lightm = findViewById(R.id.mushL);
        final ImageView regularm = findViewById(R.id.mushR);
        final ImageView extram = findViewById(R.id.mushE);
        RadioGroup mushroomGroup = findViewById(R.id.mushrooms);
        mushroomGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup Mgroup, int checkedId2)
            {
                RadioButton checkedRadioButton2 = Mgroup.findViewById(checkedId2);
                boolean checked2 = checkedRadioButton2.isChecked();

                // Check which radio button was clicked
                switch(checkedRadioButton2.getId()) {
                    case R.id.mlight:
                        if (checked2){
                            lightm.setVisibility(View.VISIBLE);//show light mushrooms
                            regularm.setVisibility(View.INVISIBLE);//hide regular mushrooms
                            extram.setVisibility(View.INVISIBLE);//hide extra mushrooms
                            //Log.i("radio","light2");
                            if(toppings2Val == 1){ //1 means light is true
                                toppingsModulePart2 = true;
                            }else{
                                toppingsModulePart2 = false;
                            }
                            break;
                        }
                    case R.id.mregular:
                        if (checked2){
                            lightm.setVisibility(View.INVISIBLE);//hide light mushrooms
                            regularm.setVisibility(View.VISIBLE);//show regular mushrooms
                            extram.setVisibility(View.INVISIBLE);//hide extra mushrooms
                            //Log.i("radio","regular2");
                            if(toppings2Val == 2){ //2 means regular is true
                                toppingsModulePart2 = true;
                            }else{
                                toppingsModulePart2 = false;
                            }
                            break;
                        }
                    case R.id.mextra:
                        if (checked2){
                            lightm.setVisibility(View.INVISIBLE);//hide light mushrooms
                            regularm.setVisibility(View.INVISIBLE);//hide regular mushrooms
                            extram.setVisibility(View.VISIBLE);//show extra mushrooms
                            //Log.i("radio","extra2");
                            if(toppings2Val == 3){ //3 means extra is true
                                toppingsModulePart2 = true;
                            }else{
                                toppingsModulePart2 = false;
                            }
                            break;
                        }
                }
                Log.i("radioFinal2", Boolean.toString(toppingsModulePart2));
                checkToppingsTruth();

            }
        });
        //peppers
        final ImageView lightp = findViewById(R.id.pepL);
        final ImageView regularp = findViewById(R.id.pepR);
        final ImageView extrap = findViewById(R.id.pepE);
        RadioGroup pepperGroup = findViewById(R.id.peppers);
        pepperGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup P2group, int checkedId3)
            {
                RadioButton checkedRadioButton3 = P2group.findViewById(checkedId3);
                boolean checked3 = checkedRadioButton3.isChecked();

                // Check which radio button was clicked
                switch(checkedRadioButton3.getId()) {
                    case R.id.plight:
                        if (checked3){
                            lightp.setVisibility(View.VISIBLE);//show light peppers
                            regularp.setVisibility(View.INVISIBLE);//hide regular peppers
                            extrap.setVisibility(View.INVISIBLE);//hide extra peppers
                            //Log.i("radio","light3");
                            if(toppings3Val == 1){ //1 means light is true
                                toppingsModulePart3 = true;
                            }else{
                                toppingsModulePart3 = false;
                            }
                            break;
                        }
                    case R.id.pregular:
                        if (checked3){
                            lightp.setVisibility(View.INVISIBLE);//hide light peppers
                            regularp.setVisibility(View.VISIBLE);//show regular peppers
                            extrap.setVisibility(View.INVISIBLE);//hide extra peppers
                            //Log.i("radio","regular3");
                            if(toppings3Val == 2){ //2 means regular is true
                                toppingsModulePart3 = true;
                            }else{
                                toppingsModulePart3 = false;
                            }
                            break;
                        }
                    case R.id.pextra:
                        if (checked3){
                            lightp.setVisibility(View.INVISIBLE);//hide light peppers
                            regularp.setVisibility(View.INVISIBLE);//hide regular peppers
                            extrap.setVisibility(View.VISIBLE);//show extra peppers
                            //Log.i("radio","extra3");
                            if(toppings3Val == 3){ //3 means extra is true
                                toppingsModulePart3 = true;
                            }else{
                                toppingsModulePart3 = false;
                            }
                            break;
                        }
                }
                Log.i("radioFinal3", Boolean.toString(toppingsModulePart3));
                checkToppingsTruth();

            }
        });
        //end toppings module

        //begin slices module
        ToggleButton slicesToggle = findViewById(R.id.toggleSlices);
        final ImageView confirmSlicesFace = findViewById(R.id.SlicesFaceWin);
        final ImageView slicesLines = findViewById(R.id.slices);
        slicesToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.i("slices", Boolean.toString(slicesGuessVal));
                if (isChecked) {
                    slicesLines.setVisibility(View.VISIBLE);//show slices img
                } else {
                    slicesLines.setVisibility(View.INVISIBLE);//hide slices img
                }
                if (isChecked == slicesGuessVal){ //toggle button matches random bool
                    confirmSlicesFace.setVisibility(View.VISIBLE);//happy face
                    slicesModuleWon = true;
                    //call check for winGame ftn
                    checkWinGame();
                }else{//does not match
                    confirmSlicesFace.setVisibility(View.INVISIBLE);//hide happy face
                    slicesModuleWon = false;
                }
            }
        });
        //end slices module


    }//end onCreate

    public void checkCheeseTruth(){
        ImageView confirmCheeseFace = findViewById(R.id.CheeseFaceWin);
        if(cheeseModulePart1 && cheeseModulePart2 && cheeseModulePart3){
            cheeseModuleWon = true;
            confirmCheeseFace.setVisibility(View.VISIBLE);//happy face
            //call check for winGame ftn
            checkWinGame();
        }else{
            cheeseModuleWon = false;
            confirmCheeseFace.setVisibility(View.INVISIBLE);//hide happy face
        }
        //Log.i("test", Boolean.toString(cheeseModuleWon));

    }

    public void checkToppingsTruth(){
        ImageView confirmToppingsFace = findViewById(R.id.ToppingsFaceWin);
        if(toppingsModulePart1 && toppingsModulePart2 && toppingsModulePart3){
            toppingsModuleWon = true;
            confirmToppingsFace.setVisibility(View.VISIBLE);//happy face
            //call check for winGame ftn
            checkWinGame();

        }else{
            toppingsModuleWon = false;
            confirmToppingsFace.setVisibility(View.INVISIBLE);//hide happy face
        }
        //Log.i("radio win", Boolean.toString(toppingsModuleWon));

    }

    public void checkWinGame(){
        if (sauceModuleWon && cheeseModuleWon && toppingsModuleWon && slicesModuleWon){ // all modules correct
            //alert on win
            Log.i("win", "Game Won");
            showAlertDialog();
        }

    }
    public void showAlertDialog(){
        AlertDialog.Builder winNote = new AlertDialog.Builder(this);
        winNote.setTitle("You Won!!!");
        winNote.setMessage("Play again?");
        winNote.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //RESET
                sauceGuessVal = (float)Math.random()+(float).1; //float .01 - 1.0
                mozzGuessVal = (Math.random() < 0.5); // random true/false
                parmGuessVal = (Math.random() < 0.5);
                chedGuessVal = (Math.random() < 0.5);
                toppings1Val = (int)Math.floor(Math.random() * 3) + 1; //1-3 where 1=light,2=regular,3=extra  //pepperoni
                toppings2Val = (int)Math.floor(Math.random() * 3) + 1; //mushroom
                toppings3Val = (int)Math.floor(Math.random() * 3) + 1; //peppers
                slicesGuessVal = (Math.random() < 0.5);

                sauceModuleWon = false;
                cheeseModulePart1 = false;
                cheeseModulePart2 = false;
                cheeseModulePart3 = false;
                cheeseModuleWon = false;
                toppingsModulePart1 = false; //pepperoni
                toppingsModulePart2 = false; //mushroom
                toppingsModulePart3 = false; //peppers
                toppingsModuleWon = false;
                slicesModuleWon = false; //not working every time??

                SeekBar sauceSeekBar = findViewById(R.id.seekBar);
                sauceSeekBar.setProgress(0);
                CheckBox mozzCheckBox = findViewById(R.id.checkBox1);
                mozzCheckBox.setChecked(false);
                CheckBox parmCheckBox = findViewById(R.id.checkBox2);
                parmCheckBox.setChecked(false);
                CheckBox chedCheckBox = findViewById(R.id.checkBox3);
                chedCheckBox.setChecked(false);
                RadioButton pp1 = findViewById(R.id.light);
                if(pp1.isChecked()){
                    pp1.setChecked(false); // null if not already checked
                }
                RadioButton pp2 = findViewById(R.id.regular); //causing small re-select issue
                if(pp2.isChecked()){
                    pp2.setChecked(false);
                };
                RadioButton pp3 = findViewById(R.id.extra);
                if(pp3.isChecked()){
                    pp3.setChecked(false);
                };
                RadioButton m1 = findViewById(R.id.mlight);
                if(m1.isChecked()){
                    m1.setChecked(false);
                };
                RadioButton m2 = findViewById(R.id.mregular);
                if(m2.isChecked()){
                    m2.setChecked(false);
                };
                RadioButton m3 = findViewById(R.id.mextra);
                if(m3.isChecked()){
                    m3.setChecked(false);
                };
                RadioButton p1 = findViewById(R.id.plight);
                if(p1.isChecked()){
                    p1.setChecked(false);
                };;
                RadioButton p2 = findViewById(R.id.pregular);
                if(p2.isChecked()){
                    p2.setChecked(false);
                };
                RadioButton p3 = findViewById(R.id.pextra);
                if(p3.isChecked()){
                    p3.setChecked(false);
                };
                ToggleButton slicesToggle = findViewById(R.id.toggleSlices);
                slicesToggle.setChecked(false);

                ImageView invisi = findViewById(R.id.sauce);
                invisi.setAlpha((float).0);
                invisi = findViewById(R.id.mozz);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.parm);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.ched);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pepL);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pepR);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pepE);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pponiL);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pponiR);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.pponiE);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.mushL);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.mushR);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.mushE);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.slices);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.SauceFaceWin);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.CheeseFaceWin);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.ToppingsFaceWin);
                invisi.setVisibility(View.INVISIBLE);
                invisi = findViewById(R.id.SlicesFaceWin);
                invisi.setVisibility(View.INVISIBLE);



            }
        });
        winNote.create().show();
    }
}


//Citations
//https://abhiandroid.com/ui/seekbar
//https://stackoverflow.com/questions/8386832/android-checkbox-listener
//https://stackoverflow.com/questions/8878015/return-true-or-false-randomly/8878065
//https://stackoverflow.com/questions/32837783/convert-double-to-float-in-java
//https://stackoverflow.com/questions/6780981/android-radiogroup-how-to-configure-the-event-listener
//https://www.youtube.com/watch?v=men8GB-7yM0