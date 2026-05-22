package com.levanthem.supperApp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // class nay chiu trach nhiem ket noi csdl, thong qua doi tong entity-fatory-management
    //hao ram, ton thoi gian tao ket noi sql server /mysql--> heavy class
    // nen tao som va chi nen co 1 lan trong ram, 1 vung ram, 1 object, singleton
    //chua ke moi lan tao ra no co the tao moi table luon (create)
    //hoac scan lai cau truc table xem co thay doi ko de cap nhat (update)

    // ky thuat viet code ma khien cho class khong new duoc lan thu 2, ko duoc new nhieu object, Lo may goi nhieu lan calss nay
    // cung chi co 1 vung new duoc tao ra,
    //STATIC + private constructor
    // 1 class ko co constructor JVM se tu tao giup 1 constructor rong
    private static final EntityManagerFactory emf;
    //duy tri ket noi csdl , heavy class nam day

    // class nay cham truoc thi bien nay duoc goi truoc
    static{
        try{
            emf = Persistence.createEntityManagerFactory("com.levanthem.superApp-PU");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private JPAUtil(){

    }
    // co ong nha xuong roi , goi ong chu ra quan ly @entity
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    // ham nay thi nhom repository se goi den nho va
}
