package StudentDemo;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {

                session.beginTransaction();

                List<Student> theStudent = session.createQuery("from Student").list();

                extracted(theStudent);

                theStudent = session.createQuery("from Student s where s.lastName='kumar'").list();

                extracted(theStudent);

                theStudent = session.createQuery("from Student s where s.lastName='kumar' and s.email LIKE '%gmail.com'").list();

                extracted(theStudent);

                session.getTransaction().commit();


            }finally {
                factory.close();
            }



        }

    private static void extracted(List<Student> theStudent) {
        for(Student student: theStudent){
            System.out.println(student);
        }
    }
}

