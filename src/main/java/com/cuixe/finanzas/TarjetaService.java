package com.cuixe.finanzas;

import com.cuixe.finanzas.domain.Tarjeta;
import com.cuixe.finanzas.ports.TarjetaJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaService {
    private final TarjetaJpaRepository tarjetaRepository;

    public Optional<Tarjeta> obtenerTarjetaPorId(Long id) {
        return tarjetaRepository.findById(id);
    }

    public TarjetaService(TarjetaJpaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    public Tarjeta crearTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public List<Tarjeta> obtenerTarjetasPorUsuario(Long usuarioId) {
        return tarjetaRepository.findByUsuarioId(usuarioId);
    }

    public Tarjeta actualizarTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public void eliminarTarjeta(Long id) {
        tarjetaRepository.deleteById(id);
    }

}