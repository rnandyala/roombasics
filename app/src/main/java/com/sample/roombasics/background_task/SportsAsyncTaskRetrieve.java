package com.sample.roombasics.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.sample.roombasics.data.StudentSingleton;
import com.sample.roombasics.data.StudentSportsJoin;

import java.util.List;

/*
AsyncTask with interface to passdata to UI  design
My First Join example..
 */

public class SportsAsyncTaskRetrieve extends AsyncTask<Void, Void, List<StudentSportsJoin>> {
    private Context mContext;
    private AsyncSports delegate;

    public interface AsyncSports {
        void processFinish(List<StudentSportsJoin> mSportsList);
    }

    public SportsAsyncTaskRetrieve(Context mContext, AsyncSports delegate) {
        this.mContext = mContext;
        this.delegate = delegate;
    }

    @Override
    protected List<StudentSportsJoin> doInBackground(Void... voids) {
        return StudentSingleton.getmStudentRoomInstance(mContext).getSportDao().getJoinData();
    }

    @Override
    protected void onPostExecute(List<StudentSportsJoin> sports) {
        super.onPostExecute(sports);
        delegate.processFinish(sports);

    }
}
