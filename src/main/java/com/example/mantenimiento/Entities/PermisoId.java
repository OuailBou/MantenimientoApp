package com.example.mantenimiento.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PermisoId implements Serializable {

    private String rolName; // Clave foránea hacia Rol
    private String pantalla; // Identificador de la pantalla

    // Getters y setters
    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisoId that = (PermisoId) o;
        return Objects.equals(rolName, that.rolName) && Objects.equals(pantalla, that.pantalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolName, pantalla);
    }
}
