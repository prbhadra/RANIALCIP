package com.ranial.cip.repository;

import com.ranial.cip.domain.Domain;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data Cassandra repository for the Domain entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomainRepository extends CassandraRepository<Domain, UUID> {

}
