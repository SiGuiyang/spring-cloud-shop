
CREATE DATABASE IF NOT EXISTS ApolloPortalDB DEFAULT CHARACTER SET = utf8mb4;

Use ApolloPortalDB;
-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Name` (`Name`(191))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='应用表';

-- ----------------------------
--  Records of `app`
-- ----------------------------
BEGIN;
INSERT INTO `app` VALUES ('1', 'SampleApp', 'Sample App', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', '201905211145', 'shop-manage', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('3', '201905211444', 'shop-activity', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('4', '201905211524', 'shop-order', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('5', '201905211527', 'shop-user', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('6', '201905211532', 'shop-seller', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('7', '201905211533', 'shop', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:53:05'), ('8', '201905211551', 'shop-risk', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `appnamespace`
-- ----------------------------
DROP TABLE IF EXISTS `appnamespace`;
CREATE TABLE `appnamespace` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) NOT NULL DEFAULT '' COMMENT 'namespace名字，注意，需要全局唯一',
  `AppId` varchar(32) NOT NULL DEFAULT '' COMMENT 'app id',
  `Format` varchar(32) NOT NULL DEFAULT 'properties' COMMENT 'namespace的format类型',
  `IsPublic` bit(1) NOT NULL DEFAULT b'0' COMMENT 'namespace是否为公共',
  `Comment` varchar(64) NOT NULL DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId` (`AppId`),
  KEY `Name_AppId` (`Name`,`AppId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='应用namespace定义';

-- ----------------------------
--  Records of `appnamespace`
-- ----------------------------
BEGIN;
INSERT INTO `appnamespace` VALUES ('1', 'application', 'SampleApp', 'properties', b'0', 'default app namespace', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', 'application', '201905211145', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('3', 'application', '201905211444', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('4', 'application', '201905211524', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('5', 'application', '201905211527', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('6', 'application', '201905211532', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('7', 'application', '201905211533', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:53:46'), ('8', 'application', '201905211551', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) NOT NULL,
  `Authority` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `authorities`
-- ----------------------------
BEGIN;
INSERT INTO `authorities` VALUES ('1', 'apollo', 'ROLE_user');
COMMIT;

-- ----------------------------
--  Table structure for `consumer`
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='开放API消费者';

-- ----------------------------
--  Table structure for `consumeraudit`
-- ----------------------------
DROP TABLE IF EXISTS `consumeraudit`;
CREATE TABLE `consumeraudit` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) unsigned DEFAULT NULL COMMENT 'Consumer Id',
  `Uri` varchar(1024) NOT NULL DEFAULT '' COMMENT '访问的Uri',
  `Method` varchar(16) NOT NULL DEFAULT '' COMMENT '访问的Method',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_ConsumerId` (`ConsumerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='consumer审计表';

-- ----------------------------
--  Table structure for `consumerrole`
-- ----------------------------
DROP TABLE IF EXISTS `consumerrole`;
CREATE TABLE `consumerrole` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) unsigned DEFAULT NULL COMMENT 'Consumer Id',
  `RoleId` int(10) unsigned DEFAULT NULL COMMENT 'Role Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_ConsumerId_RoleId` (`ConsumerId`,`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='consumer和role的绑定表';

-- ----------------------------
--  Table structure for `consumertoken`
-- ----------------------------
DROP TABLE IF EXISTS `consumertoken`;
CREATE TABLE `consumertoken` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) unsigned DEFAULT NULL COMMENT 'ConsumerId',
  `Token` varchar(128) NOT NULL DEFAULT '' COMMENT 'token',
  `Expires` datetime NOT NULL DEFAULT '2099-01-01 00:00:00' COMMENT 'token失效时间',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Token` (`Token`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='consumer token表';

-- ----------------------------
--  Table structure for `favorite`
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `UserId` varchar(32) NOT NULL DEFAULT 'default' COMMENT '收藏的用户',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Position` int(32) NOT NULL DEFAULT '10000' COMMENT '收藏顺序',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `IX_UserId` (`UserId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用收藏表';

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `PermissionType` varchar(32) NOT NULL DEFAULT '' COMMENT '权限类型',
  `TargetId` varchar(256) NOT NULL DEFAULT '' COMMENT '权限对象类型',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_TargetId_PermissionType` (`TargetId`(191),`PermissionType`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COMMENT='permission表';

-- ----------------------------
--  Records of `permission`
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES ('1', 'CreateCluster', 'SampleApp', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', 'CreateNamespace', 'SampleApp', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('3', 'AssignRole', 'SampleApp', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('4', 'ModifyNamespace', 'SampleApp+application', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('5', 'ReleaseNamespace', 'SampleApp+application', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('6', 'AssignRole', '201905211145', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('7', 'CreateCluster', '201905211145', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('8', 'CreateNamespace', '201905211145', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('9', 'ModifyNamespace', '201905211145+application', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('10', 'ReleaseNamespace', '201905211145+application', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('11', 'ModifyNamespace', '201905211145+application+DEV', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('12', 'ReleaseNamespace', '201905211145+application+DEV', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('13', 'CreateNamespace', '201905211444', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('14', 'CreateCluster', '201905211444', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('15', 'AssignRole', '201905211444', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('16', 'ModifyNamespace', '201905211444+application', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('17', 'ReleaseNamespace', '201905211444+application', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('18', 'ModifyNamespace', '201905211444+application+DEV', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('19', 'ReleaseNamespace', '201905211444+application+DEV', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('20', 'CreateNamespace', '201905211524', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('21', 'AssignRole', '201905211524', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('22', 'CreateCluster', '201905211524', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('23', 'ModifyNamespace', '201905211524+application', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('24', 'ReleaseNamespace', '201905211524+application', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('25', 'ModifyNamespace', '201905211524+application+DEV', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('26', 'ReleaseNamespace', '201905211524+application+DEV', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('27', 'CreateNamespace', '201905211527', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('28', 'CreateCluster', '201905211527', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('29', 'AssignRole', '201905211527', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('30', 'ModifyNamespace', '201905211527+application', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('31', 'ReleaseNamespace', '201905211527+application', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('32', 'ModifyNamespace', '201905211527+application+DEV', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('33', 'ReleaseNamespace', '201905211527+application+DEV', b'0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51'), ('34', 'CreateNamespace', '201905211532', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('35', 'CreateCluster', '201905211532', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('36', 'AssignRole', '201905211532', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('37', 'ModifyNamespace', '201905211532+application', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('38', 'ReleaseNamespace', '201905211532+application', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('39', 'ModifyNamespace', '201905211532+application+DEV', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('40', 'ReleaseNamespace', '201905211532+application+DEV', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('41', 'CreateNamespace', '201905211533', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:46'), ('42', 'AssignRole', '201905211533', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:48'), ('43', 'CreateCluster', '201905211533', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:50'), ('44', 'ModifyNamespace', '201905211533+application', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:56'), ('45', 'ReleaseNamespace', '201905211533+application', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:59'), ('46', 'ModifyNamespace', '201905211533+application+DEV', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:02:03'), ('47', 'ReleaseNamespace', '201905211533+application+DEV', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:02:09'), ('48', 'CreateCluster', '201905211551', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('49', 'AssignRole', '201905211551', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('50', 'CreateNamespace', '201905211551', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('51', 'ModifyNamespace', '201905211551+application', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('52', 'ReleaseNamespace', '201905211551+application', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('53', 'ModifyNamespace', '201905211551+application+DEV', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('54', 'ReleaseNamespace', '201905211551+application+DEV', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `RoleName` varchar(256) NOT NULL DEFAULT '' COMMENT 'Role name',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_RoleName` (`RoleName`(191)),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'Master+SampleApp', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', 'ModifyNamespace+SampleApp+application', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('3', 'ReleaseNamespace+SampleApp+application', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('4', 'Master+201905211145', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('5', 'ModifyNamespace+201905211145+application', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('6', 'ReleaseNamespace+201905211145+application', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('7', 'ModifyNamespace+201905211145+application+DEV', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('8', 'ReleaseNamespace+201905211145+application+DEV', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('9', 'Master+201905211444', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('10', 'ModifyNamespace+201905211444+application', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('11', 'ReleaseNamespace+201905211444+application', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('12', 'ModifyNamespace+201905211444+application+DEV', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('13', 'ReleaseNamespace+201905211444+application+DEV', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('14', 'Master+201905211524', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('15', 'ModifyNamespace+201905211524+application', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('16', 'ReleaseNamespace+201905211524+application', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('17', 'ModifyNamespace+201905211524+application+DEV', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('18', 'ReleaseNamespace+201905211524+application+DEV', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('19', 'Master+201905211527', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('20', 'ModifyNamespace+201905211527+application', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('21', 'ReleaseNamespace+201905211527+application', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('22', 'ModifyNamespace+201905211527+application+DEV', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('23', 'ReleaseNamespace+201905211527+application+DEV', b'0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51'), ('24', 'Master+201905211532', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('25', 'ModifyNamespace+201905211532+application', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('26', 'ReleaseNamespace+201905211532+application', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('27', 'ModifyNamespace+201905211532+application+DEV', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('28', 'ReleaseNamespace+201905211532+application+DEV', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('29', 'Master+201905211533', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:57:33'), ('30', 'ModifyNamespace+201905211533+application', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:12'), ('31', 'ReleaseNamespace+201905211533+application', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:16'), ('32', 'ModifyNamespace+201905211533+application+DEV', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:20'), ('33', 'ReleaseNamespace+201905211533+application+DEV', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:25'), ('34', 'Master+201905211551', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('35', 'ModifyNamespace+201905211551+application', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('36', 'ReleaseNamespace+201905211551+application', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('37', 'ModifyNamespace+201905211551+application+DEV', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('38', 'ReleaseNamespace+201905211551+application+DEV', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `rolepermission`
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `RoleId` int(10) unsigned DEFAULT NULL COMMENT 'Role Id',
  `PermissionId` int(10) unsigned DEFAULT NULL COMMENT 'Permission Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_PermissionId` (`PermissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COMMENT='角色和权限的绑定表';

-- ----------------------------
--  Records of `rolepermission`
-- ----------------------------
BEGIN;
INSERT INTO `rolepermission` VALUES ('1', '1', '1', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', '1', '2', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('3', '1', '3', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('4', '2', '4', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('5', '3', '5', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('6', '4', '6', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('7', '4', '7', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('8', '4', '8', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('9', '5', '9', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('10', '6', '10', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('11', '7', '11', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('12', '8', '12', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('13', '9', '13', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('14', '9', '14', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('15', '9', '15', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('16', '10', '16', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('17', '11', '17', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('18', '12', '18', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('19', '13', '19', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('20', '14', '20', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('21', '14', '21', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('22', '14', '22', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('23', '15', '23', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('24', '16', '24', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('25', '17', '25', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('26', '18', '26', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('27', '19', '27', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('28', '19', '28', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('29', '19', '29', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('30', '20', '30', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('31', '21', '31', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('32', '22', '32', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('33', '23', '33', b'0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51'), ('34', '24', '34', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('35', '24', '35', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('36', '24', '36', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('37', '25', '37', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('38', '26', '38', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('39', '27', '39', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('40', '28', '40', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('41', '29', '41', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('42', '29', '42', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('43', '29', '43', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('44', '30', '44', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('45', '31', '45', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('46', '32', '46', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('47', '33', '47', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('48', '34', '48', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('49', '34', '49', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('50', '34', '50', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('51', '35', '51', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('52', '36', '52', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('53', '37', '53', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('54', '38', '54', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `serverconfig`
-- ----------------------------
DROP TABLE IF EXISTS `serverconfig`;
CREATE TABLE `serverconfig` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Key` varchar(64) NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Value` varchar(2048) NOT NULL DEFAULT 'default' COMMENT '配置项值',
  `Comment` varchar(1024) DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Key` (`Key`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='配置服务自身配置';

-- ----------------------------
--  Records of `serverconfig`
-- ----------------------------
BEGIN;
INSERT INTO `serverconfig` VALUES ('1', 'apollo.portal.envs', 'dev', '可支持的环境列表', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', 'organizations', '[{\"orgId\":\"TEST1\",\"orgName\":\"样例部门1\"},{\"orgId\":\"TEST2\",\"orgName\":\"样例部门2\"}]', '部门列表', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('3', 'superAdmin', 'apollo', 'Portal超级管理员', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('4', 'api.readTimeout', '10000', 'http接口read timeout', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('5', 'consumer.token.salt', 'someSalt', 'consumer token salt', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('6', 'admin.createPrivateNamespace.switch', 'true', '是否允许项目管理员创建私有namespace', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('7', 'configView.memberOnly.envs', 'dev', '只对项目成员显示配置信息的环境列表，多个env以英文逗号分隔', b'0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
COMMIT;

-- ----------------------------
--  Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `UserId` varchar(128) DEFAULT '' COMMENT '用户身份标识',
  `RoleId` int(10) unsigned DEFAULT NULL COMMENT 'Role Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_UserId_RoleId` (`UserId`,`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='用户和role的绑定表';

-- ----------------------------
--  Records of `userrole`
-- ----------------------------
BEGIN;
INSERT INTO `userrole` VALUES ('1', 'apollo', '1', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('2', 'apollo', '2', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('3', 'apollo', '3', b'0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56'), ('4', 'apollo', '4', b'0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17'), ('5', 'apollo', '5', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('6', 'apollo', '6', b'0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18'), ('7', 'apollo', '9', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('8', 'apollo', '10', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('9', 'apollo', '11', b'0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03'), ('10', 'apollo', '14', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('11', 'apollo', '15', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('12', 'apollo', '16', b'0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46'), ('13', 'apollo', '19', b'0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50'), ('14', 'apollo', '20', b'0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51'), ('15', 'apollo', '21', b'0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51'), ('16', 'apollo', '24', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('17', 'apollo', '25', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('18', 'apollo', '26', b'0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43'), ('19', 'apollo', '29', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('20', 'apollo', '30', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('21', 'apollo', '31', b'0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48'), ('22', 'apollo', '34', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('23', 'apollo', '35', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28'), ('24', 'apollo', '36', b'0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) NOT NULL DEFAULT 'default' COMMENT '用户名',
  `Password` varchar(64) NOT NULL DEFAULT 'default' COMMENT '密码',
  `Email` varchar(64) NOT NULL DEFAULT 'default' COMMENT '邮箱地址',
  `Enabled` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'apollo', '$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS', 'apollo@acme.com', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
