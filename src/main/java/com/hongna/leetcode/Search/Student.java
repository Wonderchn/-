package com.hongna.leetcode.Search;

public class Student {
    private String name;
    private Student(){};
    public Student(String name){
        this.name = name;
    }
    public boolean equals(Object student){

        if (this == student){
            return true;
        }
        if (student == null){
            return false;
        }
        if (this.getClass() != student.getClass()){
            return false;
        }
        Student another = (Student) student;
        return another.name.equals(this.name);
    }
}
