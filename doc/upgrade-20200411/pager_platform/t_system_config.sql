alter table t_system_config drop `module`;
alter table t_system_config drop `config_value`;

BEGIN;
DELETE FROM t_system_config;
INSERT INTO `t_system_config` VALUES ('1086', '订单状态', 'order_status', b'0', '商品订单状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-10-13 19:39:17', b'0'), ('1099', '订单类型', 'order_type', b'0', '商品订单类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1109', '商品类型', 'goods_type', b'0', '商品类型', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1114', '商品状态', 'goods_status', b'0', '商品状态', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1116', '优惠券', 'coupon_type', b'0', '优惠券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1117', '折扣券', 'discount_coupon_type', b'0', '折扣券', 'admin', 'admin', '2019-05-15 15:52:35', '2019-05-15 15:52:35', b'0'), ('1124', 'Pager 模块', 'shop_module', b'0', 'Pager 模块', 'admin', 'admin', '2020-04-11 20:42:21', '2020-04-11 20:42:24', b'0'), ('1126', '优惠类型', 'offer_type', b'0', '优惠类型', 'admin', 'admin', '2020-04-11 21:33:20', '2020-04-11 21:33:24', b'0');
COMMIT;
