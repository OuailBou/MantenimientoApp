package com.example.mantenimiento.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class TipoPieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "id_tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pieza> piezas;

    protected TipoPieza() {
    }

    public TipoPieza(String nombre) {
        this.nombre = nombre;
    }
}
