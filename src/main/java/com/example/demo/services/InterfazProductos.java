package com.example.demo.services;
import com.example.demo.model.Producto;
import java.util.List;

public interface  InterfazProductos {

List<Producto> getAllProductos();

    void guardar(Producto producto);

    public Producto findProducto(int id);
void addProduct(String nombre,double precio,String tipo);
void deleteProduct(int id);
void editProduct(int id,String nombre,double precio,String tipo);

}
