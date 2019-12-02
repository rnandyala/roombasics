package com.sample.roombasics.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface StudentDao {


    @Insert
    public long insertStudent(Student mStudent);


    @Query("SELECT * FROM student")
    public List<Student> getAllStudentList();
}
