package com.labs.utils;
import com.labs.models.Hotel;
import com.labs.models.HotelReview;
import com.labs.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class Hibernate {
    private static SessionFactory sessionFactory;

    private Hibernate() {}

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");

        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:H://4 курс//Java//Lab5_final//java_db");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "");

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().addProperties(properties);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Hotel.class);
                configuration.addAnnotatedClass(HotelReview.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(properties);
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}
