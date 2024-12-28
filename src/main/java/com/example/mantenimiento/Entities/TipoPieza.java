package com.example.mantenimiento.Entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class TipoPieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo;
    @Column(unique = true)
    private String nombre;

    @OneToMany(mappedBy = "id_tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pieza> piezas;

    protected TipoPieza() {
    }

    public TipoPieza(String nombre) {
        this.nombre = nombre;
    }

}
