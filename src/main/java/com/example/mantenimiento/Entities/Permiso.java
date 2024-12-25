package com.example.mantenimiento.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Permiso {

    // Getters y setters
    @EmbeddedId
    private PermisoId id; // Clave compuesta

    @ManyToOne
    @MapsId("rolName") // Vincula rolName de la clave compuesta con la entidad Rol
    @JoinColumn(name = "rolName", nullable = false)
    private Rol rol;

    private boolean acceso;
    private boolean modificacion;

    // Constructor vacío
    protected Permiso() {
    }

    // Constructor con parámetros
    public Permiso(PermisoId id, Rol rol, boolean acceso, boolean modificacion) {
        this.id = id;
        this.rol = rol;
        this.acceso = acceso;
        this.modificacion = modificacion;
    }

}
