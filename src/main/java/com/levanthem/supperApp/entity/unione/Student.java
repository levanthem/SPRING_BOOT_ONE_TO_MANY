package com.levanthem.supperApp.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "Stduent")

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

    //private String MajorId ; anw don OOP ko lam vay.


    // nghi tu duy theo csdl la ko dung,
    //nghi dung tu duy OOP, cac object co moi quan he
    // co cach de convert tu OOP thanh Table /FK , Join column --> ORM mapping
    // can 1 thang giuyp anh xa 2 the gioi de cho tuong thich : JPA/HIBERNATE
    //     // Neu co : private Major major  (nhieu sang 1)
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
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
