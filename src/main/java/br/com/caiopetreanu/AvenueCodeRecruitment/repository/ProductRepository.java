package br.com.caiopetreanu.AvenueCodeRecruitment.repository;

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

}