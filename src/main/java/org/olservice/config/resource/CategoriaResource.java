package org.olservice.config.resource;

import org.olservice.config.model._Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoriaResource extends JpaRepository<_Categoria, Long> {


}
