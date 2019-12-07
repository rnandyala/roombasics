package com.sample.roombasics.background_task;

import android.os.AsyncTask;

import com.sample.roombasics.data.Sports;
import com.sample.roombasics.data.SportsDao;

public class StudentAsyncTaskSportsInsert extends AsyncTask<Sports, Void, Void> {

    SportsDao mSportDao;



    @Override
    protected Void doInBackground(Sports... sports) {

        Sports mSports1 = sports[0];

//        Sports mSports2 = sports[1];

        mSportDao.insertSports(mSports1);

        return null;
    }


    public StudentAsyncTaskSportsInsert(SportsDao mSportDao) {
        this.mSportDao = mSportDao;
    }
}
