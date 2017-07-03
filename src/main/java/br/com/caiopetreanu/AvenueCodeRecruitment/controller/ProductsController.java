package br.com.caiopetreanu.AvenueCodeRecruitment.controller;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Image;
import br.com.caiopetreanu.AvenueCodeRecruitment.model.Product;
import br.com.caiopetreanu.AvenueCodeRecruitment.service.ImageService;
import br.com.caiopetreanu.AvenueCodeRecruitment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/products")
public class ProductsController {

    @Autowired
    ProductService ps;

    @Autowired
    ImageService is;

    // 3) Get all products excluding relationships (child products, images)
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> list() {
        return ps.list();
    }

    // 4) Get all products including specified relationships (child product and/or images)
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> listEvalRelationship() {

        ArrayList<Product> ps = new ArrayList<>();

        for (Product p : this.ps.list()) {

            Long parentId = p.getParentProductId();

            if (parentId != null) {

                List<Product> parents = this.ps.getByParentProductId(parentId);

                for (Product parent : parents) {
                    p.addParentProduct(parent);
                }

            }

            List<Image> images = is.getByProductId(p.getId());

            if(images != null) {
                for (Image i : images) {
                    p.addImages(i);
                }
            }

            ps.add(p);

        }

        return ps;

    }

}