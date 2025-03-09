package com.cuixe.finanzas.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaccion")
@Data
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tarjeta_id", nullable = false)
    private Tarjeta tarjeta;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransaccion tipo;
    private String descripcion;
    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal monto;
    @Column(name = "fecha_transaccion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;
    @Column(name = "meses_sin_intereses")
    private Integer mesesSinIntereses = 1;
}