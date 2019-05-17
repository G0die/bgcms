/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : bgcms

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2019-05-17 23:30:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `uuid` varchar(32) NOT NULL,
  `type` varchar(11) DEFAULT NULL COMMENT '类型:支出;收入;',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  `amount` double DEFAULT NULL COMMENT '消费金额',
  `surplus` double DEFAULT NULL COMMENT '余额',
  `creator` varchar(255) NOT NULL COMMENT '创建人',
  `doTime` datetime NOT NULL COMMENT '支出/收入时间',
  `creattime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('3adecf76d5f94ea2b12a1bd688d7b264', '收入', '冰淇淋22222222222222', '2222', '20', '-13.670000000000002', 'admin', '2019-05-24 16:00:00', '2019-05-15 17:04:10');
INSERT INTO `bill` VALUES ('4f3331ab078e474eb522028ee8118ace', '支出', '冰淇淋', '2222', '20', '-33.67', 'admin', '2019-05-15 16:00:00', '2019-05-15 17:02:46');
INSERT INTO `bill` VALUES ('admin', 'zhichu', '购买桌游', '备注111', '20.09', '6.33', 'admin', '2019-05-10 06:41:07', '2019-05-10 03:28:37');
INSERT INTO `bill` VALUES ('c20f650444ad4b95b11af939d1023759', '支出', 'Hig2', '2', '2', '-15.670000000000002', 'admin', '2019-06-07 16:00:00', '2019-05-15 17:12:21');
INSERT INTO `bill` VALUES ('e3119907b2444045802bab380acb157a', '支出', 'Highcharts Demo', '1111', '20', '-13.67', 'admin', '2019-05-15 16:00:00', '2019-05-15 17:01:02');

-- ----------------------------
-- Table structure for `boardgame`
-- ----------------------------
DROP TABLE IF EXISTS `boardgame`;
CREATE TABLE `boardgame` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '名字',
  `type` varchar(255) NOT NULL COMMENT '类型；',
  `information` varchar(255) NOT NULL COMMENT '信息说明',
  `maxPlayers` int(255) DEFAULT NULL COMMENT '玩家数',
  `buytime` datetime DEFAULT NULL COMMENT '购买时间',
  `money` double DEFAULT NULL COMMENT '购买金额',
  `applicant` varchar(32) DEFAULT NULL COMMENT '添加人',
  `applicantiontime` datetime DEFAULT NULL COMMENT '申请时间',
  `currentUser` varchar(255) NOT NULL COMMENT '当前持有人',
  `status` varchar(100) DEFAULT NULL COMMENT '状态：0.仅保存,1.众筹中，2.正常，3.损坏，4.丢失',
  `views` int(11) DEFAULT NULL COMMENT '浏览次数',
  `lends` int(11) DEFAULT NULL COMMENT '出借次数',
  `stars` int(11) DEFAULT NULL COMMENT '关注数',
  `rating` int(11) DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of boardgame
-- ----------------------------
INSERT INTO `boardgame` VALUES ('1', '风声', '轻策', '《风声》是千骐动漫的国产谍战游戏巨作，通过这个谍战桌面游戏，让您有机会体验险象环生的间谍生涯！', '5', '2019-05-05 00:00:00', '79.9', '2324324', '2019-05-05 22:41:13', '2324324', '正常', '2', '0', '1', null);
INSERT INTO `boardgame` VALUES ('2', '亚特兰蒂斯', '欢乐', '逃离亚特兰蒂斯是一款消除游戏。', '5', '2019-04-05 00:00:00', '109', '2324324', '2019-04-02 22:01:34', '2324324', '正常', '2', '0', '2', null);

-- ----------------------------
-- Table structure for `boardgametag`
-- ----------------------------
DROP TABLE IF EXISTS `boardgametag`;
CREATE TABLE `boardgametag` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '名字',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of boardgametag
-- ----------------------------
INSERT INTO `boardgametag` VALUES ('21234234', '欢乐');
INSERT INTO `boardgametag` VALUES ('23424342342344234243423432', '毛线');
INSERT INTO `boardgametag` VALUES ('35465646', '重策');
INSERT INTO `boardgametag` VALUES ('43657568786', '轻策');
INSERT INTO `boardgametag` VALUES ('64986513561', '嘴炮');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) DEFAULT NULL,
  `bg_uuid` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `attachmant` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '社长');
INSERT INTO `role` VALUES ('3', '资深社员');
INSERT INTO `role` VALUES ('4', '社员');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL DEFAULT '0',
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '2019-05-13', '2019-05-13 23:55:34');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(32) NOT NULL,
  `account` varchar(32) NOT NULL COMMENT '学号',
  `pwd` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `roler` varchar(32) DEFAULT NULL,
  `experience` double DEFAULT NULL COMMENT '经验值',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `college` varchar(255) DEFAULT NULL COMMENT '学院',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `year` varchar(255) DEFAULT NULL COMMENT '入学年份',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `motto` varchar(100) DEFAULT NULL COMMENT '格言',
  `messageNumeber` int(11) DEFAULT NULL COMMENT '待处理消息',
  `deny` int(4) DEFAULT NULL COMMENT '是否允许登陆',
  `showPerson` int(11) DEFAULT NULL COMMENT '是否公示个人隐私资料',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('324234234234', '201508030221', '000000', '云梦', '女', '社长', '0', '110', '110@全球。com', '服装学院', '服装设计', '2019', '2019-05-05', '湖南', '长沙', 'go die', '0', '0', '0');
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', '王亚鹏', '男', '管理员', '0', '17638579802', 'bjdmail@163.com', '计算机学院', '网络工程', '2015', '2019-05-08', '河南', '郑州', '一切皆有可能', '0', '0', '1');

-- ----------------------------
-- Table structure for `user_f_bg`
-- ----------------------------
DROP TABLE IF EXISTS `user_f_bg`;
CREATE TABLE `user_f_bg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `bg_uuid` varchar(255) DEFAULT '' COMMENT '桌游id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_f_bg
-- ----------------------------
INSERT INTO `user_f_bg` VALUES ('23', 'admin', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '324234234234', '2');
INSERT INTO `user_role` VALUES ('2', 'admin', '1');
