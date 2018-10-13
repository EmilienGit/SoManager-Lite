package fr.eseo.dis.somanagerlite.data.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Poster;

public class DummyData {

    private static List<Poster> LIST_POSTER = new ArrayList<>();

    private static Poster[] POSTER = new Poster[]{
            new Poster("Excalibur II", "Description 1"),
            new Poster("Animal Tracker", "Description 1"),
            new Poster("NO IDEA", "Description 1"),
    };

    private DummyData() {
    }

    public static List<Poster> getPoster() {
        LIST_POSTER = Arrays.asList(POSTER);
        return LIST_POSTER;
    }
}
