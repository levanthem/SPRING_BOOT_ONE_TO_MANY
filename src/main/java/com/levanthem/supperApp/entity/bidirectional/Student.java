package com.levanthem.supperApp.entity.bidirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") // ko nhap se ra VARCHAR(255)
    private String id;
    @Column(name = "Name",columnDefinition = "NVARCHAR(50)",length = 50, nullable = false)
    private String name;
    @Column(name = "Yob",nullable = false)
    private int yob;
    @Column(name = "Gpa")
    private double gpa;

    // sv thuoc 1 chuyen nganh tai 1 toi diem
    @ManyToOne
    @JoinColumn(name = "MajorId")  // bderect chuyen joincolum ve N cho chuan
    private Major major;


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // lam cho dep trai
        return String.format("|%8s|%-40s|%4d|%4.1f|",id,name,yob,gpa);
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", yob=" + yob +
//                ", gpa=" + gpa +
//                '}';
    }
}
