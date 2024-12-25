package com.example.mantenimiento.Services;

import com.example.mantenimiento.Entities.Pieza;
import com.example.mantenimiento.Entities.TipoPieza;
import com.example.mantenimiento.Repositories.TipoPiezaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TipoPiezaService {

    private static final Logger logger = LoggerFactory.getLogger(TipoPiezaService.class);
    private final TipoPiezaRepository tipoPiezaRepository;

    @Autowired
    public TipoPiezaService(TipoPiezaRepository tipoPiezaRepository) {
        this.tipoPiezaRepository = Objects.requireNonNull(tipoPiezaRepository, "El repositorio no puede ser nulo");
    }

    @Transactional(readOnly = true)
    public List<TipoPieza> findAllTipoPiezas() {
        logger.info("Obteniendo todos los tipos de piezas");
        return tipoPiezaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Pieza> findPiezasByTipoId(Long id) {
        logger.info("Obteniendo piezas para el tipo de pieza con ID {}", id);
        TipoPieza tipo = tipoPiezaRepository.findById(id).orElseThrow(() -> {
            logger.error("El tipo de pieza con ID {} no existe", id);
            return new EntityNotFoundException("El tipo de pieza con ID " + id + " no existe");
        });

        if (tipo.getPiezas() == null || tipo.getPiezas().isEmpty()) {
            logger.warn("El tipo de pieza con ID {} no tiene piezas asociadas", id);
            return List.of(); // Devuelve una lista vacía en lugar de lanzar una excepción
        }

        return tipo.getPiezas();
    }
}
