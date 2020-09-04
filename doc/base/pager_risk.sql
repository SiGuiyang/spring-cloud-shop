/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 101.132.121.178
 Source Database       : pager_risk

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : utf-8

 Date: 09/04/2020 15:28:32 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_black_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_black_list`;
CREATE TABLE `t_black_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='黑名单';

-- ----------------------------
--  Records of `t_black_list`
-- ----------------------------
BEGIN;
INSERT INTO `t_black_list` VALUES ('1', '13818578899', '2019-04-19 14:57:18', '2019-04-19 14:57:21', b'1', 'admin'), ('2', '3242423424', '2019-04-19 15:19:33', '2019-04-19 15:19:32', b'0', null), ('3', 'yghjhbjh', '2019-04-19 15:20:35', '2019-04-19 15:20:34', b'1', null), ('4', 'fdfsfsdfdsf', '2019-04-19 15:22:31', '2019-04-19 15:22:30', b'0', null), ('5', '3242343', '2019-04-19 15:26:11', '2019-04-19 15:26:10', b'0', 'admin'), ('6', null, '2019-04-19 15:28:25', '2019-04-19 15:28:25', b'0', 'admin'), ('7', null, '2019-04-19 15:29:21', '2019-04-19 15:29:21', b'0', 'admin'), ('8', null, '2019-04-19 15:29:53', '2019-04-19 15:29:52', b'0', 'admin'), ('9', null, '2019-04-19 15:30:32', '2019-04-19 15:30:31', b'0', 'admin');
COMMIT;

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

SET FOREIGN_KEY_CHECKS = 1;
