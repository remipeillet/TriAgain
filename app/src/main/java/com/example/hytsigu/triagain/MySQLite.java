package com.example.hytsigu.triagain;

/**
 * Created by Charlotte on 19/12/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tri_again";
    private static final int DATABASE_VERSION = 1;
    private static MySQLite sInstance;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            InputStream is = Context.getResources().getAssets().open("bdd_android_kayak.sql"); // ouvre le fichier qui contient les requêtes
            Log.i("BDD", "Récupération fichier de création OK");

            String[] statements = FileHelper.parseSqlFile(is); // tableau de string pour stocker les requêtes sql

            for (String statement : statements) {
                sqLiteDatabase.execSQL(statement);   //execution des requêtes
            }

            Log.i("BDD", "Création réussi");

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("BDD", "Création ou connexion fichié échouée");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
       // onCreate(sqLiteDatabase);
    }

}