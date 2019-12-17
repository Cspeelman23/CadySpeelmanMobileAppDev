package com.example.cadyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Spinner locationSpinner;
    private ToggleButton toggleMeat;
    private TextView result;
    private String Btype = "meat";
    private String tacoOrBurrito = "notSelected";
    private String foodPlaceURL = "https://en.wikipedia.org/wiki/Burrito";
    private Switch glutenSwitch;
    public ImageView burritoPic;
    public ImageView tacoPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get views
        toggleMeat = findViewById(R.id.toggleMeat);
        locationSpinner = findViewById(R.id.locSpinner);
        result = findViewById(R.id.resultBox);
        burritoPic = findViewById(R.id.burritoPic); //Android Studio told me it needs to be final
        tacoPic = findViewById(R.id.tacoPic); //Android Studio told me it needs to be final
        glutenSwitch = findViewById(R.id.glutenSwitch);

        //FAB to external page
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadWebSite(view);    }
        });

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

        //location spinner
        String place = String.valueOf(locationSpinner.getSelectedItem());
        String bestPlace;
            switch (place){
                case "The Hill":
                    bestPlace = "Illegal Petes";
                    foodPlaceURL = "https://www.illegalpetes.com";
                    break;
                case "29th Street":
                    bestPlace = "Chipotle";
                    foodPlaceURL = "https://www.chipotle.com";
                    break;
                case "Pearl Street":
                    bestPlace = "Bartaco";
                    foodPlaceURL = "https://bartaco.com";
                    break;
                default:
                    bestPlace = "GhostTown"; //shouldn't be possible, widgets come in initialized
            }

        //switch for gluten
        //https://abhiandroid.com/ui/switch

        String gluten;
        Boolean switchState = glutenSwitch.isChecked();
            if(switchState){ //if toggled on
                gluten = "gluten-free ";
            }else{
                gluten = ""; //regular
            }


//        //string user name
        EditText userName = findViewById(R.id.userName);
        String builder = userName.getText().toString();



        //set text results if radio buttons are selected
        if(burritoOrTacoIsSelected) {
            result.setText("Hi " +builder + "! If you would like an awesome " + gluten + Btype + " " + tacoOrBurrito + " on " + place +", you should check out " + bestPlace + ".");
        }else{
            //toast if radio buttons not selected
            Context context = getApplicationContext();
            CharSequence text = "Please select either Burrito or Taco";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Log.i("test","in toast area");
            tacoPic.setVisibility(View.INVISIBLE);//hide taco img
            burritoPic.setVisibility(View.INVISIBLE);//hide burrito img
        }
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(foodPlaceURL));
        startActivity(intent);
    }
}
