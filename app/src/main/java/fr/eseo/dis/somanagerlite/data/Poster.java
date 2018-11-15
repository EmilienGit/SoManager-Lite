package fr.eseo.dis.somanagerlite.data;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Poster {


    private Drawable image;

    public Poster(Drawable image){
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int describeContents(){
        return 0;
    }
}
