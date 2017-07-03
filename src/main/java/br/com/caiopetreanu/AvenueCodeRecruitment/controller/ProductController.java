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

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/product/")
public class ProductController {

    @Autowired
    ProductService ps;

    @Autowired
    ImageService is;

    // 5) Same as 3 using specific product identity
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product get(@PathParam("id") Long id) {
        return ps.get(id);
    }

    // 1) Create products
    // 1) Update products
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Product saveOrUpdate(Product p) {
        return ps.saveOrUpdate(p);
    }

    // 1) Delete products
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String delete(@PathParam("id") Long id) {
        ps.delete(id);
        return "Register removed";
    }

    // 6) Same as 4 using specific product identity
    @GET
    @Path("/{id}/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Product getEvalRelationship(@PathParam("id") Long id) {

        Product p = ps.get(id);

        if(p.getParentProductId() != null) {

            List<Product> parents = this.ps.getByParentProductId(p.getParentProductId());

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

        return p;

    }

    // 7) Get set of child products for specific product
    @GET
    @Path("/{id}/children")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> listChildren(@PathParam("id") Long id) {
        return this.ps.getByParentProductId(id);

    }
    // 8) Get set of images for specific product
    @GET
    @Path("/{id}/images")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Image> listImages(@PathParam("id") Long id) {
        return this.is.getByProductId(id);
    }

}