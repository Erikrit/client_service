package org.olservice.config.resource;

import org.olservice.config.model._Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AnuncioResource extends JpaRepository<_Anuncio, Long> {
}
