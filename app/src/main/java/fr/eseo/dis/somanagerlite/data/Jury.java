package fr.eseo.dis.somanagerlite.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "juries")
public class Jury {

    @PrimaryKey
    @NonNull
    private int idJury;

    public Jury(@NonNull int idJury){
        this.idJury = idJury;
    }

    @NonNull
    public int getIdJury() {
        return idJury;
    }

    public void setIdJury(@NonNull int idJury) {
        this.idJury = idJury;
    }
}
