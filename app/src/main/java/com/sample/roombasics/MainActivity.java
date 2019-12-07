package com.sample.roombasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sample.roomsampleapplication.R;
import com.sample.roombasics.data.Student;
import com.sample.roombasics.presenter.StudentPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentPresenter mStudentPresenter;

// messed up life with messed up tooldf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStudentPresenter = new StudentPresenter(getApplicationContext());

        setStudentData();

        getStudentListData();

    }

    private void setStudentData() {


        mStudentPresenter.setStudentData(new Student( 250,"pragnesh", "computer science"));

    }

    private List<Student> getStudentListData(){


       return mStudentPresenter.getStudentList();
    }







}
