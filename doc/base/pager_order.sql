/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 106.54.251.32
 Source Database       : pager_order

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 12/20/2020 19:12:16 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 商户主键',
  `user_order_id` bigint(20) DEFAULT NULL COMMENT 't_user_order 主键',
  `seller_order_id` bigint(20) DEFAULT NULL COMMENT 't_seller_order 商户主订单主键',
  `goods_sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `purchase_amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品时的价格',
  `purchase_quantity` int(11) DEFAULT NULL COMMENT '购买商品数量',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细表';

-- ----------------------------
--  Table structure for `t_seller_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order`;
CREATE TABLE `t_seller_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_0`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_0`;
CREATE TABLE `t_seller_order_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_1`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_1`;
CREATE TABLE `t_seller_order_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_2`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_2`;
CREATE TABLE `t_seller_order_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_3`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_3`;
CREATE TABLE `t_seller_order_3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_4`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_4`;
CREATE TABLE `t_seller_order_4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_5`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_5`;
CREATE TABLE `t_seller_order_5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_6`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_6`;
CREATE TABLE `t_seller_order_6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_7`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_7`;
CREATE TABLE `t_seller_order_7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 优惠券主键 只有商户型优惠券与折扣券才会有值',
  `delivery_address_id` bigint(20) DEFAULT NULL COMMENT '配送地址',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '支付给商户的金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `order_code` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户订单状态',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商户主订单表';

-- ----------------------------
--  Table structure for `t_seller_order_flow`
-- ----------------------------
DROP TABLE IF EXISTS `t_seller_order_flow`;
CREATE TABLE `t_seller_order_flow` (
  `id` bigint(20) NOT NULL,
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `seller_order_id` bigint(20) DEFAULT NULL COMMENT 't_seller_order 主键',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠减免金额',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_user_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Records of `t_user_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_order` VALUES ('1', '1', null, '13818471341', '1', '1', 'wsdfr3322edf', 'BS001', '1', null, '111', '1.00', null, '11.00', '20', '1', null, null, '2019-01-13 15:59:00', '2019-01-13 15:59:30', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_order_0`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_0`;
CREATE TABLE `t_user_order_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_1`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_1`;
CREATE TABLE `t_user_order_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Records of `t_user_order_1`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_order_1` VALUES ('1', '1', null, '13818471341', '1', '1', 'wsdfr3322edf', 'BS001', '1', null, '111', '1.00', null, '11.00', '20', '1', null, null, '2019-01-13 15:59:00', '2019-01-13 15:59:30', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_order_2`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_2`;
CREATE TABLE `t_user_order_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_3`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_3`;
CREATE TABLE `t_user_order_3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_4`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_4`;
CREATE TABLE `t_user_order_4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_5`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_5`;
CREATE TABLE `t_user_order_5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_6`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_6`;
CREATE TABLE `t_user_order_6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_7`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_7`;
CREATE TABLE `t_user_order_7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商户主键',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `addr_id` bigint(20) DEFAULT NULL COMMENT 't_address 主键',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT 't_discount_coupon 主键',
  `order_code` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
  `order_type` int(2) DEFAULT NULL COMMENT '订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付方式',
  `integral` decimal(8,0) DEFAULT NULL COMMENT '消耗的积分',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `integral_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠券减免金额',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自提 1:自提 0:否',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户订单主表';

-- ----------------------------
--  Table structure for `t_user_order_flow`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order_flow`;
CREATE TABLE `t_user_order_flow` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 主键',
  `seller_id` bigint(20) DEFAULT NULL COMMENT 't_seller 主键',
  `user_order_id` bigint(20) DEFAULT NULL COMMENT 't_user_order 主键',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品金额',
  `integral_amount` decimal(10,0) DEFAULT NULL COMMENT '积分金额',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '优惠减免金额',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
