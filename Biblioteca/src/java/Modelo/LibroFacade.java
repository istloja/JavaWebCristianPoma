/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author CRISTIAN
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroFacade() {
        super(Libro.class);
    }

    public List<Libro> Libros() {
        int valor=1;
        List<Libro> libro = null;
        TypedQuery<Libro> consulta=getEntityManager().createQuery("SELECT l FROM Libro l WHERE l.idLibro = :idLibro",Libro.class);
        consulta.setParameter("idLibro", valor);
        libro=consulta.getResultList();
        return libro;
    }
}
