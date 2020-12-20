/*
 Navicat Premium Data Transfer

 Source Server         : prod
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 106.54.251.32
 Source Database       : pager_platform

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 12/20/2020 19:12:25 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人手机号码',
  `username` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收货人姓名',
  `area` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '所在地区',
  `detail_address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '详细地址',
  `label` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标签',
  `default_address` tinyint(1) DEFAULT '0' COMMENT '是否默认地址标志\ntrue：默认地址\nfalse：不是默认地址',
  `latitude` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '纬度',
  `longitude` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '经度',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_address`
-- ----------------------------
BEGIN;
INSERT INTO `t_address` VALUES ('1', '1', '13818471341', '12344', '12', '22333', '333', '0', '2223.0923983', '82.8833', '2019-01-14 14:20:33', '2019-01-14 14:20:40', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` bigint(20) NOT NULL,
  `area_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区 县 代码',
  `area_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区 县',
  `parent_area_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对应 t_city 的city_code',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL,
  `city_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市代码',
  `city_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市名称',
  `parent_city_code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对应t_province 的province_code',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_city`
-- ----------------------------
BEGIN;
INSERT INTO `t_city` VALUES ('1', '110100', '市辖区', '110000'), ('2', '110200', '县', '110000'), ('3', '120100', '市辖区', '120000'), ('4', '120200', '县', '120000'), ('5', '130100', '石家庄市', '130000'), ('6', '130200', '唐山市', '130000'), ('7', '130300', '秦皇岛市', '130000'), ('8', '130400', '邯郸市', '130000'), ('9', '130500', '邢台市', '130000'), ('10', '130600', '保定市', '130000'), ('11', '130700', '张家口市', '130000'), ('12', '130800', '承德市', '130000'), ('13', '130900', '沧州市', '130000'), ('14', '131000', '廊坊市', '130000'), ('15', '131100', '衡水市', '130000'), ('16', '140100', '太原市', '140000'), ('17', '140200', '大同市', '140000'), ('18', '140300', '阳泉市', '140000'), ('19', '140400', '长治市', '140000'), ('20', '140500', '晋城市', '140000'), ('21', '140600', '朔州市', '140000'), ('22', '140700', '晋中市', '140000'), ('23', '140800', '运城市', '140000'), ('24', '140900', '忻州市', '140000'), ('25', '141000', '临汾市', '140000'), ('26', '141100', '吕梁市', '140000'), ('27', '150100', '呼和浩特市', '150000'), ('28', '150200', '包头市', '150000'), ('29', '150300', '乌海市', '150000'), ('30', '150400', '赤峰市', '150000'), ('31', '150500', '通辽市', '150000'), ('32', '150600', '鄂尔多斯市', '150000'), ('33', '150700', '呼伦贝尔市', '150000'), ('34', '150800', '巴彦淖尔市', '150000'), ('35', '150900', '乌兰察布市', '150000'), ('36', '152200', '兴安盟', '150000'), ('37', '152500', '锡林郭勒盟', '150000'), ('38', '152900', '阿拉善盟', '150000'), ('39', '210100', '沈阳市', '210000'), ('40', '210200', '大连市', '210000'), ('41', '210300', '鞍山市', '210000'), ('42', '210400', '抚顺市', '210000'), ('43', '210500', '本溪市', '210000'), ('44', '210600', '丹东市', '210000'), ('45', '210700', '锦州市', '210000'), ('46', '210800', '营口市', '210000'), ('47', '210900', '阜新市', '210000'), ('48', '211000', '辽阳市', '210000'), ('49', '211100', '盘锦市', '210000'), ('50', '211200', '铁岭市', '210000'), ('51', '211300', '朝阳市', '210000'), ('52', '211400', '葫芦岛市', '210000'), ('53', '220100', '长春市', '220000'), ('54', '220200', '吉林市', '220000'), ('55', '220300', '四平市', '220000'), ('56', '220400', '辽源市', '220000'), ('57', '220500', '通化市', '220000'), ('58', '220600', '白山市', '220000'), ('59', '220700', '松原市', '220000'), ('60', '220800', '白城市', '220000'), ('61', '222400', '延边朝鲜族自治州', '220000'), ('62', '230100', '哈尔滨市', '230000'), ('63', '230200', '齐齐哈尔市', '230000'), ('64', '230300', '鸡西市', '230000'), ('65', '230400', '鹤岗市', '230000'), ('66', '230500', '双鸭山市', '230000'), ('67', '230600', '大庆市', '230000'), ('68', '230700', '伊春市', '230000'), ('69', '230800', '佳木斯市', '230000'), ('70', '230900', '七台河市', '230000'), ('71', '231000', '牡丹江市', '230000'), ('72', '231100', '黑河市', '230000'), ('73', '231200', '绥化市', '230000'), ('74', '232700', '大兴安岭地区', '230000'), ('75', '310100', '市辖区', '310000'), ('76', '310200', '县', '310000'), ('77', '320100', '南京市', '320000'), ('78', '320200', '无锡市', '320000'), ('79', '320300', '徐州市', '320000'), ('80', '320400', '常州市', '320000'), ('81', '320500', '苏州市', '320000'), ('82', '320600', '南通市', '320000'), ('83', '320700', '连云港市', '320000'), ('84', '320800', '淮安市', '320000'), ('85', '320900', '盐城市', '320000'), ('86', '321000', '扬州市', '320000'), ('87', '321100', '镇江市', '320000'), ('88', '321200', '泰州市', '320000'), ('89', '321300', '宿迁市', '320000'), ('90', '330100', '杭州市', '330000'), ('91', '330200', '宁波市', '330000'), ('92', '330300', '温州市', '330000'), ('93', '330400', '嘉兴市', '330000'), ('94', '330500', '湖州市', '330000'), ('95', '330600', '绍兴市', '330000'), ('96', '330700', '金华市', '330000'), ('97', '330800', '衢州市', '330000'), ('98', '330900', '舟山市', '330000'), ('99', '331000', '台州市', '330000'), ('100', '331100', '丽水市', '330000'), ('101', '340100', '合肥市', '340000'), ('102', '340200', '芜湖市', '340000'), ('103', '340300', '蚌埠市', '340000'), ('104', '340400', '淮南市', '340000'), ('105', '340500', '马鞍山市', '340000'), ('106', '340600', '淮北市', '340000'), ('107', '340700', '铜陵市', '340000'), ('108', '340800', '安庆市', '340000'), ('109', '341000', '黄山市', '340000'), ('110', '341100', '滁州市', '340000'), ('111', '341200', '阜阳市', '340000'), ('112', '341300', '宿州市', '340000'), ('113', '341400', '巢湖市', '340000'), ('114', '341500', '六安市', '340000'), ('115', '341600', '亳州市', '340000'), ('116', '341700', '池州市', '340000'), ('117', '341800', '宣城市', '340000'), ('118', '350100', '福州市', '350000'), ('119', '350200', '厦门市', '350000'), ('120', '350300', '莆田市', '350000'), ('121', '350400', '三明市', '350000'), ('122', '350500', '泉州市', '350000'), ('123', '350600', '漳州市', '350000'), ('124', '350700', '南平市', '350000'), ('125', '350800', '龙岩市', '350000'), ('126', '350900', '宁德市', '350000'), ('127', '360100', '南昌市', '360000'), ('128', '360200', '景德镇市', '360000'), ('129', '360300', '萍乡市', '360000'), ('130', '360400', '九江市', '360000'), ('131', '360500', '新余市', '360000'), ('132', '360600', '鹰潭市', '360000'), ('133', '360700', '赣州市', '360000'), ('134', '360800', '吉安市', '360000'), ('135', '360900', '宜春市', '360000'), ('136', '361000', '抚州市', '360000'), ('137', '361100', '上饶市', '360000'), ('138', '370100', '济南市', '370000'), ('139', '370200', '青岛市', '370000'), ('140', '370300', '淄博市', '370000'), ('141', '370400', '枣庄市', '370000'), ('142', '370500', '东营市', '370000'), ('143', '370600', '烟台市', '370000'), ('144', '370700', '潍坊市', '370000'), ('145', '370800', '济宁市', '370000'), ('146', '370900', '泰安市', '370000'), ('147', '371000', '威海市', '370000'), ('148', '371100', '日照市', '370000'), ('149', '371200', '莱芜市', '370000'), ('150', '371300', '临沂市', '370000'), ('151', '371400', '德州市', '370000'), ('152', '371500', '聊城市', '370000'), ('153', '371600', '滨州市', '370000'), ('154', '371700', '荷泽市', '370000'), ('155', '410100', '郑州市', '410000'), ('156', '410200', '开封市', '410000'), ('157', '410300', '洛阳市', '410000'), ('158', '410400', '平顶山市', '410000'), ('159', '410500', '安阳市', '410000'), ('160', '410600', '鹤壁市', '410000'), ('161', '410700', '新乡市', '410000'), ('162', '410800', '焦作市', '410000'), ('163', '410900', '濮阳市', '410000'), ('164', '411000', '许昌市', '410000'), ('165', '411100', '漯河市', '410000'), ('166', '411200', '三门峡市', '410000'), ('167', '411300', '南阳市', '410000'), ('168', '411400', '商丘市', '410000'), ('169', '411500', '信阳市', '410000'), ('170', '411600', '周口市', '410000'), ('171', '411700', '驻马店市', '410000'), ('172', '420100', '武汉市', '420000'), ('173', '420200', '黄石市', '420000'), ('174', '420300', '十堰市', '420000'), ('175', '420500', '宜昌市', '420000'), ('176', '420600', '襄樊市', '420000'), ('177', '420700', '鄂州市', '420000'), ('178', '420800', '荆门市', '420000'), ('179', '420900', '孝感市', '420000'), ('180', '421000', '荆州市', '420000'), ('181', '421100', '黄冈市', '420000'), ('182', '421200', '咸宁市', '420000'), ('183', '421300', '随州市', '420000'), ('184', '422800', '恩施土家族苗族自治州', '420000'), ('185', '429000', '省直辖行政单位', '420000'), ('186', '430100', '长沙市', '430000'), ('187', '430200', '株洲市', '430000'), ('188', '430300', '湘潭市', '430000'), ('189', '430400', '衡阳市', '430000'), ('190', '430500', '邵阳市', '430000'), ('191', '430600', '岳阳市', '430000'), ('192', '430700', '常德市', '430000'), ('193', '430800', '张家界市', '430000'), ('194', '430900', '益阳市', '430000'), ('195', '431000', '郴州市', '430000'), ('196', '431100', '永州市', '430000'), ('197', '431200', '怀化市', '430000'), ('198', '431300', '娄底市', '430000'), ('199', '433100', '湘西土家族苗族自治州', '430000'), ('200', '440100', '广州市', '440000'), ('201', '440200', '韶关市', '440000'), ('202', '440300', '深圳市', '440000'), ('203', '440400', '珠海市', '440000'), ('204', '440500', '汕头市', '440000'), ('205', '440600', '佛山市', '440000'), ('206', '440700', '江门市', '440000'), ('207', '440800', '湛江市', '440000'), ('208', '440900', '茂名市', '440000'), ('209', '441200', '肇庆市', '440000'), ('210', '441300', '惠州市', '440000'), ('211', '441400', '梅州市', '440000'), ('212', '441500', '汕尾市', '440000'), ('213', '441600', '河源市', '440000'), ('214', '441700', '阳江市', '440000'), ('215', '441800', '清远市', '440000'), ('216', '441900', '东莞市', '440000'), ('217', '442000', '中山市', '440000'), ('218', '445100', '潮州市', '440000'), ('219', '445200', '揭阳市', '440000'), ('220', '445300', '云浮市', '440000'), ('221', '450100', '南宁市', '450000'), ('222', '450200', '柳州市', '450000'), ('223', '450300', '桂林市', '450000'), ('224', '450400', '梧州市', '450000'), ('225', '450500', '北海市', '450000'), ('226', '450600', '防城港市', '450000'), ('227', '450700', '钦州市', '450000'), ('228', '450800', '贵港市', '450000'), ('229', '450900', '玉林市', '450000'), ('230', '451000', '百色市', '450000'), ('231', '451100', '贺州市', '450000'), ('232', '451200', '河池市', '450000'), ('233', '451300', '来宾市', '450000'), ('234', '451400', '崇左市', '450000'), ('235', '460100', '海口市', '460000'), ('236', '460200', '三亚市', '460000'), ('237', '469000', '省直辖县级行政单位', '460000'), ('238', '500100', '市辖区', '500000'), ('239', '500200', '县', '500000'), ('240', '500300', '市', '500000'), ('241', '510100', '成都市', '510000'), ('242', '510300', '自贡市', '510000'), ('243', '510400', '攀枝花市', '510000'), ('244', '510500', '泸州市', '510000'), ('245', '510600', '德阳市', '510000'), ('246', '510700', '绵阳市', '510000'), ('247', '510800', '广元市', '510000'), ('248', '510900', '遂宁市', '510000'), ('249', '511000', '内江市', '510000'), ('250', '511100', '乐山市', '510000'), ('251', '511300', '南充市', '510000'), ('252', '511400', '眉山市', '510000'), ('253', '511500', '宜宾市', '510000'), ('254', '511600', '广安市', '510000'), ('255', '511700', '达州市', '510000'), ('256', '511800', '雅安市', '510000'), ('257', '511900', '巴中市', '510000'), ('258', '512000', '资阳市', '510000'), ('259', '513200', '阿坝藏族羌族自治州', '510000'), ('260', '513300', '甘孜藏族自治州', '510000'), ('261', '513400', '凉山彝族自治州', '510000'), ('262', '520100', '贵阳市', '520000'), ('263', '520200', '六盘水市', '520000'), ('264', '520300', '遵义市', '520000'), ('265', '520400', '安顺市', '520000'), ('266', '522200', '铜仁地区', '520000'), ('267', '522300', '黔西南布依族苗族自治州', '520000'), ('268', '522400', '毕节地区', '520000'), ('269', '522600', '黔东南苗族侗族自治州', '520000'), ('270', '522700', '黔南布依族苗族自治州', '520000'), ('271', '530100', '昆明市', '530000'), ('272', '530300', '曲靖市', '530000'), ('273', '530400', '玉溪市', '530000'), ('274', '530500', '保山市', '530000'), ('275', '530600', '昭通市', '530000'), ('276', '530700', '丽江市', '530000'), ('277', '530800', '思茅市', '530000'), ('278', '530900', '临沧市', '530000'), ('279', '532300', '楚雄彝族自治州', '530000'), ('280', '532500', '红河哈尼族彝族自治州', '530000'), ('281', '532600', '文山壮族苗族自治州', '530000'), ('282', '532800', '西双版纳傣族自治州', '530000'), ('283', '532900', '大理白族自治州', '530000'), ('284', '533100', '德宏傣族景颇族自治州', '530000'), ('285', '533300', '怒江傈僳族自治州', '530000'), ('286', '533400', '迪庆藏族自治州', '530000'), ('287', '540100', '拉萨市', '540000'), ('288', '542100', '昌都地区', '540000'), ('289', '542200', '山南地区', '540000'), ('290', '542300', '日喀则地区', '540000'), ('291', '542400', '那曲地区', '540000'), ('292', '542500', '阿里地区', '540000'), ('293', '542600', '林芝地区', '540000'), ('294', '610100', '西安市', '610000'), ('295', '610200', '铜川市', '610000'), ('296', '610300', '宝鸡市', '610000'), ('297', '610400', '咸阳市', '610000'), ('298', '610500', '渭南市', '610000'), ('299', '610600', '延安市', '610000'), ('300', '610700', '汉中市', '610000'), ('301', '610800', '榆林市', '610000'), ('302', '610900', '安康市', '610000'), ('303', '611000', '商洛市', '610000'), ('304', '620100', '兰州市', '620000'), ('305', '620200', '嘉峪关市', '620000'), ('306', '620300', '金昌市', '620000'), ('307', '620400', '白银市', '620000'), ('308', '620500', '天水市', '620000'), ('309', '620600', '武威市', '620000'), ('310', '620700', '张掖市', '620000'), ('311', '620800', '平凉市', '620000'), ('312', '620900', '酒泉市', '620000'), ('313', '621000', '庆阳市', '620000'), ('314', '621100', '定西市', '620000'), ('315', '621200', '陇南市', '620000'), ('316', '622900', '临夏回族自治州', '620000'), ('317', '623000', '甘南藏族自治州', '620000'), ('318', '630100', '西宁市', '630000'), ('319', '632100', '海东地区', '630000'), ('320', '632200', '海北藏族自治州', '630000'), ('321', '632300', '黄南藏族自治州', '630000'), ('322', '632500', '海南藏族自治州', '630000'), ('323', '632600', '果洛藏族自治州', '630000'), ('324', '632700', '玉树藏族自治州', '630000'), ('325', '632800', '海西蒙古族藏族自治州', '630000'), ('326', '640100', '银川市', '640000'), ('327', '640200', '石嘴山市', '640000'), ('328', '640300', '吴忠市', '640000'), ('329', '640400', '固原市', '640000'), ('330', '640500', '中卫市', '640000'), ('331', '650100', '乌鲁木齐市', '650000'), ('332', '650200', '克拉玛依市', '650000'), ('333', '652100', '吐鲁番地区', '650000'), ('334', '652200', '哈密地区', '650000'), ('335', '652300', '昌吉回族自治州', '650000'), ('336', '652700', '博尔塔拉蒙古自治州', '650000'), ('337', '652800', '巴音郭楞蒙古自治州', '650000'), ('338', '652900', '阿克苏地区', '650000'), ('339', '653000', '克孜勒苏柯尔克孜自治州', '650000'), ('340', '653100', '喀什地区', '650000'), ('341', '653200', '和田地区', '650000'), ('342', '654000', '伊犁哈萨克自治州', '650000'), ('343', '654200', '塔城地区', '650000'), ('344', '654300', '阿勒泰地区', '650000'), ('345', '659000', '省直辖行政单位', '650000');
COMMIT;

-- ----------------------------
--  Table structure for `t_field`
-- ----------------------------
DROP TABLE IF EXISTS `t_field`;
CREATE TABLE `t_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `form_id` bigint(20) DEFAULT NULL,
  `type` varchar(31) NOT NULL,
  `field` varchar(31) NOT NULL,
  `title` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_field`
-- ----------------------------
BEGIN;
INSERT INTO `t_field` VALUES ('1', '2', 'input', 'configName', '配置项名称', '2020-05-30 14:57:00', '2020-05-30 14:57:05', 'admin', 'admin', b'0'), ('2', '2', 'input', 'configType', '配置项类型', '2020-05-30 14:57:00', '2020-05-30 15:00:01', 'admin', 'admin', b'0'), ('3', '2', 'input', 'description', '配置项描述', '2020-05-30 14:57:00', '2020-05-30 15:01:08', 'admin', 'admin', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_field_props`
-- ----------------------------
DROP TABLE IF EXISTS `t_field_props`;
CREATE TABLE `t_field_props` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `field_id` bigint(20) DEFAULT NULL COMMENT '字段表t_field 主键',
  `type` varchar(31) DEFAULT NULL COMMENT '类型',
  `max_length` int(11) DEFAULT NULL COMMENT '原生属性，最大输入长度',
  `min_length` int(11) DEFAULT NULL COMMENT '原生属性，最小输入长度',
  `placeholder` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '输入框占位文本',
  `clearable` bit(1) DEFAULT NULL COMMENT '是否可清空',
  `disabled` bit(1) DEFAULT NULL COMMENT '禁用',
  `size` varchar(31) DEFAULT NULL COMMENT '输入框尺寸，只在 type!="textarea" 时有效',
  `prefix_icon` varchar(63) DEFAULT NULL COMMENT '输入框头部图标',
  `suffix_icon` varchar(63) DEFAULT NULL COMMENT '输入框尾部图标',
  `rows` int(11) DEFAULT NULL COMMENT '输入框行数，只对 type="textarea" 有效',
  `autosize` varchar(255) DEFAULT NULL COMMENT '自适应内容高度，只对 type="textarea" 有效，可传入对象，如，{ minRows: 2, maxRows: 6 }',
  `step` int(11) DEFAULT NULL COMMENT '计数器步长',
  `datasource` varchar(127) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_field_props`
-- ----------------------------
BEGIN;
INSERT INTO `t_field_props` VALUES ('1', '1', 'input', null, null, '请设置', null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:51', '2020-05-30 15:02:50', 'admin', 'admin', b'0'), ('2', '2', 'input', null, null, '请设置', null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:47', '2020-05-30 15:03:16', 'admin', 'admin', b'0'), ('3', '3', 'textarea', null, null, '请设置', null, null, null, null, null, '4', null, null, null, '2020-05-30 15:04:44', '2020-05-30 15:03:21', 'admin', 'admin', b'0'), ('4', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-05-30 15:04:23', 'admin', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_form`
-- ----------------------------
DROP TABLE IF EXISTS `t_form`;
CREATE TABLE `t_form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `biz_type` varchar(63) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(63) DEFAULT NULL,
  `update_user` varchar(63) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_form`
-- ----------------------------
BEGIN;
INSERT INTO `t_form` VALUES ('1', '用户订单', 'PAGER_USER_ORDER', null, '2020-05-23 14:06:51', '2020-05-23 14:16:16', 'admin', 'admin', b'0'), ('2', '数据字典', 'PAGER_CONFIG_DICTIONARY', null, '2020-05-30 14:48:47', '2020-05-30 14:48:49', 'admin', 'admin', b'0'), ('3', '系统用户', 'PAGER_SYSTEM_USER_TEMPLATE', null, '2020-05-30 14:48:27', '2020-05-30 14:48:27', 'admin', 'admin', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_generator_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_generator_config`;
CREATE TABLE `t_generator_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `front_path` varchar(127) NOT NULL,
  `server_status` bit(1) NOT NULL,
  `package_path` varchar(127) NOT NULL,
  `author` varchar(63) NOT NULL,
  `module` varchar(63) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_generator_config`
-- ----------------------------
BEGIN;
INSERT INTO `t_generator_config` VALUES ('1', '/Users/siguiyang/IdeaProjects/vue-shop-admin/temp', b'0', 'quick.pager.shop', 'siguiyang', 'shop-activity2');
COMMIT;

-- ----------------------------
--  Table structure for `t_sms_template`
-- ----------------------------
DROP TABLE IF EXISTS `t_sms_template`;
CREATE TABLE `t_sms_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_code` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '短信模板编号',
  `template_content` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '短信模板内容',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_sms_template`
-- ----------------------------
BEGIN;
INSERT INTO `t_sms_template` VALUES ('1', '1000', '【xxx电商】您的验证码是%s，在10分钟内有效。如非本人操作请忽略本短信', '2018-12-12 21:13:26', null, null, '2018-10-28 12:38:34', b'0'), ('2', '1001', '【xxx电商】尊敬的%s客户，您的验证码是%s，在10分钟内有效。如非本人操作请忽略本短信', '2018-12-12 21:13:30', null, null, '2018-10-28 12:38:34', b'0'), ('3', '1002', '【xxx电商】尊敬的%s客户，您已修改本产品的密码，密码是%s。如非本人操作请忽略本短信', '2018-12-12 21:13:34', null, null, '2018-10-28 12:38:34', b'0'), ('4', '1003', '【xxx电商】尊敬的%s客户，感谢您注册本产品，您的初始密码是%s。如非本人操作请忽略本短信', '2018-12-12 21:13:37', null, null, '2018-10-28 12:38:34', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_system_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项名称',
  `config_type` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型',
  `config_status` bit(1) DEFAULT NULL COMMENT '0 启用 1 禁用',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项描述',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_system_config`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_config` VALUES ('1086', '订单状态', 'order_status', b'0', '商品订单状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-10-13 19:39:17', b'0'), ('1099', '订单类型', 'order_type', b'0', '商品订单类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1109', '商品类型', 'goods_type', b'0', '商品类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1114', '商品状态', 'goods_status', b'0', '商品状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1116', '优惠券', 'coupon_type', b'0', '优惠券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1117', '折扣券', 'discount_coupon_type', b'0', '折扣券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1124', 'Pager 模块', 'shop_module', b'0', 'Pager 模块', 'admin', 'admin', '2020-04-11 20:42:21', '2020-04-11 20:42:24', b'0'), ('1126', '优惠类型', 'offer_type', b'0', '优惠类型', 'admin', 'admin', '2020-04-11 21:33:20', '2020-04-11 21:33:24', b'0'), ('1127', 'Banner 类型', 'banner_type', b'0', 'Banner配置项类型', 'admin', 'admin', '2020-04-12 20:25:03', '2020-04-12 20:25:46', b'0'), ('1128', 'Banner 分享渠道', 'share_channel', b'0', 'Banner 分享渠道', 'admin', 'admin', '2020-04-12 20:31:05', '2020-04-12 20:31:05', b'0'), ('1129', '配送时间', 'deliveryTime', b'0', '配送时间', 'admin', 'admin', '2020-11-29 15:36:54', '2020-11-29 15:36:54', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_system_config_copy`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config_copy`;
CREATE TABLE `t_system_config_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项名称',
  `config_type` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型',
  `config_status` bit(1) DEFAULT NULL COMMENT '0 启用 1 禁用',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项描述',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Table structure for `t_system_config_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config_detail`;
CREATE TABLE `t_system_config_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项名称',
  `config_type` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型',
  `config_value` varchar(127) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项值',
  `config_key` varchar(31) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '配置项类型值',
  `config_status` bit(1) DEFAULT NULL COMMENT '0 启用 1 禁用',
  `create_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_user` varchar(63) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_system_config_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_config_detail` VALUES ('1', '待付款', 'BS001', 'BS001', 'order_status', b'0', 'admin', 'admin', '2020-04-11 19:32:47', '2020-04-11 19:33:35', b'0'), ('2', '待发货', 'BS002', 'BS002', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:06:11', '2020-04-11 20:06:37', b'0'), ('3', '已发货', 'BS003', 'BS003', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:25:20', null, b'0'), ('4', '待收获', 'BS004', 'BS004', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:25:41', null, b'0'), ('5', '已签收', 'BS005', 'BS005', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:26:09', null, b'0'), ('6', '待评价', 'BS006', 'BS006', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:26:33', null, b'0'), ('7', '待自提', 'BS007', 'BS007', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:26:59', null, b'0'), ('8', '已完成', 'BS008', 'BS008', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:27:23', null, b'0'), ('9', '已取消', 'BS009', 'BS009', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:27:42', null, b'0'), ('10', '退款中', 'BS010', 'BS010', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:28:08', null, b'0'), ('11', '已退款', 'BS011', 'BS011', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:28:42', null, b'0'), ('12', '退货中', 'BS012', 'BS012', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:29:05', null, b'0'), ('13', '已关闭', 'BS013', 'BS013', 'order_status', b'0', 'admin', 'admin', '2020-04-11 20:29:25', null, b'0'), ('14', '专区订单', 'SPECIAL_ORDER', '1', 'order_type', b'0', 'admin', 'admin', '2020-04-11 20:31:14', null, b'0'), ('15', '普通订单', 'NORMAL_ORDER', '2', 'order_type', b'0', 'admin', 'admin', '2020-04-11 20:32:12', null, b'0'), ('16', '自提订单', 'SELF_ORDER', '3', 'order_type', b'0', 'admin', 'admin', '2020-04-11 20:32:43', null, b'0'), ('17', '秒杀订单', 'SEC_KILL_ORDER', '4', 'order_type', b'0', 'admin', 'admin', '2020-04-11 20:33:05', null, b'0'), ('18', '积分订单', 'INTEGRAL_ORDER', '5', 'order_type', b'0', 'admin', 'admin', '2020-04-11 20:33:28', null, b'0'), ('19', '普通商品', 'NORMAL_GOODS', '1', 'goods_type', b'0', 'admin', 'admin', '2020-04-11 20:36:00', null, b'0'), ('20', '特价商品', 'SPECIAL_GOODS', '2', 'goods_type', b'0', 'admin', 'admin', '2020-04-11 20:36:18', null, b'0'), ('21', '拼团商品', 'ASSEMBLE_GOODS', '3', 'goods_type', b'0', 'admin', 'admin', '2020-04-11 20:37:38', null, b'0'), ('22', '秒杀商品', 'SEC_KILL_GOODS', '4', 'goods_type', b'0', 'admin', 'admin', '2020-04-11 20:37:59', null, b'0'), ('23', '满赠换购商品', 'EXCHANGE_GOODS', '5', 'goods_type', b'0', 'admin', 'admin', '2020-04-11 20:38:18', null, b'0'), ('24', '营销模块', 'module_activity', 'module_activity', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:43:24', null, b'0'), ('25', '商品模块', 'module_goods', 'module_goods', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:43:49', null, b'0'), ('26', '订单模块', 'module_order', 'module_order', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:44:07', null, b'0'), ('27', '商户模块', 'module_seller', 'module_seller', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:44:24', null, b'0'), ('28', '用户模块', 'module_user', 'module_user', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:44:41', null, b'0'), ('29', '上架', 'UPPER_SHELF_GOODS', '1', 'goods_status', b'0', 'admin', 'admin', '2020-04-11 20:45:50', null, b'0'), ('30', '下架', 'LOWER_SHELF_GOODS', '2', 'goods_status', b'0', 'admin', 'admin', '2020-04-11 20:46:05', null, b'0'), ('31', '待审核', 'PENDING_REVIEW_GOODS', '3', 'goods_status', b'0', 'admin', 'admin', '2020-04-11 20:47:48', null, b'0'), ('32', '系统管理', 'module_admin', 'module_admin', 'shop_module', b'0', 'admin', 'admin', '2020-04-11 20:49:38', null, b'0'), ('33', '优惠券', 'COUPON', '1', 'offer_type', b'0', 'admin', 'admin', '2020-04-12 19:21:14', null, b'0'), ('34', '折扣券', 'DISCOUNT_COUPON', '2', 'offer_type', b'0', 'admin', 'admin', '2020-04-12 19:21:51', null, b'0'), ('35', '首页', 'bannerType', 'home', 'banner_type', b'0', 'admin', 'admin', '2020-04-12 20:29:15', null, b'0'), ('36', '积分商场', 'bannerType', 'integralShop', 'banner_type', b'0', 'admin', 'admin', '2020-04-12 20:29:51', null, b'0'), ('37', '分类', 'bannerType', 'classification', 'banner_type', b'0', 'admin', 'admin', '2020-04-12 20:30:10', null, b'0'), ('38', 'QQ渠道', 'shareChannel', 'qq', 'share_channel', b'0', 'admin', 'admin', '2020-04-12 20:31:45', null, b'0'), ('39', '微信渠道', 'shareChannel', 'wechat', 'share_channel', b'0', 'admin', 'admin', '2020-04-12 20:32:13', null, b'0'), ('40', '微信朋友圈渠道', 'shareChannel', 'wechatFriends', 'share_channel', b'0', 'admin', 'admin', '2020-04-12 20:32:39', null, b'0'), ('41', '配置时间', 'deliveryTime', '07:00 - 07:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:38:30', null, b'0'), ('42', '配置时间', 'deliveryTime', '07:30 - 08:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:38:49', null, b'0'), ('43', '配置时间', 'deliveryTime', '08:00 - 08:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:39:03', null, b'0'), ('44', '配置时间', 'deliveryTime', '08:30 - 09:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:39:16', null, b'0'), ('45', '配置时间', 'deliveryTime', '09:00 - 09:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:39:28', null, b'0'), ('46', '配置时间', 'deliveryTime', '09:30 - 10:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:40:01', null, b'0'), ('47', '配置时间', 'deliveryTime', '10:00 - 10:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:40:15', null, b'0'), ('48', '配置时间', 'deliveryTime', '10:30 - 11:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:40:27', null, b'0'), ('49', '配送时间', 'deliveryTime', '11:00 - 11:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:40:44', null, b'0'), ('50', '配送时间', 'deliveryTime', '11:30 - 12:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:05', null, b'0'), ('51', '配置时间', 'deliveryTime', '12:00 - 12:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('52', '配置时间', 'deliveryTime', '12:30 - 13:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:31', null, b'0'), ('53', '配置时间', 'deliveryTime', '13:00 - 13:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('54', '配置时间', 'deliveryTime', '13:30 - 14:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('55', '配置时间', 'deliveryTime', '14:00 - 14:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('56', '配置时间', 'deliveryTime', '14:30 - 15:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('57', '配置时间', 'deliveryTime', '15:00 - 15:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('58', '配置时间', 'deliveryTime', '15:30 - 16:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('59', '配置时间', 'deliveryTime', '16:00 - 16:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('60', '配置时间', 'deliveryTime', '16:30 - 17:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('61', '配置时间', 'deliveryTime', '17:00 - 17:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('62', '配置时间', 'deliveryTime', '17:30 - 18:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('63', '配置时间', 'deliveryTime', '18:00 - 18:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('64', '配置时间', 'deliveryTime', '18:30 - 19:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('65', '配置时间', 'deliveryTime', '19:00 - 19:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('66', '配置时间', 'deliveryTime', '19:30 - 20:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('67', '配置时间', 'deliveryTime', '20:00 - 20:30', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0'), ('68', '配置时间', 'deliveryTime', '20:30 - 21:00', 'deliveryTime', b'0', 'admin', 'admin', '2020-11-29 15:41:19', null, b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_white_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_white_list`;
CREATE TABLE `t_white_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `white_url` varchar(255) DEFAULT NULL COMMENT '白名单访问地址',
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_white_list`
-- ----------------------------
BEGIN;
INSERT INTO `t_white_list` VALUES ('1', '/user/login', '用户登陆', '2019-02-18 15:45:26', '2019-02-18 15:45:18', b'0'), ('2', '/user/logout', '用户退出', '2019-02-18 15:45:56', '2019-02-18 15:45:58', b'0'), ('3', '/seller/login', '商户登陆', '2019-02-18 15:48:57', '2019-02-18 15:48:59', b'0'), ('4', '/seller/logout', '商户退出', '2019-02-18 15:49:22', '2019-02-18 15:49:26', b'0'), ('5', '/admin/login', '系统登陆', '2019-02-18 15:49:55', '2019-02-18 15:49:49', b'0'), ('6', '/admin/system/adminInfo', '系统用户信息', '2019-02-18 15:50:23', '2019-02-18 15:50:26', b'0'), ('7', '/admin/logout', '系统用户退出', '2019-02-18 15:50:47', '2019-02-18 15:50:45', b'0'), ('8', '/activity/banner/list', '活动banner列表', '2019-02-18 15:51:11', '2019-02-18 15:51:09', b'0'), ('9', '/goods/home', 'APP首页商品列表', '2019-02-18 15:51:53', '2019-02-18 15:51:55', b'0'), ('10', '/goods/classification/list', '商品分类列表', '2019-02-18 15:52:16', '2019-02-18 15:52:19', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `txc_lock`
-- ----------------------------
DROP TABLE IF EXISTS `txc_lock`;
CREATE TABLE `txc_lock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `key_value` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `group_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `unit_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `x_lock` int(11) DEFAULT NULL,
  `s_lock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_name` (`table_name`,`key_value`,`x_lock`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Table structure for `txc_undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `txc_undo_log`;
CREATE TABLE `txc_undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `group_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `unit_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `rollback_info` longblob,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
