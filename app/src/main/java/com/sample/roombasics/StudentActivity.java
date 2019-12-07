package com.sample.roombasics;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.sample.roombasics.adapter.StudentAdapter;
import com.sample.roombasics.data.Student;
import com.sample.roombasics.presenter.StudentListPresenter;
import com.sample.roomsampleapplication.R;

import java.util.List;

public class StudentActivity extends AppCompatActivity implements StudentListPresenter.IStudentList {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        StudentListPresenter mStudentListPresenter = new StudentListPresenter(this);

        mStudentListPresenter.startBackgroundStudentList(getApplicationContext());

        List<Student> mStudentList = mStudentListPresenter.getmStudentList();


    }

    private void setRecyclerviewAdapter(List<Student> mStudentList) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_student_list);
        StudentAdapter adapter = new StudentAdapter(mStudentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void getStudentList(List<Student> mStudentList) {
        setRecyclerviewAdapter(mStudentList);
    }
}