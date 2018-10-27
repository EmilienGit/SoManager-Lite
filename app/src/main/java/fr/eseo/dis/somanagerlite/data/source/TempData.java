package fr.eseo.dis.somanagerlite.data.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.Project;

public class TempData {

    private static List<Jury> LIST_JURY = new ArrayList<>();

    private static List<Jury> LIST_MYJURY = new ArrayList<>();

    private static List<Poster> LIST_POSTER = new ArrayList<>();

    private static List<Project> LIST_PROJECT = new ArrayList<>();

    private static List<Project> LIST_MYPROJECT = new ArrayList<>();

    private static List<Mark> LIST_MARK = new ArrayList<>();

    private static Poster[] POSTER = new Poster[]{
            new Poster("Excalibur II", "Description 1"),
            new Poster("Animal Tracker", "Description 2 : Ceci est un test pour voir jusqu'ou va la description du poster. Merci de ne pas en tenir compte. Cordialement, Quentin Pichavant."),
            new Poster("NO IDEA", "Description 3"),
    };

    private static Mark[] MARK = new Mark[]{
            new Mark("SoManager", "Alpha", 10),
            new Mark("Emma", "Mansalier", 20),
            new Mark("Quentin", "Pichavant", 17),
            new Mark("Emilien", "Mamalet",14),
            new Mark("Etienne", "Piou", 15),
    };

    private TempData() {
    }

    public static List<Poster> getPoster() {
        LIST_POSTER = Arrays.asList(POSTER);
        return LIST_POSTER;
    }

    public static List<Mark> getMark() {
        LIST_MARK = Arrays.asList(MARK);
        return LIST_MARK;
    }

    public static List<Project> getProject() {
        return LIST_PROJECT;
    }

    public static void setListProject(List<Project> listProject) {
        LIST_PROJECT = listProject;
    }

    public static List<Project> getMyProject() {
        return LIST_MYPROJECT;
    }

    public static void setListMyProject(List<Project> listMyProject) {
        LIST_MYPROJECT = listMyProject;
    }

    public static List<Jury> getJury() {
        return LIST_JURY;
    }

    public static void setListJury(List<Jury> listJury) {
        LIST_JURY = listJury;
    }

    public static List<Jury> getMyJury() {
        return LIST_MYJURY;
    }

    public static void setListMyJury(List<Jury> listMyJury) {
        LIST_MYJURY= listMyJury;
    }
}
