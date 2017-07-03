package br.com.caiopetreanu.AvenueCodeRecruitment.service;

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Image;
import br.com.caiopetreanu.AvenueCodeRecruitment.repository.ImageRepository;
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
public class ImageService {

    @Autowired
    private ImageRepository ir;

    @Autowired
    private ProductRepository pr;

    @Transactional
    public List<Image> list() {
        List<Image> images = new ArrayList<>();
        ir.findAll().forEach(images::add);
        return images;
    }

    @Transactional
    public Image get(Long id) {
        return ir.findOne(id);
    }

    @Transactional
    public Image saveOrUpdate(Image i) {
        ir.saveAndFlush(i);
        return i;
    }

    @Transactional
    public void delete(final Long id) {
        ir.delete(id);
    }

    @Transactional
    public List<Image> getByProductId(Long id) {
        Image i = new Image();
        i.setProductId(id);
        return ir.findAll(Example.of(i));
    }

}