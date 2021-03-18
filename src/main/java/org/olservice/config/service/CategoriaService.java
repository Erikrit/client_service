package org.olservice.config.service;

import org.olservice.config.model._Categoria;
import org.olservice.config.model._Categoria_;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class CategoriaService {

    @Inject
    EntityManager em;

    public List<_Categoria> listSubCategoria(Long idCategoriaPai){

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<_Categoria> query = criteria.createQuery(_Categoria.class);
        Root<_Categoria> root = query.from(_Categoria.class);

        query.select(root).where(criteria.equal(root.get(_Categoria_.ID_CATEGORIA_PAI),idCategoriaPai));
        query.orderBy(criteria.asc(root.get("nome")));
        return em.createQuery(query).getResultList();
    }

     public List<_Categoria> listCategoria() {

         CriteriaBuilder criteria = em.getCriteriaBuilder();
         CriteriaQuery<_Categoria> query = criteria.createQuery(_Categoria.class);
         Root<_Categoria> root = query.from(_Categoria.class);
         query.select(root).where(criteria.equal(root.get(_Categoria_.ID_CATEGORIA_PAI), 0));
         query.orderBy(criteria.asc(root.get("nome")));
         return em.createQuery(query).getResultList();
     }
    }
