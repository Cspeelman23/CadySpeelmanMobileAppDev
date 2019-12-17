package com.example.cadyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Spinner sizeClass;
    private ToggleButton toggleMeat;
    private TextView result;
    private String Btype = "meat";
    private String tacoOrBurrito = "notSelected";
    public ImageView burritoPic;
    public ImageView tacoPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get views
        toggleMeat = findViewById(R.id.toggleMeat);
        //sizeClass = findViewById(R.id.spinner);
        result = findViewById(R.id.resultBox);
        burritoPic = findViewById(R.id.burritoPic); //Android Studio told me it needs to be final
        tacoPic = findViewById(R.id.tacoPic); //Android Studio told me it needs to be final
        //burrito or taco radio buttons
        RadioGroup burrOrTaco = findViewById(R.id.typeGroup);
        burrOrTaco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup Typegroup, int checkedId) {
                RadioButton checkedRadioButton = Typegroup.findViewById(checkedId);
                boolean checked = checkedRadioButton.isChecked();

                // Check which radio button was clicked
                switch (checkedRadioButton.getId()) {
                    case R.id.burrito:
                        if (checked) { //if burrito is selected
                            burritoPic.setVisibility(View.VISIBLE);//show burrito img
                            tacoPic.setVisibility(View.INVISIBLE);//hide taco img
                            tacoOrBurrito = "burrito";
                        }
                        break;
                    case R.id.taco:
                        if (checked) { //if taco is selected
                            tacoPic.setVisibility(View.VISIBLE);//show taco img
                            burritoPic.setVisibility(View.INVISIBLE);//hide burrito img
                            tacoOrBurrito = "taco";
                        }
                        break;
                    default: //none selected
                        //toast


                }

            }
        });

    }

    public boolean checkForSelected(){
        if(tacoOrBurrito.equals("notSelected")){ //if no radio button picked
            return false;
        }else {
            return true;
        }
    }

    public void buildBurrito(View view) {
        //toggle filling type

        boolean burritoOrTacoIsSelected = checkForSelected();//make sure a radio button is selected

        boolean veggie = toggleMeat.isChecked(); //checked is veggie, unchecked is meat

        if(veggie){
            Btype = "veggie";
        }else{
            Btype = "meat";
        }




        //spinner size
//        String sizeLevel = String.valueOf(sizeClass.getSelectedItem());
//        //string buddy type
//        String buddy;
//        //string user name
        EditText userName = findViewById(R.id.userName);
        String builder = userName.getText().toString();

//
//        if (noiseLevel) {//yes, is noisy
//            switch (sizeLevel) {
//                case "Small":
//                    buddy = "Parakeet";
//                    break;
//                case "Medium":
//                    buddy = "Duck";
//                    break;
//                case "Large":
//                    buddy = "Seal";
//                    break;
//                default:
//                    buddy = "Ghost"; //shouldn't be possible, widgets come in initialized
//            }
//        }

//        Context context = getApplicationContext();
//        CharSequence text = "We've picked your companion!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//        ImageView buddyFace = findViewById(R.id.buddy);
//        buddyFace.setVisibility(View.VISIBLE);
        if(burritoOrTacoIsSelected) {
            result.setText(builder + " would like a " + Btype + " " + tacoOrBurrito);
        }else{
            //toast
            Log.i("test","in toast area");
            tacoPic.setVisibility(View.INVISIBLE);//hide taco img
            burritoPic.setVisibility(View.INVISIBLE);//hide burrito img
        }
    }
}
