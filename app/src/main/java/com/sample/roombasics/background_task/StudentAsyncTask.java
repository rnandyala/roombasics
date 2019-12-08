package com.sample.roombasics.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.sample.roombasics.data.Student;
import com.sample.roombasics.data.StudentRoomInstace;
import com.sample.roombasics.data.StudentSingleton;

import java.util.List;

// studentList AsyncTask
public class StudentAsyncTask extends AsyncTask<Void, Void, List<Student>> {
    private List<Student> students;
    private Context mContext;
    AsyncResponse delegate;

    public interface AsyncResponse {
        void processFinish(List<Student> mStudentList);
    }

    public StudentAsyncTask(Context mContext, AsyncResponse delegate) {
        this.mContext = mContext;
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(List<Student> students) {
        super.onPostExecute(students);
        this.students = students;
        delegate.processFinish(students);
    }

    @Override
    protected List<Student> doInBackground(Void... voids) {
        return StudentSingleton.getmStudentRoomInstance(mContext).getStudentDao().getAllStudentList();
    }
}
