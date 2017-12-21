package com.example.hytsigu.triagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SerieDechetActivity extends AppCompatActivity {

    ImageButton poubelleJaune;
    ImageButton poubelleMenager;

    ImageView dechet;

    TextView nomFrancaisDechet;
    TextView nomAnglaisDechet;

    int nbQuestionsRestantes;

    ArrayList<Dechet> serieDechet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.serieDechet = new ArrayList<>();
        setContentView(R.layout.activity_serie_dechet);
        this.poubelleJaune = (ImageButton) findViewById(R.id.poubelleJauneButton);
        this.poubelleJaune.setOnClickListener(poubelleJauneListener);
        this.poubelleMenager = (ImageButton) findViewById(R.id.poubelleMenagerButton);
        this.poubelleMenager.setOnClickListener(poubelleMenagerListener);
        this.dechet = (ImageView) findViewById(R.id.dechetView);
        this.nomFrancaisDechet = (TextView) findViewById(R.id.nomFrancaisView);
        this.nomAnglaisDechet = (TextView) findViewById(R.id.nomAnglaisView);
    }

    private View.OnClickListener poubelleJauneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Poubelle jaune",Toast.LENGTH_LONG).show();
            dechet.setImageResource(R.drawable.menager_sacplastique);
        }
    };

    private View.OnClickListener poubelleMenagerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Poubelle menager",Toast.LENGTH_LONG).show();
        }
    };

}
