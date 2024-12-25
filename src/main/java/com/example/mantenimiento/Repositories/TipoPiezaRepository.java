package com.example.mantenimiento.Repositories;

import com.example.mantenimiento.Entities.TipoPieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoPiezaRepository extends JpaRepository<TipoPieza, Long> {
}
