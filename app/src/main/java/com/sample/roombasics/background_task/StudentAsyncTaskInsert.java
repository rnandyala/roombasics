package com.sample.roombasics.background_task;

import android.os.AsyncTask;

import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentDao;


// use this to insert data
public class StudentAsyncTaskInsert extends AsyncTask<Student,Void, Void> {


    StudentDao mStudentDao;


    public StudentAsyncTaskInsert(StudentDao mStudentDao) {
        this.mStudentDao = mStudentDao;
    }

    @Override
    protected Void doInBackground(Student... students) {

        mStudentDao.insertStudent(students[0]);


        return null;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }
}
