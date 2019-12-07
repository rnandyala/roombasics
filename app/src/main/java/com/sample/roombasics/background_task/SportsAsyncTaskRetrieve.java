package com.sample.roombasics.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.sample.roombasics.data.StudentSingleton;
import com.sample.roombasics.data.StudentSportsJoin;

import java.util.List;

public class SportsAsyncTaskRetrieve extends AsyncTask<Void, Void, List<StudentSportsJoin>> {
    private Context mContext;





    public interface AsyncSports {
        void processFinish(List<StudentSportsJoin> mSportsList);

    }

public AsyncSports delegate = null;

    public SportsAsyncTaskRetrieve(Context mContext, AsyncSports delegate) {
        this.mContext = mContext;

        this.delegate = delegate;
    }

    @Override
    protected List<StudentSportsJoin> doInBackground(Void... voids) {

        List<StudentSportsJoin> mSportsList = StudentSingleton.getmStudentRoomInstance(mContext).getSportDao().getJoinData();



        return mSportsList;
    }

    @Override
    protected void onPostExecute(List<StudentSportsJoin> sports) {
        super.onPostExecute(sports);
delegate.processFinish(sports);

    }


//    @Override
//    protected Void doInBackground(Void... voids) {
//        return null;
//    }
//
//    @Override
//    protected List<Sports> doInBackground(Void... voids) {
//
//        StudentSingleton.getmStudentRoomInstance(mContext).getSportDao();
//        return null;
//    }


}
