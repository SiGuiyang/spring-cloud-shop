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

 Date: 04/12/2020 22:03:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_system_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项名称',
  `config_type` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型',
  `config_status` bit(1) DEFAULT NULL COMMENT '0 启用 1 禁用',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项描述',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_system_config`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_config` VALUES ('1086', '订单状态', 'order_status', b'0', '商品订单状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-10-13 19:39:17', b'0'), ('1099', '订单类型', 'order_type', b'0', '商品订单类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1109', '商品类型', 'goods_type', b'0', '商品类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1114', '商品状态', 'goods_status', b'0', '商品状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1116', '优惠券', 'coupon_type', b'0', '优惠券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1117', '折扣券', 'discount_coupon_type', b'0', '折扣券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1124', 'Pager 模块', 'shop_module', b'0', 'Pager 模块', 'admin', 'admin', '2020-04-11 20:42:21', '2020-04-11 20:42:24', b'0'), ('1126', '优惠类型', 'offer_type', b'0', '优惠类型', 'admin', 'admin', '2020-04-11 21:33:20', '2020-04-11 21:33:24', b'0'), ('1127', 'Banner 类型', 'banner_type', b'0', 'Banner配置项类型', 'admin', 'admin', '2020-04-12 20:25:03', '2020-04-12 20:25:46', b'0'), ('1128', 'Banner 分享渠道', 'share_channel', b'0', 'Banner 分享渠道', 'admin', 'admin', '2020-04-12 20:31:05', '2020-04-12 20:31:05', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
