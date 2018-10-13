package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Project {
    /*
    @PrimaryKey
    @NonNull
    private int idProject;

    @NonNull
    private String title;

    @NonNull
    private String resume;


    public Project(@NonNull int idProject,@NonNull String title, @NonNull String resume){
        this.idProject = idProject;
        this.title = title;
        this.resume = resume;
    }

    @NonNull
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(@NonNull int idProject) {
        this.idProject = idProject;
    }

    @NonNull
    public String getResume(){ return  resume;}

    public void setResume(@NonNull String resume){ this.resume = resume;}

    @NonNull
    public String getTitle(){
        return this.title;
    }
    public void setTitle(@NonNull String title){
        this.title = title;
    }
    */
    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>(){
        public Project createFromParcel(Parcel source){
            return new Project(source);
        }

        public Project[] newArray(int size){
            return new Project[size];
        }
    };

    private String title;
    private String resume;

    public Project(String title, String resume){
        this.title = title;
        this.resume = resume;
    }

    public Project(Parcel in){
        this.title = in.readString();
        this.resume = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.title);
        dest.writeString(this.resume);
    }
}
