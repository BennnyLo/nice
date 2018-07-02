/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : wkm

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2017-12-20 09:37:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` int(8) NOT NULL AUTO_INCREMENT COMMENT '栏目ID',
  `name` varchar(20) COLLATE utf8_icelandic_ci NOT NULL COMMENT '栏目名称',
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_icelandic_ci;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '校园资讯');
INSERT INTO `item` VALUES ('2', '社会新闻');
INSERT INTO `item` VALUES ('3', '表彰新闻');
INSERT INTO `item` VALUES ('4', '寻人启事');
INSERT INTO `item` VALUES ('5', '新闻');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsId` int(8) NOT NULL AUTO_INCREMENT COMMENT '新闻ID',
  `itemId` int(11) DEFAULT NULL COMMENT '栏目id',
  `title` varchar(50) COLLATE utf8_icelandic_ci NOT NULL COMMENT '标题',
  `detail` longtext COLLATE utf8_icelandic_ci NOT NULL COMMENT '新闻详情',
  `imgUrl` varchar(128) COLLATE utf8_icelandic_ci DEFAULT NULL COMMENT '图片地址',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`newsId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `itemId` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_icelandic_ci;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('44', '1', 'qrqttwggdssg', '对不对号库房看孩子扩大领导', null, '2017-12-08 00:00:00', '2017-12-11 08:38:12');
INSERT INTO `news` VALUES ('46', '1', 'dsfdsgdsg', 'null', null, '2017-12-08 16:49:48', null);
INSERT INTO `news` VALUES ('47', '1', 'wwwwwww', 'null', null, '2017-12-08 16:50:09', null);
INSERT INTO `news` VALUES ('48', '1', '我觉得', '艾弗森三分', null, '2017-12-08 00:00:00', '2017-12-08 16:50:47');
INSERT INTO `news` VALUES ('49', '1', '张家陈...', '都是疯狂举动是解剖', null, '2017-12-08 16:53:02', null);
INSERT INTO `news` VALUES ('50', '1', '未解决', '无法交付', null, '2017-12-08 16:53:13', null);
INSERT INTO `news` VALUES ('52', '4', '误区二', '去恶恶人', null, '2017-12-09 00:00:00', '2017-12-09 11:15:45');
INSERT INTO `news` VALUES ('54', '1', '富家大室肌肤', '打飞机水电费什么的佛计算机', null, '2017-12-11 08:31:33', null);
INSERT INTO `news` VALUES ('55', '1', '测试', '测试', null, '2017-12-11 12:13:11', null);
INSERT INTO `news` VALUES ('56', '1', '测试', '测试', null, '2017-12-11 12:14:32', null);
INSERT INTO `news` VALUES ('57', '1', '1111', '3443', null, '2017-12-11 12:15:06', null);
INSERT INTO `news` VALUES ('58', '4', '打击我i', '二位', 'D:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\wtpwebapps\\SSH\\upload', '2017-12-20 09:36:09', null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户名',
  `name` varchar(20) COLLATE utf8_icelandic_ci NOT NULL COMMENT '用户密码',
  `pwd` varchar(50) COLLATE utf8_icelandic_ci NOT NULL COMMENT '密码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_icelandic_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'a', '1', null, null);
INSERT INTO `users` VALUES ('2', 'b', '2', null, null);
INSERT INTO `users` VALUES ('4', '1', '2331', null, null);
