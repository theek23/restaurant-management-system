package lk.rms.util;

import lk.rms.embedded.QTYDetail;
import lk.rms.entity.*;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    @SneakyThrows
    private FactoryConfiguration(){
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Configuration configuration = new Configuration().mergeProperties(properties)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(QtyDetails.class)
                .addAnnotatedClass(Supplier.class)
                .addAnnotatedClass(ItemCategory.class)
                .addAnnotatedClass(ItemSubCategory.class);
        sessionFactory = configuration.buildSessionFactory();


    }
    public static  FactoryConfiguration getInstance(){
        return factoryConfiguration == null? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
