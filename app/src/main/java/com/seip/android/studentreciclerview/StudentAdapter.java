package com.seip.android.studentreciclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seip.android.studentreciclerview.databinding.FragmentStudentListBinding;
import com.seip.android.studentreciclerview.databinding.StudentRowBinding;
import com.seip.android.studentreciclerview.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final StudentRowBinding binding = StudentRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new StudentViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        StudentRowBinding binding;
        public StudentViewHolder(@NonNull StudentRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Student student) {
            binding.nameTV.setText(student.getName());
            binding.courseTypeTV.setText(student.getCourseType());
            binding.courseNameTV.setText(student.getCourseName());

            binding.deleteIV.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View v) {
                    Student.__removeStudent(student);
                    Toast.makeText(v.getContext(), "delete this row", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
        }
    }

}
