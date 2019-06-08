package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainRelationshipDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DomainRelationship} and its DTO {@link DomainRelationshipDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DomainRelationshipMapper extends EntityMapper<DomainRelationshipDTO, DomainRelationship> {


}
