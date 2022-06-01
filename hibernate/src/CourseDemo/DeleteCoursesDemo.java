package CourseDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).
                    addAnnotatedClass(InstructorDetail.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {

                session.beginTransaction();

               int theId=2;

               Course course = session.get(Course.class,theId);

                session.delete(course);

                session.getTransaction().commit();

                System.out.println("Done");

            }finally {

                session.close();
                factory.close();
            }



        }
    }


