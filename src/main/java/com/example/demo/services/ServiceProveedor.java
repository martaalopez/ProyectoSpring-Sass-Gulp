package com.example.demo.services;

import com.example.demo.model.Proveedor;
import com.example.demo.repository.RepositorioProveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceProveedor  implements InterfazProveedor{
    private final RepositorioProveedores proveedorRepositorio;

    @Autowired
    public ServiceProveedor(RepositorioProveedores proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
    }

    @Override
    public List<Proveedor> getAllProveedor() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public void guardar(Proveedor proveedor) {
        proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor findProveedor(int id) {
        return proveedorRepositorio.findById((long) id).orElse(null);
    }

    @Override
    public void addProduct(String nombre, int telefono) {

    }

    @Override
    public void addProveedor(String nombre, int telefono) {
        Proveedor proveedor= new Proveedor(nombre,telefono);
        proveedorRepositorio.save(proveedor);
    }

    @Override
    public void deleteProveedor(int id) {
        proveedorRepositorio.deleteById((long) id);
    }

    @Override
    public void editProveedor(int id, String nombre, int telefono) {
        Proveedor proveedor = proveedorRepositorio.findById((long) id).orElse(null);
        if (proveedor != null) {
            proveedor.setNombre(nombre);
            proveedor.setTelefono(telefono);
            proveedorRepositorio.save(proveedor);
        }
    }


}
