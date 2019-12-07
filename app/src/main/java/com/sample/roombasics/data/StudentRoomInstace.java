package com.sample.roombasics.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Student.class, Sports.class}, version = 2, exportSchema = false)
public abstract class StudentRoomInstace extends RoomDatabase {

    public abstract StudentDao getStudentDao();

    public abstract SportsDao getSportDao();


}
