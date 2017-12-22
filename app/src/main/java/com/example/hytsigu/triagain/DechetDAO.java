package com.example.hytsigu.triagain;

/**
 * Created by Utilisateur on 19/12/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class DechetDAO {


    private static final String TABLE_NAME = "dechets";
    private static final String ID_DECHET="id_dechet";
    private static final String NOM_FRANCAIS="nomFR";
    private static final String NOM_ANGLAIS="nomEN";
    private static final String NOM_IMAGE="nomImage";
    private static final String TYPE="type";
    public static final String CREATE_TABLE_DECHET = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+ID_DECHET+" INTEGER primary key," +
            " "+NOM_FRANCAIS+" TEXT" +
            " "+NOM_ANGLAIS+" TEXT" +
            " "+NOM_IMAGE+" TEXT" +
            " "+TYPE+" TEXT" +
            ");";


    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public DechetDAO(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);

    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addDechet(Dechet dechet) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(NOM_FRANCAIS, dechet.getNomFr());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modDechet(Dechet dechet) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(NOM_FRANCAIS, dechet.getNomFr());

        String where = ID_DECHET+" = ?";
        String[] whereArgs = {dechet.getId_dechet()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supDechet(Dechet dechet) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = ID_DECHET+" = ?";
        String[] whereArgs = {dechet.getId_dechet()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Dechet getDechet(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Dechet a=new Dechet(0,"","","","");
        /*ContentValues newTaskValues = new ContentValues();

// Assign the values for each column.
        newTaskValues.put(DechetDAO.ID_DECHET, 1);
        newTaskValues.put(DechetDAO.NOM_FRANCAIS, "Barquette confiture");
        newTaskValues.put(DechetDAO.NOM_ANGLAIS, "Jam tray");
        newTaskValues.put(DechetDAO.NOM_IMAGE, "menager_barquette_plastique_confiture");
        newTaskValues.put(DechetDAO.TYPE, "menager");

        db.insert(DechetDAO.TABLE_NAME, null, newTaskValues);*/
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ID_DECHET+"="+id, null);

        if (c.moveToFirst()) {
            System.out.println(">>>>>>>>>>>>>>>"+c.getInt(c.getColumnIndex(ID_DECHET)));
            a.setId_dechet(c.getInt(c.getColumnIndex(ID_DECHET)));
            a.setNomFr(c.getString(c.getColumnIndex(NOM_FRANCAIS)));
            a.setNomEn(c.getString(c.getColumnIndex(NOM_ANGLAIS)));
            a.setNomImage(c.getString(c.getColumnIndex(NOM_IMAGE)));
            a.setType(c.getString(c.getColumnIndex(TYPE)));
            c.close();
        }

        return a;
    }

    public Cursor getDechets() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}