package com.example.hytsigu.triagain;

/**
 * Created by Charlotte on 19/12/2017.
 */

public class Dechet {

    private int id_dechet;
    private String nomFr;
    private String nomEn;
    private String nomImage;
    private String type;


    public Dechet(int id_dechet, String nomFr, String nomEn, String nomImage, String type) {
        this.id_dechet = id_dechet;
        this.nomFr = nomFr;
        this.nomEn = nomEn;
        this.nomImage = nomImage;
        this.type = type;

    }


    public int getId_dechet() {
        return id_dechet;
    }

    public void setId_dechet(int id_dechet) {
        this.id_dechet = id_dechet;
    }

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public String getNomEn() {
        return nomEn;
    }

    public void setNomEn(String nomEn) {
        this.nomEn = nomEn;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
