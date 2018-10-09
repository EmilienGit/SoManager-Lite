package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "poster")
public class Poster {

    @PrimaryKey
    @NonNull
    private String poster;

    public Poster(@NonNull String poster){
        this.poster = poster;
    }

    @NonNull
    public String getPoster() {
        return poster;
    }

    public void setPoster(@NonNull String note) {
        this.poster = poster;
    }
}
