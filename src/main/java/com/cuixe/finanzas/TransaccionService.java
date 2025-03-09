package com.cuixe.finanzas;

import com.cuixe.finanzas.domain.Transaccion;
import com.cuixe.finanzas.ports.TransaccionJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService { // Eliminamos "implements TransaccionService"
    private final TransaccionJpaRepository transaccionRepository;

    public TransaccionService(TransaccionJpaRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Optional<Transaccion> obtenerTransaccionPorId(Long id) {
        return transaccionRepository.findById(id);
    }

    public List<Transaccion> obtenerTransaccionesPorTarjeta(Long tarjetaId) {
        return transaccionRepository.findByTarjetaId(tarjetaId);
    }

    public Transaccion actualizarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}