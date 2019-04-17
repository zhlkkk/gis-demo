CREATE TABLE `gis-demo`.`sys_route`
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `route`   MULTILINESTRING NOT NULL COMMENT '线路',
    `created` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) comment '预设路线表';

CREATE TABLE `gis-demo`.`user_route`
(
    `id`          BIGINT     NOT NULL AUTO_INCREMENT,
    `route`       LINESTRING NOT NULL COMMENT '行驶线路',
    `upload_time` DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
    `created`     DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated`     DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) comment '行驶线路表';
