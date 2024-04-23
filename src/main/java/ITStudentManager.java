/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 19-Apr-24 2:40 PM
 * @project PracticeDatabase
 * @since ${11.0.18}
 */
import javax.persistence.*;

import jdk.jfr.Event;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class ITStudentManager {
    //declare hibernate session factory
    private SessionFactory sessionFactory;
    protected void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Event.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    protected void exit()  {
        try {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        } catch (Throwable e) {
            // Handle HibernateException (e.g., log the error)
            System.err.println("Error occurred while closing Hibernate SessionFactory: " + e.getMessage());
            // Optionally, rethrow as RuntimeException or handle accordingly
            // throw new RuntimeException(e);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)  {
        ITStudentManager manager = new ITStudentManager();
        manager.setUp();
       manager.exit();


    }
}
