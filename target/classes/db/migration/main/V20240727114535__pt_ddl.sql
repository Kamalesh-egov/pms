CREATE TABLE eg_project (
    id character varying(64),
    tenantId character varying(64),
    name character varying(256),
    projectType character varying(64),
    projectSubType character varying(64),
    department character varying(64),
    description TEXT,
    referenceID character varying(64),
    natureOfWork character varying(64),
    ancestors character varying(64),
    startDate BIGINT,
    endDate BIGINT,
    isTaskEnabled BOOLEAN,
    parent character varying(64),
    rowVersion INT,
--    additionalDetails JSONB,
    isDeleted BOOLEAN,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime BIGINT,
    lastModifiedTime BIGINT,
    CONSTRAINT uk_eg_project UNIQUE (id)
);

CREATE TABLE eg_address (
    id character varying(64),
    tenantId character varying(64),
    doorNo character varying(64),
    latitude FLOAT,
    longitude FLOAT,
    locationAccuracy FLOAT,
    type character varying(64),
    addressLine1 character varying(256),
    addressLine2 character varying(256),
    landmark character varying(256),
    city character varying(64),
    pincode character varying(64),
    buildingName character varying(256),
    street character varying(256),
    localityCode character varying(64),
    localityName character varying(256),
    localityLabel character varying(256),
    localityLatitude character varying(64),
    localityLongitude character varying(64),
--    localityChildren JSONB,
    projectId character varying(64),
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime BIGINT,
    lastModifiedTime BIGINT,
    CONSTRAINT uk_eg_address UNIQUE (id),
    CONSTRAINT fk_eg_address FOREIGN KEY (projectId) REFERENCES eg_project (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE eg_target (
    id character varying(64),
    projectId character varying(64),
    beneficiaryType character varying(64),
    baseline INT,
    target INT,
    isDeleted BOOLEAN,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime BIGINT,
    lastModifiedTime BIGINT,
    CONSTRAINT uk_eg_target PRIMARY KEY (id),
    CONSTRAINT fk_eg_address FOREIGN KEY (projectId) REFERENCES eg_project (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

--CREATE TABLE eg_locality_children (
--    id character varying(64),
--    localityId character varying(64),
--    child character varying(64),
--    createdBy character varying(64),
--    lastModifiedBy character varying(64),
--    createdTime BIGINT,
--    lastModifiedTime BIGINT,
--    CONSTRAINT uk_eg_locality_children PRIMARY KEY (id),
--    CONSTRAINT fk_eg_locality_children FOREIGN KEY (localityId) REFERENCES eg_address (id)
--        ON UPDATE CASCADE
--        ON DELETE CASCADE
--);
--
--CREATE TABLE eg_additional_details (
--    id character varying(64),
--    projectId character varying(64),
--    details JSONB,
--    createdBy character varying(64),
--    lastModifiedBy character varying(64),
--    createdTime BIGINT,
--    lastModifiedTime BIGINT,
--    CONSTRAINT uk_eg_additional_details PRIMARY KEY (id),
--    CONSTRAINT fk_eg_additional_details FOREIGN KEY (projectId) REFERENCES eg_project (id)
--        ON UPDATE CASCADE
--        ON DELETE CASCADE
--);
