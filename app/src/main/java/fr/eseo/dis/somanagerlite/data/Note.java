package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey
    @NonNull
    private float note;

    public Note(@NonNull float note){
        this.note = note;
    }

    @NonNull
    public float getNote() {
        return note;
    }

    public void setNote(@NonNull float note) {
        this.note = note;
    }
}

