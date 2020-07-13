package org.olservice.config.resource;

import org.olservice.config.model._Anexos;
import org.olservice.config.model._Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AnexosResource extends JpaRepository<_Anexos, Long> {
}
