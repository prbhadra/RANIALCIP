package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainAttributesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DomainAttributes} and its DTO {@link DomainAttributesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DomainAttributesMapper extends EntityMapper<DomainAttributesDTO, DomainAttributes> {


}
