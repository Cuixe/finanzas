package com.cuixe.finanzas.adapters.rest;

import com.cuixe.finanzas.TransaccionService;
import com.cuixe.finanzas.domain.Transaccion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping
    public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {
        return ResponseEntity.ok(transaccionService.crearTransaccion(transaccion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerTransaccion(@PathVariable Long id) {
        Optional<Transaccion> transaccionOptional = transaccionService.obtenerTransaccionPorId(id);
        if (transaccionOptional.isPresent()) {
            return ResponseEntity.ok(transaccionOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tarjeta/{tarjetaId}")
    public ResponseEntity<List<Transaccion>> obtenerTransaccionesPorTarjeta(@PathVariable Long tarjetaId) {
        return ResponseEntity.ok(transaccionService.obtenerTransaccionesPorTarjeta(tarjetaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> actualizarTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        transaccion.setId(id); // Asegura que el ID sea el correcto
        return ResponseEntity.ok(transaccionService.actualizarTransaccion(transaccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}