package com.sample.roombasics.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.roombasics.SportsActivity;
import com.sample.roomsampleapplication.R;

class StudentView extends RecyclerView.ViewHolder {

    TextView mStudentName;
    TextView mStudentAge;


    StudentView(@NonNull View itemView) {
        super(itemView);
        mStudentName = itemView.findViewById(R.id.student_name);
        mStudentAge = itemView.findViewById(R.id.student_age);
        itemView.setOnClickListener(
                v -> {
                    Intent mSportsDetails = new Intent(itemView.getContext(), SportsActivity.class);
                    mSportsDetails.putExtra("studentage", mStudentAge.getText().toString());
                    itemView.getContext().startActivity(mSportsDetails);
                });
    }
}
