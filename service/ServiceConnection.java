package com.isupov.service;

import com.isupov.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Service;

@Service
public class ServiceConnection {
    private SessionFactory sessionFactory;

    public ServiceConnection() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
