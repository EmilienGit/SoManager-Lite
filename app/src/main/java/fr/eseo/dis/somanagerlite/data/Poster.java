package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

//@Entity(tableName = "poster")
public class Poster implements Parcelable {
/*
    @PrimaryKey
    @NonNull
    private String name;

    @NonNull
    private String description;

    public Poster(@NonNull String name, String description){
        this.name = name;
        this.description = description;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
    */

    public static final Parcelable.Creator<Poster> CREATOR = new Parcelable.Creator<Poster>(){
        public Poster createFromParcel(Parcel source){
            return new Poster(source);
        }

        public Poster[] newArray(int size){
            return new Poster[size];
        }
    };

    private String name;
    private String description;

    public Poster(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Poster(Parcel in){
        this.name = in.readString();
        this.description = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.name);
        dest.writeString(this.description);
    }
}
