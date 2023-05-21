package com.example.demo.controllers;

import com.example.demo.model.Producto;
import com.example.demo.model.Proveedor;
import com.example.demo.services.ServiceProductos;
import com.example.demo.services.ServiceProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@org.springframework.stereotype.Controller
public class Controller {
    private final ServiceProductos serviceProductos;
    private  final ServiceProveedor serviceProveedor;

    @Autowired
    public Controller(ServiceProductos serviceProductos, ServiceProveedor serviceProveedor ) {
        this.serviceProductos = serviceProductos;
        this.serviceProveedor=serviceProveedor;
    }

    @GetMapping("/show")
    public String mostrarProductos(Model model) {
        List<Producto> productos = serviceProductos.getAllProductos();
        model.addAttribute("titulo", "listado de productos");
        model.addAttribute("productos", productos);
        return "mostrar";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Producto producto = new Producto();
        model.addAttribute("titulo", "Nuevo producto");
        model.addAttribute("producto", producto);
        return "frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("producto") Producto producto) {
        serviceProductos.guardar(producto);
        System.out.println("Producto guardado ");
        return "redirect:/show";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idProducto, Model model) {
        Producto producto = serviceProductos.findProducto(idProducto);
        model.addAttribute("titulo", "Editar producto");
        model.addAttribute("producto", producto);
        return "frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idProducto) {
        serviceProductos.deleteProduct(idProducto);
        System.out.println("Producto eliminado");
        return "redirect:/show";
    }

    @GetMapping("/mostrarProveedor")
    public String mostrarProveedores(Model model) {
        List<Proveedor> proveedores = serviceProveedor.getAllProveedor();
        List<Producto> productos = serviceProductos.getAllProductos();
        model.addAttribute("titulo", "Listado de proveedores");
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("productos", productos); // Agregar la lista de productos al modelo
        model.addAttribute("proveedor", new Proveedor()); // Agregar un proveedor vacío para el formulario
        return "crearProv";
    }
    // Controlador
    @PostMapping("/mostrarProveedor")
    public String crearProveedor(@ModelAttribute("proveedor") Proveedor proveedor, @RequestParam("productoId") int productoId, Model model) {
        Producto producto = serviceProductos.findProducto(productoId);
        if (producto != null && !proveedor.getProductos().contains(producto)) {
            proveedor.getProductos().add(producto);
        }

        serviceProveedor.guardar(proveedor);
        List<Proveedor> proveedores = serviceProveedor.getAllProveedor();
        List<Producto> productos = serviceProductos.getAllProductos();
        model.addAttribute("titulo", "Listado de proveedores");
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("productos", productos);
        model.addAttribute("proveedor", new Proveedor());

        System.out.println("Proveedor guardado");
        return "crearProv";
    }

    @PostMapping("/saveProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        serviceProveedor.guardar(proveedor);
        System.out.println("Proveedor guardado ");
        return "mostrarProv";
    }

}

