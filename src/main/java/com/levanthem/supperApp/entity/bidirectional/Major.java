package com.levanthem.supperApp.entity.bidirectional;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "Id",columnDefinition = "CHAR(2)")
    private String id;
    @Column(name = "Name",columnDefinition = "NVARCHAR(80)",length = 80,nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "major")
    //mappBy Major ket noi voi student qua major - MajorID,chuw ko ko biet thucc nao


    // 1chuyen nhanh co nhieu sinh vien
    private List<Student> students = new ArrayList<>();
    // Students.add(dua 1 sv va Major)
    // students.remove (1 sv doi chuyen nganh)
    // Viet code nay o dau
    //
    // SRP : Single Responsibility Priceple
    // Them xoa sv la viec cua major
    //
    public void addStudent(Student obj){
        students.add(obj); // add vao sv chua biet chuyen nganh nao
        obj.setMajor(this);  // khi do se thi this la se, khi do gd thi this la gd. this linh dong vay
    }
    public void removeStudent(Student obj){
        students.remove(obj);  // 1 sv da doi nganh , chuyen nganh nao ko biet nhung ko con trong chuyen nganh
        obj.setMajor(null);
    }

    // co cau query trong DB
    // DB: SELECT * FROM STUDENT WHERE MAJORID ="SE";


    public List<Student> getStudents() {
        return students;
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
        // lAM tOSTRING DEP TRAI
        return String.format("|%2s|%-40s|",id,name);
//        return "Major{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
    }

}
