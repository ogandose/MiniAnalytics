package com.example.demo.repository;

import com.example.demo.model.Mention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface MentionRepository extends SolrCrudRepository<Mention, String> {

    public List<Mention> findByUsername(String userName);

    @Query("id:*?0* OR name:*?0*")
    public Page<Mention> findByCustomQuery(String searchTerm, Pageable pageable);

    @Query(name = "Product.findByNamedQuery")
    public Page<Mention> findByNamedQuery(String searchTerm, Pageable pageable);

}
