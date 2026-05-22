package com.levanthem.supperApp.entity.unione;

import com.levanthem.supperApp.infra.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {
    // Nho va JpaUtil
    static void main() {
        createMajorStudents();

    }
    public static void createMajorStudents(){
        // ta tao chuyen nganh SE va 2 sinh vien cua chuyen nganh nay
//        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | Ky thuat phan mem") ;
        Major beMajor = new Major("BE", "SOFTWARE ENGINEERING | Ky thuat phan mem") ;
//        Student s1 = new Student("SE100", "AN NGUYỄN",1981,8.0);
//        Student s2 = new Student("SE101", "BÌNH LÊ",1983,9.0);

        Student s3 = new Student("BE100", "NGOC NGUYỄN",1981,8.8);
        Student s4 = new Student("BE101", "THEM LÊ",1983,9.9);
        // seMaor can add 2 student s1, s2 vào cái List Students
        // Xuong db do domino , casecade 1 major , N student xuông luôn theo one di xún , manu di theo
//        seMajor.addStudent(s1);
//        seMajor.addStudent(s2);
        beMajor.addStudent(s3);
        beMajor.addStudent(s4);
        // OOP da xong relationship
        // Do domino casade
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(seMajor);  // maJor điĩuong 2 student di theo
        entityManager.persist(beMajor);  // maJor điĩuong 2 student di theo
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
