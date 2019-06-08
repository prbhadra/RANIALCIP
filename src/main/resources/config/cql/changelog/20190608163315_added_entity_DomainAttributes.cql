
CREATE TABLE IF NOT EXISTS domainAttributes (
    id uuid,
    attributeName text,
    entityName text,
    attributeLength int,
    attributeDescription text,
    allowNull boolean,
    isPrimary boolean,
    isUnique boolean,
    isIndexed boolean,
    isForaignKey boolean,
    foraignKeyEntityName text,
    foraignKeyAttributeName text,
    PRIMARY KEY(id)
);
