package StudentDemo;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {



    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
            buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {
        System.out.println("Creating new Student object");
            Student student1 = new Student("Santosh","Kumar","santoshkumar@gmail.com");

            Student student2 = new Student("veda","Kumar","vedakumar@gmail.com");

            Student student3 = new Student("damini","Kumari","daminikumari@gmail.com");

            session.beginTransaction();
        System.out.println("Saving the student...");
        session.save(student1);
            session.save(student2);
            session.save(student3);
        session.getTransaction().commit();
        System.out.println("Done");

    }finally {
        factory.close();
    }
}}
