package fr.eseo.dis.somanagerlite.data;

import android.os.Parcel;
import android.os.Parcelable;

public class User {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>(){
        public User createFromParcel(Parcel source){
            return new User(source);
        }

        public User[] newArray(int size){
            return new User[size];
        }
    };

    private String id;
    private String username;
    private String forename;
    private String surname;

    public User(String id, String username){
        this.id = id;
        this.username = username;
        this.forename = "Unknown";
        this.surname = "Unknown";
    }

    public User(String id, String forename, String surname){
        this.id = id;
        this.username = "Unknown";
        this.forename = forename;
        this.surname = surname;
    }

    public User(Parcel in){
        this.id = in.readString();
        this.username = in.readString();
        this.forename = in.readString();
        this.surname = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.forename);
        dest.writeString(this.surname);
    }
}
