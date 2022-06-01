package InstructorDemo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
                    addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {
                System.out.println("Creating new Instructor object");

                Instructor instructor = new Instructor("TestAnil","Kumar","damaanilkumar@gmail.com");

                InstructorDetail instructorDetail = new InstructorDetail("DAMA ANILKUMAR","Coding");

                instructor.setInstructorDetailId(instructorDetail);

                session.beginTransaction();

                System.out.println("Saving the Instructor...");

               session.save(instructor);

                session.getTransaction().commit();

                System.out.println("Done");

            }finally {
                factory.close();
            }



        }
    }


