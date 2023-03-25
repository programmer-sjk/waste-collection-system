CREATE TABLE collection_history (
    id  BIGINT NOT NULL AUTO_INCREMENT,
    partner_company_id BIGINT NOT NULL,
    amount INTEGER NOT NULL,
    box_count INTEGER NOT NULL,
    thumbnail_count INTEGER NOT NULL,
    note VARCHAR NOT NULL,
    collected_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE collection_thumbnail (
    id  BIGINT NOT NULL AUTO_INCREMENT,
    file_path varchar NOT NULL,
    extension varchar(16) NOT NULL,
    history_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE partner_company (
    id  BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    location varchar(16) NOT NULL,
    started_at DATE NOT NULL,
    business_name varchar(32) NOT NULL,
    PRIMARY KEY (id)
);
