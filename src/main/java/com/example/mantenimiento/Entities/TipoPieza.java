package com.example.mantenimiento.Entities;
import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

import java.util.List;


@Entity
public class TipoPieza {
    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo;
    private String nombre;

    @OneToMany(mappedBy = "id_tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pieza> piezas;

    protected TipoPieza() {
    }

    public TipoPieza(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id_tipo+" "+nombre;
    }
}
