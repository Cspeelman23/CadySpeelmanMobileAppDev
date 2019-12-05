package com.example.cady_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RadioGroup typeSelect;
    private TravelType myTravelType = new TravelType();
    private TextView testy;

    public void onRadioButtonClicked(View view){
        boolean picked = ((RadioButton)view).isChecked();
        String Ttype = "0";
        switch(view.getId()) {
            case R.id.radioButton:
                if (picked) {
                    Ttype = "0";
                }
                break;
            case R.id.radioButton2:
                if (picked) {
                    Ttype = "1";
                }
                break;
            case R.id.radioButton3:
                if (picked) {
                    Ttype = "2";
                }
                break;
            default:
                Ttype = "0";
        }

        testy.setText(Ttype);
    }

    private void findTransport(View view){
        //get radio selection
        int radioSelect = typeSelect.getCheckedRadioButtonId();
        //set result
        myTravelType.setTransportMode(radioSelect);
        //get result
        String suggestedTransport = myTravelType.getTransportMode();
        //get url
        String suggestTransportURL = myTravelType.getSiteURL();
        Log.i("suggested type","suggestedTransport");
        Log.i("suggested URL","suggestTransportURL");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        typeSelect = (RadioGroup)findViewById(R.id.radioGroup);
        testy = findViewById(R.id.testBox);
        //listener
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                findTransport(view);
            }
        };
        button.setOnClickListener(onclick);
    }
}
