package com.sample.roombasics.data;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {


    @NonNull
    @PrimaryKey
    private long studentId;

    private String name;

    private String course;


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

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

    public Student(long studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    @NonNull
    @Override
    public String toString() {
        return "The students age is:" + studentId + ";\n" +
                "his name is " + name + " " + "\n he has taken " + course + "\n";
    }
}
