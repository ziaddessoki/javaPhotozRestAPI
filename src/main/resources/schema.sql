-- IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='photoz' AND xtype='U')
-- CREATE TABLE photoz (
--     id BIGINT IDENTITY(1,1) PRIMARY KEY,
--     file_name VARCHAR(255),
--     content_type VARCHAR(255),
--     data VARBINARY(MAX)
-- );

CREATE TABLE IF NOT EXISTS PHOTOZ (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data binary
);