package fr.eseo.dis.somanagerlite.data;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String projectId;
    private String title;
    private String description;
    private boolean booleanPoster;
    private User supervisor;
    private String confidential;
    private List<User> students;

    public Project(String projectId, String title, String description, boolean booleanPoster, User supervisor, String confidential, List<User> students){
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.booleanPoster = booleanPoster;
        this.supervisor = supervisor;
        this.confidential = confidential;
        this.students = students;
    }

    public Project(String projectId, String title,  String confidential, boolean booleanPoster, User supervisor){
        this.projectId = projectId;
        this.title = title;
        this.confidential = confidential;
        this.booleanPoster = booleanPoster;
        this.supervisor = supervisor;
        this.description = "";
        this.students = new ArrayList<>();
    }

    public String getId() {
        return projectId;
    }

    public void setId(String projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBooleanPoster() {
        return booleanPoster;
    }

    public void setBooleanPoster(boolean booleanPoster) {
        this.booleanPoster = booleanPoster;
    }


    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public String getConfid() {
        return confidential;
    }

    public void setConfid(String confidential) {
        this.confidential = confidential;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public int describeContents(){
        return 0;
    }
}
