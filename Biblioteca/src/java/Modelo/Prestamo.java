/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CRISTIAN
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByIdPrestamos", query = "SELECT p FROM Prestamo p WHERE p.idPrestamos = :idPrestamos")
    , @NamedQuery(name = "Prestamo.findByFechaPrestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "Prestamo.findByFechaDevolucion", query = "SELECT p FROM Prestamo p WHERE p.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Prestamo.findByUsuarioIdUsuario", query = "SELECT p FROM Prestamo p WHERE p.usuarioIdUsuario = :usuarioIdUsuario")
    , @NamedQuery(name = "Prestamo.findByLibroIdLibro", query = "SELECT p FROM Prestamo p WHERE p.libroIdLibro = :libroIdLibro")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamos")
    private Integer idPrestamos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libro_id_libro")
    private int libroIdLibro;

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public Prestamo(Integer idPrestamos, Date fechaPrestamo, Date fechaDevolucion, int usuarioIdUsuario, int libroIdLibro) {
        this.idPrestamos = idPrestamos;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.libroIdLibro = libroIdLibro;
    }

    public Integer getIdPrestamos() {
        return idPrestamos;
    }

    public void setIdPrestamos(Integer idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getLibroIdLibro() {
        return libroIdLibro;
    }

    public void setLibroIdLibro(int libroIdLibro) {
        this.libroIdLibro = libroIdLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamos != null ? idPrestamos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamos == null && other.idPrestamos != null) || (this.idPrestamos != null && !this.idPrestamos.equals(other.idPrestamos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Prestamo[ idPrestamos=" + idPrestamos + " ]";
    }
    
}
