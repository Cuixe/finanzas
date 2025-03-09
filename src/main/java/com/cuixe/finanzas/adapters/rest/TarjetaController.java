package com.cuixe.finanzas.adapters.rest;

import com.cuixe.finanzas.TarjetaService;
import com.cuixe.finanzas.domain.Tarjeta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {
    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @PostMapping
    public ResponseEntity<Tarjeta> crearTarjeta(@RequestBody Tarjeta tarjeta) {
        return ResponseEntity.ok(tarjetaService.crearTarjeta(tarjeta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarjeta> obtenerTarjeta(@PathVariable Long id) {
        Optional<Tarjeta> tarjetaOptional = tarjetaService.obtenerTarjetaPorId(id);
        if (tarjetaOptional.isPresent()) {
            return ResponseEntity.ok(tarjetaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Tarjeta>> obtenerTarjetasPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(tarjetaService.obtenerTarjetasPorUsuario(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarjeta> actualizarTarjeta(@PathVariable Long id, @RequestBody Tarjeta tarjeta) {
        tarjeta.setId(id); // Asegura que el ID sea el correcto
        return ResponseEntity.ok(tarjetaService.actualizarTarjeta(tarjeta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarjeta(@PathVariable Long id) {
        tarjetaService.eliminarTarjeta(id);
        return ResponseEntity.noContent().build();
    }
}