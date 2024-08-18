/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3307
 Source Schema         : shopping

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/08/2024 10:05:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_arealink
-- ----------------------------
DROP TABLE IF EXISTS `tb_arealink`;
CREATE TABLE `tb_arealink`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列(省市县表)',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省市县名',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省市县表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_arealink
-- ----------------------------
INSERT INTO `tb_arealink` VALUES (1, '河南省', NULL);

-- ----------------------------
-- Table structure for tb_classes
-- ----------------------------
DROP TABLE IF EXISTS `tb_classes`;
CREATE TABLE `tb_classes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（类别表）',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '大类别、小类别名',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_classes
-- ----------------------------
INSERT INTO `tb_classes` VALUES (1, '电器', 1);

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（商品表）',
  `goodsname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` double(8, 2) NOT NULL COMMENT '原价',
  `picture` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `credate` timestamp(0) NOT NULL COMMENT '创建时间',
  `introduce` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细信息介绍',
  `classname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (1, '毛衣', 268.00, '18.jpg', '2007-10-30 16:02:33', '新品羽绒服,保温杀菌', '衣物');
INSERT INTO `tb_goods` VALUES (2, '短袖', 180.00, '21.jpg', '2024-07-25 20:15:59', '短袖', '衣物');
INSERT INTO `tb_goods` VALUES (5, '龙虾', 103.00, 'xia.jpg', '2024-06-28 11:10:43', '冷', '水产品');
INSERT INTO `tb_goods` VALUES (6, '坤肉', 2.50, 'kunrou.jpg', '2024-07-26 11:17:37', '冷藏', '畜禽');
INSERT INTO `tb_goods` VALUES (7, '牛奶', 20.00, 'niunai.jpg', '2024-07-12 11:39:20', '牛奶', '奶制品');
INSERT INTO `tb_goods` VALUES (27, '毛尖', 500.00, 'maojian.png', '2024-07-29 20:17:15', '毛尖', '茶叶');
INSERT INTO `tb_goods` VALUES (32, '金龙鱼油', 100.00, 'dadouyou.jpg', '2024-07-30 11:09:19', '金龙鱼油', '植物油');
INSERT INTO `tb_goods` VALUES (33, '白菜', 3.50, 'baicai.jpg', '2024-07-30 11:10:05', '白菜', '蔬菜');
INSERT INTO `tb_goods` VALUES (34, '小米', 4.00, 'xiaomi.jpg', '2024-07-30 11:11:16', '小米', '谷物');
INSERT INTO `tb_goods` VALUES (35, '大米', 3.00, 'dami.jpg', '2024-07-30 13:06:08', '大米', '谷物');
INSERT INTO `tb_goods` VALUES (36, '黑米', 5.00, 'heimi.jpg', '2024-07-30 13:06:29', '黑米', '谷物');
INSERT INTO `tb_goods` VALUES (37, '胡萝卜', 5.50, 'huluobo.jpg', '2024-07-30 13:06:55', '胡萝卜', '蔬菜');
INSERT INTO `tb_goods` VALUES (38, '青菜', 2.00, 'qingcai.jpg', '2024-07-30 13:07:21', '青菜', '蔬菜');
INSERT INTO `tb_goods` VALUES (39, '西蓝花', 7.00, 'xilanhua.jpg', '2024-07-30 13:08:03', '西蓝花', '蔬菜');
INSERT INTO `tb_goods` VALUES (40, '苹果', 5.00, 'pingguo.jpg', '2024-07-30 13:08:25', '苹果', '水果');
INSERT INTO `tb_goods` VALUES (41, '梨', 4.00, 'li.jpg', '2024-07-30 13:08:41', '梨', '水果');
INSERT INTO `tb_goods` VALUES (42, '火龙果', 10.00, 'huolongguo.jpg', '2024-07-30 13:09:03', '火龙果', '水果');
INSERT INTO `tb_goods` VALUES (43, '西瓜', 2.00, 'xigua.jpg', '2024-07-30 13:09:19', '西瓜', '水果');
INSERT INTO `tb_goods` VALUES (44, '鸭肉', 25.00, 'yarou.jpg', '2024-07-30 13:09:43', '鸭肉', '畜禽');
INSERT INTO `tb_goods` VALUES (45, '大闸蟹', 99.00, 'pangxie.jpg', '2024-07-30 13:10:01', '大闸蟹', '水产品');
INSERT INTO `tb_goods` VALUES (46, '酸奶', 22.00, 'suannai.jpg', '2024-07-30 13:10:17', '酸奶', '奶制品');
INSERT INTO `tb_goods` VALUES (47, '大红袍', 999.00, 'dahongpao.jpg', '2024-07-30 13:10:49', '大红袍', '茶叶');
INSERT INTO `tb_goods` VALUES (48, '铁观音', 999.00, 'teiguanyin.jpg', '2024-07-30 13:11:08', '铁观音', '茶叶');
INSERT INTO `tb_goods` VALUES (50, '鲁花', 6.00, 'luhua.jpg', '2024-07-30 15:20:32', '油', '植物油');
INSERT INTO `tb_goods` VALUES (51, '小米', 33.00, 'xiaomi.jpg', '2024-07-30 16:08:25', '小米', '谷物');

-- ----------------------------
-- Table structure for tb_goodscar
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodscar`;
CREATE TABLE `tb_goodscar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsid` int(11) NOT NULL COMMENT '商品id',
  `memberid` int(11) NOT NULL COMMENT '会员id',
  `price` double(8, 2) NULL DEFAULT NULL COMMENT '价格',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 157 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车表' ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of tb_goodscar
-- ----------------------------
INSERT INTO `tb_goodscar` VALUES (2, 2, 1, 100.00, 9);
INSERT INTO `tb_goodscar` VALUES (155, 2, 3, 180.00, 1);
INSERT INTO `tb_goodscar` VALUES (154, 37, 3, 5.50, 1);
INSERT INTO `tb_goodscar` VALUES (156, 1, 3, 268.00, 2);
INSERT INTO `tb_goodscar` VALUES (152, 34, 3, 4.00, 1);
INSERT INTO `tb_goodscar` VALUES (151, 7, 3, 20.00, 1);
INSERT INTO `tb_goodscar` VALUES (150, 5, 3, 103.00, 1);
INSERT INTO `tb_goodscar` VALUES (141, 2, 9, 180.00, 1);
INSERT INTO `tb_goodscar` VALUES (131, 3, 1, 5.00, 1);
INSERT INTO `tb_goodscar` VALUES (149, 6, 3, 2.50, 1);

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（管理表）',
  `manager` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员名',
  `pwd` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES (1, 'admin', 'admin');
INSERT INTO `tb_manager` VALUES (2, 'zs', '123');
INSERT INTO `tb_manager` VALUES (3, 'ls', '111');
INSERT INTO `tb_manager` VALUES (4, 'zz', '222');
INSERT INTO `tb_manager` VALUES (5, 'qq', '333');
INSERT INTO `tb_manager` VALUES (6, 'tt', '666');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（会员表）',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `truename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '城市',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `postcode` int(6) NOT NULL COMMENT '邮政编码',
  `cardno` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `cardtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `freeze` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '冻结(0冻结/1解冻)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES (2, '111', 'zs', '111', '河南省', '郑州市上街区', 450000, '421532645785421369', '身份证', '13545698712', '24563215478@qq.com', '1');
INSERT INTO `tb_member` VALUES (3, '222', 'qq', '222', '河南省', '郑州市高新技术开发区', 97786, '6578697068756', '身份证', '12345678435', '235467896', '0');
INSERT INTO `tb_member` VALUES (8, 'XXX', 'GGBone', '999999', '广西壮族自治区', '北海市市辖区', 450000, '421532645785421369', NULL, '13545698712', '24563215478@qq.com', '0');
INSERT INTO `tb_member` VALUES (9, '333', 'DDD', '333', '河北省', '石家庄市鹿泉区', 100001, '121231231313122344', NULL, '15164641615', 'boluomym@163.com', '0');
INSERT INTO `tb_member` VALUES (12, 'ddd', 'ddd', '111111', '山西省', '太原市尖草坪区', 100001, '121231231313122344', NULL, '15516996379', '813420846@qq.com', '0');
INSERT INTO `tb_member` VALUES (13, 'ccc', 'ccc', '111111', '湖南省', '怀化市辰溪县', 100001, '121231231313122344', NULL, '12354545444', '813420846@qq.com', '0');
INSERT INTO `tb_member` VALUES (14, 'zzz', 'zzz', 'zzzzzz', '广东省', '广州市海珠区', 100001, '121232313132312234', NULL, '34321838492', 'bdfafd@163.com', '0');
INSERT INTO `tb_member` VALUES (15, 'zzz', 'zzz', 'zzzzzz', '广东省', '广州市海珠区', 100001, '121232313132312234', NULL, '34321838492', 'bdfafd@163.com', '0');

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（公告表）',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `creatdate` timestamp(0) NOT NULL COMMENT '发布日期',
  `enddate` timestamp(0) NOT NULL COMMENT '截止日期',
  `addfile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传附件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES (1, '优惠公告', '元旦优惠…..', '2011-12-29 18:00:00', '2012-01-09 00:00:00', '201112291801.doc');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（订单表）',
  `memberid` int(11) NOT NULL COMMENT '会员id',
  `ordercode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `bnumber` int(11) NOT NULL COMMENT '品种数',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收件人姓名',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮件地址',
  `postcode` int(6) NOT NULL COMMENT '邮政编码',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话',
  `pay` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支付方式',
  `carry` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运送方式',
  `orderdate` timestamp(0) NOT NULL COMMENT '订单日期',
  `enforce` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '执行',
  `bz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `allprice` double NULL DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (1, 1, '200711280001', 3, '张峰', '北京朝阳区', 100001, '010-85468445', '积分兑换/电子支付', 'ems专递方式', '2007-11-28 16:02:33', '1', '请尽快邮寄', 999);
INSERT INTO `tb_order` VALUES (30, 1, '1722319584952', 2, 'cc', '辽宁省 沈阳市 苏家屯区 郑州', 523423, '341324321433', '支付宝', 'EMS', '2024-07-30 14:06:25', '0', '方法', 556);
INSERT INTO `tb_order` VALUES (31, 1, '1722319597847', 2, 'cc', '辽宁省 沈阳市 苏家屯区 郑州', 523423, '341324321433', '支付宝', 'EMS', '2024-07-30 14:06:38', '0', '方法', 556);
INSERT INTO `tb_order` VALUES (32, 2, '1722319972480', 2, 'tidy', '山西省 太原市 万柏林区 美国', 122112, '341324321433', '支付宝', 'EMS', '2024-07-30 14:12:52', '0', '订单', 9);
INSERT INTO `tb_order` VALUES (33, 9, '1722320058812', 3, 'ccc', '内蒙古自治区 呼和浩特市 托克托县 美国', 122112, '341324321433', '支付宝', 'EMS', '2024-07-30 14:14:19', '0', '稍等', 133);
INSERT INTO `tb_order` VALUES (34, 9, '1722324526817', 2, '333', '天津市 市辖区 河西区 郑州', 523423, '15516996379', '支付宝', 'EMS', '2024-07-30 15:28:47', '0', 'dd ', 22.5);
INSERT INTO `tb_order` VALUES (35, 9, '1722324854430', 1, 'tidy111', '山西省 太原市 尖草坪区 郑州', 100001, '15164641615', '支付宝', 'EMS', '2024-07-30 15:34:14', '0', '333', 1072);
INSERT INTO `tb_order` VALUES (36, 9, '1722324945008', 1, 'ccc333', '天津市 市辖区 红桥区 郑州', 523423, '15164641615', '支付宝', 'EMS', '2024-07-30 15:35:45', '0', '222', 20);
INSERT INTO `tb_order` VALUES (37, 9, '1722325115475', 1, 'tidy333', '河北省 石家庄市 藁城区 郑州', 122112, '15164641615', '支付宝', 'EMS', '2024-07-30 15:38:35', '0', '33', 5);
INSERT INTO `tb_order` VALUES (38, 3, '1722327110732', 2, 'ccc', '湖北省 武汉市 江汉区 郑州', 100001, '15164641615', '支付宝', 'EMS', '2024-07-30 16:11:51', '0', 'ss', 316.5);

-- ----------------------------
-- Table structure for tb_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列（订单明细表）',
  `orderid` int(11) NOT NULL COMMENT '订单id',
  `goodsid` int(11) NOT NULL COMMENT '商品id',
  `price` double(15, 2) NOT NULL COMMENT '价格',
  `numbers` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单明细表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_order_detail
-- ----------------------------
INSERT INTO `tb_order_detail` VALUES (1, 1, 1, 228.00, 1);
INSERT INTO `tb_order_detail` VALUES (21, 30, 7, 20.00, 1);
INSERT INTO `tb_order_detail` VALUES (22, 30, 1, 268.00, 2);
INSERT INTO `tb_order_detail` VALUES (23, 32, 40, 5.00, 1);
INSERT INTO `tb_order_detail` VALUES (24, 32, 41, 4.00, 1);
INSERT INTO `tb_order_detail` VALUES (25, 33, 42, 10.00, 3);
INSERT INTO `tb_order_detail` VALUES (26, 33, 32, 100.00, 1);
INSERT INTO `tb_order_detail` VALUES (27, 33, 35, 3.00, 1);
INSERT INTO `tb_order_detail` VALUES (28, 34, 6, 2.50, 1);
INSERT INTO `tb_order_detail` VALUES (29, 34, 3, 5.00, 4);
INSERT INTO `tb_order_detail` VALUES (30, 35, 1, 268.00, 4);
INSERT INTO `tb_order_detail` VALUES (31, 36, 3, 5.00, 4);
INSERT INTO `tb_order_detail` VALUES (32, 37, 3, 5.00, 1);
INSERT INTO `tb_order_detail` VALUES (33, 38, 6, 2.50, 3);
INSERT INTO `tb_order_detail` VALUES (34, 38, 5, 103.00, 3);

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键列(证件名、支付方式、运送方式表)',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '证件名、支付方式、运送方式',
  `flag` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'a/b/c',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '证件名、支付方式、运送方式表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES (1, '快递', 'c');

SET FOREIGN_KEY_CHECKS = 1;
