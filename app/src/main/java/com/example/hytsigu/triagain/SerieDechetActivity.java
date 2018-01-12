package com.example.hytsigu.triagain;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SerieDechetActivity extends AbstractActivity {

    ImageButton poubelleJaune;
    ImageButton poubelleMenager;

    ImageView dechet;

    TextView consigne;
    TextView nomFrancaisDechet;
    TextView nomAnglaisDechet;

    DechetDAO datasource;

    final String NBQUESTIONLIB = "nbQuestions";
    int nbQuestions;
    final String QUESTIONCOURANTELIB = "questionsCourante";
    int questionCourante;

    final String SERIEDECHETSLIB = "serieDechets";
    ArrayList<Dechet> serieDechet;
    final String RESULTATQUESTIONSLIB = "resultatsQuestions";
    boolean[] resultatsQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_dechet);

        if(savedInstanceState == null){
            //Obtention de la liste de dechets
            this.datasource = new DechetDAO(this);
            this.datasource.open();
            //On recupère une liste de 3 dechets
            this.serieDechet = new ArrayList<>(this.datasource.getListDechets(5));
            this.datasource.close();

            //Initialisation du déroulement de la serie
            this.nbQuestions = this.serieDechet.size();
            this.questionCourante = 0;
            this.resultatsQuestions = new boolean[this.serieDechet.size()];
        }else{
            this.nbQuestions = savedInstanceState.getInt(this.NBQUESTIONLIB);
            this.questionCourante = savedInstanceState.getInt(this.QUESTIONCOURANTELIB);
            this.serieDechet = savedInstanceState.getParcelableArrayList(this.SERIEDECHETSLIB);
            this.resultatsQuestions = savedInstanceState.getBooleanArray(this.RESULTATQUESTIONSLIB);
        }


        //Récupération des éléments de la vue
        this.poubelleJaune = (ImageButton) findViewById(R.id.poubelleJauneButton);
        this.poubelleMenager = (ImageButton) findViewById(R.id.poubelleMenagerButton);
        this.consigne = (TextView) findViewById(R.id.consigneView);
        this.dechet = (ImageView) findViewById(R.id.dechetView);
        this.nomFrancaisDechet = (TextView) findViewById(R.id.nomFrancaisView);
        this.nomAnglaisDechet = (TextView) findViewById(R.id.nomAnglaisView);

        //Mise en place des listener
        this.poubelleJaune.setOnClickListener(poubelleJauneListener);
        this.poubelleMenager.setOnClickListener(poubelleMenagerListener);

        //On récupère l'ID de l'image depuis sont nom
        int resID = this.getResources().getIdentifier(this.serieDechet.get(this.questionCourante).getNomImage(),"drawable",getPackageName());
        this.dechet.setImageResource(resID);

        //On set les nom Français et anglais.
        this.nomFrancaisDechet.setText(this.serieDechet.get(this.questionCourante).getNomFr());
        this.nomAnglaisDechet.setText(this.serieDechet.get(this.questionCourante).getNomEn());



    }

    private View.OnClickListener poubelleJauneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(serieDechet.get(questionCourante).getType().equals("recyclable")){
                resultatsQuestions[questionCourante]=true;
            }else{
                resultatsQuestions[questionCourante]=false;
            }

            if(questionCourante < nbQuestions-1){
                questionCourante++;
                int resID = getResources().getIdentifier(serieDechet.get(questionCourante).getNomImage(),"drawable",getPackageName());
                dechet.setImageResource(resID);

                //On set les nom Français et anglais.
                nomFrancaisDechet.setText(serieDechet.get(questionCourante).getNomFr());
                nomAnglaisDechet.setText(serieDechet.get(questionCourante).getNomEn());
            }else{
                finSerie();
            }


        }
    };

    private View.OnClickListener poubelleMenagerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(serieDechet.get(questionCourante).getType().equals("menager")){
                resultatsQuestions[questionCourante]=true;
            }else{
                resultatsQuestions[questionCourante]=false;
            }

            if(questionCourante < nbQuestions-1){
                questionCourante++;
                int resID = getResources().getIdentifier(serieDechet.get(questionCourante).getNomImage(),"drawable",getPackageName());
                dechet.setImageResource(resID);

                //On set les nom Français et anglais.
                nomFrancaisDechet.setText(serieDechet.get(questionCourante).getNomFr());
                nomAnglaisDechet.setText(serieDechet.get(questionCourante).getNomEn());
            }else{
                finSerie();
            }
        }
    };

    public void finSerie(){
        Intent myIntent=new Intent(getApplicationContext(),ResultatActivity.class);
        myIntent.putExtra("resultats",resultatsQuestions);
        myIntent.putParcelableArrayListExtra("dechets", (ArrayList<Dechet>) serieDechet);
        startActivityForResult(myIntent,1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }

    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(this.NBQUESTIONLIB,this.nbQuestions);
        outState.putInt(this.QUESTIONCOURANTELIB,this.questionCourante);
        outState.putParcelableArrayList(this.SERIEDECHETSLIB,this.serieDechet);
        outState.putBooleanArray(this.RESULTATQUESTIONSLIB,this.resultatsQuestions);

        super.onSaveInstanceState(outState);
    }


}
