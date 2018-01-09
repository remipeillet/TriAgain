package com.example.hytsigu.triagain;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultatActivity extends AbstractActivity {

    TextView scoreView;
    ListView resultatList;

    boolean[] resultatsQuestions;

    ArrayList<Dechet> serieDechets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Bundle bundle = getIntent().getExtras();
        this.resultatsQuestions = bundle.getBooleanArray("resultats");
        this.serieDechets = bundle.getParcelableArrayList("dechets");
        this.resultatList = (ListView) findViewById(R.id.resultatList);
        ResultatAdapter resultatAdapter = new ResultatAdapter(this,serieDechets,resultatsQuestions);
        this.resultatList.setAdapter(resultatAdapter);

        this.scoreView = (TextView) findViewById(R.id.scoreView);
        this.scoreView.setText(calculScore()+"/"+resultatsQuestions.length);


    }

    protected int calculScore(){
        int score=0;
        for(int i=0;i<this.resultatsQuestions.length;i++){
            if(this.resultatsQuestions[i]){
                score++;
            }
        }
        return score;
    }

}
