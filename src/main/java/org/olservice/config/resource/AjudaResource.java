package org.olservice.config.resource;

import org.olservice.config.model._Ajuda;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface AjudaResource extends CrudRepository<_Ajuda, Long> {

}
