package CourseDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {
        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).
                    addAnnotatedClass(InstructorDetail.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {

                session.beginTransaction();
                int theId=4;
                Instructor instructor = session.get(Instructor.class,theId);

                Course course1 = new Course("JAVA");
                Course course2 = new Course("Python");
                Course course3 = new Course("OOPS");

                instructor.add(course1);
                instructor.add(course2);
                instructor.add(course3);

                session.save(course1);
                session.save(course2);
                session.save(course3);

                session.getTransaction().commit();

                System.out.println("Done");

            }finally {

                session.close();
                factory.close();
            }



        }
    }


