package com.ufc.backendtestkeycloak.repository;


import com.ufc.backendtestkeycloak.models.Produto;

import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.yaml.snakeyaml.events.Event.ID;

@CrossOrigin
@RepositoryRestResource(path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
    @Secured({"ROLE_PRODUTO:CREATE", "ROLE_PRODUTO:EDIT"})
    Produto save(Produto entity);

    @Secured("ROLE_PRODUTO:VIEW")
    List<Produto> findAll();

    @Secured("ROLE_PRODUTO:VIEW")
    Optional<Produto> findById(Id id);

    @Secured("ROLE_PRODUTO:DELETE")
    void deleteById(ID id);

    @Secured("ROLE_PRODUTO:DELETE")
    void delete(Produto entity);

}
