/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 127.0.0.1:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/06/2020 19:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mynovel
-- ----------------------------
DROP TABLE IF EXISTS `mynovel`;
CREATE TABLE `mynovel`  (
  `id` int(11) NOT NULL,
  `novel` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` int(4) NOT NULL,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sage` int(11) NULL DEFAULT NULL,
  `saddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for addNum
-- ----------------------------
DROP PROCEDURE IF EXISTS `addNum`;
delimiter ;;
CREATE PROCEDURE `addNum`(a int , b int , out sum int)
begin 
set sum = a + b; 
end
;;
delimiter ;

-- ----------------------------
-- Function structure for addNumFunction
-- ----------------------------
DROP FUNCTION IF EXISTS `addNumFunction`;
delimiter ;;
CREATE FUNCTION `addNumFunction`(num1 int,  num2 int)
 RETURNS int(11)
begin
	
	return (num1 + num2);
 
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
