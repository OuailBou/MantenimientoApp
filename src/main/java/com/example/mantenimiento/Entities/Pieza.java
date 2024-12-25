package com.example.mantenimiento.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(exclude = "id_tipo") // Evitar bucles en toString si hay relaciones bidireccionales
@EqualsAndHashCode
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String fabricante;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoPieza id_tipo;

    protected Pieza() {

    }

    public Pieza(String nombre, String fabricante, TipoPieza tipoPieza) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.id_tipo = tipoPieza;
    }
}
