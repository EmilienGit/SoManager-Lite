package fr.eseo.dis.somanagerlite.data;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

public class Poster {


    private Bitmap image;

    public Poster(Bitmap image){
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int describeContents(){
        return 0;
    }
}
