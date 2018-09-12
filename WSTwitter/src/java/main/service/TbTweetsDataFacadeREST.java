/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import main.TbTweetsData;

/**
 *
 * @author nsand
 */

@Path("main.tbtweetsdata")
public class TbTweetsDataFacadeREST extends AbstractFacade<TbTweetsData> {

    @PersistenceContext(unitName = "twitterPU")
    public EntityManager em;
    

    public TbTweetsDataFacadeREST() {
        super(TbTweetsData.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TbTweetsData entity) {
        super.create(entity);
    }
/*
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TbTweetsData entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbTweetsData find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbTweetsData> findAll() {
        return super.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    */
    @GET
    @Path("topFollowers")
    @Produces({MediaType.APPLICATION_JSON})
    public String topFollowers() throws SQLException {
        return super.topFollowers();
    }
   @GET
    @Path("groupByDate")
    @Produces({MediaType.APPLICATION_JSON})
    public String groupByDate() throws SQLException {
        return super.groupPerHour();
    }
    @GET
    @Path("groupByLanguage")
    @Produces({MediaType.APPLICATION_JSON})
    public String groupByLanguage() throws SQLException {
        return super.groupByLanguage();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
