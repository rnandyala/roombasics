package com.sample.roombasics.presenter;

import android.content.Context;

import com.sample.roombasics.background_task.SportsAsyncTaskRetrieve;
import com.sample.roombasics.background_task.StudentAsyncTask;
import com.sample.roombasics.data.Sports;
import com.sample.roombasics.data.StudentSportsJoin;

import java.util.List;

public class StudentDetailsPresenter implements SportsAsyncTaskRetrieve.AsyncSports {


    private ISportsDetails mISportDetails;

    public interface ISportsDetails{


        void getSportsDetails(List<StudentSportsJoin> mSportsDetails);
    }




    public void startBackgroundStudentList(Context mContext) {
        new SportsAsyncTaskRetrieve(mContext, this).execute();
    }

    public StudentDetailsPresenter(ISportsDetails mISportDetails) {
        this.mISportDetails = mISportDetails;
    }

    @Override
    public void processFinish(List<StudentSportsJoin> mSportsList) {


        mISportDetails.getSportsDetails(mSportsList);

    }





}
