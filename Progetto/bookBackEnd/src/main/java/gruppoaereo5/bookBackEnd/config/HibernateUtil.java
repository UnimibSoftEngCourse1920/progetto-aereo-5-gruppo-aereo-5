package gruppoaereo5.bookBackEnd.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import gruppoaereo5.bookBackEnd.dto.CartaFedelta;
import gruppoaereo5.bookBackEnd.dto.Posto;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;
import gruppoaereo5.bookBackEnd.dto.User;
import gruppoaereo5.bookBackEnd.dto.Volo;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:.//localhost/~/bookPlaneTicket");
                settings.put(Environment.USER, "gruppo5");
                settings.put(Environment.PASS, "progetto");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

               // settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(CartaFedelta.class);               
                configuration.addAnnotatedClass(Prenotazione.class);
                configuration.addAnnotatedClass(Volo.class);
                configuration.addAnnotatedClass(Posto.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}