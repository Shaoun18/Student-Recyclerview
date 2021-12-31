package com.seip.android.studentreciclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.seip.android.studentreciclerview.databinding.FragmentStudentListBinding;
import com.seip.android.studentreciclerview.models.Student;

public class StudentList extends Fragment {

    FragmentStudentListBinding binding;


    public StudentList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStudentListBinding.inflate(inflater);



        if(Student.__getAllStudents().size()>0){
            StudentAdapter studentAdapter = new StudentAdapter(Student.__getAllStudents());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

            binding.studentsRV.setAdapter(studentAdapter);
            binding.studentsRV.setLayoutManager(linearLayoutManager);
        }else{
            Toast.makeText(getContext(), "No Have Student Data, Please Add new student", Toast.LENGTH_SHORT).show();
        }

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Student Add Page", Toast.LENGTH_SHORT).show();

                Navigation.findNavController(v).navigate(R.id.to_create_student_action);
            }
        });


        return binding.getRoot();


    }
}