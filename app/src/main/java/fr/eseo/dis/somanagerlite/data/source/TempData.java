package fr.eseo.dis.somanagerlite.data.source;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.dis.somanagerlite.data.Jury;
import fr.eseo.dis.somanagerlite.data.Mark;
import fr.eseo.dis.somanagerlite.data.Poster;
import fr.eseo.dis.somanagerlite.data.Project;

public class TempData {

    private static List<Jury> LIST_JURY = new ArrayList<>();

    private static List<Jury> LIST_MYJURY = new ArrayList<>();

    private static List<Poster> LIST_POSTER = new ArrayList<>();

    private static List<Poster> LIST_MY_POSTER = new ArrayList<>();

    private static List<Project> LIST_PROJECT = new ArrayList<>();

    private static List<Project> LIST_MYPROJECT = new ArrayList<>();

    private static List<Mark> LIST_MARK = new ArrayList<>();

    private TempData() {
    }

    public static List<Mark> getMark() {
        return LIST_MARK;
    }

    public static void setListMark(List<Mark> markList) {
        LIST_MARK = markList;
    }

    public static List<Poster> getPoster() {
        return LIST_POSTER;
    }

    public static void addPoster(Poster poster) {
        LIST_POSTER.add(poster);
    }

    public static List<Poster> getMyPoster() {
        return LIST_MY_POSTER;
    }

    public static void addMyPoster(Poster poster) {
        LIST_MY_POSTER.add(poster);
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
