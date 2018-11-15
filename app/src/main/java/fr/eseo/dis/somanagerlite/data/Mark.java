package fr.eseo.dis.somanagerlite.data;

public class Mark {

    private String id;
    private String forename;
    private String surname;
    private double mynote;
    private double avgnote;
    private String projectId;

    public Mark(String id, String forename, String surname, double mynote, double avgnote, String projectId){
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.mynote = mynote;
        this.avgnote = avgnote;
        this.projectId = projectId;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getMyNote() {
        return mynote;
    }

    public void setMyNote(double mynote) {
        this.mynote = mynote;
    }

    public double getAvgNote() {
        return avgnote;
    }

    public void setAvgNote(double avgnote) {
        this.avgnote = avgnote;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int describeContents(){
        return 0;
    }

}

