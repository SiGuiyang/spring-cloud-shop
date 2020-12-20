/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 106.54.251.32
 Source Database       : pager_activity

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 12/20/2020 19:11:46 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `activity_img` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `activity_type` int(11) DEFAULT NULL COMMENT '活动类型',
  `state` bit(1) DEFAULT NULL COMMENT 'true 禁用 false 启用',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `create_user` varchar(63) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='拼团活动';

-- ----------------------------
--  Records of `t_activity`
-- ----------------------------
BEGIN;
INSERT INTO `t_activity` VALUES ('1', '满赠换购', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', '1', b'0', '2019-12-06 00:00:00', '2019-12-23 23:59:59', 'admin', '2020-12-05 11:11:33', '2019-01-21 18:29:09', 'admin', b'0'), ('2', 'jkjkjkjkjkj', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191103/95fd799cfadb47bda7b60ca11e5dae16.jpg', '1', null, '2019-12-24 00:00:00', '2019-12-26 23:59:59', 'admin', '2019-01-21 18:29:14', '2019-11-03 10:56:33', 'admin', b'0'), ('3', 'gh', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191103/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', '1', null, '2019-11-27 00:00:00', '2019-12-17 23:59:59', 'admin', '2020-12-06 20:59:19', '2019-11-03 11:26:19', 'admin', b'0'), ('4', '3333', 'http://pp7x7b2mm.bkt.clouddn.com/static/2020-04-12/6b29b9a0c79c4a53aaf4e562afdce191.jpg', '1', b'0', '2020-04-01 00:00:00', '2020-04-30 23:59:59', 'admin', '2020-12-06 20:59:24', '2020-04-12 09:55:10', 'admin', b'0'), ('5', 'test2', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', '2', b'0', '2019-01-30 00:00:00', '2019-04-24 00:00:00', 'admin', '2019-01-21 18:29:14', '2019-01-21 18:29:09', 'admin', b'0'), ('6', '风格的复古大哥大7878', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', '2', b'0', '2019-02-12 00:00:00', '2019-03-21 00:00:00', 'admin', '2019-01-21 18:29:14', '2019-01-21 18:29:09', 'admin', b'0'), ('7', '颠三倒四的财富', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/108cfb90f64a4267a21106d1f8053c89.jpg', '2', b'0', '2019-11-22 00:00:00', '2019-12-24 23:59:59', 'admin', '2019-11-02 20:37:11', '2019-11-02 20:37:11', 'admin', b'0'), ('8', 'kjjkjkjkkljkljklj', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', '2', b'0', '2019-11-22 00:00:00', '2019-12-24 23:59:59', 'admin', '2019-11-02 20:38:04', '2019-11-02 20:38:05', 'admin', b'0'), ('9', '满赠', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/png/2020-12-06/4d8e85f5abc7486ea1441eb9c15b8fbf.png?Expires=1922619359&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=5itE2r46OM1eGrrhWHObmi2gjJw%3D', '1', b'0', '2020-12-22 00:00:00', '2020-12-30 23:59:59', 'admin', '2020-12-06 20:56:11', '2020-12-06 20:56:11', 'admin', b'0'), ('10', '拼团', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-06/95fd799cfadb47bda7b60ca11e5dae16.jpg?Expires=1922619593&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=Ky5NYSqjN%2BXz2AJK5klS3CrdW7s%3D', '2', b'0', '2020-12-16 00:00:00', '2020-12-30 23:59:59', 'admin', '2020-12-06 21:00:04', '2020-12-06 21:00:04', 'admin', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_assemble_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity_goods`;
CREATE TABLE `t_assemble_activity_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '主活动Id t_activity 的Id',
  `rule_id` bigint(20) DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='参与拼团活动的商品';

-- ----------------------------
--  Records of `t_assemble_activity_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_assemble_activity_goods` VALUES ('1', '3', '2', '1', null, null, '2019-04-26 10:16:59', '2019-04-26 10:16:58', b'1'), ('2', '1', '2', '1', null, null, '2019-04-26 11:41:55', '2019-04-26 11:41:54', b'1'), ('3', '3', '2', '1', null, null, '2019-04-26 11:42:24', '2019-04-26 11:42:24', b'1'), ('4', '1', '2', '1', null, null, '2019-04-26 11:42:27', '2019-04-26 11:42:26', b'0'), ('5', '1', '1', '3', null, null, '2019-05-04 19:34:15', '2019-05-04 19:34:14', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_assemble_activity_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity_member`;
CREATE TABLE `t_assemble_activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '主活动Id t_activity 的Id',
  `record_id` bigint(20) DEFAULT NULL COMMENT 't_fight_group_record id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(63) DEFAULT NULL,
  `master` bit(1) DEFAULT NULL COMMENT '是否是团长 1 团长 0 非团长',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='参与开团的成员表 ';

-- ----------------------------
--  Records of `t_assemble_activity_member`
-- ----------------------------
BEGIN;
INSERT INTO `t_assemble_activity_member` VALUES ('1', '1', '1', '1', '13818471314', '大神无处不在', b'1', null, null, '2019-01-23 16:47:10', '2019-01-23 16:47:36', b'0'), ('2', '1', '1', '2', '13818471314', '大神无处不在', b'0', null, null, '2019-01-23 16:48:01', '2019-01-23 16:48:04', b'0'), ('3', '1', '1', '3', '13818471315', '大神无处不在', b'0', null, null, '2019-01-23 16:48:25', '2019-01-23 16:48:28', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_assemble_activity_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity_record`;
CREATE TABLE `t_assemble_activity_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_activity 的Id',
  `status` int(11) DEFAULT NULL COMMENT '开团状态  0 已开团 1 未成团 2 已成团',
  `group_time` timestamp NULL DEFAULT NULL COMMENT '成团时间',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='拼团 - -> 开团表';

-- ----------------------------
--  Records of `t_assemble_activity_record`
-- ----------------------------
BEGIN;
INSERT INTO `t_assemble_activity_record` VALUES ('1', '1', '0', '2019-04-25 10:02:44', 'admin', 'admin', '2019-01-23 15:53:41', '2019-01-23 15:55:03', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_assemble_activity_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity_rule`;
CREATE TABLE `t_assemble_activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_activity 的Id',
  `purchase_limit` int(11) DEFAULT '1' COMMENT '限购数量 默认没人限购1份',
  `assemble_count` int(11) DEFAULT NULL COMMENT '成团人数',
  `server_status` bit(1) DEFAULT NULL COMMENT 'true 禁用， false 启用',
  `description` varchar(255) DEFAULT NULL COMMENT '规则说明',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='拼团活动规则';

-- ----------------------------
--  Records of `t_assemble_activity_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_assemble_activity_rule` VALUES ('1', '2', '31322', '233', b'0', '2健康健康健康立即离开就离开就离开家', null, null, '2019-01-22 15:48:33', '2019-01-22 15:48:33', b'0'), ('2', '1', '122277888', '1212444', b'0', '', null, null, '2019-04-24 19:07:17', '2019-04-24 19:07:17', b'1'), ('3', '1', '100', '10000', b'0', '111', null, null, '2019-05-04 19:34:02', '2019-05-04 19:34:01', b'0'), ('4', '4', '1', '19', b'0', 'gghjgjhgj', 'admin', null, '2019-11-02 22:25:05', '2019-11-02 22:25:04', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '活动标题',
  `banner_url` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页展示的图片地址',
  `banner_click_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页点击的地址',
  `banner_type` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner 类型',
  `banner_status` bit(1) DEFAULT NULL COMMENT '状态 false 开启， true 禁用',
  `share_url` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享地址',
  `share_title` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享标题',
  `share_subtitle` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享副标题',
  `share_icon` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享图标',
  `share_channel` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享渠道',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='APP banner 推广';

-- ----------------------------
--  Records of `t_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES ('15', '双12年终狂欢-上海江苏-老版轮播', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E5%8F%8C12%E5%B9%B4%E7%BB%88%E7%8B%82%E6%AC%A2-%E4%B8%8A%E6%B5%B7%E6%B1%9F%E8%8B%8F-%E8%80%81%E7%89%88%E8%BD%AE%E6%92%AD-1210.jpg?Expires=1922881415&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=nDDJo3hWKJxng1PT7FwkDP8kmZY%3D', null, 'home', b'0', null, null, null, null, 'wechatFriends', 'admin', 'admin', '2020-12-09 21:45:19', '2020-12-09 21:45:19', b'0'), ('16', '双12年终榜单-上海江苏-老版轮播', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E5%8F%8C12%E5%B9%B4%E7%BB%88%E6%A6%9C%E5%8D%95-%E4%B8%8A%E6%B5%B7%E6%B1%9F%E8%8B%8F-%E8%80%81%E7%89%88%E8%BD%AE%E6%92%AD-1209.jpg?Expires=1922881554&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=sN1tqdLHBq829Zm53b7lEZJGdbE%3D', null, 'home', b'0', null, null, null, null, 'wechat', 'admin', 'admin', '2020-12-09 21:46:01', '2020-12-09 21:46:01', b'0'), ('17', '西鲜记羊肉专题老banner12.9-12.15', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E8%A5%BF%E9%B2%9C%E8%AE%B0%E7%BE%8A%E8%82%89%E4%B8%93%E9%A2%98%E8%80%81banner12.9-12.15.jpg?Expires=1922881592&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=jF1ikYDl7JoiXK8wwAjBS465xG4%3D', null, 'home', b'0', null, null, null, null, 'wechatFriends', 'admin', 'admin', '2020-12-09 21:46:46', '2020-12-09 21:46:46', b'0'), ('18', '冬日煲汤_上海江苏_老轮播_12.09', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E5%86%AC%E6%97%A5%E7%85%B2%E6%B1%A4_%E4%B8%8A%E6%B5%B7%E6%B1%9F%E8%8B%8F_%E8%80%81%E8%BD%AE%E6%92%AD_12.09.jpg?Expires=1922881635&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=zGWu2pX212UITfPBbgxybiRTsbQ%3D', null, 'home', b'0', null, null, null, null, 'wechatFriends', 'admin', 'admin', '2020-12-09 21:47:22', '2020-12-09 21:47:22', b'0'), ('19', '红美人_华东_老轮播_12.10', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E7%BA%A2%E7%BE%8E%E4%BA%BA_%E5%8D%8E%E4%B8%9C_%E8%80%81%E8%BD%AE%E6%92%AD_12.10.jpg?Expires=1922881671&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=KWDhoysUdVgBiIkBXIwqQP%2FZKnA%3D', null, 'home', b'0', null, null, null, null, null, 'admin', 'admin', '2020-12-09 21:47:55', '2020-12-09 21:47:55', b'0'), ('20', '百款零食_华东_老轮播_12.02', 'http://pager-static.oss-cn-shanghai.aliyuncs.com/jpg/2020-12-09/%E7%99%BE%E6%AC%BE%E9%9B%B6%E9%A3%9F_%E5%8D%8E%E4%B8%9C_%E8%80%81%E8%BD%AE%E6%92%AD_12.02.jpg?Expires=1922881697&OSSAccessKeyId=LTAI4G2ZKoXjqJpHZqzFG3cD&Signature=LXo9G3WMI1UIFHVz3qtU32e%2FSQo%3D', null, 'home', b'0', null, null, null, null, null, 'admin', 'admin', '2020-12-09 21:48:20', '2020-12-09 21:48:20', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_discount_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `t_discount_coupon`;
CREATE TABLE `t_discount_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `template_id` bigint(20) DEFAULT NULL COMMENT '优惠券模板Id',
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL,
  `used` bit(1) DEFAULT NULL COMMENT '是否使用，true 使用，false 未使用',
  `begin_time` date DEFAULT NULL COMMENT '开始时间，冗余优惠券模板的开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间，冗余优惠券模板的结束时间',
  `create_user` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户优惠券';

-- ----------------------------
--  Records of `t_discount_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon` VALUES ('1', '5', '1', '13818471341', b'1', '2020-12-01', '2021-12-15', null, null, '2020-08-24 16:17:38', '2020-12-15 21:43:29', b'0'), ('2', '5', '1', '13818471341', b'0', '2020-12-01', '2021-12-15', null, null, '2020-08-24 16:17:38', '2020-12-15 21:43:40', b'0'), ('3', '5', '1', '13818471341', b'0', '2020-12-01', '2021-12-15', null, null, '2020-08-24 16:17:38', '2020-12-15 21:43:44', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_discount_coupon_template`
-- ----------------------------
DROP TABLE IF EXISTS `t_discount_coupon_template`;
CREATE TABLE `t_discount_coupon_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '优惠券模板名称',
  `template_type` int(2) DEFAULT NULL COMMENT '模板类型，模板的用途',
  `order_amount` decimal(6,2) DEFAULT NULL COMMENT '订单满金额',
  `coupon_amount` decimal(6,2) DEFAULT NULL COMMENT '减免金额',
  `discount_strength` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '折扣力度 例如 97 折 入库 则是0.97',
  `state` bit(1) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '优惠券说明',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='优惠券模板';

-- ----------------------------
--  Records of `t_discount_coupon_template`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon_template` VALUES ('1', '新年活动', '1', '3000.00', '20.00', '0.97', b'0', '2020-11-03 14:38:49', '2021-11-03 14:38:54', 'hjhjhjhjh', 'admin', 'admin', '2019-01-04 14:37:21', '2019-01-04 14:38:40', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_goods`;
CREATE TABLE `t_exchange_activity_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_activity id',
  `rule_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity_rule id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'pager_goods中t_goods 的id',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购的商品';

-- ----------------------------
--  Records of `t_exchange_activity_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity_goods` VALUES ('3', '1', '1', '4', '2019-05-04 20:35:19', '2019-05-04 20:35:20', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity_members`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_members`;
CREATE TABLE `t_exchange_activity_members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_activity id',
  `user_id` bigint(20) DEFAULT NULL COMMENT 'pager_shop中 t_user 的id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'pager_goods中t_goods 的id',
  `rule_id` bigint(20) DEFAULT NULL COMMENT '规则Id',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `update_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='购买满赠换购的人与商品';

-- ----------------------------
--  Records of `t_exchange_activity_members`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity_members` VALUES ('1', '1', '1', '1', '1', '13818471341', '2019-05-03 16:13:38', '2019-05-03 16:13:40', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_rule`;
CREATE TABLE `t_exchange_activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_activity id',
  `rule_name` varchar(127) DEFAULT NULL,
  `order_amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品满足的金额条件下限',
  `state` bit(1) DEFAULT NULL COMMENT 'true 禁用 false 启用',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购规则';

-- ----------------------------
--  Records of `t_exchange_activity_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity_rule` VALUES ('1', '1', '满50减20', '50', b'0', 'admin', 'admin', '2020-12-05 12:33:58', '2019-04-29 12:55:38', b'0'), ('2', '1', '满100减49', '100', b'0', 'admin', 'admin', '2020-12-05 12:14:09', '2019-04-29 14:51:38', b'0'), ('3', '1', '满100减80', '109', b'0', 'admin', 'admin', '2020-12-05 12:27:40', '2019-04-29 14:54:52', b'0'), ('4', '1', '欢乐购', '79', b'0', 'admin', 'admin', '2020-05-03 08:24:07', '2019-04-29 15:34:16', b'1'), ('5', '1', 'man', '12', b'0', 'admin', 'admin', '2019-11-03 12:37:29', '2019-11-03 12:37:30', b'1'), ('6', '1', '满39减10', '39', b'0', 'admin', 'admin', '2020-12-05 12:29:20', '2020-12-05 12:29:20', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_invite_friends`
-- ----------------------------
DROP TABLE IF EXISTS `t_invite_friends`;
CREATE TABLE `t_invite_friends` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id（邀请人Id）',
  `reward_rule_id` bigint(2) DEFAULT NULL COMMENT '奖励规则Id',
  `code` varchar(11) DEFAULT NULL COMMENT '邀请码',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邀请好友';

-- ----------------------------
--  Table structure for `t_invite_friends_association`
-- ----------------------------
DROP TABLE IF EXISTS `t_invite_friends_association`;
CREATE TABLE `t_invite_friends_association` (
  `user_id` bigint(20) DEFAULT NULL,
  `invited_user_id` bigint(20) DEFAULT NULL,
  `invite_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邀请人与被邀请人的关联关系\nuser_id 与 invited_user_id	 作为联合主键';

-- ----------------------------
--  Table structure for `t_invite_friends_reward_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_invite_friends_reward_record`;
CREATE TABLE `t_invite_friends_reward_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `invited_user_id` bigint(20) DEFAULT NULL COMMENT '被邀请人Id',
  `coupon_template_id` bigint(20) DEFAULT NULL COMMENT '优惠模版Id',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邀请好友奖励记录\n包括优惠券，折扣券以及积分';

-- ----------------------------
--  Table structure for `t_invite_friends_reward_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_invite_friends_reward_rule`;
CREATE TABLE `t_invite_friends_reward_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reward_name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `reward_type` bit(1) DEFAULT NULL COMMENT '奖励类型；1 优惠券 0 积分',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邀请奖励规则';

SET FOREIGN_KEY_CHECKS = 1;
