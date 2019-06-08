
CREATE TABLE IF NOT EXISTS domain (
    id uuid,
    entityName text,
    entityDescription text,
    owner text,
    createdOn timestamp,
    isActive boolean,
    PRIMARY KEY(id)
);
