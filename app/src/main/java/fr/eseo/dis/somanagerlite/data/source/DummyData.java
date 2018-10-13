package fr.eseo.dis.somanagerlite.data.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.Project;

public class DummyData {

    private static List<Jury> LIST_JURY = new ArrayList<>();

    private static List<Poster> LIST_POSTER = new ArrayList<>();

    private static List<Project> LIST_PROJECT = new ArrayList<>();

    private static List<Mark> LIST_MARK = new ArrayList<>();

    private static Jury[] JURY = new Jury[]{
            new Jury(001, "21 janv 2019 - 8h00"),
            new Jury(002, "21 janv 2019 - 8h30"),
            new Jury(003, "21 janv 2019 - 9h00"),
    };


    private static Poster[] POSTER = new Poster[]{
            new Poster("Excalibur II", "Description 1"),
            new Poster("Animal Tracker", "Description 1"),
            new Poster("NO IDEA", "Description 1"),
    };

    private static Project[] PROJECT = new Project[]{
            new Project("Titre 1", "My resume 1 "),
            new Project("Titre 2", "My resume 2 "),
            new Project("Titre 3", "My resume 3 "),
    };

    private static Mark[] MARK = new Mark[]{
            new Mark("Emma", "Mansalier", 20),
            new Mark("Quentin", "Pichavant", 17),
            new Mark("Emilien", "Mamalet",4),
            new Mark("Etienne", "Piou", 5),
    };

    private DummyData() {
    }

    public static List<Poster> getPoster() {
        LIST_POSTER = Arrays.asList(POSTER);
        return LIST_POSTER;
    }

    public static List<Jury> getJury() {
        LIST_JURY = Arrays.asList(JURY);
        return LIST_JURY;
    }

    public static List<Project> getProject() {
        LIST_PROJECT = Arrays.asList(PROJECT);
        return LIST_PROJECT;
    }

    public static List<Mark> getMark() {
        LIST_MARK = Arrays.asList(MARK);
        return LIST_MARK;
    }
}
