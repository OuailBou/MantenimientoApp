package com.example.mantenimiento.Repositories;


import com.example.mantenimiento.Entities.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiezaRepository extends JpaRepository<Pieza,Long> {



}
