package com.ranial.cip.service.dto;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ranial.cip.domain.DomainRelationship} entity.
 */
public class DomainRelationshipDTO implements Serializable {

    private UUID id;

    private String parentKeyEntityName;

    private String parentKeyAttributeName;

    private String chieldAttributeName;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParentKeyEntityName() {
        return parentKeyEntityName;
    }

    public void setParentKeyEntityName(String parentKeyEntityName) {
        this.parentKeyEntityName = parentKeyEntityName;
    }

    public String getParentKeyAttributeName() {
        return parentKeyAttributeName;
    }

    public void setParentKeyAttributeName(String parentKeyAttributeName) {
        this.parentKeyAttributeName = parentKeyAttributeName;
    }

    public String getChieldAttributeName() {
        return chieldAttributeName;
    }

    public void setChieldAttributeName(String chieldAttributeName) {
        this.chieldAttributeName = chieldAttributeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DomainRelationshipDTO domainRelationshipDTO = (DomainRelationshipDTO) o;
        if (domainRelationshipDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), domainRelationshipDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DomainRelationshipDTO{" +
            "id=" + getId() +
            ", parentKeyEntityName='" + getParentKeyEntityName() + "'" +
            ", parentKeyAttributeName='" + getParentKeyAttributeName() + "'" +
            ", chieldAttributeName='" + getChieldAttributeName() + "'" +
            "}";
    }
}
