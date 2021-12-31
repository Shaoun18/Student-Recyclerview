package com.seip.android.studentreciclerview.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private String courseType;
    private String courseName;

    private static List<Student> students = new ArrayList<>();

    public Student(String name, String courseType, String courseName) {
        this.name = name;
        this.courseType = courseType;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }


    public static List<Student> __getAllStudents(){
//        students.add(new Student("Jugol Kumar", "SEIP", "Android App Development"));
        return students;
    }

    public static void __setStudent(Student student){
        students.add(student);
    }

    public static void __removeStudent(Student student){
        students.remove(student);
    }


}
