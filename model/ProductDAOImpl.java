package com.isupov.model;

import com.isupov.service.ServiceConnection;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductDAOImpl implements ProductDAO {

    private ServiceConnection serviceConnection;

    public ProductDAOImpl(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }


    @Override
    public Product findById(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {

        Session session = serviceConnection.getSession();
        session.beginTransaction();

        List<Product> products = session.createCriteria(Product.class).list();
        //что лучше использовать вместо этого устаревшего метода?
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.remove(product);
        session.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdate(Long id, Integer cost) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setCost(cost);
        session.getTransaction().commit();
        return product;
    }

    public void addNewProduct(Product product) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }
}
