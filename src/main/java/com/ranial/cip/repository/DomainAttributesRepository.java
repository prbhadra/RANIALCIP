package com.ranial.cip.repository;

import com.ranial.cip.domain.DomainAttributes;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data Cassandra repository for the DomainAttributes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomainAttributesRepository extends CassandraRepository<DomainAttributes, UUID> {

}
