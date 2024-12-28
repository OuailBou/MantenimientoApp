package com.example.mantenimiento.Entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fabricante;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private TipoPieza id_tipo;


    protected Pieza() {

    }

    public Pieza(String nombre, String fabricante, TipoPieza tipoPieza) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.id_tipo = tipoPieza;
    }







}
