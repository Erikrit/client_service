package org.olservice.config.resource;

import org.olservice.config.model._Classificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClassificacaoResource extends JpaRepository<_Classificacao,Long> {
}
