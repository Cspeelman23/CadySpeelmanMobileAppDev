package com.example.cady_lab8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TransportationActivity extends AppCompatActivity {
    private String travelType;
    private String typeURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadWebSite(view);    }
        });

        Intent intent = getIntent();
        travelType = intent.getStringExtra("travelType");
        typeURL = intent.getStringExtra("typeURL");
        Log.i("type received", travelType);
        Log.i("URL received", typeURL);

        //update text view
        TextView messageView = findViewById(R.id.resultView);
        messageView.setText("You might want to travel by " + travelType + " proof of string:" + typeURL);
    }
    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(typeURL));
        startActivity(intent);
    }

}
