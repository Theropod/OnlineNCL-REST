DROP TABLE IF EXISTS model_file;

CREATE TABLE model_file
(
    id BIGINT(20) NOT NULL COMMENT 'primary key id',
    filename VARCHAR NULL DEFAULT NULL COMMENT 'entity output filename',
    model VARCHAR NULL DEFAULT NULL COMMENT 'entity name',
    start_time VARCHAR NULL DEFAULT NULL COMMENT 'entity predict start time',
    variable_name VARCHAR NULL DEFAULT NULL COMMENT 'entity variable_name',
    path VARCHAR NULL DEFAULT NULL COMMENT 'entity file path',
    file_info VARCHAR NULL DEFAULT NULL COMMENT 'entity file info',
    PRIMARY KEY (id)
);