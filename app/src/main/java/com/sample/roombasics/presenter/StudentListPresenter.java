package com.sample.roombasics.presenter;

import android.content.Context;

import com.sample.roombasics.background_task.StudentAsyncTask;
import com.sample.roombasics.background_task.StudentAsyncTaskSportsInsert;
import com.sample.roombasics.data.SportsDao;
import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentRoomInstace;
import com.sample.roombasics.data.StudentSingleton;

import java.util.List;


public class StudentListPresenter implements StudentAsyncTask.AsyncResponse {


    public IStudentList mIstudentList;

    private Context mContext;

    private SportsDao mISportsDao;

    public interface IStudentList {

        void getStudentList(List<Student> mStudentList);
    }

    private List<Student> mStudentList;

    public StudentListPresenter(IStudentList mIStudentList)
    {
        StudentRoomInstace mStudentRoomInstance = StudentSingleton.getmStudentRoomInstance(mContext);
        mISportsDao = mStudentRoomInstance.getSportDao();

        this.mIstudentList = mIStudentList;
    }


    public void startBackgroundStudentList(Context mContext) {

        this.mContext = mContext;
        new StudentAsyncTask(mContext, this).execute();
    }

    public List<Student> getmStudentList() {


        return mStudentList;
    }

    @Override
    public void processFinish(List<Student> mStudentList) {
        this.mStudentList = mStudentList;

        mIstudentList.getStudentList(mStudentList);
    }



    public void setSportsData(){
        new StudentAsyncTaskSportsInsert(mISportsDao);
    }
}
