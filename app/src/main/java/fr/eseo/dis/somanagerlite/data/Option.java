package fr.eseo.dis.somanagerlite.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Option implements Parcelable {

    public static final Parcelable.Creator<fr.eseo.dis.somanagerlite.data.Option> CREATOR = new Parcelable.Creator<fr.eseo.dis.somanagerlite.data.Option>(){
        public fr.eseo.dis.somanagerlite.data.Option createFromParcel(Parcel source){
            return new fr.eseo.dis.somanagerlite.data.Option(source);
        }

        public fr.eseo.dis.somanagerlite.data.Option[] newArray(int size){
            return new fr.eseo.dis.somanagerlite.data.Option[size];
        }
    };

    private int idOption;
    private String name;

    public Option(int idOption, String name){
        this.idOption = idOption;
        this.name = name;
    }

    public Option(Parcel in){
        this.idOption = in.readInt();
        this.name = in.readString();
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(this.idOption);
        dest.writeString(this.name);
    }
}
