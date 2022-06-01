package CourseDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).
                    addAnnotatedClass(InstructorDetail.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {

                session.beginTransaction();

                int theId=4;

                Instructor instructor = session.get(Instructor.class , theId);

                System.out.println(instructor.getCourses());



                session.getTransaction().commit();

                System.out.println("Done");

            }finally {

                session.close();
                factory.close();
            }

        }
    }


