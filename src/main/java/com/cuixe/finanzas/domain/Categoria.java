package com.cuixe.finanzas.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "categoria")
    private List<Transaccion> transacciones;
}