package org.olservice.config.resource;

import org.olservice.config.model._Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UsuarioResource extends JpaRepository<_Usuario,Long> {
}
