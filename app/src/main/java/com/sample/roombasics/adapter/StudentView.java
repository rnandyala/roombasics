package com.sample.roombasics.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.roombasics.SportsActivity;
import com.sample.roomsampleapplication.R;

public class StudentView extends RecyclerView.ViewHolder {

    public TextView mStudentName;
    public TextView mStudentAge;


    public StudentView(@NonNull View itemView) {
        super(itemView);
        mStudentName = (TextView) itemView.findViewById(R.id.student_name);
        mStudentAge = (TextView) itemView.findViewById(R.id.student_age);


        itemView.setOnClickListener(

                v ->{

                    Intent mSportsDetails = new Intent(itemView.getContext(), SportsActivity.class);

                    mSportsDetails.putExtra("studentage",mStudentAge.getText().toString());
itemView.getContext().startActivity(mSportsDetails);

                }

        );
    }


}
