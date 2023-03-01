/*
 Navicat Premium Data Transfer

 Source Server         : testconn
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : service-passenger-user

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 01/03/2023 10:18:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for passenger_user
-- ----------------------------
DROP TABLE IF EXISTS `passenger_user`;
CREATE TABLE `passenger_user`  (
  `id` bigint unsigned NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `passenger_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `passenger_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `passenger_gender` tinyint(1) NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `profile_photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1625406708757610503 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of passenger_user
-- ----------------------------
INSERT INTO `passenger_user` VALUES (1625406708757610500, '2023-02-24 10:26:55', '2023-02-24 10:26:55', '13138293725', '张三', 0, 0, NULL);
INSERT INTO `passenger_user` VALUES (1625406708757610501, '2023-02-24 11:13:39', '2023-02-24 11:13:39', '13138293724', '张三', 0, 0, NULL);
INSERT INTO `passenger_user` VALUES (1625406708757610502, '2023-02-24 12:40:19', '2023-02-24 12:40:19', '13138393725', '张三', 0, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
