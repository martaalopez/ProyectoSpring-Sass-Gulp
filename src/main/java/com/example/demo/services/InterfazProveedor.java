package com.example.demo.services;

import com.example.demo.model.Proveedor;

import java.util.List;

public interface InterfazProveedor {
    List<Proveedor> getAllProveedor();

    void guardar(Proveedor proveedor);

    Proveedor findProveedor(int id);

    void addProduct(String nombre, int telefono);

    void addProveedor(String nombre, int telefono);

    void deleteProveedor(int id);

    void editProveedor(int id, String nombre, int telefono);
}
