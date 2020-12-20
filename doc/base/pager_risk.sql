/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 106.54.251.32
 Source Database       : pager_risk

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 12/20/2020 19:12:33 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_coupon_limit`
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon_limit`;
CREATE TABLE `t_coupon_limit` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '使用优惠券的用户Id',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT '优惠券Id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每日下单使用优惠券记录\n';

-- ----------------------------
--  Table structure for `t_order_limit`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_limit`;
CREATE TABLE `t_order_limit` (
  `id` bigint(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL COMMENT '配送地址的手机号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '下单的用户Id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每天下单限制\n只与订单有关系\n每下一单就会生成一条记录';

-- ----------------------------
--  Table structure for `t_risk_blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `t_risk_blacklist`;
CREATE TABLE `t_risk_blacklist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `state` bit(1) DEFAULT NULL COMMENT '禁用 true ，启用 false',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='黑名单';

-- ----------------------------
--  Records of `t_risk_blacklist`
-- ----------------------------
BEGIN;
INSERT INTO `t_risk_blacklist` VALUES ('1', '13818578899', b'0', '2019-04-19 14:57:18', '2019-04-19 14:57:21', 'admin', 'admin', b'1'), ('2', '3242423424', b'1', '2019-04-19 15:19:33', '2020-12-06 22:18:45', 'admin', 'admin', b'0'), ('3', 'yghjhbjh', b'0', '2019-04-19 15:20:35', '2019-04-19 15:20:34', 'admin', 'admin', b'1'), ('4', 'fdfsfsdfdsf', b'0', '2019-04-19 15:22:31', '2019-04-19 15:22:30', 'admin', 'admin', b'0'), ('5', '3242343', b'0', '2019-04-19 15:26:11', '2019-04-19 15:26:10', 'admin', 'admin', b'0'), ('6', '212', b'0', '2019-04-19 15:28:25', '2019-04-19 15:28:25', 'admin', 'admin', b'0'), ('7', '22', b'0', '2019-04-19 15:29:21', '2019-04-19 15:29:21', 'admin', 'admin', b'0'), ('8', '21', b'0', '2019-04-19 15:29:53', '2019-04-19 15:29:52', 'admin', 'admin', b'0'), ('9', '212', b'0', '2019-04-19 15:30:32', '2019-04-19 15:30:31', 'admin', 'admin', b'0'), ('10', null, null, null, '2020-12-06 22:16:36', null, 'admin', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_risk_whitelist`
-- ----------------------------
DROP TABLE IF EXISTS `t_risk_whitelist`;
CREATE TABLE `t_risk_whitelist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `state` bit(1) DEFAULT NULL COMMENT '禁用 true ，启用 false',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='白名单';

SET FOREIGN_KEY_CHECKS = 1;
