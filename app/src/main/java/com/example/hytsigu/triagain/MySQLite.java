package com.example.hytsigu.triagain;

/**
 * Created by Utilisateur on 19/12/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tri_again.db";
    private static final int DATABASE_VERSION = 4;
    private static MySQLite sInstance;
    private Context context;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        try {
            String requete = "";
            InputStream ips = context.getResources().getAssets().open("tri_again_database.sql");
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            int i=0;
            while ((ligne=br.readLine())!=null){
                sqLiteDatabase.execSQL(ligne);
                i++;
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //sqLiteDatabase.execSQL(DechetDAO.CREATE_TABLE_DECHET);// création table "dechet"
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
       onCreate(sqLiteDatabase);
    }

}