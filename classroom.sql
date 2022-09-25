/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : classroom

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 24/09/2022 21:30:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `account` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `is_freeze` tinyint(1) NOT NULL COMMENT '是否冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'zhangsan', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '991', 'zhangsan@qq.com', '男', 0);

-- ----------------------------
-- Table structure for administrator_menu
-- ----------------------------
DROP TABLE IF EXISTS `administrator_menu`;
CREATE TABLE `administrator_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `administrator_id` int(11) NOT NULL COMMENT '管理员id',
  `menu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator_menu
-- ----------------------------

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室名称',
  `class_no` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室编号',
  `site_count` int(2) NOT NULL COMMENT '教室拥有的座位数量',
  `is_use` tinyint(1) NOT NULL COMMENT '教室是否启用：0-未启用，1-启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (1, '教室99', '1001', 50, 0);
INSERT INTO `classroom` VALUES (2, '教室2', '1002', 20, 1);
INSERT INTO `classroom` VALUES (3, '教室3', '1003', 30, 1);
INSERT INTO `classroom` VALUES (4, '教室4', '1004', 50, 1);
INSERT INTO `classroom` VALUES (5, '教室5', '1005', 50, 1);
INSERT INTO `classroom` VALUES (19, '教师15', '1234', 50, 1);
INSERT INTO `classroom` VALUES (20, '教师16', '1523', 50, 1);

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级名称',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for login_info
-- ----------------------------
DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录者姓名',
  `login_time` datetime(0) NOT NULL COMMENT '登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_info
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编码',
  `parent_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级菜单编码',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `sort` tinyint(2) NOT NULL COMMENT '菜单排序',
  `is_use` tinyint(1) NOT NULL COMMENT '是否启用：0-未启用，1-启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '教室管理', 'c001', NULL, '/back/classroom/list', 1, 1);
INSERT INTO `menu` VALUES (2, '学生管理', 'c002', NULL, '/back/student/list', 2, 1);
INSERT INTO `menu` VALUES (3, '年级管理', 'c003', 'c002', '/back/grade/list', 3, 1);
INSERT INTO `menu` VALUES (4, '专业管理', 'c004', 'c002', '/back/profession/list', 4, 1);
INSERT INTO `menu` VALUES (5, '权限管理', 'c005', NULL, NULL, 5, 1);
INSERT INTO `menu` VALUES (6, '菜单管理', 'c006', 'c005', '/back/menu/list', 6, 1);

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业描述',
  `pro_no` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profession
-- ----------------------------

-- ----------------------------
-- Table structure for send_email_log
-- ----------------------------
DROP TABLE IF EXISTS `send_email_log`;
CREATE TABLE `send_email_log`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `sender_id` int(11) NOT NULL COMMENT '发件人id',
  `receder_id` int(11) NOT NULL COMMENT '收件人id',
  `send_time` datetime(0) NOT NULL COMMENT '发送时间',
  `status` tinyint(1) NOT NULL COMMENT '发送状态：0-失败，1-成功',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of send_email_log
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_no` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `birthday` date NOT NULL COMMENT '出生日期',
  `grade_id` int(11) NOT NULL COMMENT '年级id',
  `profession_id` int(11) NOT NULL COMMENT '专业id',
  `class_id` int(11) NOT NULL COMMENT '班级id',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `PROFESSION_OUT_KEY`(`profession_id`) USING BTREE,
  INDEX `GRADE_OUT_KEY`(`grade_id`) USING BTREE,
  INDEX `CLAZZ_OUT_KEY`(`class_id`) USING BTREE,
  CONSTRAINT `CLAZZ_OUT_KEY` FOREIGN KEY (`class_id`) REFERENCES `clazz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GRADE_OUT_KEY` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `PROFESSION_OUT_KEY` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
