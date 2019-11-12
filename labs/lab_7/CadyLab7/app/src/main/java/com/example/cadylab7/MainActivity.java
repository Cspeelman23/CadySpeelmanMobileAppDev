package com.example.cadylab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Spinner sizeClass;
    private ToggleButton toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                case "sm":
                    buddy = "Parakeet";
                    break;
                case "md":
                    buddy = "Duck";
                    break;
                case "lg":
                    buddy = "Seal";
                    break;
                default:
                    buddy = "Ghost"; //shouldn't be possible, widgets come in initialized
            }
        }else{//no, is quiet
            switch (sizeLevel) {
                case "sm":
                    buddy = "Succulent";
                    break;
                case "md":
                    buddy = "Snowman";
                    break;
                case "lg":
                    buddy = "Giraffe";
                    break;
                default:
                    buddy = "Ghost"; //shouldn't be possible, widgets come in initialized
            }
        }
    //text view
        TextView result = findViewById(R.id.resultBox);
        result.setText(owner + ", your perfect companion is a " + buddy);

    }


}
