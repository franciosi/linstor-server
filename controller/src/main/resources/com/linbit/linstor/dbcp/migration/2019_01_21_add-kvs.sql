CREATE TABLE KEY_VALUE_STORE
(
    UUID CHARACTER(36) NOT NULL,
    KVS_NAME VARCHAR(48) NOT NULL,
    KVS_DSP_NAME VARCHAR(48) NOT NULL,
    CONSTRAINT PK_KVS PRIMARY KEY (KVS_NAME),
    CONSTRAINT UNQ_KVS_UUID UNIQUE (UUID),
    CONSTRAINT CHK_KVS_KVS_NAME CHECK (UPPER(KVS_NAME) = KVS_NAME AND LENGTH(KVS_NAME) >= 2),
    CONSTRAINT CHK_KVS_KVS_DSP_NAME CHECK (UPPER(KVS_DSP_NAME) = KVS_NAME)
);
