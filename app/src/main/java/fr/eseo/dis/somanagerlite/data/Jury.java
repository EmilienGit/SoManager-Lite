package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

//@Entity(tableName = "juries")
public class Jury {
    /*
        @PrimaryKey
        @NonNull
        private int idJury;

        @NonNull
        private String date;


        public Jury(@NonNull int idJury, @NonNull String date){
            this.idJury = idJury;
            this.date = date;
        }

        @NonNull
        public int getIdJury() {
            return idJury;
        }

        public void setIdJury(@NonNull int idJury) {
            this.idJury = idJury;
        }

        @NonNull
        public String getDate(){ return  date;}

        public void setDate(@NonNull String date){ this.date = date;}
    }*/
    public static final Parcelable.Creator<Jury> CREATOR = new Parcelable.Creator<Jury>(){
        public Jury createFromParcel(Parcel source){
            return new Jury(source);
        }

        public Jury[] newArray(int size){
            return new Jury[size];
        }
    };

    private int number;
    private String date;

    public Jury(int number, String date){
        this.number = number;
        this.date = date;
    }

    public Jury(Parcel in){
        this.number = in.readInt();
        this.date = in.readString();
    }

    public int getId() {
        return number;
    }

    public void setId(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(this.number);
        dest.writeString(this.date);
    }
}
