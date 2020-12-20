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

 Date: 05/30/2020 16:47:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_form`
-- ----------------------------
DROP TABLE IF EXISTS `t_form`;
CREATE TABLE `t_form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `biz_type` varchar(63) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_form`
-- ----------------------------
BEGIN;
INSERT INTO `t_form` VALUES ('1', '用户订单', 'PAGER_USER_ORDER', null, '2020-05-23 14:06:51', '2020-05-23 14:16:16', 'admin', 'admin', b'0'), ('2', '数据字典', 'PAGER_CONFIG_DICTIONARY', null, '2020-05-30 14:48:47', '2020-05-30 14:48:49', 'admin', 'admin', b'0'), ('3', '系统用户', 'PAGER_SYSTEM_USER_TEMPLATE', null, '2020-05-30 14:48:27', '2020-05-30 14:48:27', 'admin', 'admin', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
