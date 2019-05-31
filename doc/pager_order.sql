/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost
 Source Database       : pager_order

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 05/04/2019 21:21:36 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_buy_order_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_buy_order_cart`;
CREATE TABLE `t_buy_order_cart` (
  `id` bigint(20) NOT NULL,
  `goods_cart_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_buy_order_cart`
-- ----------------------------
BEGIN;
INSERT INTO `t_buy_order_cart` VALUES ('1', '1', '2019-01-14 14:21:50', '2019-01-14 14:22:14', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_flow`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_flow`;
CREATE TABLE `t_order_flow` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_seller_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order`;
CREATE TABLE `t_seller_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '支付给商户的金额',
  `seller_id` bigint(20) DEFAULT NULL,
  `user_order_id` bigint(20) DEFAULT NULL COMMENT '用户订单Id',
  `order_amount` decimal(4,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` int(3) DEFAULT NULL COMMENT '商户订单状态',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_user_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `buy_order_cart_id` bigint(20) DEFAULT NULL COMMENT '对应t_buy_order_cart id',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户Id',
  `ship_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT '优惠券的Id',
  `order_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `order_amount` decimal(8,2) DEFAULT NULL COMMENT '订单金额',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `integral_amount` decimal(4,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(4,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_user_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_order` VALUES ('1', '1', '13818471341', '1', '1', '1', '1', 'wsdfr3322edf', 'BS001', '1', '1.00', '111', '11.00', '20', '1', '2019-01-13 15:59:00', '2019-01-13 15:59:30', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
