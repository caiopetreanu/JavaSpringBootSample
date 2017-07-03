package br.com.caiopetreanu.AvenueCodeRecruitment.controller;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */

import br.com.caiopetreanu.AvenueCodeRecruitment.model.Image;
import br.com.caiopetreanu.AvenueCodeRecruitment.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/image")
public class ImageController {

    @Autowired
    ImageService ps;

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Image get(@PathParam("id") Long id) {
        return ps.get(id);
    }

    // 2) Create images
    // 2) Update images
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Image saveOrUpdate(Image i) {
        return ps.saveOrUpdate(i);
    }

    // 2) Delete images
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String delete(@PathParam("id") Long id) {
        ps.delete(id);
        return "Register removed";
    }

}