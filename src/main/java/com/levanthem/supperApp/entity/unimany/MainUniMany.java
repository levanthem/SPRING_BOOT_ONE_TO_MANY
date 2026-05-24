package com.levanthem.supperApp.entity.unimany;

import com.levanthem.supperApp.infra.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.lang.model.util.SimpleElementVisitor14;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MainUniMany {
    static void main() {
        createMajorStudents();
    }



    public static void createMajorStudents(){
       Major seMajor = new Major("SE", "Software Engineering");
       Student sv1 = new Student("SE100","THEM LE",1987,7.9);
       Student sv2 = new Student("SE101","BINH LE",2002,8.7);

        sv1.setMajor(seMajor);
        sv2.setMajor(seMajor);

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(seMajor);  // lưu majỏ trước

        entityManager.persist(sv1);     // luu student sau, ko do dominno duoc, chi domino tu one
        entityManager.persist(sv2);   // DOMINO 1-N

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
