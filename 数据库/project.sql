/*
 Navicat Premium Data Transfer

 Source Server         : mysql04
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 06/05/2022 21:56:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zds_books
-- ----------------------------
DROP TABLE IF EXISTS `zds_books`;
CREATE TABLE `zds_books`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书名',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态（0：不可借，1：可借）',
  `stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存',
  `publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `typeid` int(0) NULL DEFAULT NULL COMMENT '书类型',
  `addtime` datetime(0) NULL DEFAULT NULL COMMENT '创键时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_books
-- ----------------------------
INSERT INTO `zds_books` VALUES (1, '军事书1', 1, '33', '清华出版社', '吴某', 1, '2022-03-16 16:41:34');
INSERT INTO `zds_books` VALUES (2, '军事书2', 1, '243', '北京出版社', '赵某', 1, '2022-03-16 16:42:52');
INSERT INTO `zds_books` VALUES (3, '军事书3', 1, '41', '广东水利出版社', '吴某', 1, '2022-03-16 16:43:56');
INSERT INTO `zds_books` VALUES (4, '军事书4', 1, '32', '揭阳出版社', '郑某', 1, '2022-03-16 23:54:03');
INSERT INTO `zds_books` VALUES (5, '文学书1', 0, '332', '揭阳出版社', '宋某', 2, '2022-03-17 00:06:49');
INSERT INTO `zds_books` VALUES (6, '文学书2', 0, '3', '清华出版社', '赵某', 2, '2022-03-17 15:15:54');
INSERT INTO `zds_books` VALUES (7, '科技书3', 0, '32', '广东水利出版社', '何某', 3, '2022-03-17 15:41:37');
INSERT INTO `zds_books` VALUES (8, '科技书4', 0, '12', '南京大学出版社', '陈某', 3, '2022-03-17 15:06:27');
INSERT INTO `zds_books` VALUES (15, '其他书1', 1, '3', '汕头大学出版社', '柯某', 7, '2022-03-18 06:02:14');
INSERT INTO `zds_books` VALUES (19, '新加的书啦啦啦', 0, '33', '新的出版社', '新加的作者', 5, '2022-03-28 15:34:56');

-- ----------------------------
-- Table structure for zds_books_type
-- ----------------------------
DROP TABLE IF EXISTS `zds_books_type`;
CREATE TABLE `zds_books_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_books_type
-- ----------------------------
INSERT INTO `zds_books_type` VALUES (1, '军事', '2022-03-16 21:47:36');
INSERT INTO `zds_books_type` VALUES (2, '文学', '2022-03-16 21:47:51');
INSERT INTO `zds_books_type` VALUES (3, '科技', '2022-03-16 21:47:59');
INSERT INTO `zds_books_type` VALUES (4, '科幻', '2022-03-16 21:48:19');
INSERT INTO `zds_books_type` VALUES (5, '历史', '2022-03-16 21:48:29');
INSERT INTO `zds_books_type` VALUES (6, '小说', '2022-03-16 21:52:20');
INSERT INTO `zds_books_type` VALUES (7, '其他', '2022-03-17 00:08:37');

-- ----------------------------
-- Table structure for zds_email_vcode
-- ----------------------------
DROP TABLE IF EXISTS `zds_email_vcode`;
CREATE TABLE `zds_email_vcode`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `vcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `addtime` datetime(0) NULL DEFAULT NULL COMMENT '创键时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_email_vcode
-- ----------------------------
INSERT INTO `zds_email_vcode` VALUES (1, '2412786682@qq.com', '8487', '2022-03-19 08:27:57');
INSERT INTO `zds_email_vcode` VALUES (2, '2714499297@qq.com', '8883', '2022-03-19 14:45:42');
INSERT INTO `zds_email_vcode` VALUES (3, '2274606528@qq.com', '7519', '2022-03-19 14:59:41');

-- ----------------------------
-- Table structure for zds_mainmenu
-- ----------------------------
DROP TABLE IF EXISTS `zds_mainmenu`;
CREATE TABLE `zds_mainmenu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `addtime` datetime(0) NULL DEFAULT NULL COMMENT '创键时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_mainmenu
-- ----------------------------
INSERT INTO `zds_mainmenu` VALUES (100, '图书管理', '/manage', '2022-03-16 07:58:27');
INSERT INTO `zds_mainmenu` VALUES (101, '证件挂失', '/zj', '2022-03-16 08:02:51');
INSERT INTO `zds_mainmenu` VALUES (102, '图书借阅', '/lend', '2022-03-16 08:03:16');

-- ----------------------------
-- Table structure for zds_submenu
-- ----------------------------
DROP TABLE IF EXISTS `zds_submenu`;
CREATE TABLE `zds_submenu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二级标题',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `mid` int(0) NULL DEFAULT NULL COMMENT '关联一级菜单',
  `addtime` datetime(0) NULL DEFAULT NULL COMMENT '创键时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_submenu
-- ----------------------------
INSERT INTO `zds_submenu` VALUES (1, '图书信息', '/information', 100, '2022-03-16 08:01:23');
INSERT INTO `zds_submenu` VALUES (2, '图书借阅', '/literature', 103, '2022-03-16 08:03:51');
INSERT INTO `zds_submenu` VALUES (3, '图书动态', '/history', 103, '2022-03-16 12:23:30');
INSERT INTO `zds_submenu` VALUES (4, '证件追踪', '/zj', 103, '2022-03-17 00:20:13');

-- ----------------------------
-- Table structure for zds_user
-- ----------------------------
DROP TABLE IF EXISTS `zds_user`;
CREATE TABLE `zds_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `addtime` datetime(0) NULL DEFAULT NULL COMMENT '创键时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zds_user
-- ----------------------------
INSERT INTO `zds_user` VALUES (1, '944acd5604a6402b9d1a617f0b81a7d8', '222', '222', '2027703411@qq.com', '', '2022-03-19 16:47:19');
INSERT INTO `zds_user` VALUES (2, '3078b223b1c642cd8b8cb43e24d23650', '吴老师', 'wyh', '2412786682@qq.com', NULL, '2022-03-19 08:44:25');
INSERT INTO `zds_user` VALUES (5, '21329c4e59174df199af00962543914b', '范老师', 'slh', '2274606528@qq.com', NULL, '2022-03-19 15:28:53');

SET FOREIGN_KEY_CHECKS = 1;
