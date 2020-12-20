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

 Date: 05/30/2020 16:47:40 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_field_props`
-- ----------------------------
DROP TABLE IF EXISTS `t_field_props`;
CREATE TABLE `t_field_props` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `field_id` bigint(20) DEFAULT NULL COMMENT '字段表t_field 主键',
  `type` varchar(31) DEFAULT NULL COMMENT '类型',
  `max_length` int(11) DEFAULT NULL COMMENT '原生属性，最大输入长度',
  `min_length` int(11) DEFAULT NULL COMMENT '原生属性，最小输入长度',
  `placeholder` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '输入框占位文本',
  `clearable` bit(1) DEFAULT NULL COMMENT '是否可清空',
  `disabled` bit(1) DEFAULT NULL COMMENT '禁用',
  `size` varchar(31) DEFAULT NULL COMMENT '输入框尺寸，只在 type!="textarea" 时有效',
  `prefix_icon` varchar(63) DEFAULT NULL COMMENT '输入框头部图标',
  `suffix_icon` varchar(63) DEFAULT NULL COMMENT '输入框尾部图标',
  `rows` int(11) DEFAULT NULL COMMENT '输入框行数，只对 type="textarea" 有效',
  `autosize` varchar(255) DEFAULT NULL COMMENT '自适应内容高度，只对 type="textarea" 有效，可传入对象，如，{ minRows: 2, maxRows: 6 }',
  `step` int(11) DEFAULT NULL COMMENT '计数器步长',
  `datasource` varchar(127) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_field_props`
-- ----------------------------
BEGIN;
INSERT INTO `t_field_props` VALUES ('1', '1', 'input', null, null, '请设置', null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:51', '2020-05-30 15:02:50', 'admin', 'admin', b'0'), ('2', '2', 'input', null, null, '请设置', null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:47', '2020-05-30 15:03:16', 'admin', 'admin', b'0'), ('3', '3', 'textarea', null, null, '请设置', null, null, null, null, null, '4', null, null, null, '2020-05-30 15:04:44', '2020-05-30 15:03:21', 'admin', 'admin', b'0'), ('4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:23', 'admin', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
