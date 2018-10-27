package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

//@Entity(tableName = "notes")
public class Mark {
/*
    @PrimaryKey
    @NonNull
    private float note;

    public Mark(@NonNull float note){
        this.note = note;
    }

    @NonNull
    public float getNote() {
        return note;
    }

    public void setNote(@NonNull float note) {
        this.note = note;
    }

    */
    public static final Parcelable.Creator<Mark> CREATOR = new Parcelable.Creator<Mark>(){
        public Mark createFromParcel(Parcel source){
            return new Mark(source);
        }

        public Mark[] newArray(int size){
            return new Mark[size];
        }
    };

    private String nom;
    private String prenom;
    private double note;

    public Mark(String nom, String prenom, double note){
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
    }

    public Mark(Parcel in){
        this.nom = in.readString();
        this.prenom = in.readString();
        this.note = in.readDouble();

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.nom);
        dest.writeString(this.prenom);
        dest.writeDouble(this.note);
    }
}

