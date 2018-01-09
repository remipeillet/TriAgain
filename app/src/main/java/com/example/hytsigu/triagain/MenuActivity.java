package com.example.hytsigu.triagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class MenuActivity extends AppCompatActivity {

    ImageButton startButton;
    DechetDAO datasource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.startButton  = (ImageButton) findViewById(R.id.startButton);
        this.startButton.setOnClickListener(startListener);
        datasource = new DechetDAO(this);
        datasource.open();
        System.out.println(">>>>>>>>>>>>>>>Activity : "+datasource.getDechet(0).getNomFr());

    }

    private OnClickListener startListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(getApplicationContext(), SerieDechetActivity.class);
            startActivityForResult(myIntent, 1);
        }
    };

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
