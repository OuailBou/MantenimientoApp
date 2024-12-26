package com.example.mantenimiento.Services;

import com.example.mantenimiento.Entities.Pieza;
import com.example.mantenimiento.Repositories.PiezaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
public class PiezaService {

    private static final Logger logger = LoggerFactory.getLogger(PiezaService.class);
    private final PiezaRepository piezaRepository;

    @Autowired
    public PiezaService(PiezaRepository piezaRepository) {
        this.piezaRepository = Objects.requireNonNull(piezaRepository, "El repositorio no puede ser nulo");

    }

    @Transactional
    public void crearPieza(Pieza pieza) {
        validarPieza(pieza);
        piezaRepository.save(pieza);
        logger.info("Pieza creada exitosamente: {}", pieza);
    }

    @Transactional
    public void eliminarPieza(Long id) {
        logger.info("Eliminando pieza con ID {}", id);
        if (!piezaRepository.existsById(id)) {
            logger.error("La pieza con ID {} no existe", id);
            throw new EntityNotFoundException("La pieza con ID " + id + " no existe");
        }
        piezaRepository.deleteById(id);
        logger.info("Pieza con ID {} eliminada exitosamente", id);
    }

    @Transactional
    public void modificarPieza(Long id, String nombre, String fabricante) {
        Pieza pieza = piezaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("La pieza con ID " + id + " no existe"));
        validarPieza(pieza);
        pieza.setNombre(nombre);
        pieza.setFabricante(fabricante);
        logger.info("Pieza con ID {} modificada exitosamente", id);
    }

    private void validarPieza(Pieza pieza) {
        Objects.requireNonNull(pieza, "La pieza no puede ser nula");
        if (pieza.getNombre() == null || pieza.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la pieza no puede ser nulo ni estar vacío");
        }
        if (pieza.getFabricante() == null || pieza.getFabricante().isBlank()) {
            throw new IllegalArgumentException("El fabricante de la pieza no puede ser nulo ni estar vacío");
        }
    }
}
