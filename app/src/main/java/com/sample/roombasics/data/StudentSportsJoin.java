package com.sample.roombasics.data;

public class StudentSportsJoin {
    //student.name, student.course, sports.favorite Sport
    private String name;
    private String course;
    private String favoriteSport;
    private long child_studentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setChild_studentId(long child_studentId) {
        this.child_studentId = child_studentId;
    }

    public long getChild_studentId() {
        return child_studentId;
    }

    public void setChildId(long child_studentId) {
        this.child_studentId = child_studentId;
    }

    public String getFavoriteSport() {
        return favoriteSport;
    }

    public void setFavoriteSport(String favoriteSport) {
        this.favoriteSport = favoriteSport;
    }

    StudentSportsJoin(String name, String course, String favoriteSport, long child_studentId) {
        this.name = name;
        this.course = course;
        this.favoriteSport = favoriteSport;
        this.child_studentId = child_studentId;
    }


}
