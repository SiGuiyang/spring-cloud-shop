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

 Date: 04/29/2019 15:51:14 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='APP banner 推广';

-- ----------------------------
--  Records of `t_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES ('1', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', 'fsdfsdfsdfsfsf', 'integralShop', 'eeee', '玩转圣诞', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', '\"[\\\"qq\\\",\\\"wechat\\\"]\"', '2018-12-23 19:12:42', '', '2018-12-23 03:11:27', b'0'), ('2', 'rrrr', null, 'ffff', 'integralShop', 'ff', 'ff', 'ff', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', '\"[\\\"qq\\\"]\"', '2019-01-04 11:00:22', 'admin', '2019-01-04 11:00:21', b'0'), ('3', 'iioi', null, 'yyy', 'home', 'yyy', 'yy', 'yy', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/1e38caaafa5d41469252a35c3321a35a.jpg', '\"[\\\"qq\\\",\\\"wechat\\\"]\"', '2019-01-04 11:19:14', 'admin', '2019-01-04 11:19:14', b'0'), ('4', '66666', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/20a950c5384e4e42acf24733f85d43f3.jpg', 'rrewrwe', 'integralShop', 'rwerwer', 'rwerwer', 'rwerw', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', '\"[]\"', '2019-01-04 11:21:35', 'admin', '2019-01-04 11:21:34', b'0'), ('5', 'fsdffsdf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/0331a2f8be34477e88681a2c6d8ca6c9.jpg', 'rrr', 'home', 'rrr', 'rrr', 'rrr', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', '\"[\\\"wechatFriends\\\",\\\"wechat\\\",\\\"qq\\\"]\"', '2019-01-04 11:25:48', '', '2019-01-04 11:25:47', b'0'), ('6', '44455rddtt', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', 'fdsfs', 'home', 'fdsf', 'fsdf', 'fsdf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/858ba9b8b33145c288477c2b0f2d790e.jpg', '\"[\\\"wechat\\\"]\"', '2019-01-04 11:34:47', '', '2019-01-04 11:34:47', b'0'), ('7', '', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', 'fdsfs', '', 'fsdfs', 'fdsfs', 'fsdfs', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/8cca633b0b884faea8d6a56a3c7eeb75.jpg', '\"[]\"', '2019-01-04 11:36:51', 'admin', '2019-01-04 11:36:50', b'1'), ('9', '', null, null, '', null, null, null, null, '\"[]\"', '2019-04-22 17:11:20', 'admin', '2019-04-22 17:11:19', b'0'), ('10', '', null, null, '', null, null, null, null, '\"[]\"', '2019-04-22 17:12:27', '', '2019-04-22 17:12:27', b'0'), ('11', '', null, null, '', null, null, null, null, '\"[]\"', '2019-04-22 17:14:50', 'admin', '2019-04-22 17:14:49', b'0'), ('12', '', null, null, '', null, null, null, null, '\"[]\"', '2019-04-24 11:20:06', 'admin', '2019-04-24 11:20:05', b'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户优惠券';

-- ----------------------------
--  Records of `t_discount_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon` VALUES ('1', '1', '1', '13818471341', '新年活动', '59.00', '30.00', '0.97', '1', b'0', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-04-24 16:17:38', '2019-04-24 15:47:15', b'0'), ('2', '2', '2', '13818471341', '222gjhghjgjh', '59.00', '30.00', '0.97', '1', b'1', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-04-24 16:17:38', '2019-04-24 15:50:14', b'0'), ('3', '3', '3', '13818471341', 'fsdfsdfsdf', '59.00', '30.00', '0.97', '1', b'1', '2019-01-07 16:17:38', '2019-01-10 16:17:38', 'eeeee', '2019-04-24 16:17:38', '2019-04-24 15:50:16', b'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='优惠券模板';

-- ----------------------------
--  Records of `t_discount_coupon_template`
-- ----------------------------
BEGIN;
INSERT INTO `t_discount_coupon_template` VALUES ('1', '3000.00', '20.00', '0.97', '2', '新年活动', 'hjhjhjhjh', 'admin', '2019-01-04 14:37:21', '2019-01-04 14:38:40', b'1'), ('2', '221.00', '22.00', null, '1', '1111111111222gjhghjgjh', 'ihihhkjhkjh222gdfgdfgdg', 'admin', '2019-01-06 17:52:51', '2019-01-06 17:52:50', b'0'), ('3', '122.00', null, '0.88', '2', 'fsdfsdfsdf5566677', 'dsfsfsfdfsfsf', 'admin', '2019-01-06 18:54:20', '2019-01-06 18:54:20', b'0'), ('4', '333.00', '40.00', null, '1', 'fsdfsfsfd', 'fsdfsdfsdf', 'admin', '2019-01-06 18:54:44', '2019-01-06 18:54:44', b'1'), ('5', '322.00', '12.00', null, '1', 'fsdfs', '22', 'admin', '2019-01-06 19:37:18', '2019-01-06 19:37:18', b'0'), ('6', '21.00', null, '0.22', '2', '', '', '', '2019-01-06 19:37:37', '2019-01-06 19:37:37', b'1'), ('7', '32.00', null, '0.11', '2', '', '', '', '2019-01-06 19:38:57', '2019-01-06 19:38:56', b'0'), ('8', null, null, null, null, '', '', '', '2019-04-24 14:14:36', '2019-04-24 14:14:36', null), ('9', null, null, null, null, '', '', '', '2019-04-24 14:14:58', '2019-04-24 14:14:58', null), ('10', '30.00', '22.00', null, '1', 'eee', '3232', '', '2019-04-24 14:15:34', '2019-04-24 14:15:33', null), ('11', '50.00', '10.00', null, '1', 'ewrwerwe', '324234234', '', '2019-04-24 14:16:09', '2019-04-24 14:16:09', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity`;
CREATE TABLE `t_exchange_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(127) DEFAULT NULL COMMENT '活动名称',
  `activity_img` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `update_user` varchar(63) DEFAULT NULL COMMENT '更新操作人',
  `update_time` timestamp NULL DEFAULT NULL,
  `begin_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购活动\n一个活动对应多个规则，\n一个规则对应一个商品（也就是不同的档次对应不同的商品）';

-- ----------------------------
--  Records of `t_exchange_activity`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity` VALUES ('1', '满赠换购', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', 'dddddd', '2019-01-21 18:29:14', '2019-02-21 00:00:00', '2019-04-24 00:00:00', '2019-01-21 18:29:09', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_goods`;
CREATE TABLE `t_exchange_activity_goods` (
  `id` bigint(20) NOT NULL,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
  `rule_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity_rule id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'pager_goods中t_goods 的id',
  `update_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购的商品';

-- ----------------------------
--  Table structure for `t_exchange_activity_members`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_members`;
CREATE TABLE `t_exchange_activity_members` (
  `id` bigint(20) NOT NULL,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
  `user_id` bigint(20) DEFAULT NULL COMMENT 'pager_shop中 t_user 的id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'pager_goods中t_goods 的id',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `update_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购买满赠换购的人与商品';

-- ----------------------------
--  Table structure for `t_exchange_activity_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_rule`;
CREATE TABLE `t_exchange_activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
  `rule_name` varchar(127) DEFAULT NULL,
  `order_amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品满足的金额条件下限',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购规则';

-- ----------------------------
--  Records of `t_exchange_activity_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity_rule` VALUES ('1', '1', '满50减30', '50', '2019-04-29 12:55:33', '2019-04-29 12:55:38', b'0'), ('2', '1', null, '100', '2019-04-29 14:51:38', '2019-04-29 14:51:38', b'0'), ('3', '1', '满100减80', '100', '2019-04-29 14:54:51', '2019-04-29 14:54:52', b'0'), ('4', '1', '欢乐购', '79', '2019-04-29 15:34:16', '2019-04-29 15:34:16', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_fight_group_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_fight_group_activity`;
CREATE TABLE `t_fight_group_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `activity_img` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='拼团活动';

-- ----------------------------
--  Records of `t_fight_group_activity`
-- ----------------------------
BEGIN;
INSERT INTO `t_fight_group_activity` VALUES ('1', 'test2', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', '2019-01-30 00:00:00', '2019-04-24 00:00:00', '2019-01-21 18:29:09', '2019-01-21 18:29:14', 'admin', b'0'), ('2', '风格的复古大哥大7878', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', '2019-02-12 00:00:00', '2019-03-21 00:00:00', '2019-01-21 18:29:09', '2019-01-21 18:29:14', 'admin', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_fight_group_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_fight_group_activity_goods`;
CREATE TABLE `t_fight_group_activity_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
  `rule_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='参与拼团活动的商品';

-- ----------------------------
--  Records of `t_fight_group_activity_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_fight_group_activity_goods` VALUES ('1', '3', '2', '1', '2019-04-26 10:16:59', '2019-04-26 10:16:58', b'1'), ('2', '1', '2', '1', '2019-04-26 11:41:55', '2019-04-26 11:41:54', b'1'), ('3', '3', '2', '1', '2019-04-26 11:42:24', '2019-04-26 11:42:24', b'1'), ('4', '1', '2', '1', '2019-04-26 11:42:27', '2019-04-26 11:42:26', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_fight_group_activity_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_fight_group_activity_member`;
CREATE TABLE `t_fight_group_activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
  `record_id` bigint(20) DEFAULT NULL COMMENT 't_fight_group_record id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(63) DEFAULT NULL,
  `master` bit(1) DEFAULT NULL COMMENT '是否是团长 1 团长 0 非团长',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='参与开团的成员表 ';

-- ----------------------------
--  Records of `t_fight_group_activity_member`
-- ----------------------------
BEGIN;
INSERT INTO `t_fight_group_activity_member` VALUES ('1', '1', '1', '1', '13818471314', '大神无处不在', b'1', '2019-01-23 16:47:10', '2019-01-23 16:47:36', b'0'), ('2', '1', '1', '2', '13818471314', '大神无处不在', b'0', '2019-01-23 16:48:01', '2019-01-23 16:48:04', b'0'), ('3', '1', '1', '3', '13818471315', '大神无处不在', b'0', '2019-01-23 16:48:25', '2019-01-23 16:48:28', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_fight_group_activity_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_fight_group_activity_record`;
CREATE TABLE `t_fight_group_activity_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
  `status` int(11) DEFAULT NULL COMMENT '开团状态  0 已开团 1 未成团 2 已成团',
  `create_time` timestamp NULL DEFAULT NULL,
  `group_time` timestamp NULL DEFAULT NULL COMMENT '成团时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='拼团 - -> 开团表';

-- ----------------------------
--  Records of `t_fight_group_activity_record`
-- ----------------------------
BEGIN;
INSERT INTO `t_fight_group_activity_record` VALUES ('1', '1', '0', '2019-01-23 15:53:41', '2019-04-25 10:02:44', '2019-01-23 15:55:03', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_fight_group_activity_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_fight_group_activity_rule`;
CREATE TABLE `t_fight_group_activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
  `purchase_limit` int(11) DEFAULT '1' COMMENT '限购数量 默认没人限购1份',
  `fight_count` int(11) DEFAULT NULL COMMENT '成团人数',
  `description` varchar(255) DEFAULT NULL COMMENT '规则说明',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_fight_group_activity_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_fight_group_activity_rule` VALUES ('1', '2', '31322', '233', '2健康健康健康立即离开就离开就离开家', '2019-01-22 15:48:33', '2019-01-22 15:48:33', b'0'), ('2', '1', '122277888', '1212444', '', '2019-04-24 19:07:17', '2019-04-24 19:07:17', b'1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
