package com.levanthem.supperApp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")

public class Major {

    @Id
    @Column(name = "Id",columnDefinition = "CHAR(2)")  // thieeus columdefini se thanh varchar(255)

    private String id; // ma chuyen nganh
    @Column(name = "Name",columnDefinition = "NVARCHAR(100)",length = 100, nullable = false)
    private String name;  // ten chuyen nganh
    // Trong ngon ngu doi thuong mot chuyen nganh major co nhieu sinh vien
    // muon luu nieu thong tin List/Arraythang tien, object naytham chieu thonog tin object kia

    // mpping here.
    //CSS cascade style sheet , hieu ung day chuyen.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // nho cau nay ma table Student xuat hien va no se doi FK/join column// do domino
                                                           // eager load luon ds many student, lazu la tu tu , chung nao may can view thi tao load.
    @JoinColumn(name = "MajorId")  // tu tao ben table Studen cot foreign key ten la major)
    private List<Student> students = new ArrayList<>();
    // De co cu the sinh vien nao ta Student.add(mot ban sv duoc new o dau do)Students.add("SE",...)
    // add mot phan tu vao arrayList
    public void addStudent(Student obj){
        students.add(obj);
    }
    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
