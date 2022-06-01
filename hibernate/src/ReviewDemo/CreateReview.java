package ReviewDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReview {
        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).
                    addAnnotatedClass(Review.class).
                    addAnnotatedClass(InstructorDetail.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {

                session.beginTransaction();

                Course course = new Course("JAVAX");

                course.addReview(new Review("Great for application development"));
                course.addReview(new Review("super great for development"));
                course.addReview(new Review("Good"));


                session.save(course);



                session.getTransaction().commit();

                System.out.println("Done");

            }finally {

                session.close();
                factory.close();
            }



        }
    }


