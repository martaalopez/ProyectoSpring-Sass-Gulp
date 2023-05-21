package com.example.demo.repository;
import com.example.demo.model.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepositorioProveedores  extends JpaRepository<Proveedor,Long> {
    /*LONG ES UNA RESERVA DE MEMORIA*/
    @Query(value="select * from proveedores",nativeQuery = true)//se extrae lo de la consulta ,es como escribir en la consola*/
    public List<Proveedor> FindAll();

    @Query(value="select *from proveedores where id=?1",nativeQuery = true)
    public Optional<Proveedor> FindByID(int id);


    }

