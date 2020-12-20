/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 106.54.251.32
 Source Database       : pager_platform

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : utf-8

 Date: 05/30/2020 16:47:21 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_field`
-- ----------------------------
DROP TABLE IF EXISTS `t_field`;
CREATE TABLE `t_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `form_id` bigint(20) DEFAULT NULL,
  `type` varchar(31) NOT NULL,
  `field` varchar(31) NOT NULL,
  `title` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_field`
-- ----------------------------
BEGIN;
INSERT INTO `t_field` VALUES ('1', '2', 'input', 'configName', '配置项名称', '2020-05-30 14:57:00', '2020-05-30 14:57:05', 'admin', 'admin', b'0'), ('2', '2', 'input', 'configType', '配置项类型', '2020-05-30 14:57:00', '2020-05-30 15:00:01', 'admin', 'admin', b'0'), ('3', '2', 'input', 'description', '配置项描述', '2020-05-30 14:57:00', '2020-05-30 15:01:08', 'admin', 'admin', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
