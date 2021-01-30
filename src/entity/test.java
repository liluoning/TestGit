package entity;

import java.util.ArrayList;
import java.util.List;

class test{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Student student = new Student();
            students.add(student);
        }
        System.out.println(Student.count);
    }
}