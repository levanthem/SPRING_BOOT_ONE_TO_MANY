package com.levanthem.supperApp.entity.bidirectional;

import com.levanthem.supperApp.infra.JPAUtil;
import com.sun.codemodel.JForEach;
import jakarta.persistence.EntityManager;

import java.sql.SQLOutput;
import java.util.List;

public class MainBiOneMany {
    //psvm tab
    static void main() {
//        createMajorStudent() ;
        getAll() ;
    }


    public static void getAll(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Major se = entityManager.find(Major.class,"SE");

        System.out.println("The SE Major info: " + se);
        List<Student> students = se.getStudents();
        //in bang bieu thuc lamda
        System.out.println(" The student List:");
        students.forEach(  nt -> System.out.println(nt)); // goi tham ten em tostring xin cua Student

    }

    public static void createMajorStudent(){
        Major se = new Major("SE", "Software Engineering");
        Major gd = new Major("GD", "Graphic Design");

        Student an = new Student("SE100", "AN NGUYEN", 1983,8.0);
        Student binh = new Student("SE101", "BINH LE", 1984,8.8);
        Student hung = new Student("GD100", "HUNG TRAN", 1987,9.0);
        Student dung = new Student("GD101", "DUNG PHAM", 1988,9.8);

        se.addStudent(an);
        se.addStudent(binh);
        gd.addStudent(hung);
        gd.addStudent(dung);

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(se);
        entityManager.persist(gd);
        entityManager.getTransaction().commit();
        entityManager.close();    }
}
