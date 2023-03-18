/*
 Navicat Premium Data Transfer

 Source Server         : testconn
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : service-driver-user

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 01/03/2023 10:17:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` bigint unsigned NOT NULL,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆所在城市',
  `vehicle_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆号牌',
  `plate_color` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌颜色（1：蓝色，2：黄色，3：黑色，4：白色，5：绿色，9：其他）',
  `seats` int(0) NULL DEFAULT NULL COMMENT '核定载客位',
  `brand` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆厂牌',
  `model` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆型号',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆类型',
  `owner_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆所有人',
  `vehicle_color` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆颜色（1：白色，2：黑色）',
  `engine_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发动机号',
  `vin` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `certify_date_a` date NULL DEFAULT NULL COMMENT '车辆注册日期',
  `fue_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '燃料类型(1：汽油，2：柴油，3：天然气，4：液化气，5：电动，9：其他）',
  `engine_displace` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发动机排量（毫升）',
  `trans_agency` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆运输证发证机构',
  `trans_area` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆经验区域',
  `trans_date_start` date NULL DEFAULT NULL COMMENT '车辆运输证有效期起',
  `trans_date_end` date NULL DEFAULT NULL COMMENT '车辆运输证有效期止',
  `certify_date_b` date NULL DEFAULT NULL COMMENT '车辆初次登记日期',
  `fix_state` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆的检修状态(0：未检修，1：已检修，2：未知）',
  `next_fix_date` date NULL DEFAULT NULL COMMENT '下次年检时间',
  `check_state` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '年度审验状态（0：未年审，1：年审合格，2：年审不合格）',
  `fee_print_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发票打印设备序列号',
  `gps_brand` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卫星定位装置品牌',
  `gps_model` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卫星型号',
  `gps_install_date` date NULL DEFAULT NULL COMMENT '卫星定位设备安装日期',
  `register_date` date NULL DEFAULT NULL COMMENT '报备日期',
  `commercial_type` int(0) NULL DEFAULT NULL COMMENT '服务类型：1：网络预约出租车，2：巡游出租车，3：私人小客车合乘',
  `fare_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '运价编码 关联计价规则',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态：0:有效，1：失效',
  `tid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终端Id',
  `trid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '轨迹ID',
  `trname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '轨迹名称',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1584359540577861642 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1584359540577861638, '110000', '京p83130', '1', 5, '大众', '迈腾', '1', '张三', '1', '30fdajk', NULL, '2022-02-02', '1', '2.0', '车管所1', '111234', '2022-09-09', '2022-09-20', '2022-08-07', '1', '2026-06-05', '1', '25fdjaskl', 'gps brand', 'gps model', '1987-09-18', '2004-05-31', 1, '110000$1', 1, '639988822', '160', '', '2023-02-24 10:18:09', '2023-02-24 10:18:09');
INSERT INTO `car` VALUES (1584359540577861639, '110000', '京p83131', '1', 5, '大众', '迈腾', '1', '张三', '1', '30fdajk', NULL, '2022-02-02', '1', '2.0', '车管所1', '111234', '2022-09-09', '2022-09-20', '2022-08-07', '1', '2026-06-05', '1', '25fdjaskl', 'gps brand', 'gps model', '1987-09-18', '2004-05-31', 1, '110000$1', 1, '640013580', '180', '', '2023-02-24 11:27:46', '2023-02-24 11:27:46');
INSERT INTO `car` VALUES (1584359540577861640, '110000', '京p83132', '1', 5, '大众', '迈腾', '1', '张三', '1', '30fdajk', NULL, '2022-02-02', '1', '2.0', '车管所1', '111234', '2022-09-09', '2022-09-20', '2022-08-07', '1', '2026-06-05', '1', '25fdjaskl', 'gps brand', 'gps model', '1987-09-18', '2004-05-31', 1, '110000$1', 1, '640017163', '200', '', '2023-02-24 11:34:57', '2023-02-24 11:34:57');
INSERT INTO `car` VALUES (1584359540577861641, '110000', '京p83133', '1', 5, '大众', '迈腾', '1', '张三', '1', '30fdajk', NULL, '2022-02-02', '1', '2.0', '车管所1', '111234', '2022-09-09', '2022-09-20', '2022-08-07', '1', '2026-06-05', '1', '25fdjaskl', 'gps brand', 'gps model', '1987-09-18', '2004-05-31', 1, '110000$1', 1, '640040757', '220', '', '2023-02-24 12:35:36', '2023-02-24 12:35:36');

-- ----------------------------
-- Table structure for driver_car_binding_relationship
-- ----------------------------
DROP TABLE IF EXISTS `driver_car_binding_relationship`;
CREATE TABLE `driver_car_binding_relationship`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `driver_id` bigint(0) NULL DEFAULT NULL,
  `car_id` bigint(0) NULL DEFAULT NULL,
  `bind_state` int(0) NULL DEFAULT NULL,
  `binding_time` datetime(0) NULL DEFAULT NULL,
  `un_binding_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver_car_binding_relationship
-- ----------------------------
INSERT INTO `driver_car_binding_relationship` VALUES (4, 1584359006294835207, 1584359540577861638, 1, '2023-02-24 10:18:33', NULL);
INSERT INTO `driver_car_binding_relationship` VALUES (5, 1584359006294835208, 1584359540577861639, 1, '2023-02-24 11:28:04', NULL);
INSERT INTO `driver_car_binding_relationship` VALUES (6, 1584359006294835209, 1584359540577861640, 1, '2023-02-24 11:35:24', NULL);
INSERT INTO `driver_car_binding_relationship` VALUES (7, 1584359006294835200, 1584359540577861641, 1, '2023-02-24 12:35:56', NULL);

-- ----------------------------
-- Table structure for driver_user
-- ----------------------------
DROP TABLE IF EXISTS `driver_user`;
CREATE TABLE `driver_user`  (
  `id` bigint unsigned NOT NULL,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '司机注册地行政区划代码',
  `driver_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `driver_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `driver_gender` tinyint(0) NULL DEFAULT NULL COMMENT '1:男，2：女',
  `driver_birthday` date NULL DEFAULT NULL,
  `driver_nation` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '驾驶员民族',
  `driver_contact_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机动车驾驶证号',
  `get_driver_license_date` date NULL DEFAULT NULL COMMENT '初次领取驾驶证日期',
  `driver_license_on` date NULL DEFAULT NULL COMMENT '驾驶证有效期起',
  `driver_license_off` date NULL DEFAULT NULL COMMENT '驾驶证有效期止',
  `taxi_driver` tinyint(0) NULL DEFAULT NULL COMMENT '是否巡游出租汽车：1：是，0：否',
  `certificate_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网络预约出租汽车驾驶员资格证号',
  `network_car_issue_organization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网络预约出租汽车驾驶员发证机构',
  `network_car_issue_date` date NULL DEFAULT NULL COMMENT '资格证发证日期',
  `get_network_car_proof_date` date NULL DEFAULT NULL COMMENT '初次领取资格证日期',
  `network_car_proof_on` date NULL DEFAULT NULL COMMENT '资格证有效起始日期',
  `network_car_proof_off` date NULL DEFAULT NULL COMMENT '资格证有效截止日期',
  `register_date` date NULL DEFAULT NULL COMMENT '报备日期',
  `commercial_type` tinyint(0) NULL DEFAULT NULL COMMENT '服务类型：1：网络预约出租汽车，2：巡游出租汽车，3：私人小客车合乘',
  `contract_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '驾驶员合同（协议）签署公司',
  `contract_on` date NULL DEFAULT NULL COMMENT '合同（协议）有效期起',
  `contract_off` date NULL DEFAULT NULL COMMENT '合同有效期止',
  `state` tinyint(0) NULL DEFAULT NULL COMMENT '司机状态：0：有效，1：失效',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1584359006294835211 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver_user
-- ----------------------------
INSERT INTO `driver_user` VALUES (1584359006294835200, '地址', '张大拿', '13138293714', 1, '2020-01-03', '01', '通信地址', '机动车驾驶证号', '2019-01-05', '2019-01-01', '2019-12-01', 1, '网络预约出租车资格证号', '发证机构', '2020-01-01', '2001-03-04', '2021-03-04', '2021-03-04', '2023-01-03', 1, '公司', '2020-02-12', '2020-03-13', 1, '2023-02-24 12:37:01', '2023-02-24 12:37:01');
INSERT INTO `driver_user` VALUES (1584359006294835207, '地址', '张大拿', '13138293724', 1, '2020-01-03', '01', '通信地址', '机动车驾驶证号', '2019-01-05', '2019-01-01', '2019-12-01', 1, '网络预约出租车资格证号', '发证机构', '2020-01-01', '2001-03-04', '2021-03-04', '2021-03-04', '2023-01-03', 1, '公司', '2020-02-12', '2020-03-13', 1, '2023-02-24 10:17:54', '2023-02-24 10:17:54');
INSERT INTO `driver_user` VALUES (1584359006294835208, '地址', '张大拿', '13138293723', 1, '2020-01-03', '01', '通信地址', '机动车驾驶证号', '2019-01-05', '2019-01-01', '2019-12-01', 1, '网络预约出租车资格证号', '发证机构', '2020-01-01', '2001-03-04', '2021-03-04', '2021-03-04', '2023-01-03', 1, '公司', '2020-02-12', '2020-03-13', 1, '2023-02-24 11:25:58', '2023-02-24 11:25:58');
INSERT INTO `driver_user` VALUES (1584359006294835209, '地址', '张大拿', '13138293713', 1, '2020-01-03', '01', '通信地址', '机动车驾驶证号', '2019-01-05', '2019-01-01', '2019-12-01', 1, '网络预约出租车资格证号', '发证机构', '2020-01-01', '2001-03-04', '2021-03-04', '2021-03-04', '2023-01-03', 1, '公司', '2020-02-12', '2020-03-13', 1, '2023-02-24 11:34:51', '2023-02-24 11:34:51');

-- ----------------------------
-- Table structure for driver_user_work_status
-- ----------------------------
DROP TABLE IF EXISTS `driver_user_work_status`;
CREATE TABLE `driver_user_work_status`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `driver_id` bigint(0) NULL DEFAULT NULL,
  `work_status` int(0) NULL DEFAULT NULL COMMENT '收车：0；出车：1，暂停：2',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver_user_work_status
-- ----------------------------
INSERT INTO `driver_user_work_status` VALUES (4, 1584359006294835207, 0, '2023-02-24 10:17:54', '2023-02-24 10:17:54');
INSERT INTO `driver_user_work_status` VALUES (5, 1584359006294835208, 0, '2023-02-24 11:25:58', '2023-02-24 11:25:58');
INSERT INTO `driver_user_work_status` VALUES (6, 1584359006294835209, 0, '2023-02-24 11:34:51', '2023-02-24 11:34:51');
INSERT INTO `driver_user_work_status` VALUES (7, 1584359006294835200, 1, '2023-02-24 12:37:10', '2023-02-24 12:37:10');

-- ----------------------------
-- View structure for v_city_driver_user_word_status_
-- ----------------------------
DROP VIEW IF EXISTS `v_city_driver_user_word_status_`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `v_city_driver_user_word_status_` AS select `t1`.`id` AS `driver_id`,`t1`.`address` AS `city_code`,`t2`.`work_status` AS `work_status` from (`driver_user` `t1` left join `driver_user_work_status` `t2` on((`t1`.`id` = `t2`.`driver_id`)));

-- ----------------------------
-- View structure for v_ctity_driver_user_work_status
-- ----------------------------
DROP VIEW IF EXISTS `v_ctity_driver_user_work_status`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `v_ctity_driver_user_work_status` AS select `t1`.`id` AS `driver_id`,`t1`.`address` AS `city_code`,`t2`.`work_status` AS `work_status` from (`driver_user` `t1` left join `driver_user_work_status` `t2` on((`t1`.`id` = `t2`.`driver_id`)));

SET FOREIGN_KEY_CHECKS = 1;
