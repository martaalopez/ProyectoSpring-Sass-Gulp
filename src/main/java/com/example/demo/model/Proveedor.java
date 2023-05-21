package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data//lombok
@Entity//Es una entidad
@Table(name="proveedores")//Como quieres que se llame la tabla
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "nombre", nullable = false)
    public String nombre;

    @Column(name = "telefono")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private int telefono;

    @ManyToMany
    @JoinTable(name = "proveedores_producto",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "productoes_id"))
    private List<Producto> productoes = new ArrayList<>();

    public Proveedor(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Proveedor() {

    }
    public List<Producto> getProductos() {
        return this.productoes;
    }
}

