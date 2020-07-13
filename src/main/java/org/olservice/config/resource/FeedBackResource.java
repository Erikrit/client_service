package org.olservice.config.resource;

import org.olservice.config.model._FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FeedBackResource extends JpaRepository<_FeedBack,Long> {
}
