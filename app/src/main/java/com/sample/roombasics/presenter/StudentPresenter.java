package com.sample.roombasics.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.sample.roombasics.background_task.StudentAsyncTaskDelete;
import com.sample.roombasics.background_task.StudentAsyncTaskInsert;
import com.sample.roombasics.background_task.StudentAsyncTaskSportsInsert;
import com.sample.roombasics.data.Sports;
import com.sample.roombasics.data.SportsDao;
import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentDao;
import com.sample.roombasics.data.StudentRoomInstace;
import com.sample.roombasics.data.StudentSingleton;

import java.util.List;

public class StudentPresenter {

    private Context mContext;
    List<Student> mStudentList;
    private StudentDao mStudentDao;

    private SportsDao mSprotsDao;

    public StudentPresenter(Context mContext) {
        this.mContext = mContext;
        StudentRoomInstace mStudentRoomInstance = StudentSingleton.getmStudentRoomInstance(mContext);
        mStudentDao = mStudentRoomInstance.getStudentDao();
    }

    public void setOrInsertStudentData() {

    }

    public void setStudentData(Student mStudent) {

        new StudentAsyncTaskInsert(mStudentDao).execute(mStudent);
    }

    public List<Student> getStudentList() {
        new StudentAsyncTask().execute();
        return mStudentList;
    }


    public void deleteStudentRecord(Student mStudent) {


        if (mStudent == null) {
            new StudentAsyncTaskDelete(mStudentDao).execute(mStudent);

        } else {

            new StudentAsyncTaskDelete(mStudentDao).execute(mStudent);
        }

    }


    public void addSportsRecord(Sports mSportsData, Sports mSportsData2) {

        StudentRoomInstace mStudentRoomInstance = StudentSingleton.getmStudentRoomInstance(mContext);
        mSprotsDao = mStudentRoomInstance.getSportDao();


        new StudentAsyncTaskSportsInsert(mSprotsDao).execute(mSportsData);


    }


    public class StudentAsyncTask extends AsyncTask<Void, Void, List<Student>> {
        @Override
        protected List<Student> doInBackground(Void... voids) {
            return mStudentDao.getAllStudentList();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Student> mStudent) {
            super.onPostExecute(mStudentList);
            mStudentList = mStudent;
        }
    }
}
