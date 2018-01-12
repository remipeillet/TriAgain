package com.example.hytsigu.triagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixActivity extends AppCompatActivity {

    Button Questions5;
    Button Questions10;
    Button Questions15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        this.Questions5  = (Button) findViewById(R.id.button5Questions);
        this.Questions5.setOnClickListener(startListener);
        this.Questions10  = (Button) findViewById(R.id.button10Questions);
        this.Questions10.setOnClickListener(startListener);
        this.Questions15  = (Button) findViewById(R.id.button15Questions);
        this.Questions15.setOnClickListener(startListener);
    }

    private View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(getApplicationContext(), SerieDechetActivity.class);



            switch(v.getId()){
                case(R.id.button5Questions):
                    myIntent.putExtra("nbQuestions",5
                    );
                    break;

                case(R.id.button10Questions):
                    myIntent.putExtra("nbQuestions",10
                    );
                    break;

                case(R.id.button15Questions):
                    myIntent.putExtra("nbQuestions",15
                    );
                    break;

            }
            startActivityForResult(myIntent, 1);
        }
    };

}
