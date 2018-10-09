package fr.eseo.dis.somanagerlite.data.source;

import java.util.Arrays;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Poster;

public class DummyData {

    private static List<Poster> LIST_POSTER;

    private static Poster[] POSTER = new Poster[]{
            new Poster("Excalibur II"),
            new Poster("Animal Tracker"),
            new Poster("NO IDEA"),
    };

    private DummyData() {
    }

    public static List<Poster> getPoster() {
        if (LIST_POSTER == null) {
            LIST_POSTER = Arrays.asList(POSTER);
        }
        return LIST_POSTER;
    }
}
