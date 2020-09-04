/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 101.132.121.178
 Source Database       : pager_goods

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : utf-8

 Date: 09/04/2020 15:27:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL COMMENT 't_goods_brand 品牌主键',
  `gcs_id` bigint(20) NOT NULL COMMENT 't_goods_calss 商品二级分类主键',
  `goods_property_group_id` bigint(20) NOT NULL COMMENT 't_goods_property_group 商品属性组主键',
  `spu_id` bigint(20) DEFAULT NULL COMMENT 'spu 主键',
  `name` varchar(64) NOT NULL COMMENT '商品主表名称',
  `publish_status` int(1) NOT NULL COMMENT '商品状态 0 未上架 1 上架申请 2 上架 3 已下架',
  `goods_type` int(11) DEFAULT NULL,
  `state` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommend` int(1) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `description` text COMMENT '商品描述',
  `weight` decimal(10,0) DEFAULT NULL COMMENT '商品重量',
  `unit` varchar(16) NOT NULL COMMENT '单位',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
--  Records of `t_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods` VALUES ('37', '1', '5', '2', '2', '12', '1', '4', '0', '0', '<p>dadasdadadasdasdasfsfsf</p><p><strong>fdsfsfsa</strong></p><p class=\"ql-align-center\"><strong>fsfsfasff</strong></p><ol><li class=\"ql-align-justify\"><strong>fsfsafasfsafsafsf</strong></li><li class=\"ql-align-justify\"><strong><span class=\"ql-cursor\">﻿﻿</span></strong><img src=\"http://pp7x7b2mm.bkt.clouddn.com/static/2020-05-05/95fd799cfadb47bda7b60ca11e5dae16 (1).jpg\"></li></ol>', null, 'KG', '2020-05-04 14:02:27', '2020-05-31 10:40:25', 'admin', 'admin', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_brand`;
CREATE TABLE `t_goods_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_brand_group 主键',
  `brand_name` varchar(63) DEFAULT NULL COMMENT '品牌名称',
  `brand_code` varchar(64) DEFAULT NULL COMMENT '品牌编码',
  `icon` varchar(127) DEFAULT NULL COMMENT '品牌图标',
  `sequence` int(4) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='商品品牌';

-- ----------------------------
--  Records of `t_goods_brand`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_brand` VALUES ('1', '3', '宝马', '123', 'http://q5u3r2zhc.bkt.clouddn.com/static/2020-02-18/20a950c5384e4e42acf24733f85d43f3.jpg', '1', 'admin', 'admin', '2020-02-18 22:49:59', '2020-08-16 11:12:06', b'1'), ('2', '10', '奥迪', '456', 'http://q5u3r2zhc.bkt.clouddn.com/static/2020-02-18/092c25c8558c419197fe3287f0a0165a.jpg', '2', 'admin', 'admin', '2020-02-18 22:50:41', '2020-08-16 11:12:08', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_brand_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_brand_group`;
CREATE TABLE `t_goods_brand_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_group_name` varchar(63) DEFAULT NULL COMMENT '商品品牌组名称',
  `sequence` int(11) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='品牌组';

-- ----------------------------
--  Records of `t_goods_brand_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_brand_group` VALUES ('1', '手机', '0', 'admin', 'admin', '2019-11-09 12:55:10', '2020-08-16 11:11:27', b'1'), ('2', '电脑', '1', 'admin', 'admin', '2019-11-09 12:55:19', '2020-08-16 11:11:29', b'1'), ('3', '平板电脑', '2', 'admin', 'admin', '2019-11-09 12:55:50', '2020-08-16 11:11:32', b'1'), ('4', '手环', '4', 'admin', 'admin', '2019-11-09 12:56:09', '2020-08-16 11:11:35', b'1'), ('5', '手表', '5', 'admin', 'admin', '2019-11-09 12:56:53', '2020-08-16 11:11:37', b'1'), ('6', '汽车', '6', 'admin', 'admin', '2019-11-09 12:59:26', '2020-08-16 11:11:39', b'1'), ('7', '苹果电脑', '9', 'admin', 'admin', '2019-11-09 13:00:35', '2020-08-16 11:11:49', b'1'), ('8', '男帽', '7', 'admin', 'admin', '2019-11-09 13:01:40', '2020-08-16 11:11:44', b'1'), ('9', '女帽', '8', 'admin', 'admin', '2019-11-09 13:02:03', '2020-08-16 11:11:47', b'1'), ('10', '男裤', '10', 'admin', 'admin', '2019-11-09 13:02:56', '2020-08-16 11:11:51', b'1'), ('11', '女裤', '11', 'admin', 'admin', '2019-11-09 13:03:04', '2020-08-16 11:10:57', b'1'), ('12', '水果', '12', 'admin', 'admin', '2019-11-09 14:25:31', '2020-08-16 11:10:54', b'1'), ('13', '蔬菜', '13', 'admin', 'admin', '2019-11-09 14:25:41', '2020-08-16 11:10:52', b'1'), ('14', '肉类', '14', 'admin', 'admin', '2019-11-09 14:35:32', '2020-08-16 11:10:50', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_brand_spu`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_brand_spu`;
CREATE TABLE `t_goods_brand_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) DEFAULT NULL COMMENT 't_goods_spu 主键',
  `brand_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_brand_group id',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌与商品spu关联关系表\n多对多关系';

-- ----------------------------
--  Table structure for `t_goods_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT 't_user 用户主键',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `purchase_quantity` int(4) DEFAULT NULL COMMENT '购买商品的数量',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='购物车';

-- ----------------------------
--  Records of `t_goods_cart`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_cart` VALUES ('1', '1', '1', '3', null, null, '2019-01-14 14:22:54', '2019-01-14 14:23:02', b'0'), ('2', '1', '2', '5', null, null, '2019-01-14 14:23:16', '2019-01-14 14:23:24', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class`;
CREATE TABLE `t_goods_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '商品父级Id',
  `class_name` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分类名称',
  `icon` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分类图标',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商品分类';

-- ----------------------------
--  Records of `t_goods_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class` VALUES ('1', null, '推荐分类', null, 'admin', 'admin', '2019-10-27 13:28:46', '2019-10-27 13:28:55', b'0'), ('2', null, '京东超市', null, 'admin', 'admin', '2019-10-27 13:29:44', '2019-10-27 13:40:30', b'0'), ('3', null, '国际名牌', null, 'admin', 'admin', '2019-10-27 13:40:59', '2019-10-27 13:41:03', b'0'), ('4', null, '奢饰品', null, 'admin', 'admin', '2019-10-27 13:41:04', '2019-10-27 13:41:08', b'0'), ('5', null, '海囤全球', null, 'admin', 'admin', '2019-10-27 13:41:09', '2019-10-27 13:41:13', b'0'), ('6', null, '唯品会', null, 'admin', 'admin', '2019-10-27 13:41:15', '2019-10-27 13:41:17', b'0'), ('7', null, '男装', null, 'admin', 'admin', '2019-10-27 13:42:18', '2019-10-27 13:42:21', b'0'), ('8', null, '女装', null, 'admin', 'admin', '2019-10-27 13:42:22', '2019-10-27 13:42:25', b'0'), ('9', null, '男鞋', null, 'admin', 'admin', '2019-10-27 13:42:26', '2019-10-27 13:42:32', b'0'), ('10', null, '女鞋', null, 'admin', 'admin', '2019-10-27 13:41:19', '2019-10-27 13:41:22', b'0'), ('11', null, '内衣配饰', null, 'admin', 'admin', '2019-10-27 13:42:33', '2019-10-27 13:42:39', b'0'), ('12', null, '箱包手袋', null, 'admin', 'admin', '2019-10-27 13:42:57', '2019-10-27 13:43:00', b'0'), ('13', null, '美妆护肤', null, 'admin', 'admin', '2019-10-27 13:41:34', '2019-10-27 13:41:37', b'0'), ('14', null, '个护清洁', null, 'admin', 'admin', '2019-10-27 13:41:29', '2019-10-27 13:41:33', b'0'), ('15', null, '钟表珠宝', null, 'admin', 'admin', '2019-10-27 13:41:24', '2019-10-27 13:41:27', b'0'), ('16', null, '手机数码', null, 'admin', 'admin', '2019-10-27 13:42:40', '2019-10-27 13:42:42', b'0'), ('17', null, '电脑办公', null, 'admin', 'admin', '2019-10-27 13:43:01', '2019-10-27 13:43:05', b'0'), ('18', null, '家用电器', null, 'admin', 'admin', '2019-10-27 13:41:38', '2019-10-27 13:41:42', b'0'), ('19', null, '食品生鲜', null, 'admin', 'admin', '2019-10-27 13:42:44', '2019-10-27 13:42:47', b'0'), ('20', null, '酒水饮料', null, 'admin', 'admin', '2019-10-27 13:43:07', '2019-10-27 13:43:10', b'0'), ('21', null, '母婴童装', null, 'admin', 'admin', '2019-10-27 13:42:01', '2019-10-27 13:42:05', b'0'), ('22', null, '玩具乐器', null, 'admin', 'admin', '2019-10-27 13:42:49', '2019-10-27 13:42:53', b'0'), ('23', null, '医药保健', null, 'admin', 'admin', '2019-10-27 13:41:44', '2019-10-27 13:41:48', b'0'), ('24', null, '计生情趣', null, 'admin', 'admin', '2019-10-27 13:43:12', '2019-10-27 13:43:15', b'0'), ('25', null, '运动户外', null, 'admin', 'admin', '2019-10-27 13:43:20', '2019-10-27 13:43:23', b'0'), ('26', null, '汽车生活', null, 'admin', 'admin', '2019-10-27 13:41:49', '2019-10-27 13:41:52', b'0'), ('27', null, '家居厨具', null, 'admin', 'admin', '2019-10-27 13:43:16', '2019-10-27 13:43:19', b'0'), ('28', null, '家具家装', null, 'admin', 'admin', '2019-10-27 13:41:53', '2019-10-27 13:41:56', b'0'), ('29', null, '礼品鲜花', null, 'admin', 'admin', '2019-10-27 13:41:57', '2019-10-27 13:42:00', b'0'), ('30', null, '宠物生活', null, 'admin', 'admin', '2019-10-27 13:43:24', '2019-10-27 13:43:29', b'0'), ('31', null, '生活旅行', null, 'admin', 'admin', '2019-10-27 13:42:06', '2019-10-27 13:42:13', b'0'), ('32', '1', '3333', null, 'admin', 'admin', '2019-10-27 14:02:03', '2020-08-16 11:03:34', b'1'), ('33', '2', 'hhh', null, 'admin', 'admin', '2020-04-19 11:34:57', '2020-08-16 11:03:32', b'1'), ('34', '32', 'hhh', null, 'admin', 'admin', '2020-04-19 11:55:07', '2020-08-16 11:03:29', b'1'), ('35', '32', 'hhh', null, 'admin', 'admin', '2020-04-19 14:43:58', '2020-08-16 11:03:27', b'1'), ('36', null, '图书文娱', null, 'admin', 'admin', '2020-08-16 12:36:02', '2020-08-16 12:36:02', b'0'), ('37', null, '艺术邮币', null, 'admin', 'admin', '2020-08-16 12:36:21', '2020-08-16 12:36:21', b'0'), ('38', null, '农资园艺', null, 'admin', 'admin', '2020-08-16 12:36:31', '2020-08-16 12:36:31', b'0'), ('39', null, '特产管', null, 'admin', 'admin', '2020-08-16 12:36:41', '2020-08-16 12:36:41', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class_banner`;
CREATE TABLE `t_goods_class_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classification_id` bigint(20) DEFAULT NULL,
  `banner_id` bigint(20) DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='商品分类与商品品牌关联';

-- ----------------------------
--  Records of `t_goods_class_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class_banner` VALUES ('2', '35', '10', 'admin', 'admin', '2020-04-19 15:21:16', '2020-08-16 11:03:01', b'0'), ('3', '34', '6', 'admin', 'admin', '2020-04-19 15:49:40', '2020-04-19 15:49:40', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class_brand`;
CREATE TABLE `t_goods_class_brand` (
  `goods_class_id` bigint(20) DEFAULT NULL,
  `goods_brand_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类与商品品牌关联';

-- ----------------------------
--  Table structure for `t_goods_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_property`;
CREATE TABLE `t_goods_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `property_group_id` bigint(20) DEFAULT NULL COMMENT '属性组主键',
  `property_name` varchar(63) DEFAULT NULL COMMENT '属性名',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='商品属性';

-- ----------------------------
--  Records of `t_goods_property`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_property` VALUES ('1', '1', '白色', 'admin', 'admin', '2020-02-18 18:39:58', '2020-08-16 11:14:27', b'1'), ('2', '1', '红色', 'admin', 'admin', '2020-02-18 21:21:39', '2020-08-16 11:14:35', b'1'), ('3', '1', '灰色', 'admin', 'admin', '2020-02-18 21:30:52', '2020-08-16 11:14:30', b'1'), ('4', '1', '橙色', 'admin', 'admin', '2020-03-01 20:17:16', '2020-08-16 11:14:32', b'1'), ('5', '2', '4X4', 'admin', 'admin', '2020-04-06 18:25:37', '2020-08-16 11:14:37', b'1'), ('6', '2', '4X5', 'admin', 'admin', '2020-04-06 18:30:28', '2020-08-16 11:14:40', b'1'), ('7', '2', '4X6', 'admin', 'admin', '2020-04-06 18:31:49', '2020-08-16 11:14:54', b'1'), ('8', '2', '4X7', 'admin', 'admin', '2020-04-06 18:34:31', '2020-08-16 11:14:52', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_property_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_property_group`;
CREATE TABLE `t_goods_property_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `property_group_name` varchar(63) DEFAULT NULL COMMENT '属性组名称',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商品属性组';

-- ----------------------------
--  Records of `t_goods_property_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_property_group` VALUES ('1', '颜色', 'admin', 'admin', '2020-02-18 18:56:53', '2020-08-16 11:14:13', b'1'), ('2', '规格', 'admin', 'admin', '2020-02-18 21:59:27', '2020-08-16 11:14:07', b'1'), ('3', '尺寸', 'admin', 'admin', '2020-04-06 18:36:30', '2020-08-16 11:14:16', b'1'), ('4', '内存', 'admin', 'admin', '2020-04-06 18:39:57', '2020-08-16 11:14:18', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品主表主键',
  `sku_name` varchar(127) DEFAULT NULL COMMENT '商品sku名称',
  `sku_code` varchar(31) DEFAULT NULL COMMENT 'sku 编码',
  `sku_amount` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `discount_amount` decimal(10,0) DEFAULT NULL COMMENT '折扣价',
  `default_sku` bit(1) DEFAULT NULL COMMENT '默认的sku，显示在列表的主sku商品 true, false',
  `inventory` int(11) DEFAULT NULL COMMENT '入库量（库存量）',
  `description` text COMMENT '说明',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='商品sku';

-- ----------------------------
--  Records of `t_goods_sku`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_sku` VALUES ('1', '37', 'dsds', 'SKU5eb100114ceaf071a52d35d9', '12', '212', b'0', '222', null, 'admin', 'admin', '2020-05-05 13:56:34', '2020-05-31 10:12:03', b'1'), ('2', '37', 'dsds', 'SKU5eb100134ceaf071a52d35da', '12', '212', b'0', '222', null, 'admin', 'admin', '2020-05-05 13:56:35', '2020-05-31 10:12:08', b'1'), ('3', '37', 'dsds', 'SKU5eb1001d4ceaf071a52d35db', '12', '212', b'0', '222', null, 'admin', 'admin', '2020-05-05 13:56:45', '2020-05-31 10:12:12', b'1'), ('4', '37', 'dsds', 'SKU5eb100394ceaf071a52d35dc', '12', '212', b'0', '222', null, 'admin', 'admin', '2020-05-05 13:57:13', '2020-05-31 10:12:15', b'1'), ('5', '37', 'dsds', 'SKU5eb101ac4ceaf071a52d35dd', '12', '212', b'0', '222', null, 'admin', 'admin', '2020-05-05 14:03:24', '2020-05-31 10:12:18', b'1'), ('6', '37', 'ddasd', 'SKU1257556549916823552', '22', '43', b'0', '1111', null, 'admin', 'admin', '2020-05-05 14:23:40', '2020-08-16 11:22:28', b'1'), ('7', '37', '生姜', 'SKU1266920087634448384', '12', '10', b'0', '100', '<p>很快就会看见好看好看</p>', 'admin', 'admin', '2020-05-31 10:31:02', '2020-08-16 11:22:26', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_sku_image`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_image`;
CREATE TABLE `t_goods_sku_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品信息主键',
  `sku_id` bigint(20) DEFAULT NULL COMMENT '商品t_goods_sku id',
  `images` varchar(2000) DEFAULT NULL COMMENT '图片路径，存储方式为json格式[{ "/123/abc/2001.png"}]',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='商品主图集';

-- ----------------------------
--  Records of `t_goods_sku_image`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_sku_image` VALUES ('1', '37', '5', '[{\"name\":\"41f82e8b05744a6fbf20a9c008a9fd6d.jpg\",\"url\":\"http://pp7x7b2mm.bkt.clouddn.com/static/2020-05-05/41f82e8b05744a6fbf20a9c008a9fd6d.jpg\"},{\"name\":\"108cfb90f64a4267a21106d1f8053c89.jpg\",\"url\":\"http://pp7x7b2mm.bkt.clouddn.com/static/2020-05-05/108cfb90f64a4267a21106d1f8053c89.jpg\"}]', 'admin', 'admin', '2020-05-05 14:03:24', '2020-05-05 14:03:24', b'0'), ('2', '37', '6', '[{\"name\":\"328ddb5849584056b38f0c003313f152.jpg\",\"url\":\"http://pp7x7b2mm.bkt.clouddn.com/static/2020-05-05/328ddb5849584056b38f0c003313f152.jpg\"},{\"name\":\"643359975ce3484a99bcf1e077a67cd7.jpg\",\"url\":\"http://pp7x7b2mm.bkt.clouddn.com/static/2020-05-05/643359975ce3484a99bcf1e077a67cd7.jpg\"}]', 'admin', 'admin', '2020-05-05 14:23:40', '2020-05-05 14:23:40', b'0'), ('3', '37', '7', '[{\"name\":\"20a950c5384e4e42acf24733f85d43f3.jpg\",\"url\":\"null/2020-05-31/20a950c5384e4e42acf24733f85d43f3.jpg\"},{\"name\":\"20a950c5384e4e42acf24733f85d43f3.jpg\",\"url\":\"static/2020-05-31/20a950c5384e4e42acf24733f85d43f3.jpg\"},{\"name\":\"8cca633b0b884faea8d6a56a3c7eeb75.jpg\",\"url\":\"static/2020-05-31/8cca633b0b884faea8d6a56a3c7eeb75.jpg\"}]', 'admin', 'admin', '2020-05-31 10:31:02', '2020-05-31 10:31:02', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_sku_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_property`;
CREATE TABLE `t_goods_sku_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品信息主键',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `property_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_property_group 主键',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku 与商品属性组关联关系表\n多对多关系';

-- ----------------------------
--  Table structure for `t_goods_sku_property_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_property_group`;
CREATE TABLE `t_goods_sku_property_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品信息主键',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `property_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_property_group 主键',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku与商品属性组property_group 关联表\n多对多关系';

-- ----------------------------
--  Table structure for `t_goods_sku_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_tag`;
CREATE TABLE `t_goods_sku_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `name` varchar(63) DEFAULT NULL COMMENT 'sku标签名',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku tag标签';

-- ----------------------------
--  Table structure for `t_goods_spu`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_spu`;
CREATE TABLE `t_goods_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classification_id` bigint(20) DEFAULT NULL COMMENT '分类 t_goods_class 主键（这个分类必须是二级分类，不可是顶级分类）',
  `spu_name` varchar(63) DEFAULT NULL COMMENT 'spu 名称',
  `spu_image` varchar(127) DEFAULT NULL COMMENT 'spu 图片',
  `sequence` int(4) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='商品spu';

-- ----------------------------
--  Records of `t_goods_spu`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_spu` VALUES ('1', '1', '水果', null, '1', 'admin', 'admin', '2020-02-17 15:21:51', '2020-05-31 10:10:57', b'1'), ('2', '3', '蔬菜', null, '2', 'admin', 'admin', '2020-04-05 20:16:15', '2020-08-16 11:20:27', b'1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
