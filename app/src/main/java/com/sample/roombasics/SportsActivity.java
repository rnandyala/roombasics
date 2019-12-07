package com.sample.roombasics;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.sample.roombasics.data.Sports;
import com.sample.roombasics.data.StudentSportsJoin;
import com.sample.roombasics.presenter.StudentDetailsPresenter;
import com.sample.roomsampleapplication.R;

import java.util.List;

public class SportsActivity extends AppCompatActivity implements StudentDetailsPresenter.ISportsDetails {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
StudentDetailsPresenter mStudentDetailsPresenter = new StudentDetailsPresenter(this);
mStudentDetailsPresenter.startBackgroundStudentList(getApplicationContext());
    }

    @Override
    public void getSportsDetails(List<StudentSportsJoin> mSportsDetails) {





    }
}
