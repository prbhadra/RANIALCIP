package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Domain} and its DTO {@link DomainDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DomainMapper extends EntityMapper<DomainDTO, Domain> {


}
