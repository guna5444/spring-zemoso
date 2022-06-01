package InstructorDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
                    addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {


                session.beginTransaction();

                int theId=4;

                Instructor instructor = session.get(Instructor.class,theId);

                session.delete(instructor);

                session.getTransaction().commit();

                System.out.println("Done");

            }finally {
                factory.close();
            }



        }
    }



