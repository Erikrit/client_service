package org.olservice.config.resource;

import org.olservice.config.model._Categoria;
import org.olservice.config.model._Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ImagemResource extends JpaRepository<_Imagem, Long> {
}
