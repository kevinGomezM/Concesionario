/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "tbl_vehiculo")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByCodigoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.codigoVehiculo = :codigoVehiculo"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByPrecio", query = "SELECT v FROM Vehiculo v WHERE v.precio = :precio")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoVehiculo")
    private Integer codigoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "codigoConcesionario", referencedColumnName = "nit")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Concesionario codigoConcesionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idVehiculo", fetch = FetchType.LAZY)
    private Ventas ventas;

    public Vehiculo() {
    }

    public Vehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public Vehiculo(Integer codigoVehiculo, String marca, int modelo, double precio) {
        this.codigoVehiculo = codigoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Integer getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Concesionario getCodigoConcesionario() {
        return codigoConcesionario;
    }

    public void setCodigoConcesionario(Concesionario codigoConcesionario) {
        this.codigoConcesionario = codigoConcesionario;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVehiculo != null ? codigoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.codigoVehiculo == null && other.codigoVehiculo != null) || (this.codigoVehiculo != null && !this.codigoVehiculo.equals(other.codigoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vehiculo[ codigoVehiculo=" + codigoVehiculo + " ]";
    }
    
}
