package com.example.mantenimiento.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol {

    @Id
    private String rolName;

    private String rolDes;



}
