package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hatchEgg(View view){
        //edit text
        EditText chickenName = findViewById(R.id.editText);
        String nameVal = chickenName.getText().toString();
        //text view
        TextView announcement = findViewById(R.id.result);
        announcement.setText("Congratulations! You've hatched " + nameVal + "!");

        ImageView chicken = findViewById(R.id.chicken);
        chicken.setImageResource(R.drawable.chicken);

        ImageView egg = findViewById(R.id.egg);
        egg.setImageResource(R.drawable.blank);
    }
}
