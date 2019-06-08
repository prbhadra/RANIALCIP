package com.ranial.cip.service.impl;

import com.ranial.cip.service.DomainAttributesService;
import com.ranial.cip.domain.DomainAttributes;
import com.ranial.cip.repository.DomainAttributesRepository;
import com.ranial.cip.service.dto.DomainAttributesDTO;
import com.ranial.cip.service.mapper.DomainAttributesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link DomainAttributes}.
 */
@Service
public class DomainAttributesServiceImpl implements DomainAttributesService {

    private final Logger log = LoggerFactory.getLogger(DomainAttributesServiceImpl.class);

    private final DomainAttributesRepository domainAttributesRepository;

    private final DomainAttributesMapper domainAttributesMapper;

    public DomainAttributesServiceImpl(DomainAttributesRepository domainAttributesRepository, DomainAttributesMapper domainAttributesMapper) {
        this.domainAttributesRepository = domainAttributesRepository;
        this.domainAttributesMapper = domainAttributesMapper;
    }

    /**
     * Save a domainAttributes.
     *
     * @param domainAttributesDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DomainAttributesDTO save(DomainAttributesDTO domainAttributesDTO) {
        log.debug("Request to save DomainAttributes : {}", domainAttributesDTO);
        DomainAttributes domainAttributes = domainAttributesMapper.toEntity(domainAttributesDTO);
        domainAttributes = domainAttributesRepository.save(domainAttributes);
        return domainAttributesMapper.toDto(domainAttributes);
    }

    /**
     * Get all the domainAttributes.
     *
     * @return the list of entities.
     */
    @Override
    public List<DomainAttributesDTO> findAll() {
        log.debug("Request to get all DomainAttributes");
        return domainAttributesRepository.findAll().stream()
            .map(domainAttributesMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one domainAttributes by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<DomainAttributesDTO> findOne(UUID id) {
        log.debug("Request to get DomainAttributes : {}", id);
        return domainAttributesRepository.findById(id)
            .map(domainAttributesMapper::toDto);
    }

    /**
     * Delete the domainAttributes by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(UUID id) {
        log.debug("Request to delete DomainAttributes : {}", id);
        domainAttributesRepository.deleteById(id);
    }
}
