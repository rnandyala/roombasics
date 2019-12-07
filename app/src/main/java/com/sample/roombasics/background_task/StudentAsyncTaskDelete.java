package com.sample.roombasics.background_task;

import android.os.AsyncTask;

import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentDao;


// use  this to delete a record...
public class StudentAsyncTaskDelete extends AsyncTask<Student, Void, Void> {


    StudentDao mStudentDao;

    @Override
    protected Void doInBackground(Student... students) {
// to delete specific record dude..
        //mStudentDao.deleteStudentRecord(students[0]);
//To delete all records
        mStudentDao.deleteAllStudentRecords();

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


    public StudentAsyncTaskDelete(StudentDao mStudentDao) {
        this.mStudentDao = mStudentDao;
    }
}
