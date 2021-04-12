package com.hongna.leetcode.Sort;

public class Student implements Comparable<Student>{
    private String name;
    private int score;

    private Student(){};
    public Student(String name , int score){
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score)
//            return -1;
//        else if (this.score == another.score)
//            return 0;
//        return 1;
        return this.score - another.score;

    }
}
