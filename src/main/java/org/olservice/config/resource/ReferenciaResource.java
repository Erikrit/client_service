package org.olservice.config.resource;

import org.olservice.config.model._Referencia;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ReferenciaResource extends JpaRepository<_Referencia,Long> {
}
