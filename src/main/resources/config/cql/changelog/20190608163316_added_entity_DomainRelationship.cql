
CREATE TABLE IF NOT EXISTS domainRelationship (
    id uuid,
    parentKeyEntityName text,
    parentKeyAttributeName text,
    chieldAttributeName text,
    PRIMARY KEY(id)
);
