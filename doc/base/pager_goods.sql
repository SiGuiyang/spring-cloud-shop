/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 106.54.251.32
 Source Database       : pager_goods

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 12/20/2020 19:12:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_class_id` bigint(20) NOT NULL COMMENT 't_goods_calss 商品二级分类主键',
  `publish_status` int(1) NOT NULL COMMENT '商品审核 0 上架申请 1 审核通过 2 审核拒绝',
  `goods_type` int(11) DEFAULT NULL,
  `goods_state` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommend` int(1) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `description` text COMMENT '商品描述',
  `unit` varchar(16) NOT NULL COMMENT '单位',
  `begin_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
--  Records of `t_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods` VALUES ('43', '259', '1', '1', '0', '0', null, 'g', '2020-11-05', '2020-11-26', '2020-11-21 21:26:12', '2020-12-06 14:33:37', 'admin', 'admin', '1'), ('45', '259', '2', '2', '0', '1', null, 'g', '2020-11-19', '2020-11-30', '2020-11-21 22:16:37', '2020-12-06 14:36:52', 'admin', 'admin', '1'), ('49', '259', '0', '4', '0', '0', null, 'g', '2020-12-06', '2020-12-18', '2020-12-06 14:49:09', '2020-12-06 14:49:09', 'admin', 'admin', '1'), ('50', '265', '0', '2', '1', '1', null, 'g', '2020-12-06', '2021-01-01', '2020-12-06 14:52:09', '2020-12-06 14:52:09', 'admin', 'admin', '1'), ('51', '245', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:14:24', '2020-12-12 14:02:28', 'admin', 'admin', '0'), ('52', '245', '1', '1', '1', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:18:06', '2020-12-12 14:02:33', 'admin', 'admin', '0'), ('53', '248', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:21:58', '2020-12-12 14:02:38', 'admin', 'admin', '0'), ('54', '258', '1', '1', '1', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:24:01', '2020-12-12 14:02:45', 'admin', 'admin', '0'), ('55', '260', '1', '2', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:27:30', '2020-12-12 14:02:50', 'admin', 'admin', '0'), ('56', '262', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:29:52', '2020-12-12 14:02:54', 'admin', 'admin', '0'), ('57', '263', '1', '1', '1', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:32:49', '2020-12-12 14:02:58', 'admin', 'admin', '0'), ('58', '262', '1', '1', '0', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:35:53', '2020-12-12 14:03:04', 'admin', 'admin', '0'), ('59', '265', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:39:35', '2020-12-12 14:03:10', 'admin', 'admin', '0'), ('60', '265', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:44:17', '2020-12-12 14:03:14', 'admin', 'admin', '0'), ('61', '266', '1', '1', '0', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:48:59', '2020-12-12 14:03:21', 'admin', 'admin', '0'), ('62', '267', '1', '1', '0', '0', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 21:55:58', '2020-12-12 14:03:25', 'admin', 'admin', '0'), ('63', '268', '1', '1', '1', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 22:09:58', '2020-12-12 14:03:29', 'admin', 'admin', '0'), ('64', '272', '1', '1', '1', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 22:12:25', '2020-12-12 14:03:33', 'admin', 'admin', '0'), ('65', '272', '1', '1', '1', '1', null, 'g', '2020-12-08', '2021-12-31', '2020-12-08 22:15:06', '2020-12-12 14:03:37', 'admin', 'admin', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_approve`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_approve`;
CREATE TABLE `t_goods_approve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `publish_status` int(11) DEFAULT NULL COMMENT '商品审核 0 上架申请 1 审核通过 2 审核拒绝',
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_goods_approve`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_approve` VALUES ('1', '43', '14', '1', '但是分身乏术地方', '2020-12-06 14:33:37', '2020-12-06 14:33:37', 'admin', 'admin', b'0'), ('2', '45', '16', '2', '好借好还开会讲话', '2020-12-06 14:36:52', '2020-12-06 14:36:52', 'admin', 'admin', b'0'), ('3', '51', '21', '1', null, '2020-12-12 14:02:28', '2020-12-12 14:02:28', 'admin', 'admin', b'0'), ('4', '52', '22', '1', null, '2020-12-12 14:02:33', '2020-12-12 14:02:33', 'admin', 'admin', b'0'), ('5', '53', '23', '1', null, '2020-12-12 14:02:38', '2020-12-12 14:02:38', 'admin', 'admin', b'0'), ('6', '54', '24', '1', null, '2020-12-12 14:02:45', '2020-12-12 14:02:45', 'admin', 'admin', b'0'), ('7', '55', '25', '1', null, '2020-12-12 14:02:49', '2020-12-12 14:02:49', 'admin', 'admin', b'0'), ('8', '56', '26', '1', null, '2020-12-12 14:02:54', '2020-12-12 14:02:54', 'admin', 'admin', b'0'), ('9', '57', '27', '1', null, '2020-12-12 14:02:58', '2020-12-12 14:02:58', 'admin', 'admin', b'0'), ('10', '58', '28', '1', null, '2020-12-12 14:03:04', '2020-12-12 14:03:04', 'admin', 'admin', b'0'), ('11', '59', '29', '1', null, '2020-12-12 14:03:10', '2020-12-12 14:03:10', 'admin', 'admin', b'0'), ('12', '60', '30', '1', null, '2020-12-12 14:03:14', '2020-12-12 14:03:14', 'admin', 'admin', b'0'), ('13', '61', '31', '1', null, '2020-12-12 14:03:21', '2020-12-12 14:03:21', 'admin', 'admin', b'0'), ('14', '62', '32', '1', null, '2020-12-12 14:03:25', '2020-12-12 14:03:25', 'admin', 'admin', b'0'), ('15', '63', '33', '1', null, '2020-12-12 14:03:29', '2020-12-12 14:03:29', 'admin', 'admin', b'0'), ('16', '64', '34', '1', null, '2020-12-12 14:03:33', '2020-12-12 14:03:33', 'admin', 'admin', b'0'), ('17', '65', '35', '1', null, '2020-12-12 14:03:37', '2020-12-12 14:03:37', 'admin', 'admin', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class`;
CREATE TABLE `t_goods_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) DEFAULT NULL COMMENT 'spu 主键',
  `class_name` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分类名称',
  `sequence` int(11) DEFAULT NULL,
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=314 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='商品分类';

-- ----------------------------
--  Records of `t_goods_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class` VALUES ('245', '1', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('246', '1', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:23', b'0'), ('247', '1', '平价好菜', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:26', b'0'), ('248', '1', '崇明蔬菜', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:29', b'0'), ('249', '1', '绿叶蔬菜', '5', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:32', b'0'), ('250', '1', '土豆/根茎', '6', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:35', b'0'), ('251', '1', '番茄/茄瓜果', '7', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:39', b'0'), ('252', '1', '花菜/球菜', '8', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:42', b'0'), ('253', '1', '营养菌菇', '9', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:45', b'0'), ('254', '1', '供港蔬菜', '10', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:48', b'0'), ('255', '1', '豆类/芽苗', '11', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:50', b'0'), ('256', '1', '一顿吃光', '12', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:52', b'0'), ('257', '1', '香辛葱蒜', '13', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:55', b'0'), ('258', '2', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('259', '2', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:11', b'0'), ('260', '2', '特惠专区', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:12', b'0'), ('261', '2', '日日鲜', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:16', b'0'), ('262', '3', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('263', '3', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:02', b'0'), ('264', '3', '大闸蟹', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:04', b'0'), ('265', '3', '鲜活虾蟹', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:23:09', b'0'), ('266', '4', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('267', '4', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:49', b'0'), ('268', '4', '热销', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:53', b'0'), ('269', '4', '特惠专区', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:56', b'0'), ('270', '5', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('271', '5', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:34', b'0'), ('272', '5', '今日鲜奶', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:36', b'0'), ('273', '5', '面包蛋糕', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:40', b'0'), ('274', '6', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('275', '6', '特惠专区', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:23', b'0'), ('276', '6', '新品', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:25', b'0'), ('277', '6', '包子馒头', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:29', b'0'), ('278', '7', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('279', '7', '特惠专区', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:11', b'0'), ('280', '7', '日日鲜面', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:14', b'0'), ('281', '7', '鲜面年糕', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:18', b'0'), ('282', '8', '特惠专区', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('283', '8', '推荐', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:01', b'0'), ('284', '8', '碳酸饮料', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:04', b'0'), ('285', '8', '茶饮果饮', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:22:08', b'0'), ('286', '9', '今日力荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('287', '9', '本周上新', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:51', b'0'), ('288', '9', '超值套餐', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:54', b'0'), ('289', '9', '家常小炒', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:59', b'0'), ('290', '10', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('291', '10', '特惠专区', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:38', b'0'), ('292', '10', '组合套餐', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:41', b'0'), ('293', '10', '大满贯', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:47', b'0'), ('294', '11', '今日C位', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('295', '11', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:30', b'0'), ('296', '11', '粉面馆儿', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:32', b'0'), ('297', '11', '零食铺子', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:36', b'0'), ('298', '12', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('299', '12', '清洁用品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:17', b'0'), ('300', '12', '保鲜袋', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:19', b'0'), ('301', '12', '纸巾湿巾', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:26', b'0'), ('302', '13', '推荐', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('303', '13', '新品', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:07', b'0'), ('304', '13', '日日鲜早餐', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:10', b'0'), ('305', '13', '手抓饼', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:13', b'0'), ('306', '14', '煌上煌', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('307', '14', '周黑鸭', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:20:58', b'0'), ('308', '14', '久久丫', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:01', b'0'), ('309', '14', '紫燕', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:21:05', b'0'), ('310', '15', '特惠专区', '1', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:01:00', b'0'), ('311', '15', '推荐', '2', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:20:46', b'0'), ('312', '15', '薯片炒货', '3', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:20:48', b'0'), ('313', '15', '坚果炒货', '4', 'admin', 'admin', '2020-11-21 21:01:00', '2020-11-21 21:20:55', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品主表主键',
  `sku_name` varchar(127) DEFAULT NULL COMMENT '商品sku名称',
  `sku_code` varchar(63) DEFAULT NULL COMMENT 'sku 编码',
  `weight` decimal(10,0) DEFAULT NULL COMMENT '含重量',
  `sku_amount` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '折扣价',
  `state` bit(1) DEFAULT NULL COMMENT '商品状态 0 未上架 1 上架',
  `default_sku` bit(1) DEFAULT NULL COMMENT '默认的sku，显示在列表的主sku商品 true, false',
  `description` text COMMENT '说明',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COMMENT='商品sku';

-- ----------------------------
--  Records of `t_goods_sku`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_sku` VALUES ('14', '43', '问问', null, '200', '11111.00', '11.00', b'1', b'0', '<p>v想吃vxvxcvxcvx</p>', 'admin', 'admin', '2020-11-21 21:26:12', '2020-12-08 21:10:37', b'1'), ('16', '45', '我付水电费水电费', null, '500', '121.00', '120.00', b'1', b'0', '<p>大大大时</p>', 'admin', 'admin', '2020-11-21 22:16:37', '2020-12-08 21:10:40', b'1'), ('19', '49', '测试', 'SKUcn.hutool.core.lang.Snowflake@7d3e533e', '500', '100.00', '99.00', b'0', null, '<p>放松放松放松的</p>', 'admin', 'admin', '2020-12-06 14:49:09', '2020-12-08 21:10:43', b'1'), ('20', '50', '的哦大闸蟹', 'SKU1335477107220418560', '1500', '100.00', '99.00', b'0', null, '<p>收到方式的分身乏术的反倒是付水电费水电费</p>', 'admin', 'admin', '2020-12-06 14:52:09', '2020-12-08 21:10:46', b'1'), ('21', '51', '崇明水果玉米 350g/份', 'SKU1336298080001724416', '350', '13.00', '13.00', b'1', null, '<p>源自生态岛，可以吃的玉米</p>', 'admin', 'admin', '2020-12-08 21:14:24', '2020-12-12 14:02:28', b'0'), ('22', '52', '崇明苦瓜 500g/份', 'SKU1336299009912475648', '500', '10.00', '10.00', b'1', null, '<p>源自生态岛 小仙女夏日必吃 高颜值的秘密</p>', 'admin', 'admin', '2020-12-08 21:18:06', '2020-12-12 14:02:33', b'0'), ('23', '53', '崇明芦笋 350g/份', 'SKU1336299983309770752', '350', '12.00', '12.00', b'1', null, '<p>安心菜 源自生态岛 嫩到没朋友</p>', 'admin', 'admin', '2020-12-08 21:21:58', '2020-12-12 14:02:38', b'0'), ('24', '54', '爱森五花肉 500g', 'SKU1336300501616693248', '500', '47.00', '47.00', b'1', null, '<p>高端五花肉 吃出幸福的滋味</p>', 'admin', 'admin', '2020-12-08 21:24:02', '2020-12-12 14:02:45', b'0'), ('25', '55', '云南文山黄牛鲜牛里脊 260g', 'SKU1336301376946966528', '260', '40.00', '40.00', b'1', null, '<p>牛的小肉 轻松炒制就很香嫩</p>', 'admin', 'admin', '2020-12-08 21:27:30', '2020-12-12 14:02:50', b'0'), ('26', '56', '鲜活光明鳊鱼 550g以上', 'SKU1336301973448298496', '550', '22.00', '22.00', b'1', null, '<p>一条带身份证的“鳊鱼”</p>', 'admin', 'admin', '2020-12-08 21:29:52', '2020-12-12 14:02:54', b'0'), ('27', '57', '鲜活光明鲫鱼 450g以上', 'SKU1336302716251148288', '450', '20.00', '20.00', b'1', null, '<p>一条带身份证的品牌鲫鱼哦</p>', 'admin', 'admin', '2020-12-08 21:32:50', '2020-12-12 14:02:58', b'0'), ('28', '58', '冰鲜海蛎肉 200g/罐', 'SKU1336303486476357632', '200', '15.00', '15.00', b'1', null, '<p>肉肥爽滑 海中牛奶～ 小心有碎壳</p>', 'admin', 'admin', '2020-12-08 21:35:53', '2020-12-12 14:03:04', b'0'), ('29', '59', '鲜活大头虾 350g', 'SKU1336304417410519040', '350', '40.00', '40.00', b'1', null, '<p>活碰乱跳个头大 每一只精挑细选！</p>', 'admin', 'admin', '2020-12-08 21:39:35', '2020-12-12 14:03:10', b'0'), ('30', '60', '鲜活蛤蜊 500g', 'SKU1336305601957466112', '500', '20.00', '20.00', b'1', null, '<p>吃了蛤蜊肉 百味都失灵</p>', 'admin', 'admin', '2020-12-08 21:44:18', '2020-12-12 14:03:14', b'0'), ('31', '61', '巨峰葡萄 500g', 'SKU1336306781886484480', '500', '13.00', '13.00', b'1', null, '<p>酸甜味浓 皮薄易撕</p>', 'admin', 'admin', '2020-12-08 21:48:59', '2020-12-12 14:03:21', b'0'), ('32', '62', '云南红提 400g', 'SKU1336308539706707968', '400', '10.00', '10.00', b'1', null, '<p>高原上的红宝石</p>', 'admin', 'admin', '2020-12-08 21:55:58', '2020-12-12 14:03:25', b'0'), ('33', '63', '宁夏硒砂瓜1个 约15斤', 'SKU1336312062494248960', '15000', '35.00', '28.00', b'1', null, '<p>石缝里长出的西瓜</p>', 'admin', 'admin', '2020-12-08 22:09:58', '2020-12-12 14:03:29', b'0'), ('34', '64', '【今日上架】光明优倍高品质鲜牛奶 950ml/盒', 'SKU1336312680151650304', '950', '23.00', '23.00', b'1', null, '<p>新老包装混发</p>', 'admin', 'admin', '2020-12-08 22:12:25', '2020-12-12 14:03:33', b'0'), ('35', '65', '延世新鲜牧场牛奶 1L/瓶', 'SKU1336313356986486784', '10000', '35.00', '35.00', b'1', null, '<p>韩国原装进口 来自延世牧场的新鲜问候</p>', 'admin', 'admin', '2020-12-08 22:15:06', '2020-12-12 14:03:37', b'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COMMENT='商品主图集';

-- ----------------------------
--  Records of `t_goods_sku_image`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_sku_image` VALUES ('9', '43', '14', '[{\"name\":\"858ba9b8b33145c288477c2b0f2d790e.jpg\",\"status\":\"success\",\"uid\":1605965163138,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-21/858ba9b8b33145c288477c2b0f2d790e.jpg?Expires=1921325162&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=vxPVjKWkR9b8mtOmXu%2BITMou7xo%3D\"}]', 'admin', 'admin', '2020-11-21 21:26:12', '2020-12-08 21:10:37', b'1'), ('11', '45', '16', '[{\"name\":\"328ddb5849584056b38f0c003313f152.jpg\",\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-21/328ddb5849584056b38f0c003313f152.jpg?Expires=1921328190&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=MseKP6u%2FA%2FcaMQz2QTv3jjfKQ34%3D\"}]', 'admin', 'admin', '2020-11-21 22:16:37', '2020-12-08 21:10:40', b'1'), ('14', '49', '19', '[{\"name\":\"092c25c8558c419197fe3287f0a0165a.jpg\",\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-06/092c25c8558c419197fe3287f0a0165a.jpg?Expires=1922597301&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=65uWKmvqU6uYNc1oATeDvrVYRhE%3D\"}]', 'admin', 'admin', '2020-12-06 14:49:09', '2020-12-08 21:10:43', b'1'), ('15', '50', '20', '[{\"name\":\"95fd799cfadb47bda7b60ca11e5dae16 (1).jpg\",\"status\":\"success\",\"uid\":1607237522968,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-06/95fd799cfadb47bda7b60ca11e5dae16%20%281%29.jpg?Expires=1922597521&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=j%2BDRA3Uaukl2QsRS7xzuzyN5lTM%3D\"}]', 'admin', 'admin', '2020-12-06 14:52:09', '2020-12-08 21:10:46', b'1'), ('16', '51', '21', '[{\"name\":\"崇明水果玉米 350g:份.jpg\",\"status\":\"success\",\"uid\":1607433230149,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%B4%87%E6%98%8E%E6%B0%B4%E6%9E%9C%E7%8E%89%E7%B1%B3%20350g%3A%E4%BB%BD.jpg?Expires=1922793220&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=IBkVIjb7mdDM3%2BcV6pfPOHarmnw%3D\"}]', 'admin', 'admin', '2020-12-08 21:14:24', '2020-12-08 21:14:24', b'0'), ('17', '52', '22', '[{\"name\":\"崇明苦瓜 500g:份.jpg\",\"status\":\"success\",\"uid\":1607433409422,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%B4%87%E6%98%8E%E8%8B%A6%E7%93%9C%20500g%3A%E4%BB%BD.jpg?Expires=1922793399&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=ZI4AF28JKOH3Q3lFXheIz0o2Dvg%3D\"}]', 'admin', 'admin', '2020-12-08 21:18:06', '2020-12-08 21:18:06', b'0'), ('18', '53', '23', '[{\"name\":\"崇明芦笋 350g:份.jpg\",\"status\":\"success\",\"uid\":1607433624556,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%B4%87%E6%98%8E%E8%8A%A6%E7%AC%8B%20350g%3A%E4%BB%BD.jpg?Expires=1922793615&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=MD3zQj6Hy3G0w5oJc8jFgNSy5v8%3D\"}]', 'admin', 'admin', '2020-12-08 21:21:58', '2020-12-08 21:21:58', b'0'), ('19', '54', '24', '[{\"name\":\"爱森五花肉 500g.jpg\",\"status\":\"success\",\"uid\":1607433821961,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E7%88%B1%E6%A3%AE%E4%BA%94%E8%8A%B1%E8%82%89%20500g.jpg?Expires=1922793806&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=47XreqahuQkJ1nILP0CNqqgiDlc%3D\"}]', 'admin', 'admin', '2020-12-08 21:24:02', '2020-12-08 21:24:02', b'0'), ('20', '55', '25', '[{\"name\":\"云南文山黄牛鲜牛里脊 260g.jpg\",\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E4%BA%91%E5%8D%97%E6%96%87%E5%B1%B1%E9%BB%84%E7%89%9B%E9%B2%9C%E7%89%9B%E9%87%8C%E8%84%8A%20260g.jpg?Expires=1922794046&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=QNLrsCy9LjoxCKgHIOM9Yd0fHaI%3D\"}]', 'admin', 'admin', '2020-12-08 21:27:30', '2020-12-08 21:27:30', b'0'), ('21', '56', '26', '[{\"name\":\"鲜活光明鳊鱼 550g以上.jpg\",\"status\":\"success\",\"uid\":1607434175057,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E9%B2%9C%E6%B4%BB%E5%85%89%E6%98%8E%E9%B3%8A%E9%B1%BC%20550g%E4%BB%A5%E4%B8%8A.jpg?Expires=1922794160&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=PA9MbQUOQPfXP8%2Fl81sR%2B%2BZACDM%3D\"}]', 'admin', 'admin', '2020-12-08 21:29:53', '2020-12-08 21:29:53', b'0'), ('22', '57', '27', '[{\"name\":\"鲜活光明鲫鱼 450g以上.png\",\"status\":\"success\",\"uid\":1607434342433,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/png/2020-12-08/%E9%B2%9C%E6%B4%BB%E5%85%89%E6%98%8E%E9%B2%AB%E9%B1%BC%20450g%E4%BB%A5%E4%B8%8A.png?Expires=1922794331&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=Ro8FvbOKvm0RmIm8iVjvbOyIEOo%3D\"}]', 'admin', 'admin', '2020-12-08 21:32:50', '2020-12-08 21:32:50', b'0'), ('23', '58', '28', '[{\"name\":\"冰鲜海蛎肉 200g:罐.jpg\",\"status\":\"success\",\"uid\":1607434518078,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%86%B0%E9%B2%9C%E6%B5%B7%E8%9B%8E%E8%82%89%20200g%3A%E7%BD%90.jpg?Expires=1922794511&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=mv2Fzcg3c%2BJhem2HtvgqWB8pOGg%3D\"}]', 'admin', 'admin', '2020-12-08 21:35:53', '2020-12-08 21:35:53', b'0'), ('24', '59', '29', '[{\"name\":\"鲜活大头虾 350g.jpg\",\"status\":\"success\",\"uid\":1607434749322,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E9%B2%9C%E6%B4%BB%E5%A4%A7%E5%A4%B4%E8%99%BE%20350g.jpg?Expires=1922794741&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=hXpARAt9s7YIyXHMdrImRQX1Kvw%3D\"}]', 'admin', 'admin', '2020-12-08 21:39:35', '2020-12-08 21:39:35', b'0'), ('25', '60', '30', '[{\"name\":\"鲜活蛤蜊 500g.jpg\",\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E9%B2%9C%E6%B4%BB%E8%9B%A4%E8%9C%8A%20500g.jpg?Expires=1922795054&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=BWRn7HHcwnAVPhNTwUaVsDdz%2Beg%3D\"}]', 'admin', 'admin', '2020-12-08 21:44:18', '2020-12-08 21:44:18', b'0'), ('26', '61', '31', '[{\"name\":\"巨峰葡萄 500g.jpg\",\"status\":\"success\",\"uid\":1607435287746,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%B7%A8%E5%B3%B0%E8%91%A1%E8%90%84%20500g.jpg?Expires=1922795278&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=BG68abWRxzhGPIVX3pAn38kV6Lk%3D\"}]', 'admin', 'admin', '2020-12-08 21:48:59', '2020-12-08 21:48:59', b'0'), ('27', '62', '32', '[{\"name\":\"云南红提 400g.jpg\",\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E4%BA%91%E5%8D%97%E7%BA%A2%E6%8F%90%20400g.jpg?Expires=1922795754&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=Xmkr%2FldYhKffmdwU3hCHQoHIRmg%3D\"}]', 'admin', 'admin', '2020-12-08 21:55:58', '2020-12-08 21:55:58', b'0'), ('28', '63', '33', '[{\"name\":\"宁夏硒砂瓜1个 约15斤.jpg\",\"status\":\"success\",\"uid\":1607436586464,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%AE%81%E5%A4%8F%E7%A1%92%E7%A0%82%E7%93%9C1%E4%B8%AA%20%E7%BA%A615%E6%96%A4.jpg?Expires=1922796580&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=n4RaTpFLt5Et0jBCDp95u6flxTM%3D\"}]', 'admin', 'admin', '2020-12-08 22:09:58', '2020-12-08 22:09:58', b'0'), ('29', '64', '34', '[{\"name\":\"【今日上架】光明优倍高品质鲜牛奶 950ml:盒.jpg\",\"status\":\"success\",\"uid\":1607436732050,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E3%80%90%E4%BB%8A%E6%97%A5%E4%B8%8A%E6%9E%B6%E3%80%91%E5%85%89%E6%98%8E%E4%BC%98%E5%80%8D%E9%AB%98%E5%93%81%E8%B4%A8%E9%B2%9C%E7%89%9B%E5%A5%B6%20950ml%3A%E7%9B%92.jpg?Expires=1922796730&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=X7K2zABc2vfZQWdBlB%2FkqClOMf8%3D\"}]', 'admin', 'admin', '2020-12-08 22:12:25', '2020-12-08 22:12:25', b'0'), ('30', '65', '35', '[{\"name\":\"延世新鲜牧场牛奶 1L:瓶.jpg\",\"status\":\"success\",\"uid\":1607436838316,\"url\":\"http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%BB%B6%E4%B8%96%E6%96%B0%E9%B2%9C%E7%89%A7%E5%9C%BA%E7%89%9B%E5%A5%B6%201L%3A%E7%93%B6.jpg?Expires=1922796828&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=ZvnVFoBrP8WU4mATATVMKqu3aM0%3D\"}]', 'admin', 'admin', '2020-12-08 22:15:07', '2020-12-08 22:15:07', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_stock`;
CREATE TABLE `t_goods_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_goods_sku_stock`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_sku_stock` VALUES ('4', '43', '14', '1111', '2020-11-21 21:26:12', '2020-11-21 21:26:12', 'admin', 'admin', '0'), ('6', '45', '16', '12', '2020-11-21 22:16:37', '2020-11-21 22:16:37', 'admin', 'admin', '0'), ('9', '49', '19', '10', '2020-12-06 14:49:09', '2020-12-06 14:49:09', 'admin', 'admin', '0'), ('10', '50', '20', '100', '2020-12-06 14:52:09', '2020-12-06 14:52:09', 'admin', 'admin', '0'), ('11', '51', '21', '100', '2020-12-08 21:14:24', '2020-12-08 21:14:24', 'admin', 'admin', '0'), ('12', '52', '22', '80', '2020-12-08 21:18:06', '2020-12-08 21:18:06', 'admin', 'admin', '0'), ('13', '53', '23', '200', '2020-12-08 21:21:58', '2020-12-08 21:21:58', 'admin', 'admin', '0'), ('14', '54', '24', '100', '2020-12-08 21:24:02', '2020-12-08 21:24:02', 'admin', 'admin', '0'), ('15', '55', '25', '1000', '2020-12-08 21:27:30', '2020-12-08 21:27:30', 'admin', 'admin', '0'), ('16', '56', '26', '1000', '2020-12-08 21:29:53', '2020-12-08 21:29:53', 'admin', 'admin', '0'), ('17', '57', '27', '200', '2020-12-08 21:32:50', '2020-12-08 21:32:50', 'admin', 'admin', '0'), ('18', '58', '28', '500', '2020-12-08 21:35:53', '2020-12-08 21:35:53', 'admin', 'admin', '0'), ('19', '59', '29', '100', '2020-12-08 21:39:35', '2020-12-08 21:39:35', 'admin', 'admin', '0'), ('20', '60', '30', '400', '2020-12-08 21:44:18', '2020-12-08 21:44:18', 'admin', 'admin', '0'), ('21', '61', '31', '120', '2020-12-08 21:48:59', '2020-12-08 21:48:59', 'admin', 'admin', '0'), ('22', '62', '32', '200', '2020-12-08 21:55:58', '2020-12-08 21:55:58', 'admin', 'admin', '0'), ('23', '63', '33', '1000', '2020-12-08 22:09:58', '2020-12-08 22:09:58', 'admin', 'admin', '0'), ('24', '64', '34', '1000', '2020-12-08 22:12:25', '2020-12-08 22:12:25', 'admin', 'admin', '0'), ('25', '65', '35', '400', '2020-12-08 22:15:07', '2020-12-08 22:15:07', 'admin', 'admin', '0');
COMMIT;

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
  `spu_name` varchar(63) DEFAULT NULL COMMENT 'spu 名称',
  `spu_image` varchar(512) DEFAULT NULL COMMENT 'spu 图片',
  `sequence` int(4) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='商品spu';

-- ----------------------------
--  Records of `t_goods_spu`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_spu` VALUES ('1', '安心蔬菜', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%AE%89%E5%BF%83%E8%94%AC%E8%8F%9C.jpg?Expires=1922791869&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=hkZdXyMGimxniHUqfJfhvjq%2BqUM%3D', '1', 'system', 'admin', '2020-11-21 13:32:03', '2020-12-12 10:29:26', b'0'), ('2', '肉禽蛋', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E8%82%89%E7%A6%BD%E8%9B%8B.jpg?Expires=1922791914&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=E7uF8KMHut691GeZzrqFVDlfKhk%3D', '2', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:32', b'0'), ('3', '水产海鲜', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E6%B5%B7%E9%B2%9C%E6%B0%B4%E4%BA%A7.jpg?Expires=1922792007&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=KBgO03P3kVLX7hQIuabgDwQKvVg%3D', '3', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:44', b'0'), ('4', '新鲜水果', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E6%B0%B4%E6%9E%9C.jpg?Expires=1922792037&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=NCeJD9nljAO8HtUV%2FnfUmMO3Lg8%3D', '4', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:45', b'0'), ('5', '乳品烘培', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E4%B9%B3%E5%93%81%E7%83%98%E7%84%99.jpg?Expires=1922792091&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=C6FPEthoLQpoCTFRTcfUJZYYYAc%3D', '5', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:46', b'0'), ('6', '速食冻品', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-22/0331a2f8be34477e88681a2c6d8ca6c9.jpg?Expires=1921392620&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=wYeHcwFZoIXjY%2BgoWRy0%2F68G2qo%3D', '6', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:47', b'0'), ('7', '粮油调味', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E7%B1%B3%E9%9D%A2%E7%B2%AE%E6%B2%B9.jpg?Expires=1922792149&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=zrSY3R3fxTKL5wE%2BOSB3DgZMVxE%3D', '7', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:49', b'0'), ('8', '酒水饮品', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%86%9C%E5%A4%AB%E5%B1%B1%E6%B3%89%E9%A5%AE%E7%94%A8%E5%A4%A9%E7%84%B6%E6%B0%B4%20550ml%2A28%E7%93%B6.jpg?Expires=1922792397&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=%2BtyHcKU%2BdTFdz0y1fNL2j%2FLxuTM%3D', '8', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:50', b'0'), ('9', '快手菜', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/png/2020-12-08/%E9%BE%99%E9%A1%BB%E7%89%8C%E7%BA%A2%E8%96%AF%E5%AE%BD%E7%B2%89%20300g%3A%E8%A2%8B.png?Expires=1922792424&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=k9un6FZpNVc6S0skFad%2FSY9u634%3D', '9', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:51', b'0'), ('10', '火锅人生', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E6%81%92%E9%83%BD%E7%B2%BE%E9%80%89%E5%86%B7%E5%86%BB%E7%BE%8A%E8%82%89%E5%8D%B7%20350g.jpg?Expires=1922792492&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=vlRmon8vUIKuIW7ifEW09oI2njU%3D', '10', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:53', b'0'), ('11', '网红打卡', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-22/mangguo.jpg?Expires=1921392680&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=qxQTdRsLVvHhnhJwYLVfo21GJIQ%3D', '11', 'system', 'admin', '2020-11-21 13:32:03', '2020-12-12 10:29:29', b'0'), ('12', '厨房用品', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-11-22/0331a2f8be34477e88681a2c6d8ca6c9.jpg?Expires=1921392689&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=iGexmxl48ssEkBWPRXgL5xh31hM%3D', '12', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:56', b'0'), ('13', '营养早餐', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E5%8F%AE%E5%92%9A%E5%BF%83%E9%80%89.jpg?Expires=1922792520&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=rb5N1nGZof7tYLRMNFwzk8aUmCQ%3D', '13', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-21 13:36:58', b'0'), ('14', '熟食卤味', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E7%95%99%E5%A4%AB%E9%B8%AD%E5%BE%AE%E8%BE%A3%E9%B8%AD%E7%BF%85%20120g%3A%E7%9B%92.jpg?Expires=1922792541&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=TahFDlqamW4Ya0oW0vVeWCIYYS8%3D', '14', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-22 16:12:00', b'0'), ('15', '休闲零食', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-08/%E8%90%A5%E5%85%BB%E6%97%A9%E9%A4%90.jpg?Expires=1922792605&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=IWYZBZKIMNXkapsffkH2hJGTScc%3D', '15', 'system', 'admin', '2020-11-21 13:32:03', '2020-11-22 16:12:03', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
