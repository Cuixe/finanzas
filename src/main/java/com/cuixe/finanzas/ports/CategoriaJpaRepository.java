package com.cuixe.finanzas.ports;

import com.cuixe.finanzas.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<Categoria, Long> {
}