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
import java.util.List;

@Component
@Path("/images")
public class ImagesController {

    @Autowired
    ImageService ps;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Image> list() {
        return ps.list();
    }

}