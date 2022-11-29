package com.isupov.api;

import com.isupov.model.Product;
import com.isupov.model.ProductDAOImpl;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductDAOImpl service;

    public ProductController(ProductDAOImpl service) {
        this.service = service;
    }


    @PostConstruct
    public void init() {
//        service.addNewProduct(new Product("Apple", 100));
//        service.addNewProduct(new Product("Orange", 55));
//        service.addNewProduct(new Product("Cucumber", 44));
//        service.addNewProduct(new Product("Onion", 45));
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        List<Product> products = service.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        Product product = service.findById(id);
        return product;
        //не доделал чтобы фронт отображал, не понимаю как сделать на фронте. нужен новый контролле и новая страница или можно все там же??
    }



    @GetMapping("/add")
    public void testAdd(@RequestParam String title, Integer cost) {
    service.addNewProduct(new Product(title,cost));
    }

    @GetMapping("/delete/{id}")
    public void deleteProducts(@PathVariable Long id) {
        service.deleteById(id);
    }

}
