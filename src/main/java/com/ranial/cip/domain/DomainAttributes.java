package com.ranial.cip.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DomainAttributes.
 */
@Table("domainAttributes")
public class DomainAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    @NotNull
    private String attributeName;

    @NotNull
    private String entityName;

    @NotNull
    private DATATYPE attributeType;

    private Integer attributeLength;

    private String attributeDescription;

    @NotNull
    private Boolean allowNull;

    @NotNull
    private Boolean isPrimary;

    @NotNull
    private Boolean isUnique;

    @NotNull
    private Boolean isIndexed;

    @NotNull
    private Boolean isForaignKey;

    private String foraignKeyEntityName;

    private String foraignKeyAttributeName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public DomainAttributes attributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getEntityName() {
        return entityName;
    }

    public DomainAttributes entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public DATATYPE getAttributeType() {
        return attributeType;
    }

    public DomainAttributes attributeType(DATATYPE attributeType) {
        this.attributeType = attributeType;
        return this;
    }

    public void setAttributeType(DATATYPE attributeType) {
        this.attributeType = attributeType;
    }

    public Integer getAttributeLength() {
        return attributeLength;
    }

    public DomainAttributes attributeLength(Integer attributeLength) {
        this.attributeLength = attributeLength;
        return this;
    }

    public void setAttributeLength(Integer attributeLength) {
        this.attributeLength = attributeLength;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public DomainAttributes attributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
        return this;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    public Boolean isAllowNull() {
        return allowNull;
    }

    public DomainAttributes allowNull(Boolean allowNull) {
        this.allowNull = allowNull;
        return this;
    }

    public void setAllowNull(Boolean allowNull) {
        this.allowNull = allowNull;
    }

    public Boolean isIsPrimary() {
        return isPrimary;
    }

    public DomainAttributes isPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Boolean isIsUnique() {
        return isUnique;
    }

    public DomainAttributes isUnique(Boolean isUnique) {
        this.isUnique = isUnique;
        return this;
    }

    public void setIsUnique(Boolean isUnique) {
        this.isUnique = isUnique;
    }

    public Boolean isIsIndexed() {
        return isIndexed;
    }

    public DomainAttributes isIndexed(Boolean isIndexed) {
        this.isIndexed = isIndexed;
        return this;
    }

    public void setIsIndexed(Boolean isIndexed) {
        this.isIndexed = isIndexed;
    }

    public Boolean isIsForaignKey() {
        return isForaignKey;
    }

    public DomainAttributes isForaignKey(Boolean isForaignKey) {
        this.isForaignKey = isForaignKey;
        return this;
    }

    public void setIsForaignKey(Boolean isForaignKey) {
        this.isForaignKey = isForaignKey;
    }

    public String getForaignKeyEntityName() {
        return foraignKeyEntityName;
    }

    public DomainAttributes foraignKeyEntityName(String foraignKeyEntityName) {
        this.foraignKeyEntityName = foraignKeyEntityName;
        return this;
    }

    public void setForaignKeyEntityName(String foraignKeyEntityName) {
        this.foraignKeyEntityName = foraignKeyEntityName;
    }

    public String getForaignKeyAttributeName() {
        return foraignKeyAttributeName;
    }

    public DomainAttributes foraignKeyAttributeName(String foraignKeyAttributeName) {
        this.foraignKeyAttributeName = foraignKeyAttributeName;
        return this;
    }

    public void setForaignKeyAttributeName(String foraignKeyAttributeName) {
        this.foraignKeyAttributeName = foraignKeyAttributeName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DomainAttributes)) {
            return false;
        }
        return id != null && id.equals(((DomainAttributes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DomainAttributes{" +
            "id=" + getId() +
            ", attributeName='" + getAttributeName() + "'" +
            ", entityName='" + getEntityName() + "'" +
            ", attributeType='" + getAttributeType() + "'" +
            ", attributeLength=" + getAttributeLength() +
            ", attributeDescription='" + getAttributeDescription() + "'" +
            ", allowNull='" + isAllowNull() + "'" +
            ", isPrimary='" + isIsPrimary() + "'" +
            ", isUnique='" + isIsUnique() + "'" +
            ", isIndexed='" + isIsIndexed() + "'" +
            ", isForaignKey='" + isIsForaignKey() + "'" +
            ", foraignKeyEntityName='" + getForaignKeyEntityName() + "'" +
            ", foraignKeyAttributeName='" + getForaignKeyAttributeName() + "'" +
            "}";
    }
}
