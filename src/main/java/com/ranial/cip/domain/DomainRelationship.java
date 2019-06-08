package com.ranial.cip.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DomainRelationship.
 */
@Table("domainRelationship")
public class DomainRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String parentKeyEntityName;

    private String parentKeyAttributeName;

    private String chieldAttributeName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParentKeyEntityName() {
        return parentKeyEntityName;
    }

    public DomainRelationship parentKeyEntityName(String parentKeyEntityName) {
        this.parentKeyEntityName = parentKeyEntityName;
        return this;
    }

    public void setParentKeyEntityName(String parentKeyEntityName) {
        this.parentKeyEntityName = parentKeyEntityName;
    }

    public String getParentKeyAttributeName() {
        return parentKeyAttributeName;
    }

    public DomainRelationship parentKeyAttributeName(String parentKeyAttributeName) {
        this.parentKeyAttributeName = parentKeyAttributeName;
        return this;
    }

    public void setParentKeyAttributeName(String parentKeyAttributeName) {
        this.parentKeyAttributeName = parentKeyAttributeName;
    }

    public String getChieldAttributeName() {
        return chieldAttributeName;
    }

    public DomainRelationship chieldAttributeName(String chieldAttributeName) {
        this.chieldAttributeName = chieldAttributeName;
        return this;
    }

    public void setChieldAttributeName(String chieldAttributeName) {
        this.chieldAttributeName = chieldAttributeName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DomainRelationship)) {
            return false;
        }
        return id != null && id.equals(((DomainRelationship) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DomainRelationship{" +
            "id=" + getId() +
            ", parentKeyEntityName='" + getParentKeyEntityName() + "'" +
            ", parentKeyAttributeName='" + getParentKeyAttributeName() + "'" +
            ", chieldAttributeName='" + getChieldAttributeName() + "'" +
            "}";
    }
}
