package com.cuixe.finanzas.ports;

import com.cuixe.finanzas.domain.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaJpaRepository extends JpaRepository<Tarjeta, Long> {
    List<Tarjeta> findByUsuarioId(Long usuarioId);
}