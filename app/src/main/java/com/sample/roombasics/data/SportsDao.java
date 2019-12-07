package com.sample.roombasics.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SportsDao {


    @Insert
    public long insertSports(Sports mSports);


    @Query("SELECT * FROM sports")
    public List<Sports> getAllSportList();


    @Query("SELECT student.course, student.name, sports.favoriteSport, sports.child_studentId FROM Student INNER JOIN Sports ON student.studentId = sports.child_studentId"

    )
    public List<StudentSportsJoin> getJoinData();


}
