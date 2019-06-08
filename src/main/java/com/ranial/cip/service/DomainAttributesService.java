package com.ranial.cip.service;

import com.ranial.cip.service.dto.DomainAttributesDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Interface for managing {@link com.ranial.cip.domain.DomainAttributes}.
 */
public interface DomainAttributesService {

    /**
     * Save a domainAttributes.
     *
     * @param domainAttributesDTO the entity to save.
     * @return the persisted entity.
     */
    DomainAttributesDTO save(DomainAttributesDTO domainAttributesDTO);

    /**
     * Get all the domainAttributes.
     *
     * @return the list of entities.
     */
    List<DomainAttributesDTO> findAll();


    /**
     * Get the "id" domainAttributes.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DomainAttributesDTO> findOne(UUID id);

    /**
     * Delete the "id" domainAttributes.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}
