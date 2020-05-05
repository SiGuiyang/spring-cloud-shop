/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 101.132.121.178
 Source Database       : pager_activity

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : utf-8

 Date: 05/05/2020 18:37:39 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_assemble_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity`;
CREATE TABLE `t_assemble_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `activity_img` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `server_status` bit(1) DEFAULT NULL,
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `create_user` varchar(63) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='拼团活动';

-- ----------------------------
--  Records of `t_assemble_activity`
-- ----------------------------
BEGIN;
INSERT INTO `t_assemble_activity` VALUES ('1', 'test2', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', b'0', '2019-01-30 00:00:00', '2019-04-24 00:00:00', 'admin', '2019-01-21 18:29:14', '2019-01-21 18:29:09', 'admin', b'0'), ('2', '风格的复古大哥大7878', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', b'0', '2019-02-12 00:00:00', '2019-03-21 00:00:00', 'admin', '2019-01-21 18:29:14', '2019-01-21 18:29:09', 'admin', b'0'), ('3', '颠三倒四的财富', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/108cfb90f64a4267a21106d1f8053c89.jpg', b'0', '2019-11-22 00:00:00', '2019-12-24 23:59:59', 'admin', '2019-11-02 20:37:11', '2019-11-02 20:37:11', 'admin', b'0'), ('4', 'kjjkjkjkkljkljklj', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', b'0', '2019-11-22 00:00:00', '2019-12-24 23:59:59', 'admin', '2019-11-02 20:38:04', '2019-11-02 20:38:05', 'admin', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_assemble_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_assemble_activity_goods`;
CREATE TABLE `t_assemble_activity_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
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
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
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
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
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
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼团活动Id t_fight_group 的Id',
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
  `banner_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页展示的图片地址',
  `banner_click_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner在首页点击的地址',
  `banner_type` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'banner 类型',
  `banner_status` bit(1) DEFAULT NULL COMMENT '状态 false 开启， true 禁用',
  `share_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享地址',
  `share_title` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享标题',
  `share_subtitle` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享副标题',
  `share_icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享图标',
  `share_channel` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分享渠道',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='APP banner 推广';

-- ----------------------------
--  Records of `t_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES ('1', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', 'fsdfsdfsdfsfsf', 'integralShop', null, 'eeee', '玩转圣诞', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', null, '', null, '2018-12-23 19:12:42', '2018-12-23 03:11:27', b'0'), ('2', 'rrrr', null, 'ffff', 'integralShop', null, 'ff', 'ff', 'ff', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', null, 'admin', null, '2019-01-04 11:00:22', '2019-01-04 11:00:21', b'1'), ('3', 'iioi', null, 'yyy', 'home', null, 'yyy', 'yy', 'yy', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/1e38caaafa5d41469252a35c3321a35a.jpg', null, 'admin', null, '2019-01-04 11:19:14', '2019-01-04 11:19:14', b'0'), ('4', '66666', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/20a950c5384e4e42acf24733f85d43f3.jpg', 'rrewrwe', 'integralShop', null, 'rwerwer', 'rwerwer', 'rwerw', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', null, 'admin', null, '2019-01-04 11:21:35', '2019-01-04 11:21:34', b'0'), ('5', 'fsdffsdf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/0331a2f8be34477e88681a2c6d8ca6c9.jpg', 'rrr', 'home', null, 'rrr', 'rrr', 'rrr', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', null, '', null, '2019-01-04 11:25:48', '2019-01-04 11:25:47', b'0'), ('6', '44455rddtt', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/715b98f69b1c44bfb9ee978b48b9af0e.jpg', 'fdsfs', 'home', null, 'fdsf', 'fsdf', 'fsdf', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/858ba9b8b33145c288477c2b0f2d790e.jpg', 'wechatFriends,wechat,qq', '', null, '2019-01-04 11:34:47', '2019-01-04 11:34:47', b'0'), ('7', '玩转圣诞', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/092c25c8558c419197fe3287f0a0165a.jpg', 'fdsfs', 'classification', null, 'fsdfs', 'fdsfs', 'fsdfs', 'http://pk6b0a7n8.bkt.clouddn.com/20190104/8cca633b0b884faea8d6a56a3c7eeb75.jpg', '', 'admin', null, '2019-01-04 11:36:51', '2019-01-04 11:36:50', b'1'), ('9', '玩转圣诞', null, null, 'classification', null, null, null, null, null, '', 'admin', null, '2019-04-22 17:11:20', '2019-04-22 17:11:19', b'0'), ('10', '玩转圣诞', null, null, 'classification', null, null, null, null, null, '', '', null, '2019-04-22 17:12:27', '2019-04-22 17:12:27', b'0'), ('11', '玩转圣诞', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/95fd799cfadb47bda7b60ca11e5dae16 (1).jpg', 'e', 'classification', null, '3', '3', '3', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/6b29b9a0c79c4a53aaf4e562afdce191.jpg', 'wechatFriends', 'admin', 'admin', '2019-04-22 17:14:50', '2019-04-22 17:14:49', b'0'), ('12', '玩转圣诞', null, null, 'classification', null, null, null, null, null, null, 'admin', 'admin', '2019-04-24 11:20:06', '2019-04-24 11:20:05', b'0'), ('13', '会计法', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/95fd799cfadb47bda7b60ca11e5dae16 (1).jpg', null, 'integralShop', null, '空流泪了', '积极 iui', '一个个回家赶紧回归', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', 'wechatFriends,wechat,qq', 'admin', null, '2019-11-02 14:22:55', '2019-11-02 14:17:54', b'0'), ('14', 'fsfsdfsdfrwerwe', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/25aa537d3745416b832634a22df57307.jpg', 'rrrr', 'home', null, 'rrr', 'rrr', 'rrr', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191102/715b98f69b1c44bfb9ee978b48b9af0e.jpg', 'wechat,qq', 'admin', null, '2019-11-02 14:24:29', '2019-11-02 14:24:28', b'0');
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
INSERT INTO `t_discount_coupon` VALUES ('1', '1', '1', '13818471341', b'1', null, null, '2019-04-24 16:17:38', '2019-11-03 14:46:34', b'0'), ('2', '2', '2', '13818471341', b'0', null, null, '2019-04-24 16:17:38', '2019-11-03 14:46:36', b'0'), ('3', '3', '3', '13818471341', b'0', null, null, '2019-04-24 16:17:38', '2019-11-03 14:46:39', b'0');
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
  `server_status` bit(1) DEFAULT NULL,
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
INSERT INTO `t_discount_coupon_template` VALUES ('1', '新年活动', '2', '3000.00', '20.00', '0.97', b'1', '2019-11-03 14:38:49', '2019-11-03 14:38:54', 'hjhjhjhjh', 'admin', 'admin', '2019-01-04 14:37:21', '2019-01-04 14:38:40', b'1'), ('2', '1111111111222gjhghjgjh', '1', '221.00', '22.00', null, b'1', '2019-11-03 14:40:09', '2019-11-03 14:39:04', 'ihihhkjhkjh222gdfgdfgdg', 'admin', 'admin', '2019-01-06 17:52:51', '2019-01-06 17:52:50', b'0'), ('3', 'fsdfsdfsdf5566677', '2', '122.00', null, '0.88', b'1', '2019-11-03 14:40:13', '2019-11-03 14:39:08', 'dsfsfsfdfsfsf', 'admin', 'admin', '2019-01-06 18:54:20', '2019-01-06 18:54:20', b'0'), ('4', 'fsdfsfsfd', '1', '333.00', '40.00', null, b'1', '2019-11-03 14:40:05', '2019-11-03 14:40:16', 'fsdfsdfsdf', 'admin', 'admin', '2019-01-06 18:54:44', '2019-01-06 18:54:44', b'1'), ('5', 'fsdfs', '1', '322.00', '12.00', null, b'1', '2019-11-03 14:39:17', '2019-11-03 14:39:13', '22', 'admin', 'admin', '2019-01-06 19:37:18', '2019-01-06 19:37:18', b'0'), ('6', '', '2', '21.00', null, '0.22', b'0', '2019-11-03 14:39:21', '2019-11-03 14:39:41', '', 'admin', 'admin', '2019-01-06 19:37:37', '2019-01-06 19:37:37', b'1'), ('7', '', '2', '32.00', null, '0.11', b'1', '2019-11-03 14:39:25', '2019-11-03 14:39:37', '', 'admin', 'admin', '2019-01-06 19:38:57', '2019-01-06 19:38:56', b'0'), ('8', 'hhhkjjjhjj', '1', '17.00', '1.00', null, b'0', '2019-11-03 14:39:28', '2019-11-03 14:39:33', 'jj', 'admin', 'admin', '2019-04-24 14:14:36', '2019-04-24 14:14:36', null), ('9', 'hhhhhhh', '2', '79.00', null, '0.95', b'1', '2019-11-03 14:40:23', '2019-11-03 14:40:21', 'hjkhjhkjhjk', 'admin', 'admin', '2019-04-24 14:14:58', '2019-04-24 14:14:58', null), ('10', 'eee', '1', '30.00', '22.00', null, b'1', '2019-11-03 14:39:48', '2019-11-03 14:39:45', '3232', 'admin', 'admin', '2019-04-24 14:15:34', '2019-04-24 14:15:33', b'0'), ('11', 'ewrwerwe', '2', '50.00', '10.00', '1', b'0', '2019-11-03 14:40:30', '2019-11-03 14:40:28', '324234234', 'admin', 'admin', '2019-04-24 14:16:09', '2019-04-24 14:16:09', b'0'), ('12', '哈哈哈', '1', '78.00', '8.00', null, b'0', '2019-11-03 14:39:55', '2019-11-03 14:39:52', '回家见客户', 'admin', 'admin', '2019-11-03 13:26:12', '2019-11-03 13:26:11', b'0'), ('13', '热热热热', '2', '100.00', null, '0.85', b'0', '2019-11-03 14:40:01', '2019-11-03 14:39:58', '33333', 'admin', 'admin', '2019-11-03 13:26:34', '2019-11-03 13:26:33', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity`;
CREATE TABLE `t_exchange_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(127) DEFAULT NULL COMMENT '活动名称',
  `activity_img` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `server_status` bit(1) DEFAULT NULL,
  `begin_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL COMMENT '更新操作人',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购活动\n一个活动对应多个规则，\n一个规则对应一个商品（也就是不同的档次对应不同的商品）';

-- ----------------------------
--  Records of `t_exchange_activity`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity` VALUES ('1', '满赠换购', 'http://pk6b0a7n8.bkt.clouddn.com/banner1.jpg', b'0', '2019-12-06 00:00:00', '2019-12-23 23:59:59', 'admin', 'admin', '2019-01-21 18:29:09', '2019-01-21 18:29:14', b'0'), ('2', 'jkjkjkjkjkj', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191103/95fd799cfadb47bda7b60ca11e5dae16.jpg', null, '2019-12-24 00:00:00', '2019-12-26 23:59:59', 'admin', 'admin', '2019-11-03 10:56:33', '2019-01-21 18:29:14', b'0'), ('3', 'gh', 'http://pp7x7b2mm.bkt.clouddn.com/static/20191103/41f82e8b05744a6fbf20a9c008a9fd6d.jpg', null, '2019-11-27 00:00:00', '2019-12-17 23:59:59', 'admin', 'admin', '2019-11-03 11:26:19', null, b'0'), ('4', '3333', 'http://pp7x7b2mm.bkt.clouddn.com/static/2020-04-12/6b29b9a0c79c4a53aaf4e562afdce191.jpg', b'0', '2020-04-01 00:00:00', '2020-04-30 23:59:59', 'admin', 'admin', '2020-04-12 09:55:10', null, b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_exchange_activity_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_exchange_activity_goods`;
CREATE TABLE `t_exchange_activity_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
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
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
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
  `activity_id` bigint(20) DEFAULT NULL COMMENT 't_exchange_activity id',
  `rule_name` varchar(127) DEFAULT NULL,
  `order_amount` decimal(10,0) DEFAULT NULL COMMENT '购买商品满足的金额条件下限',
  `server_status` bit(1) DEFAULT NULL COMMENT 'true 禁用 false 启用',
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='满赠换购规则';

-- ----------------------------
--  Records of `t_exchange_activity_rule`
-- ----------------------------
BEGIN;
INSERT INTO `t_exchange_activity_rule` VALUES ('1', '1', '满50减20', '50', b'0', null, 'admin', '2020-05-03 08:20:13', '2019-04-29 12:55:38', b'0'), ('2', '1', '满100减49', '100', null, null, 'admin', '2019-04-29 14:51:38', '2019-04-29 14:51:38', b'0'), ('3', '1', '满100减80', '109', b'0', null, 'admin', '2019-04-29 14:54:51', '2019-04-29 14:54:52', b'0'), ('4', '1', '欢乐购', '79', null, null, 'admin', '2020-05-03 08:24:07', '2019-04-29 15:34:16', b'0'), ('5', '1', 'man', '12', null, 'admin', 'admin', '2019-11-03 12:37:29', '2019-11-03 12:37:30', b'0');
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
