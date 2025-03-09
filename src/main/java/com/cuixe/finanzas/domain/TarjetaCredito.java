package com.cuixe.finanzas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tarjeta")
public class TarjetaCredito extends Tarjeta{

    private BigDecimal totalPagar;

    private BigDecimal totalMesesSinIntereses;

    private BigDecimal calculateTotalPagar() {
        this.getTransacciones().forEach(transaccion -> {
            if (transaccion.getFechaTransaccion().equals(transaccion.getFechaTransaccion()) || transaccion.getFechaTransaccion().after(transaccion.getFechaTransaccion())) {
                totalPagar.add(transaccion.getMonto());
                if (totalMesesSinIntereses)
            }
        });
    }



}
