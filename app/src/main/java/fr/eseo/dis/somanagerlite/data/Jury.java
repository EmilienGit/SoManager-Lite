package fr.eseo.dis.somanagerlite.data;

import java.util.List;

public class Jury {

    private String idJury;
    private String date;
    private List<Project> listProject;


    public Jury(String idJury, String date, List<Project> listProject){
        this.idJury = idJury;
        this.date = date;
        this.listProject = listProject;
    }

    public String getId() {
        return idJury;
    }

    public void setId(String idJury) {
        this.idJury = idJury;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }

    public int describeContents(){
        return 0;
    }
}
