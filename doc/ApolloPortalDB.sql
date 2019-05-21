
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
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('1', 'SampleApp', 'Sample App', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `app` VALUES ('2', '201905211145', 'shop-manage', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `app` VALUES ('3', '201905211444', 'shop-activity', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `app` VALUES ('4', '201905211524', 'shop-order', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `app` VALUES ('5', '201905211527', 'shop-user', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `app` VALUES ('6', '201905211532', 'shop-seller', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `app` VALUES ('7', '201905211533', 'shop-goods', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:53:05');
INSERT INTO `app` VALUES ('8', '201905211551', 'shop-risk', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for appnamespace
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
-- Records of appnamespace
-- ----------------------------
INSERT INTO `appnamespace` VALUES ('1', 'application', 'SampleApp', 'properties', '\0', 'default app namespace', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `appnamespace` VALUES ('2', 'application', '201905211145', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `appnamespace` VALUES ('3', 'application', '201905211444', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `appnamespace` VALUES ('4', 'application', '201905211524', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `appnamespace` VALUES ('5', 'application', '201905211527', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `appnamespace` VALUES ('6', 'application', '201905211532', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `appnamespace` VALUES ('7', 'application', '201905211533', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:53:46');
INSERT INTO `appnamespace` VALUES ('8', 'application', '201905211551', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) NOT NULL,
  `Authority` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('1', 'apollo', 'ROLE_user');

-- ----------------------------
-- Table structure for consumer
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
-- Records of consumer
-- ----------------------------

-- ----------------------------
-- Table structure for consumeraudit
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
-- Records of consumeraudit
-- ----------------------------

-- ----------------------------
-- Table structure for consumerrole
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
-- Records of consumerrole
-- ----------------------------

-- ----------------------------
-- Table structure for consumertoken
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
-- Records of consumertoken
-- ----------------------------

-- ----------------------------
-- Table structure for favorite
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='应用收藏表';

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for permission
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
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'CreateCluster', 'SampleApp', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `permission` VALUES ('2', 'CreateNamespace', 'SampleApp', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `permission` VALUES ('3', 'AssignRole', 'SampleApp', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `permission` VALUES ('4', 'ModifyNamespace', 'SampleApp+application', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `permission` VALUES ('5', 'ReleaseNamespace', 'SampleApp+application', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `permission` VALUES ('6', 'AssignRole', '201905211145', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `permission` VALUES ('7', 'CreateCluster', '201905211145', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `permission` VALUES ('8', 'CreateNamespace', '201905211145', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `permission` VALUES ('9', 'ModifyNamespace', '201905211145+application', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `permission` VALUES ('10', 'ReleaseNamespace', '201905211145+application', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `permission` VALUES ('11', 'ModifyNamespace', '201905211145+application+DEV', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `permission` VALUES ('12', 'ReleaseNamespace', '201905211145+application+DEV', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `permission` VALUES ('13', 'CreateNamespace', '201905211444', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('14', 'CreateCluster', '201905211444', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('15', 'AssignRole', '201905211444', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('16', 'ModifyNamespace', '201905211444+application', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('17', 'ReleaseNamespace', '201905211444+application', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('18', 'ModifyNamespace', '201905211444+application+DEV', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('19', 'ReleaseNamespace', '201905211444+application+DEV', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `permission` VALUES ('20', 'CreateNamespace', '201905211524', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('21', 'AssignRole', '201905211524', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('22', 'CreateCluster', '201905211524', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('23', 'ModifyNamespace', '201905211524+application', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('24', 'ReleaseNamespace', '201905211524+application', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('25', 'ModifyNamespace', '201905211524+application+DEV', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('26', 'ReleaseNamespace', '201905211524+application+DEV', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `permission` VALUES ('27', 'CreateNamespace', '201905211527', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('28', 'CreateCluster', '201905211527', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('29', 'AssignRole', '201905211527', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('30', 'ModifyNamespace', '201905211527+application', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('31', 'ReleaseNamespace', '201905211527+application', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('32', 'ModifyNamespace', '201905211527+application+DEV', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `permission` VALUES ('33', 'ReleaseNamespace', '201905211527+application+DEV', '\0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51');
INSERT INTO `permission` VALUES ('34', 'CreateNamespace', '201905211532', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('35', 'CreateCluster', '201905211532', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('36', 'AssignRole', '201905211532', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('37', 'ModifyNamespace', '201905211532+application', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('38', 'ReleaseNamespace', '201905211532+application', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('39', 'ModifyNamespace', '201905211532+application+DEV', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('40', 'ReleaseNamespace', '201905211532+application+DEV', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `permission` VALUES ('41', 'CreateNamespace', '201905211533', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:46');
INSERT INTO `permission` VALUES ('42', 'AssignRole', '201905211533', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:48');
INSERT INTO `permission` VALUES ('43', 'CreateCluster', '201905211533', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:50');
INSERT INTO `permission` VALUES ('44', 'ModifyNamespace', '201905211533+application', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:56');
INSERT INTO `permission` VALUES ('45', 'ReleaseNamespace', '201905211533+application', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:01:59');
INSERT INTO `permission` VALUES ('46', 'ModifyNamespace', '201905211533+application+DEV', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:02:03');
INSERT INTO `permission` VALUES ('47', 'ReleaseNamespace', '201905211533+application+DEV', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 16:02:09');
INSERT INTO `permission` VALUES ('48', 'CreateCluster', '201905211551', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('49', 'AssignRole', '201905211551', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('50', 'CreateNamespace', '201905211551', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('51', 'ModifyNamespace', '201905211551+application', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('52', 'ReleaseNamespace', '201905211551+application', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('53', 'ModifyNamespace', '201905211551+application+DEV', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `permission` VALUES ('54', 'ReleaseNamespace', '201905211551+application+DEV', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for role
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
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'Master+SampleApp', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `role` VALUES ('2', 'ModifyNamespace+SampleApp+application', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `role` VALUES ('3', 'ReleaseNamespace+SampleApp+application', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `role` VALUES ('4', 'Master+201905211145', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `role` VALUES ('5', 'ModifyNamespace+201905211145+application', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `role` VALUES ('6', 'ReleaseNamespace+201905211145+application', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `role` VALUES ('7', 'ModifyNamespace+201905211145+application+DEV', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `role` VALUES ('8', 'ReleaseNamespace+201905211145+application+DEV', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `role` VALUES ('9', 'Master+201905211444', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `role` VALUES ('10', 'ModifyNamespace+201905211444+application', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `role` VALUES ('11', 'ReleaseNamespace+201905211444+application', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `role` VALUES ('12', 'ModifyNamespace+201905211444+application+DEV', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `role` VALUES ('13', 'ReleaseNamespace+201905211444+application+DEV', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `role` VALUES ('14', 'Master+201905211524', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `role` VALUES ('15', 'ModifyNamespace+201905211524+application', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `role` VALUES ('16', 'ReleaseNamespace+201905211524+application', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `role` VALUES ('17', 'ModifyNamespace+201905211524+application+DEV', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `role` VALUES ('18', 'ReleaseNamespace+201905211524+application+DEV', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `role` VALUES ('19', 'Master+201905211527', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `role` VALUES ('20', 'ModifyNamespace+201905211527+application', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `role` VALUES ('21', 'ReleaseNamespace+201905211527+application', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `role` VALUES ('22', 'ModifyNamespace+201905211527+application+DEV', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `role` VALUES ('23', 'ReleaseNamespace+201905211527+application+DEV', '\0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51');
INSERT INTO `role` VALUES ('24', 'Master+201905211532', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `role` VALUES ('25', 'ModifyNamespace+201905211532+application', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `role` VALUES ('26', 'ReleaseNamespace+201905211532+application', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `role` VALUES ('27', 'ModifyNamespace+201905211532+application+DEV', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `role` VALUES ('28', 'ReleaseNamespace+201905211532+application+DEV', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `role` VALUES ('29', 'Master+201905211533', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:57:33');
INSERT INTO `role` VALUES ('30', 'ModifyNamespace+201905211533+application', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:12');
INSERT INTO `role` VALUES ('31', 'ReleaseNamespace+201905211533+application', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:16');
INSERT INTO `role` VALUES ('32', 'ModifyNamespace+201905211533+application+DEV', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:20');
INSERT INTO `role` VALUES ('33', 'ReleaseNamespace+201905211533+application+DEV', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:58:25');
INSERT INTO `role` VALUES ('34', 'Master+201905211551', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `role` VALUES ('35', 'ModifyNamespace+201905211551+application', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `role` VALUES ('36', 'ReleaseNamespace+201905211551+application', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `role` VALUES ('37', 'ModifyNamespace+201905211551+application+DEV', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `role` VALUES ('38', 'ReleaseNamespace+201905211551+application+DEV', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for rolepermission
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
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1', '1', '1', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `rolepermission` VALUES ('2', '1', '2', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `rolepermission` VALUES ('3', '1', '3', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `rolepermission` VALUES ('4', '2', '4', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `rolepermission` VALUES ('5', '3', '5', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `rolepermission` VALUES ('6', '4', '6', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `rolepermission` VALUES ('7', '4', '7', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `rolepermission` VALUES ('8', '4', '8', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `rolepermission` VALUES ('9', '5', '9', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `rolepermission` VALUES ('10', '6', '10', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `rolepermission` VALUES ('11', '7', '11', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `rolepermission` VALUES ('12', '8', '12', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `rolepermission` VALUES ('13', '9', '13', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('14', '9', '14', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('15', '9', '15', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('16', '10', '16', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('17', '11', '17', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('18', '12', '18', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('19', '13', '19', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `rolepermission` VALUES ('20', '14', '20', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('21', '14', '21', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('22', '14', '22', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('23', '15', '23', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('24', '16', '24', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('25', '17', '25', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('26', '18', '26', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `rolepermission` VALUES ('27', '19', '27', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('28', '19', '28', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('29', '19', '29', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('30', '20', '30', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('31', '21', '31', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('32', '22', '32', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `rolepermission` VALUES ('33', '23', '33', '\0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51');
INSERT INTO `rolepermission` VALUES ('34', '24', '34', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('35', '24', '35', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('36', '24', '36', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('37', '25', '37', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('38', '26', '38', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('39', '27', '39', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('40', '28', '40', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `rolepermission` VALUES ('41', '29', '41', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('42', '29', '42', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('43', '29', '43', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('44', '30', '44', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('45', '31', '45', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('46', '32', '46', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('47', '33', '47', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `rolepermission` VALUES ('48', '34', '48', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('49', '34', '49', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('50', '34', '50', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('51', '35', '51', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('52', '36', '52', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('53', '37', '53', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `rolepermission` VALUES ('54', '38', '54', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for serverconfig
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
-- Records of serverconfig
-- ----------------------------
INSERT INTO `serverconfig` VALUES ('1', 'apollo.portal.envs', 'dev', '可支持的环境列表', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('2', 'organizations', '[{\"orgId\":\"TEST1\",\"orgName\":\"样例部门1\"},{\"orgId\":\"TEST2\",\"orgName\":\"样例部门2\"}]', '部门列表', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('3', 'superAdmin', 'apollo', 'Portal超级管理员', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('4', 'api.readTimeout', '10000', 'http接口read timeout', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('5', 'consumer.token.salt', 'someSalt', 'consumer token salt', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('6', 'admin.createPrivateNamespace.switch', 'true', '是否允许项目管理员创建私有namespace', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `serverconfig` VALUES ('7', 'configView.memberOnly.envs', 'dev', '只对项目成员显示配置信息的环境列表，多个env以英文逗号分隔', '\0', 'default', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');

-- ----------------------------
-- Table structure for userrole
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
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', 'apollo', '1', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `userrole` VALUES ('2', 'apollo', '2', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `userrole` VALUES ('3', 'apollo', '3', '\0', '', '2019-05-21 10:48:56', '', '2019-05-21 10:48:56');
INSERT INTO `userrole` VALUES ('4', 'apollo', '4', '\0', 'apollo', '2019-05-21 11:43:17', 'apollo', '2019-05-21 11:43:17');
INSERT INTO `userrole` VALUES ('5', 'apollo', '5', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `userrole` VALUES ('6', 'apollo', '6', '\0', 'apollo', '2019-05-21 11:43:18', 'apollo', '2019-05-21 11:43:18');
INSERT INTO `userrole` VALUES ('7', 'apollo', '9', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `userrole` VALUES ('8', 'apollo', '10', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `userrole` VALUES ('9', 'apollo', '11', '\0', 'apollo', '2019-05-21 14:42:03', 'apollo', '2019-05-21 14:42:03');
INSERT INTO `userrole` VALUES ('10', 'apollo', '14', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `userrole` VALUES ('11', 'apollo', '15', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `userrole` VALUES ('12', 'apollo', '16', '\0', 'apollo', '2019-05-21 15:21:46', 'apollo', '2019-05-21 15:21:46');
INSERT INTO `userrole` VALUES ('13', 'apollo', '19', '\0', 'apollo', '2019-05-21 15:24:50', 'apollo', '2019-05-21 15:24:50');
INSERT INTO `userrole` VALUES ('14', 'apollo', '20', '\0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51');
INSERT INTO `userrole` VALUES ('15', 'apollo', '21', '\0', 'apollo', '2019-05-21 15:24:51', 'apollo', '2019-05-21 15:24:51');
INSERT INTO `userrole` VALUES ('16', 'apollo', '24', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `userrole` VALUES ('17', 'apollo', '25', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `userrole` VALUES ('18', 'apollo', '26', '\0', 'apollo', '2019-05-21 15:29:43', 'apollo', '2019-05-21 15:29:43');
INSERT INTO `userrole` VALUES ('19', 'apollo', '29', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `userrole` VALUES ('20', 'apollo', '30', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `userrole` VALUES ('21', 'apollo', '31', '\0', 'apollo', '2019-05-21 15:30:48', 'apollo', '2019-05-21 15:30:48');
INSERT INTO `userrole` VALUES ('22', 'apollo', '34', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `userrole` VALUES ('23', 'apollo', '35', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');
INSERT INTO `userrole` VALUES ('24', 'apollo', '36', '\0', 'apollo', '2019-05-21 15:48:28', 'apollo', '2019-05-21 15:48:28');

-- ----------------------------
-- Table structure for users
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
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'apollo', '$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS', 'apollo@acme.com', '1');
