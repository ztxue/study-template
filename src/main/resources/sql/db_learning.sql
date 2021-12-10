/*
 Navicat Premium Data Transfer

 Source Server         : root_ztx
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_learning

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 10/12/2021 15:48:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  `levels` smallint(0) NOT NULL DEFAULT 0 COMMENT '等级',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `sort` int(0) NULL DEFAULT 0 COMMENT '排序',
  `descr` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '逻辑删除,0存在,1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (1, '董事部', 0, '张童学', '13257979427', 0, '董事会', NULL, NULL, 0);
INSERT INTO `tb_dept` VALUES (2, '财务部', 1, '范蠡', '88888888888', 0, '财务管理', NULL, NULL, 0);
INSERT INTO `tb_dept` VALUES (3, '研发部', 1, '比尔盖茨', '66666666666', 0, '臭敲代码的', NULL, NULL, 0);
INSERT INTO `tb_dept` VALUES (4, '销售部', 1, '张仪', '11111111111', 0, '卖东西的', NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_staff`;
CREATE TABLE `tb_staff`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `dept_id` int(0) NULL DEFAULT NULL COMMENT '部门ID',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `age` int(0) NULL DEFAULT 0 COMMENT '年龄',
  `sex` smallint(0) NULL DEFAULT 1 COMMENT '性别1表男,2表女',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `levels` smallint(0) UNSIGNED NULL DEFAULT 1 COMMENT '级别,1234....',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '逻辑删除,0存在,1删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
INSERT INTO `tb_staff` VALUES (1, 'ztx', '123456', 0, '董事会', 22, 1, '13257979427@163.com', '13257979427', 1, '公寓', NULL, NULL, 0);
INSERT INTO `tb_staff` VALUES (2, 'xzr', '123456', 0, '董事会', 20, 1, '13257979427@163.com', '19215638988', 1, '他家', NULL, NULL, 0);
INSERT INTO `tb_staff` VALUES (3, 'fanli', '888888', 1, '财务部', 2000, 1, '8888888@fanli.com', '88888888888', 1, '春秋战国', NULL, NULL, 0);
INSERT INTO `tb_staff` VALUES (4, 'zhangyi', '111111', 1, '销售部', 2000, 1, '1111111@zhangyi.com', '11111111111', 1, '秦', NULL, NULL, 0);
INSERT INTO `tb_staff` VALUES (5, 'BillGates', '666666', 1, '研发部', 66, 1, '6666666@gates.com', '66666666666', 1, '美', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
