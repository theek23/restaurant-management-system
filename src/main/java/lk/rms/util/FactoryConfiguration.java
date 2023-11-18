package lk.rms.util;

import lk.rms.entity.Item;
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

        properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));

        Configuration configuration = new Configuration().mergeProperties(properties)
                .addAnnotatedClass(Item.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static  FactoryConfiguration getInstance(){
        return factoryConfiguration == null? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
