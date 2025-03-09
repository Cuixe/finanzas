package com.cuixe.finanzas.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarjeta")
@Data
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(length = 100)
    private String banco;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTarjeta tipo;
    @Column(name = "numero_tarjeta", length = 20, nullable = false)
    private String numeroTarjeta;
    @Column(name = "fecha_corte")
    private Date fechaCorte;
    @Column(name = "fecha_pago")
    private Integer fechaPago;
    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal limiteCredito;
    @Column(name = "saldo_actual", precision = 15, scale = 2)
    private BigDecimal saldoActual = BigDecimal.ZERO;
    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaccion> transacciones;
}