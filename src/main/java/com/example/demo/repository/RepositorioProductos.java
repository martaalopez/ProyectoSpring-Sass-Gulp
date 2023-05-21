package com.example.demo.repository;

import com.example.demo.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositorioProductos  extends JpaRepository<Producto,Long> {
    /*LONG ES UNA RESERVA DE MEMORIA*/
    @Query(value="select * from productos",nativeQuery = true)//se extrae lo de la consulta ,es como escribir en la consola*/
    public List<Producto> FindAll();

    @Query(value="select *from productos where id=?1",nativeQuery = true)
    public Optional<Producto> FindByID(int id);



}
