package com.example.demo.services;

import com.example.demo.model.Producto;
import com.example.demo.repository.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductos implements InterfazProductos {
    private final RepositorioProductos productoRepositorio;

    @Autowired
    public ServiceProductos(RepositorioProductos productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public Producto findProducto(int id) {
        return productoRepositorio.findById((long) id).orElse(null);
    }

    @Override
    public void addProduct(String nombre, double precio, String tipo) {
        Producto producto = new Producto(nombre, precio, tipo);
        productoRepositorio.save(producto);
    }

    @Override
    public void deleteProduct(int id) {
        productoRepositorio.deleteById((long) id);
    }

    @Override
    public void editProduct(int id, String nombre, double precio, String tipo) {
        Producto producto = productoRepositorio.findById((long) id).orElse(null);
        if (producto != null) {
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setTipo(tipo);
            productoRepositorio.save(producto);
        }
    }
}
