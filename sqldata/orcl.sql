/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : orcl

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-02-19 11:15:38
*/
CREATE DATABASE orcl;
USE orcl;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for k_dept
-- ----------------------------
DROP TABLE IF EXISTS `k_dept`;
CREATE TABLE `k_dept` (
  `ID` int(11) NOT NULL,
  `DEPTNO` varchar(20) NOT NULL,
  `DEPTNAME` varchar(50) DEFAULT NULL,
  `DEPTLEADER` varchar(50) DEFAULT NULL,
  `DEPTTEL` varchar(20) DEFAULT NULL,
  `PARENTDEPTNO` varchar(20) DEFAULT NULL,
  `DEPTDESC` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_dept
-- ----------------------------
INSERT INTO `k_dept` VALUES ('1', 'dept_0001', '软件研发部', '宋国强', '8890111', '总经办', '开发任务', null);
INSERT INTO `k_dept` VALUES ('2', 'dept_0002', '综管部', '张小达', '8890222', '总经办', '总管任务', null);
INSERT INTO `k_dept` VALUES ('3', 'dept_0003', '财务部', '刘辉', '8890333', '总经办', '财务任务', null);
INSERT INTO `k_dept` VALUES ('4', 'dept_0004', '总经办', '韩敬海', '8890444', '总经办', '公司发展任务', null);

-- ----------------------------
-- Table structure for k_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `k_dictionary`;
CREATE TABLE `k_dictionary` (
  `ID` int(11) NOT NULL,
  `dicid` varchar(30) DEFAULT NULL,
  `dictype` varchar(255) DEFAULT NULL,
  `diccode` varchar(30) DEFAULT NULL,
  `dicvalue` varchar(255) DEFAULT NULL,
  `dicsort` varchar(20) DEFAULT NULL,
  `validateflag` varchar(10) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_dictionary
-- ----------------------------
INSERT INTO `k_dictionary` VALUES ('1', 'stockState', '库存申请单', '0', '创建', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('2', 'stockState', '库存申请单', '2', '记账', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('3', 'stockState', '产品分类', 'jiaocai', '教材', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('4', 'productType', '产品分类', 'office', '办公用品', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('5', 'province', '省市', 'SD', '山东', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('6', 'province', '省市', 'JS', '江苏', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('7', 'province', '省市', 'BJ', '北京', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('8', 'province', '省市', 'SH', '上海', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('9', 'province', '省市', 'GZ', '广州', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('16', 'year', '年份', '2010', '2010', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('17', 'year', '年份', '2011', '2011', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('18', 'year', '年份', '2012', '2012', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('19', 'year', '年份', '2013', '2013', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('20', 'year', '年份', '2014', '2014', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('21', 'year', '年份', '2015', '2015', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('22', 'year', '年份', '2016', '2016', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('23', 'year', '年份', '2017', '2017', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('24', 'month', '月份', '1', '1', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('25', 'month', '月份', '2', '2', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('26', 'month', '月份', '3', '3', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('27', 'month', '月份', '4', '4', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('28', 'month', '月份', '5', '5', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('29', 'month', '月份', '6', '6', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('30', 'month', '月份', '7', '7', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('31', 'month', '月份', '8', '8', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('32', 'month', '月份', '9', '9', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('33', 'month', '月份', '10', '10', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('34', 'month', '月份', '11', '11', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('35', 'month', '月份', '12', '12', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('36', 'productType', '产品分类', 'medical', '医疗用品', null, '0', null);
INSERT INTO `k_dictionary` VALUES ('37', 'productType', '产品分类', 'drink', '酒水', null, '0', null);

-- ----------------------------
-- Table structure for k_goods
-- ----------------------------
DROP TABLE IF EXISTS `k_goods`;
CREATE TABLE `k_goods` (
  `ID` int(11) NOT NULL,
  `PRODUCTNO` varchar(50) DEFAULT NULL,
  `PRODUCTNAME` varchar(255) DEFAULT NULL,
  `PRODUCTTYPE` varchar(20) DEFAULT NULL,
  `PRODUCTSTANDARD` varchar(255) DEFAULT NULL,
  `UNIT` varchar(20) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_goods
-- ----------------------------
INSERT INTO `k_goods` VALUES ('1', 'pdno_0001', '计算器', '桌面文具', '00', '个', '20', null);
INSERT INTO `k_goods` VALUES ('2', 'pdno_0002', '回形针', '桌面文具', '00', '个', '5', null);
INSERT INTO `k_goods` VALUES ('3', 'pdno_0003', '中性笔', '桌面文具', '00', '支', '5', null);
INSERT INTO `k_goods` VALUES ('4', 'pdno_0004', '复印纸', '纸制品', '00', '盒', '10', null);
INSERT INTO `k_goods` VALUES ('5', 'pdno_0005', '账本', '纸制品', '00', '本', '2', null);
INSERT INTO `k_goods` VALUES ('6', 'pdno_0006', '拖布', '办公生活用品', '00', '个', '20', null);
INSERT INTO `k_goods` VALUES ('7', 'pdno_0007', '小蜜蜂扩音器', '授课设备', '00', '个', '25', null);
INSERT INTO `k_goods` VALUES ('8', 'pdno_0008', '纸杯', '办公生活用品', '00', '个', '5', null);
INSERT INTO `k_goods` VALUES ('9', 'pdno_0009', '白板', '桌面文具', '00', '块', '50', null);
INSERT INTO `k_goods` VALUES ('10', 'pdno_0010', '软面炒', '纸制品', '00', '本', '1', null);
INSERT INTO `k_goods` VALUES ('11', 'pdno_0011', '双面胶', '桌面文具', '00', '个', '2', null);
INSERT INTO `k_goods` VALUES ('12', 'pdno_0012', '文件夹', '桌面文具', '00', '把', '3', null);
INSERT INTO `k_goods` VALUES ('13', 'pdno_0013', '剪刀', '文件管理用品', '00', '个', '8', null);
INSERT INTO `k_goods` VALUES ('14', 'pdno_0014', '档案盒', '文件管理用品', '00', '个', '10', null);
INSERT INTO `k_goods` VALUES ('15', 'pdno_0015', '电脑', '办公集写', '00', '个', '2000', null);

-- ----------------------------
-- Table structure for k_instock
-- ----------------------------
DROP TABLE IF EXISTS `k_instock`;
CREATE TABLE `k_instock` (
  `ID` int(11) NOT NULL,
  `INSTOCKNO` varchar(30) DEFAULT NULL,
  `STOCKID` int(11) DEFAULT NULL,
  `SUPPLIERID` int(11) DEFAULT NULL,
  `INSTOCKSTATE` varchar(2) DEFAULT NULL,
  `INSTOCKDATE` datetime DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_instock
-- ----------------------------
INSERT INTO `k_instock` VALUES ('1', 'inst_0001', '1', '1', '00', '2015-12-15 00:00:00', '加急处理');
INSERT INTO `k_instock` VALUES ('2', 'inst_0002', '2', '1', '00', '2015-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('3', 'inst_0003', '3', '1', '00', '2015-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('4', 'inst_0004', '1', '1', '00', '2015-12-25 00:00:00', null);
INSERT INTO `k_instock` VALUES ('5', 'inst_0005', '2', '1', '00', '2015-12-25 00:00:00', null);
INSERT INTO `k_instock` VALUES ('6', 'inst_0006', '3', '1', '00', '2015-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('7', 'inst_0007', '1', '2', '00', '2016-01-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('8', 'inst_0008', '2', '2', '00', '2016-01-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('9', 'inst_0009', '3', '2', '00', '2016-12-15 00:00:00', '加急处理');
INSERT INTO `k_instock` VALUES ('10', 'inst_0010', '1', '2', '00', '2016-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('11', 'inst_0011', '2', '2', '00', '2016-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('12', 'inst_0012', '3', '2', '00', '2016-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('13', 'inst_0013', '1', '3', '00', '2016-12-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('14', 'inst_0014', '2', '3', '00', '2016-02-15 00:00:00', null);
INSERT INTO `k_instock` VALUES ('15', 'inst_0015', '3', '3', '00', '2016-02-15 00:00:00', '加急处理');
INSERT INTO `k_instock` VALUES ('16', 'inst_0016', '1', '3', '00', '2016-02-15 00:00:00', null);

-- ----------------------------
-- Table structure for k_instock_detail
-- ----------------------------
DROP TABLE IF EXISTS `k_instock_detail`;
CREATE TABLE `k_instock_detail` (
  `ID` int(11) DEFAULT NULL,
  `INSTOCKID` int(11) DEFAULT NULL,
  `PRODUCTNO` varchar(30) DEFAULT NULL,
  `PRODUCTNAME` varchar(255) DEFAULT NULL,
  `PRODUCTSTANDARD` varchar(255) DEFAULT NULL,
  `PRODUCTNUM` int(11) DEFAULT NULL,
  `UNIT` varchar(20) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `TOTALPRICE` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_instock_detail
-- ----------------------------
INSERT INTO `k_instock_detail` VALUES ('1', '1', 'pdno_0001', '计算器', '1', '100', '个', '20', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('2', '2', 'pdno_0002', '回形针', '1', '100', '盒', '5', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('3', '3', 'pdno_0003', '中性笔', '1', '100', '盒', '5', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('4', '4', 'pdno_0004', '复印纸', '1', '100', '包', '10', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('5', '5', 'pdno_0005', '账本', '1', '100', '本', '2', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('6', '6', 'pdno_0006', '拖布', '1', '100', '把', '20', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('7', '7', 'pdno_0007', '小蜜蜂扩音器', '1', '100', '个', '25', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('8', '8', 'pdno_0008', '纸杯', '1', '100', '包', '5', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('9', '9', 'pdno_0009', '白板', '1', '100', '块', '50', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('10', '10', 'pdno_0010', '软面抄', '1', '100', '本', '1', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('11', '11', 'pdno_0011', '双面胶', '1', '100', '卷', '2', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('12', '12', 'pdno_0012', '剪刀', '1', '100', '个', '3', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('13', '13', 'pdno_0013', '文件夹', '1', '100', '个', '8', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('14', '14', 'pdno_0014', '档案盒', '1', '100', '个', '10', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('15', '15', 'pdno_0015', '电脑', '1', '100', '台', '1000', '1000', null);
INSERT INTO `k_instock_detail` VALUES ('16', '16', 'pdno_0016', '电脑', '1', '100', '台', '1000', '1000', null);

-- ----------------------------
-- Table structure for k_inventory
-- ----------------------------
DROP TABLE IF EXISTS `k_inventory`;
CREATE TABLE `k_inventory` (
  `ID` int(11) DEFAULT NULL,
  `STOCKID` int(11) DEFAULT NULL,
  `PRODUCTNO` varchar(30) DEFAULT NULL,
  `PRODUCTNAME` varchar(255) DEFAULT NULL,
  `PRODUCTSTANDARD` varchar(255) DEFAULT NULL,
  `INVENTORYNUM` int(11) DEFAULT NULL,
  `INVENTORYPRICE` int(11) DEFAULT NULL,
  `INSTOCKNUM` int(11) DEFAULT NULL,
  `INSTOCKPRICE` int(11) DEFAULT NULL,
  `OUTSTOCKNUM` int(11) DEFAULT NULL,
  `OUTSTOCKPRICE` int(11) DEFAULT NULL,
  `MAXNUM` int(11) DEFAULT NULL,
  `MINNUM` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_inventory
-- ----------------------------
INSERT INTO `k_inventory` VALUES ('1', '1', 'pdno_0001', '计算器', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);
INSERT INTO `k_inventory` VALUES ('2', '1', 'pdno_0002', '回形针', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);
INSERT INTO `k_inventory` VALUES ('3', '2', 'pdno_0003', '中性笔', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);
INSERT INTO `k_inventory` VALUES ('4', '2', 'pdno_0004', '复印纸', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);
INSERT INTO `k_inventory` VALUES ('5', '3', 'pdno_0005', '账本', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);
INSERT INTO `k_inventory` VALUES ('6', '3', 'pdno_0006', '拖布', '1', '100', '20', '10', '100', '100', '10', '1000', '1', null);

-- ----------------------------
-- Table structure for k_outstock
-- ----------------------------
DROP TABLE IF EXISTS `k_outstock`;
CREATE TABLE `k_outstock` (
  `ID` int(11) NOT NULL,
  `OUTSTOCKNO` varchar(30) DEFAULT NULL,
  `STOCKID` int(11) DEFAULT NULL,
  `SUPPLIERID` int(11) DEFAULT NULL,
  `OUTSTOCKSTATE` varchar(255) DEFAULT NULL,
  `OUTSTOCKDATE` datetime DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_outstock
-- ----------------------------
INSERT INTO `k_outstock` VALUES ('1', 'outst_0001', '1', '1', '00', '2015-12-15 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('2', 'outst_0002', '2', '2', '00', '2015-12-15 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('3', 'outst_0003', '1', '3', '00', '2015-12-15 00:00:00', '请处理');
INSERT INTO `k_outstock` VALUES ('4', 'outst_0004', '2', '1', '00', '2015-12-25 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('5', 'outst_0005', '1', '2', '00', '2015-12-25 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('6', 'outst_0006', '2', '3', '00', '2015-12-25 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('7', 'outst_0007', '1', '1', '00', '2016-01-15 00:00:00', '及时处理');
INSERT INTO `k_outstock` VALUES ('8', 'outst_0008', '2', '2', '00', '2016-01-15 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('9', 'outst_0009', '1', '3', '00', '2016-01-25 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('10', 'outst_0010', '2', '1', '00', '2016-01-25 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('11', 'outst_0011', '1', '2', '00', '2016-01-25 00:00:00', '加急处理');
INSERT INTO `k_outstock` VALUES ('12', 'outst_0012', '2', '3', '00', '2016-02-15 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('13', 'outst_0013', '1', '1', '00', '2016-02-15 00:00:00', null);
INSERT INTO `k_outstock` VALUES ('14', 'outst_0014', '2', '2', '00', '2016-02-15 00:00:00', '处理');
INSERT INTO `k_outstock` VALUES ('15', 'outst_0015', '1', '3', '00', '2016-02-15 00:00:00', null);

-- ----------------------------
-- Table structure for k_outstock_detail
-- ----------------------------
DROP TABLE IF EXISTS `k_outstock_detail`;
CREATE TABLE `k_outstock_detail` (
  `ID` int(11) NOT NULL,
  `OUTSTOCKID` int(11) DEFAULT NULL,
  `PRODUCTNO` varchar(30) DEFAULT NULL,
  `PRODUCTNAME` varchar(255) DEFAULT NULL,
  `PRODUCTSTANDARD` varchar(255) DEFAULT NULL,
  `PRODUCTNUM` int(11) DEFAULT NULL,
  `UNIT` varchar(20) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `TOTALPRICE` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_outstock_detail
-- ----------------------------
INSERT INTO `k_outstock_detail` VALUES ('1', '1', 'pdno_0001', '计算器', '1', '10', '个', '20', '200', null);
INSERT INTO `k_outstock_detail` VALUES ('2', '2', 'pdno_0002', '回形针', '1', '10', '盒', '5', '50', null);
INSERT INTO `k_outstock_detail` VALUES ('3', '3', 'pdno_0003', '中性笔', '1', '10', '盒', '5', '50', null);
INSERT INTO `k_outstock_detail` VALUES ('4', '4', 'pdno_0004', '复印纸', '1', '10', '包', '10', '100', null);
INSERT INTO `k_outstock_detail` VALUES ('5', '5', 'pdno_0005', '账本', '1', '10', '本', '2', '20', null);
INSERT INTO `k_outstock_detail` VALUES ('6', '6', 'pdno_0006', '拖布', '1', '10', '把', '20', '200', null);
INSERT INTO `k_outstock_detail` VALUES ('7', '7', 'pdno_0007', '小蜜蜂扩音器', '1', '10', '个', '25', '250', null);
INSERT INTO `k_outstock_detail` VALUES ('8', '8', 'pdno_0008', '纸杯', '1', '10', '包', '5', '50', null);
INSERT INTO `k_outstock_detail` VALUES ('9', '9', 'pdno_0009', '白板', '1', '10', '块', '50', '500', null);
INSERT INTO `k_outstock_detail` VALUES ('10', '10', 'pdno_0010', '软面抄', '1', '10', '本', '1', '10', null);
INSERT INTO `k_outstock_detail` VALUES ('11', '11', 'pdno_0011', '双面胶', '1', '10', '卷', '2', '20', null);
INSERT INTO `k_outstock_detail` VALUES ('12', '12', 'pdno_0012', '剪刀', '1', '10', '个', '3', '30', null);
INSERT INTO `k_outstock_detail` VALUES ('13', '13', 'pdno_0013', '文件夹', '1', '10', '个', '8', '80', null);
INSERT INTO `k_outstock_detail` VALUES ('14', '14', 'pdno_0014', '档案盒', '1', '10', '个', '10', '100', null);
INSERT INTO `k_outstock_detail` VALUES ('15', '15', 'pdno_0015', '电脑', '1', '10', '台', '1000', '10000', null);

-- ----------------------------
-- Table structure for k_stock
-- ----------------------------
DROP TABLE IF EXISTS `k_stock`;
CREATE TABLE `k_stock` (
  `ID` int(11) NOT NULL,
  `STOCKNO` varchar(30) DEFAULT NULL,
  `STOCKNAME` varchar(255) DEFAULT NULL,
  `PROVINCE` varchar(20) DEFAULT NULL,
  `STOCKADDRESS` varchar(255) DEFAULT NULL,
  `STOCKTEL` varchar(20) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_stock
-- ----------------------------
INSERT INTO `k_stock` VALUES ('1', 'stk_0001', '一号仓库', '青岛', '教学楼一楼', '111111', null);
INSERT INTO `k_stock` VALUES ('2', 'stk_0002', '二号仓库', '青岛', '教学楼二楼', '111111', null);
INSERT INTO `k_stock` VALUES ('3', 'stk_0003', '三号仓库', '青岛', '教学楼三楼', '111111', null);

-- ----------------------------
-- Table structure for k_supplier
-- ----------------------------
DROP TABLE IF EXISTS `k_supplier`;
CREATE TABLE `k_supplier` (
  `ID` int(11) NOT NULL,
  `SUPPLIERNO` varchar(30) DEFAULT NULL,
  `SUPPLIERNAME` varchar(255) DEFAULT NULL,
  `PROVINCECODE` varchar(20) DEFAULT NULL,
  `SUPPLIERADDRESS` varchar(255) DEFAULT NULL,
  `SUPPLIEREMAIL` varchar(50) DEFAULT NULL,
  `SUPPLIERTEL` varchar(20) DEFAULT NULL,
  `SUPPLIERTAX` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(30) DEFAULT NULL,
  `USERTEL` varchar(20) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_supplier
-- ----------------------------
INSERT INTO `k_supplier` VALUES ('1', 'sup_0001', '利群', '山东', '市北台东', '1111@163.com', '1111', '1111', '李刚', '1111', null);
INSERT INTO `k_supplier` VALUES ('2', 'sup_0002', '银座', '山东', '李村商圈', '1112@163.com', '1112', '1112', '王小贱', '1112', null);
INSERT INTO `k_supplier` VALUES ('3', 'sup_0003', '北方国贸', '山东', '李村商圈', '1113@163.com', '1113', '1113', '黄小仙', '1113', null);

-- ----------------------------
-- Table structure for k_user
-- ----------------------------
DROP TABLE IF EXISTS `k_user`;
CREATE TABLE `k_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNO` varchar(30) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PWD` varchar(20) DEFAULT NULL,
  `DEPTNO` varchar(30) DEFAULT NULL,
  `SEX` varchar(2) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `POSITION` varchar(50) DEFAULT NULL,
  `HOMETOWN` varchar(255) DEFAULT NULL,
  `TELPHONE` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ROLENO` varchar(1) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k_user
-- ----------------------------
INSERT INTO `k_user` VALUES ('1', 'admin', '系统管理员', '123456', 'dept_0001', '0', '99', '管理员', '山东', '18998881234', '10000000@163.com', '0', null);
INSERT INTO `k_user` VALUES ('2', 'user_0002', '王武', '123456', 'dept_0001', '0', '23', '员工', '山东', '10000000001', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('3', 'user_0003', '刘成', '123456', 'dept_0001', '0', '20', '员工', '北京', '10000000002', '10000000@163.com', '1', '总部外派');
INSERT INTO `k_user` VALUES ('4', 'user_0004', '杨胜', '123456', 'dept_0001', '0', '33', '员工', '山东', '10000000003', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('5', 'user_0005', '孙小斌', '123456', 'dept_0002', '0', '28', '员工', '上海', '10000000004', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('6', 'user_0006', '赵刚', '123456', 'dept_0002', '0', '24', '员工', '山东', '10000000005', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('7', 'user_0007', '李争', '123456', 'dept_0002', '0', '35', '经理', '江苏', '10000000006', '10000000@163.com', '1', '实习');
INSERT INTO `k_user` VALUES ('8', 'user_0008', '崔建', '123456', 'dept_0002', '0', '46', '员工', '山东', '10000000007', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('9', 'user_0009', '何娟', '123456', 'dept_0002', '1', '19', '员工', '上海', '10000000008', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('10', 'user_0010', '方晓花', '123456', 'dept_0003', '1', '26', '员工', '山东', '10000000009', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('11', 'user_0011', '田小草', '123456', 'dept_0003', '1', '27', '员工', '北京', '10000000010', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('12', 'user_0012', '候丽', '123456', 'dept_0003', '1', '32', '员工', '山东', '10000000011', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('13', 'user_0013', '黄小仙', '123456', 'dept_0003', '1', '30', '员工', '浙江', '10000000012', '10000000@163.com', '1', null);
INSERT INTO `k_user` VALUES ('14', 'user_0014', '王文欣', '123456', 'dept_0003', '1', '37', '员工', '山东', '10000000013', '10000000@163.com', '1', '');
INSERT INTO `k_user` VALUES ('15', 'user_0015', '李莉', '123456', 'dept_0003', '1', '55', '部门经理', '山东', '10000000014', '10000000@163.com', '1', '');
