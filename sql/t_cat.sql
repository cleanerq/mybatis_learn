/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-07-17 16:12:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_cat`
-- ----------------------------
DROP TABLE IF EXISTS `t_cat`;
CREATE TABLE `t_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cName` varchar(100) DEFAULT NULL,
  `cAge` int DEFAULT NULL,
  `cgender` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cat
-- ----------------------------
INSERT INTO `t_cat` VALUES ('1', '加菲猫', '12', '0');
INSERT INTO `t_cat` VALUES ('2', '汤姆猫', '13', '1');
INSERT INTO `t_cat` VALUES ('3', '波斯猫', '10', '0');

-- ----------------------------
-- Table structure for `t_key`
-- ----------------------------
DROP TABLE IF EXISTS `t_key`;
CREATE TABLE `t_key` (
  `id` int NOT NULL AUTO_INCREMENT,
  `keyname` varchar(100) DEFAULT NULL,
  `lockid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_key_lock` (`lockid`),
  CONSTRAINT `fk_key_lock` FOREIGN KEY (`lockid`) REFERENCES `t_lock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_key
-- ----------------------------
INSERT INTO `t_key` VALUES ('1', '1号钥匙', '1');
INSERT INTO `t_key` VALUES ('2', '2号钥匙', '2');

-- ----------------------------
-- Table structure for `t_lock`
-- ----------------------------
DROP TABLE IF EXISTS `t_lock`;
CREATE TABLE `t_lock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lockName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lock
-- ----------------------------
INSERT INTO `t_lock` VALUES ('1', '1号锁');
INSERT INTO `t_lock` VALUES ('2', '2号锁');
