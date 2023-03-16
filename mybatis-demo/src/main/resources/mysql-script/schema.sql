-- CREATE DATABASE IF NOT EXISTS mybatis
-- DEFAULT CHARACTER SET utf8mb4
-- DEFAULT COLLATE utf8mb4_unicode_520_ci;

DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `appearance`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `post_tag`;
DROP TABLE IF EXISTS `tag`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `blog`;
DROP TABLE IF EXISTS `author`;
DROP TABLE IF EXISTS `node`;

CREATE TABLE `person` (
`id`            int(11) NOT NULL AUTO_INCREMENT,
`name`          varchar(100) NOT NULL,
`address`       varchar(100) DEFAULT NULL,
`head_img_url` varchar(200) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

CREATE TABLE `appearance` (
`pid` bigint unsigned not null,
`height` double,
`weight` double,
PRIMARY KEY (`pid`)
);

CREATE TABLE `author` (
`id`                INT NOT NULL AUTO_INCREMENT,
`username`          VARCHAR(255) NOT NULL,
`password`          VARCHAR(255) NOT NULL,
`email`             VARCHAR(255) NOT NULL,
`bio`               BLOB,
`favourite_section` VARCHAR(25),
PRIMARY KEY (`id`)
);


CREATE TABLE blog (
`id`          INT NOT NULL AUTO_INCREMENT,
`author_id`   INT NOT NULL,
`title`       VARCHAR(255),
PRIMARY KEY (`id`)
);

CREATE TABLE `post` (
`id`          INT NOT NULL AUTO_INCREMENT,
`blog_id`     INT,
`author_id`   INT NOT NULL,
`created_on`  TIMESTAMP NOT NULL,
`section`     VARCHAR(25) NOT NULL,
`subject`     VARCHAR(255) NOT NULL,
`body`        BLOB NOT NULL,
`draft`       INT NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE tag (
`id`          INT NOT NULL AUTO_INCREMENT,
`name`        VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE post_tag (
`post_id`     INT NOT NULL,
`tag_id`      INT NOT NULL,
PRIMARY KEY (`post_id`, `tag_id`)
);

CREATE TABLE comment (
`id`          INT NOT NULL AUTO_INCREMENT,
`post_id`     INT NOT NULL,
`name`        VARCHAR(100) NOT NULL,
`comment`     VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE node (
`id`  INT NOT NULL,
`parent_id` INT,
PRIMARY KEY(`id`)
);
