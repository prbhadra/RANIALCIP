package com.ranial.cip.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A Domain.
 */
@Table("domain")
public class Domain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    @NotNull
    private String entityName;

    private String entityDescription;

    private String owner;

    private Instant createdOn;

    private Boolean isActive;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public Domain entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public Domain entityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
        return this;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getOwner() {
        return owner;
    }

    public Domain owner(String owner) {
        this.owner = owner;
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Domain createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Domain isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Domain)) {
            return false;
        }
        return id != null && id.equals(((Domain) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Domain{" +
            "id=" + getId() +
            ", entityName='" + getEntityName() + "'" +
            ", entityDescription='" + getEntityDescription() + "'" +
            ", owner='" + getOwner() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", isActive='" + isIsActive() + "'" +
            "}";
    }
}
