package com.sample.roombasics.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


/*
try kotlin and forget asynctask for crud
try @transaction for multiple operations
the above one is used for atomic operation..
 */

/*
full text search
 */


@Dao
public interface SportsDao {
    @Insert
     long insertSports(Sports mSports);

    @Query("SELECT * FROM sports")
     List<Sports> getAllSportList();

    @Query("SELECT student.course, student.name, sports.favoriteSport, sports.child_studentId FROM Student INNER JOIN Sports ON student.studentId = sports.child_studentId")
     List<StudentSportsJoin> getJoinData();


}
