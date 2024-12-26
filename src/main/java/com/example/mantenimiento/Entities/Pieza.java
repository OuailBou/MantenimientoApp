package com.example.mantenimiento.Entities;
import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

@Entity
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fabricante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public TipoPieza getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(TipoPieza id_tipo) {
        this.id_tipo = id_tipo;
    }

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
