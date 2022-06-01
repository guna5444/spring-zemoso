package StudentDemo;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object");
            Student student = new Student("Daffy","Duck","damaanilkumar@gmail.com");

            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done");

            System.out.println("Saved Student id:" + student.getId());

            session = factory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Getting student id"+ student.getId());

            Student myStudent = session.get(Student.class , student.getId());

            System.out.println("Get complete"+myStudent);

            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            factory.close();
        }



    }
}
