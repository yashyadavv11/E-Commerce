package com.project.util;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.project.model.Cart;
import com.project.model.Customers;
import com.project.model.Order_items;
import com.project.model.Orders;
import com.project.model.Products;

public class DBConnection {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost/montran1");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Products.class);
                configuration.addAnnotatedClass(Customers.class);
                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(Order_items.class);
                configuration.addAnnotatedClass(Orders.class);

                
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                
            } catch (Exception e) {
                e.printStackTrace();
                throw new ExceptionInInitializerError("Initial SessionFactory creation failed." + e);
            }
        }
        return sessionFactory;
    }
}