/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost
 Source Database       : pager_activity

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 01/16/2019 11:01:37 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '活动标题',
  `banner_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页展示的图片地址',
  `banner_click_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页点击的地址',
  `banner_type` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner 类型',
  `share_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享地址',
  `share_title` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享标题',
  `share_subtitle` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享副标题',
  `share_icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享图标',
  `share_channel` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享渠道',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES ('1', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', 'fsdfsdfsdfsfsf', 'integralShop', 'eeee', '玩转圣诞', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', '[\"qq\",\"wechat\"]', '2018-12-23 19:12:42', '', '2018-12-23 03:11:27', b'1'), ('2', 'rrrr', null, 'ffff', 'integralShop', 'ff', 'ff', 'ff', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', '[\"qq\"]', '2019-01-04 11:00:22', null, '2019-01-04 11:00:21', b'0'), ('3', 'iioi', null, 'yyy', 'home', 'yyy', 'yy', 'yy', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/1e38caaafa5d41469252a35c3321a35a.jpg', '[\"qq\",\"wechat\"]', '2019-01-04 11:19:14', null, '2019-01-04 11:19:14', b'1'), ('4', '66666', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/20a950c5384e4e42acf24733f85d43f3.jpg', 'rrewrwe', 'integralShop', 'rwerwer', 'rwerwer', 'rwerw', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', '[\"qq\",\"wechat\",\"wechatFriends\"]', '2019-01-04 11:21:35', null, '2019-01-04 11:21:34', b'1'), ('5', '0ojuhhhggf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/0331a2f8be34477e88681a2c6d8ca6c9.jpg', 'rrr', 'home', 'rrr', 'rrr', 'rrr', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', '[\"wechatFriends\",\"wechat\",\"qq\"]', '2019-01-04 11:25:48', '', '2019-01-04 11:25:47', b'1'), ('6', '44455rder', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', 'fdsfs', 'integralShop', 'fdsf', 'fsdf', 'fsdf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/858ba9b8b33145c288477c2b0f2d790e.jpg', '[\"qq\",\"wechatFriends\",\"wechat\"]', '2019-01-04 11:34:47', 'admin', '2019-01-04 11:34:47', b'1'), ('7', 'rewrwedsfs', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', 'fdsfs', 'home', 'fsdfs', 'fdsfs', 'fsdfs', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/8cca633b0b884faea8d6a56a3c7eeb75.jpg', '[\"wechatFriends\",\"wechat\"]', '2019-01-04 11:36:51', 'admin', '2019-01-04 11:36:50', b'1');
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
  `coupon_name` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL,
  `order_amount` decimal(4,2) DEFAULT NULL COMMENT '满订单金额',
  `coupon_amount` decimal(4,2) DEFAULT NULL COMMENT '减免金额',
  `discount_strength` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '折扣力度 例如 97 折 入库 则是0.97',
  `discount_type` tinyint(4) DEFAULT '1' COMMENT '优惠券类型',
  `used` bit(1) DEFAULT NULL COMMENT '是否使用 0 未使用 1 已使用',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `description` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '优惠券说明',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_discount_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon` VALUES ('1', '1', '1', '13818471341', '新年活动', '59.00', '30.00', '0.97', '1', b'0', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-01-07 16:17:38', '2019-01-10 11:23:19', b'0'), ('2', '2', '2', null, null, '59.00', '30.00', '0.97', '1', b'1', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-01-07 16:17:38', '2019-01-10 11:23:25', b'0'), ('3', '3', '3', null, null, '59.00', '30.00', '0.97', '1', b'1', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-01-07 16:17:38', '2019-01-10 11:23:27', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_discount_coupon_template`
-- ----------------------------
DROP TABLE IF EXISTS `t_discount_coupon_template`;
CREATE TABLE `t_discount_coupon_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_amount` decimal(6,2) DEFAULT NULL COMMENT '订单满金额',
  `coupon_amount` decimal(6,2) DEFAULT NULL COMMENT '减免金额',
  `discount_strength` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '折扣力度 例如 97 折 入库 则是0.97',
  `template_type` int(2) DEFAULT NULL COMMENT '模板类型，模板的用途',
  `template_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '优惠券模板名称',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '优惠券说明',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_discount_coupon_template`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon_template` VALUES ('1', '3000.00', '20.00', '0.97', '2', '新年活动', 'hjhjhjhjh', 'admin', '2019-01-04 14:37:21', '2019-01-04 14:38:40', b'1'), ('2', '221.00', '22.00', null, '1', '222gjhghjgjh', 'ihihhkjhkjh222', 'admin', '2019-01-06 17:52:51', '2019-01-06 17:52:50', b'0'), ('3', '122.00', null, '0.88', '2', 'fsdfsdfsdf', 'dsfsfsfdfsfsf', 'admin', '2019-01-06 18:54:20', '2019-01-06 18:54:20', b'0'), ('4', '333.00', '40.00', null, '1', 'fsdfsfsfd', 'fsdfsdfsdf', 'admin', '2019-01-06 18:54:44', '2019-01-06 18:54:44', b'1'), ('5', '322.00', '12.00', null, '1', 'fsdfs', '22', 'admin', '2019-01-06 19:37:18', '2019-01-06 19:37:18', b'0'), ('6', '21.00', null, '0.22', '2', 'eweweqw', '121', 'admin', '2019-01-06 19:37:37', '2019-01-06 19:37:37', b'0'), ('7', '32.00', null, '0.11', '2', 'fsdfsdf', '221', 'admin', '2019-01-06 19:38:57', '2019-01-06 19:38:56', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
