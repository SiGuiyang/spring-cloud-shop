/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost
 Source Database       : pager_goods

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 01/16/2019 11:01:49 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gcs_id` bigint(20) DEFAULT NULL COMMENT '产品分类Id',
  `goods_name` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名称',
  `goods_code` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品编码',
  `goods_status` tinyint(2) DEFAULT NULL COMMENT '商品状态',
  `goods_type` tinyint(4) DEFAULT NULL COMMENT '商品类型 1 普通商品 2 特价商品 3 拼团商品 4 秒杀商品',
  `goods_amount` decimal(4,2) DEFAULT NULL COMMENT '商品价格',
  `goods_discount_amount` decimal(4,2) DEFAULT NULL COMMENT '商品折扣价格',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品描述',
  `integral` int(11) DEFAULT NULL COMMENT '赠送的积分',
  `goods_inventory` int(11) DEFAULT NULL COMMENT '商品库存',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods` VALUES ('1', '1', 'ddd', '1547198358588zgpwy', '1', '1', '3.00', '3.00', 'd', '3', '3', '2019-01-11 17:19:19', '2019-01-11 17:19:18', b'0'), ('2', '3', '发大发大发', '1547199040001q7tw0', '2', '2', '44.00', '4.00', '发大丰收的', '3', '323', '2019-01-11 17:30:40', '2019-01-11 17:30:40', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `buy_cart_id` bigint(20) DEFAULT NULL COMMENT '对应 order 模块t_buy_order_cart id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `goods_count` int(4) DEFAULT NULL COMMENT '购买商品的数量',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_goods_cart`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_cart` VALUES ('1', '1', '1', '1', '3', '2019-01-14 14:22:54', '2019-01-14 14:23:02', b'0'), ('2', '1', '1', '2', '5', '2019-01-14 14:23:16', '2019-01-14 14:23:24', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class`;
CREATE TABLE `t_goods_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分类名称',
  `icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分类图标',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商品类别';

-- ----------------------------
--  Records of `t_goods_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class` VALUES ('1', '超值特惠', 'http://pk6b0a7n8.bkt.clouddn.com/chaozhitehui.png', 'admin', '2018-12-23 17:47:48', '2019-01-08 16:40:13', b'0'), ('2', '新品上市', 'http://pk6b0a7n8.bkt.clouddn.com/xianfenxinpin.png', 'admin', '2018-12-23 17:48:09', '2019-01-08 16:40:15', b'0'), ('3', '店长推荐', 'http://pk6b0a7n8.bkt.clouddn.com/dianzhangtuijian.png', 'admin', '2018-12-23 17:48:27', '2019-01-08 16:40:18', b'0'), ('4', '国产精品', 'http://pk6b0a7n8.bkt.clouddn.com/guochanjingpin.png', 'admin', '2018-12-23 17:48:44', '2019-01-08 16:40:17', b'0'), ('5', '礼盒专区', 'http://pk6b0a7n8.bkt.clouddn.com/lihezhuanqu.png', 'admin', '2018-12-23 17:49:01', '2019-01-08 16:40:19', b'0'), ('6', '漂洋过海', 'http://pk6b0a7n8.bkt.clouddn.com/piaoyangguohai.png', 'admin', '2018-12-23 17:49:18', '2019-01-08 16:40:21', b'0'), ('7', '特色乳品', 'http://pk6b0a7n8.bkt.clouddn.com/teserupin.png', 'admin', '2018-12-23 17:49:42', '2019-01-08 16:40:20', b'0'), ('8', '休闲零食', 'http://pk6b0a7n8.bkt.clouddn.com/xiuxianlingshi.png', 'admin', '2018-12-23 17:50:05', '2019-01-08 16:40:22', b'0'), ('9', '轻食果切', 'http://pk6b0a7n8.bkt.clouddn.com/qinshiguoqie.png', 'admin', '2018-12-23 17:50:39', '2019-01-08 16:40:25', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_detail`;
CREATE TABLE `t_goods_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `goods_img` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `banner_first` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品详情图片',
  `banner_second` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品详情描述图爿',
  `banner_third` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `details_img_first` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `details_img_second` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `details_img_third` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `details_img_fourth` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `details_img_fifth` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_goods_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_detail` VALUES ('1', '1', 'http://pk6b0a7n8.bkt.clouddn.com/static/20190112/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', '', '', '', '', '', '', '', '', '2019-01-11 17:19:19', '2019-01-14 16:44:48', b'0'), ('2', '2', 'http://pk6b0a7n8.bkt.clouddn.com/static/20190112/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', 'http://pk6b0a7n8.bkt.clouddn.com/static/20190112/5fbc5073f7114074b071d6c56fb61a86.jpg', 'http://pk6b0a7n8.bkt.clouddn.com/static/20190113/25aa537d3745416b832634a22df57307.jpg', '', '', '', '', '', 'http://pk6b0a7n8.bkt.clouddn.com/static/20190112/2bc73a752af1401aa83d7f1f337d28b9.jpg', '2019-01-11 17:30:40', '2019-01-13 11:31:21', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
