package com.example.hytsigu.triagain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Utilisateur on 19/12/2017.
 */

public class Dechet implements Parcelable {

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


    protected Dechet(Parcel in) {
        id_dechet = in.readInt();
        nomFr = in.readString();
        nomEn = in.readString();
        nomImage = in.readString();
        type = in.readString();
    }

    public static final Creator<Dechet> CREATOR = new Creator<Dechet>() {
        @Override
        public Dechet createFromParcel(Parcel in) {
            return new Dechet(in);
        }

        @Override
        public Dechet[] newArray(int size) {
            return new Dechet[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_dechet);
        dest.writeString(nomFr);
        dest.writeString(nomEn);
        dest.writeString(nomImage);
        dest.writeString(type);
    }
}
