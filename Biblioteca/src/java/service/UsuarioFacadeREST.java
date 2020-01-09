/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author CRISTIAN
 */
@Stateless
@Path("modelo.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }
    
    @POST 
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearUser(@FormParam ("id_usuario") Integer idU, @FormParam ("cedula") String Ced, @FormParam ("nombre") String Nom, @FormParam ("apellido") String Apell, @FormParam ("direccion") String Dire, @FormParam ("telefono") String Tel, @FormParam ("correo") String Corr, @FormParam ("tipo") Integer Tip){
        Usuario user= new Usuario();
        user.setIdUsuario(idU); 
        user.setCedula(Ced);
        user.setNombre(Nom);
        user.setApellido(Apell);
        user.setDireccion(Dire);
        user.setTelefono(Tel);
        user.setCorreo(Corr);
        user.setTipo(Tip);        
        super.create(user);
        return "Usuario Creado";
    }
    
    @POST 
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON}) 
    public String EditarUser(@FormParam("id_usuario") Integer idU, @FormParam ("cedula") String Ced, @FormParam ("nombre") String Nom, @FormParam ("apellido") String Apell, @FormParam ("direccion") String Dire, @FormParam ("telefono") String Tel, @FormParam ("correo") String Corr, @FormParam ("tipo") Integer Tip){
        Usuario user;
        user=super.find(idU);
        user.setCedula(Ced);
        user.setNombre(Nom);
        user.setApellido(Apell);
        user.setDireccion(Dire);
        user.setTelefono(Tel);
        user.setCorreo(Corr);
        user.setTipo(Tip); 
        super.edit(user);
        return "Usuario Editado";
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @POST
    @Path("obtenerUsuario")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Usuario Obtener(@FormParam("idUser") Integer idU){
        return super.find(idU);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    } 
    
    @POST
    @Path("post")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll1() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
