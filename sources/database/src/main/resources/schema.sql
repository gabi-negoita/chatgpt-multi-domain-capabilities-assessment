CREATE TABLE `user_query_result`
(
    `id`         varchar(38)   NOT NULL,
    `title`      varchar(64)   NOT NULL,
    `input`      varchar(4096) NOT NULL,
    `input_type` varchar(32)   NOT NULL,
    `result`     varchar(1024) NOT NULL,
    `output`     varchar(4096) NOT NULL,
    `rating`     tinyint       NOT NULL,
    `comment`    varchar(256) DEFAULT NULL,
    `reference`  varchar(128)  NOT NULL,
    `confidence` varchar(6)    NOT NULL,
    `timestamp`  datetime      NOT NULL,
    `model`      varchar(13)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;