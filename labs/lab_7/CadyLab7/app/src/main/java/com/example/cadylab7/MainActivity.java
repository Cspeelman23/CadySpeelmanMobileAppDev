package com.example.cadylab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Spinner sizeClass;
    private ToggleButton toggle;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        sizeClass = findViewById(R.id.spinner);
        toggle = findViewById(R.id.toggleButton);
        result = findViewById(R.id.resultBox);
    }


    public void findCompanion(View view){
        //toggle noise
        boolean noiseLevel = toggle.isChecked();
        //spinner size
        String sizeLevel = String.valueOf(sizeClass.getSelectedItem());
        //string buddy type
        String buddy;
        //string user name
        EditText ownerName = findViewById(R.id.ownerName);
        String owner = ownerName.getText().toString();


        if(noiseLevel){//yes, is noisy
            switch (sizeLevel){
                case "Small":
                    buddy = "Parakeet";
                    break;
                case "Medium":
                    buddy = "Duck";
                    break;
                case "Large":
                    buddy = "Seal";
                    break;
                default:
                    buddy = "Ghost"; //shouldn't be possible, widgets come in initialized
            }
        }else{//no, is quiet
            switch (sizeLevel) {
                case "Small":
                    buddy = "Succulent";
                    break;
                case "Medium":
                    buddy = "Snowman";
                    break;
                case "Large":
                    buddy = "Giraffe";
                    break;
                default:
                    buddy = "Ghost"; //shouldn't be possible, widgets come in initialized
            }
        }
    //text view and image

        ImageView buddyFace = findViewById(R.id.buddy);
        buddyFace.setVisibility(View.VISIBLE);
        result.setText(owner + ", your perfect companion is a " + buddy);

    }


}
