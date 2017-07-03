package br.com.caiopetreanu.AvenueCodeRecruitment.service;

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Product;
import br.com.caiopetreanu.AvenueCodeRecruitment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    @Transactional
    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        pr.findAll().forEach(products::add);
        return products;
    }

    @Transactional
    public Product get(final Long id) {
        return pr.findOne(id);
    }

    @Transactional
    public Product saveOrUpdate(final Product p) {
        pr.saveAndFlush(p);
        return p;
    }

    @Transactional
    public void delete(final Long id) {
        pr.delete(id);
    }

    @Transactional
    public List<Product> getByParentProductId(final Long id) {
        Product p = new Product();
        p.setParentProductId(id);
        return pr.findAll(Example.of(p));
    }

}