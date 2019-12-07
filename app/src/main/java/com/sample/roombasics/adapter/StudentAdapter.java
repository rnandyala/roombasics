package com.sample.roombasics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.roombasics.data.Student;
import com.sample.roomsampleapplication.R;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentView> {


    List<Student> mStudentList;

    public StudentAdapter(List<Student> mArrayListOfStudents) {
        this.mStudentList = mArrayListOfStudents;

    }

    @NonNull
    @Override
    public StudentView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.student_view, parent, false);

        StudentView mStudentView = new StudentView(listItem);
        return mStudentView;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentView holder, int position) {

        holder.mStudentName.setText(mStudentList.get(position).getName());

        holder.mStudentAge.setText(String.valueOf(mStudentList.get(position).getStudentId()));
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }
}
