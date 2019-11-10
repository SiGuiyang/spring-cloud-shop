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

 Date: 11/10/2019 11:03:05 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品品牌';

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
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='品牌组';

-- ----------------------------
--  Records of `t_goods_brand_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_brand_group` VALUES ('1', '手机', '0', 'admin', 'admin', '2019-11-09 12:55:10', '2019-11-09 12:58:48', b'0'), ('2', '电脑', '1', 'admin', 'admin', '2019-11-09 12:55:19', '2019-11-09 12:58:37', b'0'), ('3', '平板电脑', '2', 'admin', 'admin', '2019-11-09 12:55:50', '2019-11-09 12:58:41', b'0'), ('4', '手环', '4', 'admin', 'admin', '2019-11-09 12:56:09', '2019-11-09 12:58:45', b'0'), ('5', '手表', '5', 'admin', 'admin', '2019-11-09 12:56:53', '2019-11-09 12:56:52', b'0'), ('6', '汽车', '6', 'admin', 'admin', '2019-11-09 12:59:26', '2019-11-09 12:59:26', b'0'), ('7', '苹果电脑', '9', 'admin', 'admin', '2019-11-09 13:00:35', '2019-11-09 13:00:34', b'0'), ('8', '男帽', '7', 'admin', 'admin', '2019-11-09 13:01:40', '2019-11-09 13:00:34', b'0'), ('9', '女帽', '8', 'admin', 'admin', '2019-11-09 13:02:03', '2019-11-09 13:00:34', b'0'), ('10', '男裤', '10', 'admin', 'admin', '2019-11-09 13:02:56', '2019-11-09 13:00:34', b'0'), ('11', '女裤', '11', 'admin', 'admin', '2019-11-09 13:03:04', '2019-11-09 13:00:34', b'0'), ('12', '水果', '12', 'admin', 'admin', '2019-11-09 14:25:31', '2019-11-09 14:25:31', b'0'), ('13', '蔬菜', '13', 'admin', 'admin', '2019-11-09 14:25:41', '2019-11-09 14:25:41', b'0'), ('14', '肉类', '14', 'admin', 'admin', '2019-11-09 14:35:32', '2019-11-09 14:35:32', b'0');
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
  `update_time` datetime DEFAULT NULL,
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
  `purchase_sku_count` int(4) DEFAULT NULL COMMENT '购买商品的数量',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商品分类';

-- ----------------------------
--  Records of `t_goods_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class` VALUES ('1', null, '推荐分类', null, 'admin', 'admin', '2019-10-27 13:28:46', '2019-10-27 13:28:55', b'0'), ('2', null, '京东超市', null, 'admin', 'admin', '2019-10-27 13:29:44', '2019-10-27 13:40:30', b'0'), ('3', null, '国际名牌', null, 'admin', 'admin', '2019-10-27 13:40:59', '2019-10-27 13:41:03', b'0'), ('4', null, '奢饰品', null, 'admin', 'admin', '2019-10-27 13:41:04', '2019-10-27 13:41:08', b'0'), ('5', null, '海囤全球', null, 'admin', 'admin', '2019-10-27 13:41:09', '2019-10-27 13:41:13', b'0'), ('6', null, '唯品会', null, 'admin', 'admin', '2019-10-27 13:41:15', '2019-10-27 13:41:17', b'0'), ('7', null, '男装', null, 'admin', 'admin', '2019-10-27 13:42:18', '2019-10-27 13:42:21', b'0'), ('8', null, '女装', null, 'admin', 'admin', '2019-10-27 13:42:22', '2019-10-27 13:42:25', b'0'), ('9', null, '男鞋', null, 'admin', 'admin', '2019-10-27 13:42:26', '2019-10-27 13:42:32', b'0'), ('10', null, '女鞋', null, 'admin', 'admin', '2019-10-27 13:41:19', '2019-10-27 13:41:22', b'0'), ('11', null, '内衣配饰', null, 'admin', 'admin', '2019-10-27 13:42:33', '2019-10-27 13:42:39', b'0'), ('12', null, '箱包手袋', null, 'admin', 'admin', '2019-10-27 13:42:57', '2019-10-27 13:43:00', b'0'), ('13', null, '美妆护肤', null, 'admin', 'admin', '2019-10-27 13:41:34', '2019-10-27 13:41:37', b'0'), ('14', null, '个护清洁', null, 'admin', 'admin', '2019-10-27 13:41:29', '2019-10-27 13:41:33', b'0'), ('15', null, '钟表珠宝', null, 'admin', 'admin', '2019-10-27 13:41:24', '2019-10-27 13:41:27', b'0'), ('16', null, '手机数码', null, 'admin', 'admin', '2019-10-27 13:42:40', '2019-10-27 13:42:42', b'0'), ('17', null, '电脑办公', null, 'admin', 'admin', '2019-10-27 13:43:01', '2019-10-27 13:43:05', b'0'), ('18', null, '家用电器', null, 'admin', 'admin', '2019-10-27 13:41:38', '2019-10-27 13:41:42', b'0'), ('19', null, '食品生鲜', null, 'admin', 'admin', '2019-10-27 13:42:44', '2019-10-27 13:42:47', b'0'), ('20', null, '酒水饮料', null, 'admin', 'admin', '2019-10-27 13:43:07', '2019-10-27 13:43:10', b'0'), ('21', null, '母婴童装', null, 'admin', 'admin', '2019-10-27 13:42:01', '2019-10-27 13:42:05', b'0'), ('22', null, '玩具乐器', null, 'admin', 'admin', '2019-10-27 13:42:49', '2019-10-27 13:42:53', b'0'), ('23', null, '医药保健', null, 'admin', 'admin', '2019-10-27 13:41:44', '2019-10-27 13:41:48', b'0'), ('24', null, '计生情趣', null, 'admin', 'admin', '2019-10-27 13:43:12', '2019-10-27 13:43:15', b'0'), ('25', null, '运动户外', null, 'admin', 'admin', '2019-10-27 13:43:20', '2019-10-27 13:43:23', b'0'), ('26', null, '汽车生活', null, 'admin', 'admin', '2019-10-27 13:41:49', '2019-10-27 13:41:52', b'0'), ('27', null, '家居厨具', null, 'admin', 'admin', '2019-10-27 13:43:16', '2019-10-27 13:43:19', b'0'), ('28', null, '家具家装', null, 'admin', 'admin', '2019-10-27 13:41:53', '2019-10-27 13:41:56', b'0'), ('29', null, '礼品鲜花', null, 'admin', 'admin', '2019-10-27 13:41:57', '2019-10-27 13:42:00', b'0'), ('30', null, '宠物生活', null, 'admin', 'admin', '2019-10-27 13:43:24', '2019-10-27 13:43:29', b'0'), ('31', null, '生活旅行', null, 'admin', 'admin', '2019-10-27 13:42:06', '2019-10-27 13:42:13', b'0'), ('32', '1', '3333', null, 'admin', 'admin', '2019-10-27 14:02:03', '2019-10-27 14:02:22', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class_banner`;
CREATE TABLE `t_goods_class_banner` (
  `goods_class_id` bigint(20) DEFAULT NULL,
  `goods_banner_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类与商品品牌关联';

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
  `property_name` varchar(63) DEFAULT NULL COMMENT '属性名',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性';

-- ----------------------------
--  Table structure for `t_goods_property_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_property_group`;
CREATE TABLE `t_goods_property_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `property_id` bigint(20) DEFAULT NULL COMMENT '商品属性 t_goods_property 主键',
  `property_group_name` varchar(63) DEFAULT NULL COMMENT '属性组名称',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性组';

-- ----------------------------
--  Table structure for `t_goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) DEFAULT NULL COMMENT 't_goods_spu 主键',
  `sku_name` varchar(127) DEFAULT NULL COMMENT '商品sku名称',
  `sku_code` varchar(31) DEFAULT NULL COMMENT 'sku 编码',
  `sku_amount` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `default_sku` bit(1) DEFAULT NULL COMMENT '默认的sku，显示在列表的主sku商品 true, false',
  `sku_status` int(11) DEFAULT NULL COMMENT '商品状态 0 未上架 1 上架申请 2 上架 3 已下架',
  `weight` decimal(10,0) DEFAULT NULL COMMENT '商品重量',
  `unit` varchar(11) DEFAULT NULL COMMENT '商品单位，比如kg',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku';

-- ----------------------------
--  Table structure for `t_goods_sku_image`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_image`;
CREATE TABLE `t_goods_sku_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) DEFAULT NULL COMMENT '商品t_goods_sku id',
  `images` varchar(255) DEFAULT NULL COMMENT '图片路径，存储方式为json格式[{"imageUrl": "/123/abc/2001.png", "master": true},{"imageUrl": "/123/abc/2001.png" , "master": false}]',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品主图集';

-- ----------------------------
--  Table structure for `t_goods_sku_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_property`;
CREATE TABLE `t_goods_sku_property` (
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `property_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_property_group 主键',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku 与商品属性组关联关系表\n多对多关系';

-- ----------------------------
--  Table structure for `t_goods_sku_property_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_property_group`;
CREATE TABLE `t_goods_sku_property_group` (
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `property_group_id` bigint(20) DEFAULT NULL COMMENT 't_goods_property_group 主键',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku与商品属性组property_group 关联表\n多对多关系';

-- ----------------------------
--  Table structure for `t_goods_sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_stock`;
CREATE TABLE `t_goods_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `stock` int(11) DEFAULT NULL COMMENT '商品库存',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品库存表\n库存单独抽取出来\n用于后期扩展使用';

-- ----------------------------
--  Table structure for `t_goods_sku_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_tag`;
CREATE TABLE `t_goods_sku_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) DEFAULT NULL COMMENT 't_goods_sku 主键',
  `sku_tag_name` varchar(63) DEFAULT NULL COMMENT 'sku标签名',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku tag标签';

-- ----------------------------
--  Table structure for `t_goods_spu`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_spu`;
CREATE TABLE `t_goods_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_id` bigint(20) DEFAULT NULL COMMENT '分类 t_goods_class 主键（这个分类必须是二级分类，不可是顶级分类）',
  `spu_name` varchar(63) DEFAULT NULL COMMENT 'spu 名称',
  `spu_image` varchar(127) DEFAULT NULL COMMENT 'spu 图片',
  `sequence` int(4) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品spu';

SET FOREIGN_KEY_CHECKS = 1;
