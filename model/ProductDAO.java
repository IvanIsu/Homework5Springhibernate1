package com.isupov.model;

import java.util.List;

public interface ProductDAO {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Long id, Integer cost);

}
