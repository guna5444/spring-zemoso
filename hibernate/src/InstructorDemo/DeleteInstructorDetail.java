package InstructorDemo;

import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {


        public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
                    addAnnotatedClass(InstructorDetail.class).
                    buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {


                session.beginTransaction();

                int theId=3;

                InstructorDetail instructorDetail= session.get(InstructorDetail.class,theId);

                System.out.println(instructorDetail);

                System.out.println(instructorDetail.getInstructor());

                instructorDetail.getInstructor().setInstructorDetailId(null);

                session.delete(instructorDetail);

                session.getTransaction().commit();

                System.out.println("Done");

            }
            catch(Exception exc){
                exc.printStackTrace();
            }
            finally {
                session.close();
                factory.close();
            }



        }
    }

