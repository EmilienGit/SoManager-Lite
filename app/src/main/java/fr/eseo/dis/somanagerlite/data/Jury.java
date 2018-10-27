package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.List;

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

    private String idJury;
    private String date;
    private List<Project> listProject;


    public Jury(String idJury, String date, List<Project> listProject){
        this.idJury = idJury;
        this.date = date;
        this.listProject = listProject;
    }

    public String getId() {
        return idJury;
    }

    public void setId(String idJury) {
        this.idJury = idJury;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }

    public int describeContents(){
        return 0;
    }
}
