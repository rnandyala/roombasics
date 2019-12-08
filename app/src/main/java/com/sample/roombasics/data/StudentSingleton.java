package com.sample.roombasics.data;

import android.content.Context;

import androidx.room.Room;

public class StudentSingleton {

    private static StudentRoomInstace mStudentRoomInstance = null;

    private static final String STUDENT_DB_NAME = "student&sport_db";

    private StudentSingleton() {
    }


    public static StudentRoomInstace getmStudentRoomInstance(Context mContext) {

        if (mStudentRoomInstance == null) {
            mStudentRoomInstance = Room.databaseBuilder(
                    mContext,
                    StudentRoomInstace.class,
                    STUDENT_DB_NAME
            ).build();
        }
        return mStudentRoomInstance;
    }

}
