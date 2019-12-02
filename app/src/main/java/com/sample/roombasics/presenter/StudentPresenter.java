package com.sample.roombasics.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentDao;
import com.sample.roombasics.data.StudentRoomInstace;
import com.sample.roombasics.data.StudentSingleton;

import java.util.List;

public class StudentPresenter {

List<Student> mStudentList;
    private StudentDao mStudentDao;

    public StudentPresenter(Context mContext) {

        StudentRoomInstace mStudentRoomInstance = StudentSingleton.getmStudentRoomInstance(mContext);


mStudentDao = mStudentRoomInstance.getStudentDao();

    }


    public void setStudentData(Student mStudent) {



    }

    public List<Student> getStudentList() {

        new StudentAsyncTask().execute();

        return mStudentList;

    }


 public class StudentAsyncTask extends AsyncTask<Void,Void, List<Student>>{


     @Override
     protected List<Student> doInBackground(Void... voids) {

       return   mStudentDao.getAllStudentList();
     }

     @Override
     protected void onPreExecute() {
         super.onPreExecute();
     }

     @Override
     protected void onPostExecute(List<Student> mStudent) {
         super.onPostExecute(mStudentList);

mStudent.size();



     }


 }





}
