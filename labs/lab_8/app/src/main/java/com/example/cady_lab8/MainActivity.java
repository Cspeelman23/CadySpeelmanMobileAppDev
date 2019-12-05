package com.example.cady_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    public Integer Ttype = 0;
    public void onRadioButtonClicked(View view){
        boolean picked = ((RadioButton)view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton:
                if (picked) {
                    Ttype = 0;
                }
                break;
            case R.id.radioButton2:
                if (picked) {
                    Ttype = 1;
                }
                break;
            case R.id.radioButton3:
                if (picked) {
                    Ttype = 2;
                }
                break;
            default:
                Ttype = 0;
        }

       // testy.setText(Ttype);
    }

    private void findTransport(View view){
        //get radio selection
        //int radioSelect = typeSelect.getCheckedRadioButtonId();
        //set result
        myTravelType.setTransportMode(Ttype);
        //get result
        String suggestedTransport = myTravelType.getTransportMode();
        //get url
        String suggestTransportURL = myTravelType.getSiteURL();
        Log.i("radioSelect", Integer.toString(Ttype));

        //Intent
        Intent intent = new Intent(this, TransportationActivity.class);
        intent.putExtra("travelType",suggestedTransport);
        intent.putExtra("typeURL",suggestTransportURL);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        typeSelect = (RadioGroup)findViewById(R.id.radioGroup);
        Ttype = 0;
        //listener
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                findTransport(view);
            }
        };
        button.setOnClickListener(onclick);
    }
}
