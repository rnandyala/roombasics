package com.sample.roombasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sample.roombasics.data.Sports;
import com.sample.roomsampleapplication.R;
import com.sample.roombasics.data.Student;
import com.sample.roombasics.presenter.StudentPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentPresenter mStudentPresenter;
    private Button mButton;
    private Button mRetrieveStudents;
    private Button mDeleteStudent;
    private EditText mStudentAge;
    private EditText mStudentCourse;
    private EditText mStudentName;
    private TextView mShowData;
    private Button mNextActivity;
    private Button mSubmitSports;
    private EditText mSportsName;
    private EditText mAchievement;
    private EditText mChildStudentId;
    private EditText mAchievement2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllViewId();
        mStudentPresenter = new StudentPresenter(getApplicationContext());
        getStudentListData();
        addStudentRecordToDataBase();
        retrieveStudents();
        deleteStudentRecordFromDataBase();
        submitDataToRoom();
    }

    private void retrieveStudents() {
        mRetrieveStudents.setOnClickListener(
                v -> mShowData.setText(getStudentListData().toString()));

    }

    private void setAllViewId() {
        mButton = findViewById(R.id.add_student);
        mStudentAge = findViewById(R.id.studentAge);
        mStudentCourse = findViewById(R.id.studentCourse);
        mStudentName = findViewById(R.id.studentName);
        mRetrieveStudents = findViewById(R.id.retrieve_student);
        mShowData = findViewById(R.id.database_data);
        mDeleteStudent = findViewById(R.id.delete_student);
        mNextActivity = findViewById(R.id.goto_student_list);
        mSubmitSports = findViewById(R.id.submit_room);

        mNextActivity.setOnClickListener(
                v -> startActivity(new Intent(this, StudentActivity.class)));
        mSportsName = findViewById(R.id.sport_name);
        mAchievement = findViewById(R.id.achievement);
        mChildStudentId = findViewById(R.id.sport_name_second);
        mAchievement = findViewById(R.id.achievement2);
    }

    private void addStudentRecordToDataBase() {
        mButton.setOnClickListener(
                v -> {
                    String studentName = mStudentName.getText().toString();
                    String studentAge = mStudentAge.getText().toString();
                    Integer mStudentAgeInt = Integer.parseInt(studentAge);
                    String studentCourse = mStudentCourse.getText().toString();
                    mStudentPresenter.setStudentData(new Student(mStudentAgeInt, studentName, studentCourse));
                }
        );
    }


    private void deleteStudentRecordFromDataBase() {
        // To delete specific record use below code


//        mDeleteStudent.setOnClickListener(
//
//                v -> {
//                    String studentName = mStudentName.getText().toString();
//                    String studentAge = mStudentAge.getText().toString();
//                    Integer mStudentAgeInt = Integer.parseInt(studentAge);
//                    String studentCourse = mStudentCourse.getText().toString();
//
//                    mStudentPresenter.deleteStudentRecord(new Student(mStudentAgeInt, studentName, studentCourse));
//
//                }
// To delete all records

        mDeleteStudent.setOnClickListener(
                v -> mStudentPresenter.deleteStudentRecord(null));
    }


    private void submitDataToRoom() {
        mSubmitSports.setOnClickListener(
                v -> {
                    String mSportName = mSportsName.getText().toString();
                    String mSportAchievement = mAchievement.getText().toString();
                    int mSportsManAge = Integer.parseInt(mChildStudentId.getText().toString());

//
//                    String mSportName2 = mSprotName2.getText().toString();
//
//                    String mAchievement = mAchievement2.getText().toString();

                    Sports mFirstSport = new Sports(mSportName, mSportAchievement, mSportsManAge);
                    mStudentPresenter.addSportsRecord(mFirstSport, null);
                    // Sports mSecondSport =    new Sports(mSportName2, mAchievement);
                });
    }

    private List<Student> getStudentListData() {
        return mStudentPresenter.getStudentList();
    }
}
