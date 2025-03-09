package com.cuixe.finanzas.ports;

import com.cuixe.finanzas.domain.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionJpaRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByTarjetaId(Long tarjetaId);
}