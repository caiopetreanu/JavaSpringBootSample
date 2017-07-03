package br.com.caiopetreanu.AvenueCodeRecruitment.repository;

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Transactional
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}