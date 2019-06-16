/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : bgcms

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2019-06-16 20:34:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bg_trip_details`
-- ----------------------------
DROP TABLE IF EXISTS `bg_trip_details`;
CREATE TABLE `bg_trip_details` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `cur_user` varchar(255) DEFAULT NULL COMMENT '当前持有者',
  `laster` varchar(255) DEFAULT NULL COMMENT '上一个持有者',
  `get_time` datetime DEFAULT NULL COMMENT '拿到手时间',
  `bg_id` varchar(255) DEFAULT NULL COMMENT '桌游id',
  `borrower_id` varchar(255) DEFAULT NULL COMMENT '申请表id',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_trip_details
-- ----------------------------

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
INSERT INTO `bill` VALUES ('9a65ab6ab4214ddf96c28e5b4a961f9b', '支出', '111', '11', '11', '-26.67', 'admin', '2019-05-22 16:00:00', '2019-05-22 20:11:47');
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
  `views` int(11) DEFAULT '0' COMMENT '浏览次数',
  `lends` int(11) DEFAULT '0' COMMENT '出借次数',
  `stars` int(11) DEFAULT '0' COMMENT '关注数',
  `rating` int(11) DEFAULT '0' COMMENT '评分',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of boardgame
-- ----------------------------
INSERT INTO `boardgame` VALUES ('1', '风声', '轻策', '《风声》是千骐动漫的国产谍战游戏巨作，通过这个谍战桌面游戏，让您有机会体验险象环生的间谍生涯！', '5', '2019-05-05 00:00:00', '79.9', 'admin', '2019-05-05 22:41:13', 'admin', '正常', '8', '0', '1', '0');
INSERT INTO `boardgame` VALUES ('2', '亚特兰蒂斯', '欢乐', '逃离亚特兰蒂斯是一款消除游戏。', '5', '2019-04-05 00:00:00', '109', 'admin', '2019-04-02 22:01:34', 'admin', '正常', '24', '0', '2', '0');
INSERT INTO `boardgame` VALUES ('2ac1f8fa013745128fd56e2495a82b9d', '扑克', '策略', '暗示', '4', null, '44', 'admin', '2019-06-07 07:41:14', 'admin', '仅保存', '0', '0', '0', '0');
INSERT INTO `boardgame` VALUES ('b86b7f488be74343a3a4319d63ea9abf', '扑克', '策略', '暗示', '4', null, '99', 'admin', '2019-06-07 07:42:15', 'admin', '仅保存', '0', '0', '0', '0');
INSERT INTO `boardgame` VALUES ('bc2d250bb1e54eb7bdd9cb90ecee3731', '名字', '策略', '111', '3', null, '33', 'admin', '2019-05-28 06:53:10', 'admin', '仅保存', '0', '0', '0', '0');

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
-- Table structure for `borrow_form`
-- ----------------------------
DROP TABLE IF EXISTS `borrow_form`;
CREATE TABLE `borrow_form` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `bg_id` varchar(255) DEFAULT NULL COMMENT '桌游id',
  `cur_user` varchar(255) DEFAULT NULL COMMENT '当前持有人',
  `applicant` varchar(255) DEFAULT NULL COMMENT '申请人',
  `remark` text,
  `cur_step` int(11) DEFAULT '0' COMMENT '当前步骤:-1，已经被否决；0，持有者批准；1，申请者拿到；2，结束',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_form
-- ----------------------------
INSERT INTO `borrow_form` VALUES ('99b5e6f26a2d4929b3627187e490bc91', '1', 'admin', 'admin', '23333333333333333333333', '2', '2019-05-27 16:12:36');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `uuid` varchar(32) NOT NULL,
  `content` text COMMENT '内容',
  `img_id` varchar(255) DEFAULT NULL COMMENT '图片id',
  `to_user_id` varchar(255) DEFAULT NULL COMMENT '评论者id',
  `from_user_id` varchar(32) DEFAULT NULL COMMENT '接收者id',
  `obj_id` varchar(32) DEFAULT NULL COMMENT '评论对象',
  `last_id` varchar(32) DEFAULT NULL,
  `grade` int(32) DEFAULT NULL COMMENT '等级',
  `create_time` datetime DEFAULT NULL COMMENT '创建使劲按',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2e70822f72f34cbbb46f9b17ceab4a4a', '支持', null, '0', 'admin', '2', '5ba5465ee79a49b1997359aec723f0d0', '2', '2019-05-28 04:37:14');
INSERT INTO `comment` VALUES ('39c64a473b6e450ba2e1eea3c1f29e89', '我是六关系', null, '0', 'admin', '2', '61a2e46b9576420cb1a93e4b15532380', '2', '2019-05-21 22:35:45');
INSERT INTO `comment` VALUES ('4387b22bcd9f49089fceb1f24d085c9f', '不要水帖子', null, '0', 'admin', '2', 'd51059a199544d2cbaa2c709ae4557c5', '2', '2019-05-21 22:45:44');
INSERT INTO `comment` VALUES ('5ba5465ee79a49b1997359aec723f0d0', '赶紧滚吧', null, '0', 'admin', '2', '77f3b1ef48314aa792143267d4cc9dd3', '1', '2019-05-28 04:37:01');
INSERT INTO `comment` VALUES ('61a2e46b9576420cb1a93e4b15532380', '刘晨曦报道', null, '0', 'admin', '2', 'a78752d27661449b8ff2bb12ca8403d1', '1', '2019-05-21 22:06:44');
INSERT INTO `comment` VALUES ('632501564e4b4eaf850bb1a346db10db', '7', null, '0', 'admin', '2', '61a2e46b9576420cb1a93e4b15532380', '2', '2019-05-21 22:38:36');
INSERT INTO `comment` VALUES ('77f3b1ef48314aa792143267d4cc9dd3', '先勇回来了', null, '0', 'admin', '2', '2', '0', '2019-05-28 04:36:46');
INSERT INTO `comment` VALUES ('7fb38eb881884a2da8a5fd3c79a78bb2', '请吃饭吧', null, '0', 'admin', '2', '77f3b1ef48314aa792143267d4cc9dd3', '1', '2019-05-28 04:37:25');
INSERT INTO `comment` VALUES ('87d3c29e387c4fc2ac6c27b2dbefebed', '111', null, '0', 'admin', '2', 'd51059a199544d2cbaa2c709ae4557c5', '2', '2019-05-21 22:46:22');
INSERT INTO `comment` VALUES ('87f1d2c47f2c4ddfb4767e0a437734ba', '张口加来', null, '0', 'admin', '2', '39c64a473b6e450ba2e1eea3c1f29e89', '2', '2019-05-21 22:38:08');
INSERT INTO `comment` VALUES ('9526eceeaaa54dc9835c4109c20f0ac1', 'qing', null, '0', 'admin', '2', 'd51059a199544d2cbaa2c709ae4557c5', '2', '2019-05-21 22:46:10');
INSERT INTO `comment` VALUES ('97eac7f5baa646cf81cc600c331af9a6', '后天可以么', null, '0', 'admin', '2', 'a274924296434700884f5ada8991d30c', '1', '2019-05-24 01:10:44');
INSERT INTO `comment` VALUES ('a274924296434700884f5ada8991d30c', '有人一起玩么', null, '0', 'admin', '2', '2', '0', '2019-05-24 01:10:33');
INSERT INTO `comment` VALUES ('a78752d27661449b8ff2bb12ca8403d1', '火钳留名\n', null, '0', 'admin', '2', '2', '0', '2019-05-21 20:33:24');
INSERT INTO `comment` VALUES ('abd402f094c64075a6e6eb88d5cf765e', '1111', null, '0', 'admin', '2', 'a78752d27661449b8ff2bb12ca8403d1', '1', '2019-05-21 22:46:53');
INSERT INTO `comment` VALUES ('d51059a199544d2cbaa2c709ae4557c5', '留名+1', null, '0', 'admin', '2', 'a78752d27661449b8ff2bb12ca8403d1', '1', '2019-05-21 20:37:12');
INSERT INTO `comment` VALUES ('ed9fc429ad4b4fd6838dd3d027701e50', 'D', null, '0', 'admin', '2', '97eac7f5baa646cf81cc600c331af9a6', '2', '2019-05-24 01:10:51');
INSERT INTO `comment` VALUES ('f3cbda216ecf43d3abab27d6da056800', '这个游戏真好玩', null, '0', 'admin', '2', '2', '0', '2019-05-21 22:45:55');

-- ----------------------------
-- Table structure for `like`
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `obj_id` varchar(0) DEFAULT NULL,
  `user_id` varchar(0) DEFAULT NULL,
  `flag` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of like
-- ----------------------------

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
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('38849d39686941a3b78bf94f1820a454', '开会', '0', '开会', 'admin', '2019-05-18 15:55:43', null);
INSERT INTO `notice` VALUES ('5396a097593b4d67956d0c8eb9556e08', '111111111111111111', '0', '11111111111111111111', 'admin', '2019-05-17 18:57:09', null);
INSERT INTO `notice` VALUES ('71adf133c3ae43dfb454244e3065af84', '开会', '0', '开会', 'admin', '2019-05-18 15:55:25', null);
INSERT INTO `notice` VALUES ('a5e359b35e5c40df8ebae747cca80109', '明天烧烤', '2', '烤肉、烤茄子、烤鱼', 'admin', '2019-05-18 15:29:01', null);

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `out_trade_no` varchar(255) NOT NULL DEFAULT '' COMMENT '商户订单号',
  `total_amount` double(255,0) DEFAULT '0' COMMENT '总金额',
  `subject` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `body` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `obj_id` varchar(255) DEFAULT NULL COMMENT '物体id',
  `user_id` varchar(255) DEFAULT NULL,
  `alipay_id` varchar(255) DEFAULT NULL COMMENT '阿里订单号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态:1.success,2.fail,3.unusual,4.wait',
  PRIMARY KEY (`out_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('07091fd2f41c446fac27e433ba6d499c', '111', 'admin1233', '桌游众筹发起费用', 'f5729be5918c48d08c21df890798010d', 'admin', null, '2019-05-24 10:52:00', 'wait');
INSERT INTO `orders` VALUES ('0aa8b9fb3f3f42e0bfb39904eda8ba59', '22', '需先用', '桌游众筹发起费用', '85330894d71b4c09be86aa60f15c6860', 'admin', null, '2019-05-28 04:41:23', 'wait');
INSERT INTO `orders` VALUES ('1223', '0', '213', '123', '213', '213', '213', null, '123');
INSERT INTO `orders` VALUES ('123', '0', '213', '123', '213', '213', '213', null, '123');
INSERT INTO `orders` VALUES ('1542579b23ff4de595f31ac5bd09ee48', '22', '需先用', '桌游众筹发起费用', '03ece50be0e04869846d0b28c3507f1d', 'admin', null, '2019-05-28 04:41:23', 'wait');
INSERT INTO `orders` VALUES ('1b4ebec71a5e4dbe8a1cf7a2d215ca01', '22', '需先用', '桌游众筹发起费用', 'f2b2b41e75e7433f898a6e971e5ac1af', 'admin', null, '2019-05-28 04:41:23', 'wait');
INSERT INTO `orders` VALUES ('22a6a690c9894d2581715f1655d48d94', '11', '三国杀', '桌游众筹发起费用', '4b50a05545df4219954ed1a75ae7403f', 'admin', null, '2019-05-25 20:08:57', 'wait');
INSERT INTO `orders` VALUES ('3b5931436c3349eea48164019ee6784f', '11', '狼人杀', '桌游众筹发起费用', '4b5ff74c423143a7aa24ee279fec1368', 'admin', null, '2019-05-24 21:51:41', 'wait');
INSERT INTO `orders` VALUES ('3c73696797ab42c6ace7511ddd1264c8', '49', '扑克', '桌游众筹发起费用', 'b86b7f488be74343a3a4319d63ea9abf', 'admin', null, '2019-06-07 07:42:15', 'wait');
INSERT INTO `orders` VALUES ('432a95c4312e41e390304d646fbda6ef', '1116', 'admin123322', '桌游众筹发起费用', '323296637f9c4872bb8c99007c40d0be', 'admin', null, '2019-05-24 10:53:25', 'wait');
INSERT INTO `orders` VALUES ('4394b522238b4ce2bf4d18fc0a85c7c5', '22', '需先用', '桌游众筹发起费用', '3109f7ec98e04939a0bf3c8e900cd7d9', 'admin', null, '2019-05-28 04:41:23', 'wait');
INSERT INTO `orders` VALUES ('6209c96a896b4b629858ac2938507379', '11', 'admin33', '桌游众筹发起费用', 'e3aebdbd01a849d4b534e4dba70c7f34', 'admin', null, '2019-05-24 10:55:24', 'wait');
INSERT INTO `orders` VALUES ('6c688b5eb288469194eca8d26910cb28', '11', '111', '桌游众筹发起费用', '03026cb9e1c1412d8b5a075b557c0a2c', 'admin', null, '2019-05-28 04:43:52', 'wait');
INSERT INTO `orders` VALUES ('75f2a0c58b0b444fa89ed300ca92a3cf', '16', '名字', '桌游众筹发起费用', 'bc2d250bb1e54eb7bdd9cb90ecee3731', 'admin', null, '2019-05-28 06:53:10', 'wait');
INSERT INTO `orders` VALUES ('7afaa89f70b2468daff27bccdc03f2e8', '11', 'admin', '桌游众筹发起费用', '8b6b36472b13442aad66348757d1477b', 'admin', null, '2019-05-24 10:48:37', 'wait');
INSERT INTO `orders` VALUES ('84c9fc0746644c0a875cc09d1d9b72e5', '22', '需先用', '桌游众筹发起费用', '88458ca5ab5244d5a5e0e3a3a5b71312', 'admin', null, '2019-05-28 04:41:23', 'wait');
INSERT INTO `orders` VALUES ('8e41a039308f4b8f893299804f5fec68', '22', '扑克', '桌游众筹发起费用', '2ac1f8fa013745128fd56e2495a82b9d', 'admin', null, '2019-06-07 07:41:14', 'wait');
INSERT INTO `orders` VALUES ('a9ddc10379cd4172b82a0a4c8e727506', '11', 'admin123', '桌游众筹发起费用', '1e1ae90cc2b24c1182bb810db1882406', 'admin', null, '2019-05-24 10:49:39', 'wait');
INSERT INTO `orders` VALUES ('e3bd631cf38b49a2bf87518433e24e3f', '22', '需先用', '桌游众筹发起费用', '3963cb4516b14728be3d64afa46589a1', 'admin', null, '2019-05-28 04:41:23', 'wait');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'shiro:show', '/permission/rolerList');
INSERT INTO `permission` VALUES ('2', 'permission:add', '');
INSERT INTO `permission` VALUES ('3', 'role:add', '');
INSERT INTO `permission` VALUES ('4', 'bill:add', '');
INSERT INTO `permission` VALUES ('5', 'notice:add', '');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('3', '4', '2');
INSERT INTO `role_permission` VALUES ('7', '2', '1');
INSERT INTO `role_permission` VALUES ('8', '2', '3');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_f_bg
-- ----------------------------
INSERT INTO `user_f_bg` VALUES ('23', 'admin', '1');
INSERT INTO `user_f_bg` VALUES ('30', 'admin', '2');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('4', 'admin', '1');
