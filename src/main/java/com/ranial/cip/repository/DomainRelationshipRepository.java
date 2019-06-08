package com.ranial.cip.repository;

import com.ranial.cip.domain.DomainRelationship;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data Cassandra repository for the DomainRelationship entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomainRelationshipRepository extends CassandraRepository<DomainRelationship, UUID> {

}
