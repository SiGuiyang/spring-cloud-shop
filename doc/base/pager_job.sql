/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost
 Source Database       : pager_job

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 02/07/2020 20:01:45 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `QUARTZ_BLOB_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_BLOB_TRIGGERS`;
CREATE TABLE `QUARTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `quartz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `XXL_JOB_QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_CALENDARS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_CALENDARS`;
CREATE TABLE `QUARTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `CALENDAR_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `QUARTZ_CRON_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_CRON_TRIGGERS`;
CREATE TABLE `QUARTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `quartz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `XXL_JOB_QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_FIRED_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_FIRED_TRIGGERS`;
CREATE TABLE `QUARTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `ENTRY_ID` varchar(95) COLLATE utf8_bin NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8_bin NOT NULL,
  `INSTANCE_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) COLLATE utf8_bin NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QUARTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QUARTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QUARTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QUARTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QUARTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QUARTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `QUARTZ_JOB_DETAILS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_JOB_DETAILS`;
CREATE TABLE `QUARTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) COLLATE utf8_bin NOT NULL,
  `IS_DURABLE` varchar(1) COLLATE utf8_bin NOT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_bin NOT NULL,
  `IS_UPDATE_DATA` varchar(1) COLLATE utf8_bin NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_bin NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QUARTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QUARTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `QUARTZ_JOB_DETAILS`
-- ----------------------------
BEGIN;
INSERT INTO `QUARTZ_JOB_DETAILS` VALUES ('DefaultQuartzScheduler', 'testHello', 'push', null, 'quick.pager.shop.job.schedule.JobQuartzJobBean', '0', '1', '1', '0', 0xaced0005737200156f72672e71756172747a2e4a6f62446174614d61709fb083e8bfa9b0cb020000787200266f72672e71756172747a2e7574696c732e537472696e674b65794469727479466c61674d61708208e8c3fbc55d280200015a0013616c6c6f77735472616e7369656e74446174617872001d6f72672e71756172747a2e7574696c732e4469727479466c61674d617013e62ead28760ace0200025a000564697274794c00036d617074000f4c6a6176612f7574696c2f4d61703b787001737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c7708000000100000000174000a4a6f624164617074657273720022717569636b2e70616765722e73686f702e6a6f622e6d6f64656c2e4a6f62496e666f7cae5b57abc9f9ad02000a4c000a63726561746554696d657400194c6a6176612f74696d652f4c6f63616c4461746554696d653b4c000463726f6e7400124c6a6176612f6c616e672f537472696e673b4c000b6465736372697074696f6e71007e000a4c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00086a6f6247726f757071007e000a4c00076a6f624e616d6571007e000a4c00096a6f625374617475737400134c6a6176612f6c616e672f496e74656765723b4c0006706172616d7371007e000a4c000d736572766963654d6574686f6471007e000a4c000b736572766963654e616d6571007e000a78707372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770a05000007e1081b0216dc7874000d30202a2f32202a202a202a203f740006e6b58be8af957372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b02000078700000000000000001740004707573687400097465737448656c6c6f737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c75657871007e001300000002740007657865637574657400082f746573744a6f6274000d73686f702d61637469766974797800);
COMMIT;

-- ----------------------------
--  Table structure for `QUARTZ_JOB_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_JOB_INFO`;
CREATE TABLE `QUARTZ_JOB_INFO` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `job_group` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `job_status` int(4) DEFAULT NULL,
  `cron` varchar(31) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `service_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `service_method` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `params` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '执行参数',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `QUARTZ_JOB_INFO`
-- ----------------------------
BEGIN;
INSERT INTO `QUARTZ_JOB_INFO` VALUES ('1', 'testHello', 'push', '2', '0 */2 * * * ?', '测试', 'shop-activity', '/testJob', 'execute', '2017-08-26 13:22:35');
COMMIT;

-- ----------------------------
--  Table structure for `QUARTZ_LOCKS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_LOCKS`;
CREATE TABLE `QUARTZ_LOCKS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `LOCK_NAME` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `QUARTZ_LOCKS`
-- ----------------------------
BEGIN;
INSERT INTO `QUARTZ_LOCKS` VALUES ('DefaultQuartzScheduler', 'STATE_ACCESS'), ('DefaultQuartzScheduler', 'TRIGGER_ACCESS');
COMMIT;

-- ----------------------------
--  Table structure for `QUARTZ_PAUSED_TRIGGER_GRPS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QUARTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `QUARTZ_SCHEDULER_STATE`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_SCHEDULER_STATE`;
CREATE TABLE `QUARTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `INSTANCE_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `QUARTZ_SCHEDULER_STATE`
-- ----------------------------
BEGIN;
INSERT INTO `QUARTZ_SCHEDULER_STATE` VALUES ('DefaultQuartzScheduler', 'siguiyangdeMBP.lan1580044376043', '1580044557362', '5000');
COMMIT;

-- ----------------------------
--  Table structure for `QUARTZ_SIMPLE_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QUARTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `quartz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `XXL_JOB_QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_SIMPROP_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QUARTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `quartz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `XXL_JOB_QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGERS`;
CREATE TABLE `QUARTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8_bin NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8_bin NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8_bin NOT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8_bin NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) COLLATE utf8_bin NOT NULL,
  `TRIGGER_TYPE` varchar(8) COLLATE utf8_bin NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QUARTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QUARTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QUARTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QUARTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QUARTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QUARTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QUARTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QUARTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QUARTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QUARTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QUARTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QUARTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QUARTZ_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `quartz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `QUARTZ_TRIGGERS`
-- ----------------------------
BEGIN;
INSERT INTO `QUARTZ_TRIGGERS` VALUES ('DefaultQuartzScheduler', 'testHello', 'push', 'testHello', 'push', null, '1580044440000', '-1', '5', 'WAITING', 'CRON', '1580044377000', '0', null, '0', '');
COMMIT;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGER_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGER_GROUP`;
CREATE TABLE `QUARTZ_TRIGGER_GROUP` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(64) NOT NULL COMMENT '执行器AppName',
  `title` varchar(12) NOT NULL COMMENT '执行器名称',
  `sequence` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
  `address_list` varchar(512) DEFAULT NULL COMMENT '执行器地址列表，多地址逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGER_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGER_INFO`;
CREATE TABLE `QUARTZ_TRIGGER_INFO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_cron` varchar(128) NOT NULL COMMENT '任务执行CRON',
  `job_desc` varchar(255) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `author` varchar(64) DEFAULT NULL COMMENT '作者',
  `alarm_email` varchar(255) DEFAULT NULL COMMENT '报警邮件',
  `executor_route_strategy` varchar(50) DEFAULT NULL COMMENT '执行器路由策略',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_block_strategy` varchar(50) DEFAULT NULL COMMENT '阻塞处理策略',
  `executor_timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `glue_type` varchar(50) NOT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) DEFAULT NULL COMMENT 'GLUE备注',
  `glue_updatetime` datetime DEFAULT NULL COMMENT 'GLUE更新时间',
  `child_jobid` varchar(255) DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGER_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGER_LOG`;
CREATE TABLE `QUARTZ_TRIGGER_LOG` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `executor_address` varchar(255) DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_sharding_param` varchar(20) DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `trigger_time` datetime DEFAULT NULL COMMENT '调度-时间',
  `trigger_code` int(11) NOT NULL COMMENT '调度-结果',
  `trigger_msg` text COMMENT '调度-日志',
  `handle_time` datetime DEFAULT NULL COMMENT '执行-时间',
  `handle_code` int(11) NOT NULL COMMENT '执行-状态',
  `handle_msg` text COMMENT '执行-日志',
  `alarm_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
  PRIMARY KEY (`id`),
  KEY `I_trigger_time` (`trigger_time`),
  KEY `I_handle_code` (`handle_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGER_LOGGLUE`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGER_LOGGLUE`;
CREATE TABLE `QUARTZ_TRIGGER_LOGGLUE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `glue_type` varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) NOT NULL COMMENT 'GLUE备注',
  `add_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `QUARTZ_TRIGGER_REGISTRY`
-- ----------------------------
DROP TABLE IF EXISTS `QUARTZ_TRIGGER_REGISTRY`;
CREATE TABLE `QUARTZ_TRIGGER_REGISTRY` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registry_group` varchar(255) NOT NULL,
  `registry_key` varchar(255) NOT NULL,
  `registry_value` varchar(255) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
