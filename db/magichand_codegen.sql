/*
 Navicat Premium Data Transfer

 Source Server         : magichand
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.220.12
 Source Database       : magichand_codegen

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : utf-8

 Date: 04/02/2021 17:35:59 PM
*/

DROP DATABASE IF EXISTS `magichand_codegen`;

CREATE DATABASE  `magichand_codegen` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE magichand_codegen;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `gen_datasource_conf`
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource_conf`;
CREATE TABLE `gen_datasource_conf` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新',
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据源表';

-- ----------------------------
--  Records of `gen_datasource_conf`
-- ----------------------------
BEGIN;
INSERT INTO `gen_datasource_conf` VALUES ('9', 'magichand_code', 'jdbc:mysql://192.168.220.12:3316/magichand?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai', 'root', 'ThPEgPNzqWCSzESW76ezYQ==', '2021-03-19 09:01:29', '2021-03-19 09:01:29', '0'), ('10', 'magichand_mall', 'jdbc:mysql://192.168.220.12:3316/mall?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai', 'root', 'uYeSjYMupFiXPApMI9lY4Q==', '2021-03-23 07:53:13', '2021-03-23 07:53:13', '0');
COMMIT;

-- ----------------------------
--  Table structure for `gen_form_conf`
-- ----------------------------
DROP TABLE IF EXISTS `gen_form_conf`;
CREATE TABLE `gen_form_conf` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `table_name` varchar(64) DEFAULT NULL,
  `form_info` json NOT NULL COMMENT '表单信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `table_name` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='表单配置';

SET FOREIGN_KEY_CHECKS = 1;
