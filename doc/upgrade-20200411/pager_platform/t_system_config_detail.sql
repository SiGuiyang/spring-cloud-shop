
DROP TABLE IF EXISTS `t_system_config_detail`;
CREATE TABLE `t_system_config_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项名称',
  `config_type` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型',
  `config_value` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项值',
  `config_key` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型值',
  `config_status` bit(1) DEFAULT NULL COMMENT '0 启用 1 禁用',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
