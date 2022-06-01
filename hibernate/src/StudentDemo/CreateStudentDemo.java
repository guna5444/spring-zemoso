package StudentDemo;

import Entity.Student;
import org.hibernate.Session;
import  org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object");
            Student student = new Student("Anilkumar","dama","damaanilkumar@gmail.com");

            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            factory.close();
        }

    }
}
