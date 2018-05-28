/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-05-28 10:02:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('123456789', '11111111', '1111112', '皮蛋粥', '1.20', '2', 'http://xxx.jpg', '2018-05-04 18:00:47', '2018-05-04 18:00:47');
INSERT INTO `order_detail` VALUES ('1525615967736382872', '1525615967588720235', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-06 22:12:47', '2018-05-06 22:12:47');
INSERT INTO `order_detail` VALUES ('1525616422656537511', '1525616422542838976', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-06 22:20:22', '2018-05-06 22:20:22');
INSERT INTO `order_detail` VALUES ('1525616422690244561', '1525616422542838976', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-06 22:20:22', '2018-05-06 22:20:22');
INSERT INTO `order_detail` VALUES ('1525660302072776504', '1525660301970238851', '123456', '皮蛋瘦肉粥', '10.00', '2', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-07 10:31:42', '2018-05-07 10:31:42');
INSERT INTO `order_detail` VALUES ('1525661618316466414', '1525661618260946747', '123456', '皮蛋瘦肉粥', '10.00', '2', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-07 10:53:38', '2018-05-07 10:53:38');
INSERT INTO `order_detail` VALUES ('1525756423774739928', '1525756423534373089', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-08 13:13:43', '2018-05-08 13:13:43');
INSERT INTO `order_detail` VALUES ('1525756423930582029', '1525756423534373089', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-08 13:13:44', '2018-05-08 13:13:44');
INSERT INTO `order_detail` VALUES ('1525847587796449304', '1525847587795159023', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 14:33:07', '2018-05-09 14:33:07');
INSERT INTO `order_detail` VALUES ('1525847588097841535', '1525847588095665615', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 14:33:08', '2018-05-09 14:33:08');
INSERT INTO `order_detail` VALUES ('1525847589351674926', '1525847589349496914', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 14:33:09', '2018-05-09 14:33:09');
INSERT INTO `order_detail` VALUES ('1525847589968794495', '1525847589966896865', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 14:33:09', '2018-05-09 14:33:09');
INSERT INTO `order_detail` VALUES ('1525855022903217972', '1525855022888250493', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 16:37:03', '2018-05-09 16:37:03');
INSERT INTO `order_detail` VALUES ('1525855903952921531', '1525855903935430705', '123456', '皮蛋瘦肉粥', '10.00', '1', 'http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-09 16:51:44', '2018-05-09 16:51:44');
INSERT INTO `order_detail` VALUES ('1526040492669944023', '1526040492657576821', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-11 20:08:12', '2018-05-11 20:08:12');
INSERT INTO `order_detail` VALUES ('1526040492726108242', '1526040492657576821', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-11 20:08:12', '2018-05-11 20:08:12');
INSERT INTO `order_detail` VALUES ('1526040918599769588', '1526040918596931956', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-11 20:15:18', '2018-05-11 20:15:18');
INSERT INTO `order_detail` VALUES ('1526040974524300614', '1526040974522999840', '123461', '牛肉馅饼', '14.00', '1', 'http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-11 20:16:14', '2018-05-11 20:16:14');
INSERT INTO `order_detail` VALUES ('1526106449606120960', '1526106449570484664', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-12 14:27:29', '2018-05-12 14:27:29');
INSERT INTO `order_detail` VALUES ('1526106557035408788', '1526106557034565271', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-12 14:29:17', '2018-05-12 14:29:17');
INSERT INTO `order_detail` VALUES ('1526106557039808851', '1526106557034565271', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-12 14:29:17', '2018-05-12 14:29:17');
INSERT INTO `order_detail` VALUES ('1526106737029332789', '1526106737028239239', '123465', 'VC无限橙果汁', '8.00', '1', 'http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-12 14:32:17', '2018-05-12 14:32:17');
INSERT INTO `order_detail` VALUES ('1526216006805444713', '1526216005322704966', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-13 20:53:27', '2018-05-13 20:53:27');
INSERT INTO `order_detail` VALUES ('1526216056846230646', '1526216056844317015', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-13 20:54:16', '2018-05-13 20:54:16');
INSERT INTO `order_detail` VALUES ('1526219128868548221', '1526219128863906012', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-13 21:45:28', '2018-05-13 21:45:28');
INSERT INTO `order_detail` VALUES ('1526219128875558342', '1526219128863906012', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-13 21:45:28', '2018-05-13 21:45:28');
INSERT INTO `order_detail` VALUES ('1526219128878497845', '1526219128863906012', '123461', '牛肉馅饼', '14.00', '1', 'http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-13 21:45:28', '2018-05-13 21:45:28');
INSERT INTO `order_detail` VALUES ('1526354296357676644', '1526354296346657404', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-15 11:18:16', '2018-05-15 11:18:16');
INSERT INTO `order_detail` VALUES ('1526354296429973958', '1526354296346657404', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-15 11:18:16', '2018-05-15 11:18:16');
INSERT INTO `order_detail` VALUES ('1526566930267848696', '1526566930267237353', '123456', '皮蛋粥', '3.00', '1', 'http://www.baidu.com', '2018-05-17 22:22:10', '2018-05-17 22:22:10');
INSERT INTO `order_detail` VALUES ('1526566930277626587', '1526566930267237353', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-17 22:22:10', '2018-05-17 22:22:10');
INSERT INTO `order_detail` VALUES ('1526567211053639379', '1526567211028438180', '123456', '皮蛋粥', '3.00', '1', 'http://www.baidu.com', '2018-05-17 22:26:51', '2018-05-17 22:26:51');
INSERT INTO `order_detail` VALUES ('1526567211058810046', '1526567211028438180', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-17 22:26:51', '2018-05-17 22:26:51');
INSERT INTO `order_detail` VALUES ('1526620346975792312', '1526620346965354959', '123456', '皮蛋粥', '3.00', '1', 'http://www.baidu.com', '2018-05-18 13:12:26', '2018-05-18 13:12:26');
INSERT INTO `order_detail` VALUES ('1526620346985622056', '1526620346965354959', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 13:12:27', '2018-05-18 13:12:27');
INSERT INTO `order_detail` VALUES ('1526620486835656307', '1526620486825270341', '123456', '皮蛋粥', '3.00', '1', 'http://www.baidu.com', '2018-05-18 13:14:46', '2018-05-18 13:14:46');
INSERT INTO `order_detail` VALUES ('1526620486845441863', '1526620486825270341', '123457', '扁豆焖面', '14.00', '2', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 13:14:46', '2018-05-18 13:14:46');
INSERT INTO `order_detail` VALUES ('1526642968574196366', '1526642968500197304', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:29:28', '2018-05-18 19:29:28');
INSERT INTO `order_detail` VALUES ('1526643622431415158', '1526643622421375625', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:40:22', '2018-05-18 19:40:22');
INSERT INTO `order_detail` VALUES ('1526643818618687909', '1526643818605918365', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:43:38', '2018-05-18 19:43:38');
INSERT INTO `order_detail` VALUES ('1526644161785982465', '1526644161774338213', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:49:21', '2018-05-18 19:49:21');
INSERT INTO `order_detail` VALUES ('1526644362959884225', '1526644362955428153', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:52:42', '2018-05-18 19:52:42');
INSERT INTO `order_detail` VALUES ('1526644510540786355', '1526644510538539778', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:55:10', '2018-05-18 19:55:10');
INSERT INTO `order_detail` VALUES ('1526644666853320858', '1526644666851506529', '123465', 'VC无限橙果汁', '8.00', '1', 'http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 19:57:46', '2018-05-18 19:57:46');
INSERT INTO `order_detail` VALUES ('1526644832837362982', '1526644832835692955', '123458', '红枣山药粥套餐', '29.00', '1', 'http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:00:32', '2018-05-18 20:00:32');
INSERT INTO `order_detail` VALUES ('1526644998513368353', '1526644998503283496', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:03:18', '2018-05-18 20:03:18');
INSERT INTO `order_detail` VALUES ('1526645405486344809', '1526645405475278609', '123465', 'VC无限橙果汁', '8.00', '1', 'http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:10:05', '2018-05-18 20:10:05');
INSERT INTO `order_detail` VALUES ('1526645707720574709', '1526645707717228217', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:15:07', '2018-05-18 20:15:07');
INSERT INTO `order_detail` VALUES ('1526646832073758045', '1526646832071353164', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:33:52', '2018-05-18 20:33:52');
INSERT INTO `order_detail` VALUES ('1526646835282618421', '1526646835280663929', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:33:55', '2018-05-18 20:33:55');
INSERT INTO `order_detail` VALUES ('1526646846326587855', '1526646846324137064', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:34:06', '2018-05-18 20:34:06');
INSERT INTO `order_detail` VALUES ('1526647026084207569', '1526647026083284530', '123458', '红枣山药粥套餐', '29.00', '1', 'http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:37:06', '2018-05-18 20:37:06');
INSERT INTO `order_detail` VALUES ('1526647060464461475', '1526647060463108289', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-18 20:37:40', '2018-05-18 20:37:40');
INSERT INTO `order_detail` VALUES ('1527089577022122435', '1527089576986182085', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-23 23:32:57', '2018-05-23 23:32:57');
INSERT INTO `order_detail` VALUES ('1527089617596206187', '1527089617591865876', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-23 23:33:37', '2018-05-23 23:33:37');
INSERT INTO `order_detail` VALUES ('1527089861611277642', '1527089861609191377', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-23 23:37:41', '2018-05-23 23:37:41');
INSERT INTO `order_detail` VALUES ('1527090755960489373', '1527090755954305313', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-23 23:52:35', '2018-05-23 23:52:35');
INSERT INTO `order_detail` VALUES ('1527091040842232195', '1527091040838385351', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-23 23:57:20', '2018-05-23 23:57:20');
INSERT INTO `order_detail` VALUES ('1527091321283841292', '1527091321258533885', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-24 00:02:01', '2018-05-24 00:02:01');
INSERT INTO `order_detail` VALUES ('1527091569643424437', '1527091569640492432', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-24 00:06:09', '2018-05-24 00:06:09');
INSERT INTO `order_detail` VALUES ('1527140242990547547', '1527140242980868244', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-24 13:37:23', '2018-05-24 13:37:23');
INSERT INTO `order_detail` VALUES ('1527143075725265450', '1527143075723864797', '123457', '扁豆焖面', '14.00', '1', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-24 14:24:35', '2018-05-24 14:24:35');
INSERT INTO `order_detail` VALUES ('1527144047941869319', '1527144047940377162', '123459', '葱花饼', '10.00', '1', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '2018-05-24 14:40:47', '2018-05-24 14:40:47');

-- ----------------------------
-- Table structure for `order_master`
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态,默认0新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0为未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('113', '测试第二页', '120', '亚洲', 'bb', '11.00', '0', '0', '2018-05-10 17:51:17', '2018-05-10 17:51:17');
INSERT INTO `order_master` VALUES ('123456', '帅哥', '12345678910', '东区九栋', '110110', '2.30', '0', '0', '2018-05-04 17:01:34', '2018-05-04 17:01:34');
INSERT INTO `order_master` VALUES ('123457', '帅哥', '12345678910', '东区九栋', '110110', '2.50', '0', '0', '2018-05-04 17:06:23', '2018-05-04 17:06:23');
INSERT INTO `order_master` VALUES ('1525615967588720235', '李先生', '12345678910', '1号餐桌', '110110', '10.00', '2', '1', '2018-05-06 22:12:48', '2018-05-17 22:22:10');
INSERT INTO `order_master` VALUES ('1525616422542838976', '李先生', '12345678910', '1号餐桌', '110110', '38.00', '0', '0', '2018-05-06 22:20:22', '2018-05-06 22:20:22');
INSERT INTO `order_master` VALUES ('1525660301970238851', '张三', '18868822111', '东区九栋', 'ew3euwhd7sjw9diwk', '20.00', '2', '0', '2018-05-07 10:31:42', '2018-05-07 21:24:32');
INSERT INTO `order_master` VALUES ('1525661618260946747', '张三', '18868822111', '东区九栋', 'ew3euwhd7sjw9diwk', '20.00', '0', '0', '2018-05-07 10:53:38', '2018-05-07 10:53:38');
INSERT INTO `order_master` VALUES ('1525756423534373089', '李振杰', '18487135835', '东区九栋', 'lizhenjie', '24.00', '2', '0', '2018-05-08 13:13:44', '2018-05-13 22:04:08');
INSERT INTO `order_master` VALUES ('1525847589966896865', '刚刚', '11', '泰国', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '1', '0', '2018-05-09 14:33:09', '2018-05-13 20:55:25');
INSERT INTO `order_master` VALUES ('1525855022888250493', '张三', '110', '229', 'aa', '10.00', '2', '0', '2018-05-09 16:37:03', '2018-05-11 18:15:01');
INSERT INTO `order_master` VALUES ('1525855903935430705', '李四', '123', '223', 'abc', '10.00', '0', '0', '2018-05-09 16:51:44', '2018-05-10 19:47:04');
INSERT INTO `order_master` VALUES ('1526040492657576821', '赵', '6', '6', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '24.00', '0', '1', '2018-05-11 20:08:12', '2018-05-11 20:08:13');
INSERT INTO `order_master` VALUES ('1526040918596931956', '好', '1', '8', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '2', '1', '2018-05-11 20:15:18', '2018-05-11 20:15:48');
INSERT INTO `order_master` VALUES ('1526040974522999840', '马飞', '110', '230', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '2', '1', '2018-05-11 20:16:14', '2018-05-11 20:21:54');
INSERT INTO `order_master` VALUES ('1526106449570484664', '李黑帅', '888', '6', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '1', '1', '2018-05-12 14:27:29', '2018-05-12 14:28:06');
INSERT INTO `order_master` VALUES ('1526106557034565271', 'test', '999', '230', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '24.00', '2', '1', '2018-05-12 14:29:17', '2018-05-12 14:30:51');
INSERT INTO `order_master` VALUES ('1526106737028239239', 'test', '888', '228', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '8.00', '2', '1', '2018-05-12 14:32:17', '2018-05-12 14:32:37');
INSERT INTO `order_master` VALUES ('1526216005322704966', '6', '6', '6', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '2', '1', '2018-05-13 20:53:31', '2018-05-13 20:54:43');
INSERT INTO `order_master` VALUES ('1526216056844317015', '抿压', '8', '8', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '2', '1', '2018-05-13 20:54:16', '2018-05-13 20:54:25');
INSERT INTO `order_master` VALUES ('1526219128863906012', 'test', '18487235835', '2', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '52.00', '2', '1', '2018-05-13 21:45:28', '2018-05-13 21:51:16');
INSERT INTO `order_master` VALUES ('1526354296346657404', 'test', '11111', '3', 'abc', '24.00', '2', '1', '2018-05-15 11:18:16', '2018-05-15 11:18:46');
INSERT INTO `order_master` VALUES ('1526566930267237353', '李先生', '12345678910', '1号餐桌', '110110', '31.00', '0', '0', '2018-05-17 22:22:10', '2018-05-17 22:22:10');
INSERT INTO `order_master` VALUES ('1526567211028438180', '李先生', '12345678910', '1号餐桌', '110110', '31.00', '0', '0', '2018-05-17 22:26:51', '2018-05-17 22:26:51');
INSERT INTO `order_master` VALUES ('1526620346965354959', '李先生', '12345678910', '1号餐桌', '110110', '31.00', '0', '0', '2018-05-18 13:12:27', '2018-05-18 13:12:27');
INSERT INTO `order_master` VALUES ('1526620486825270341', '李先生', '12345678910', '1号餐桌', '110110', '31.00', '0', '0', '2018-05-18 13:14:46', '2018-05-18 13:14:46');
INSERT INTO `order_master` VALUES ('1526642968500197304', '部署测试', '666', '313', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '2', '1', '2018-05-18 19:29:28', '2018-05-18 19:29:38');
INSERT INTO `order_master` VALUES ('1526643622421375625', '部署测试二', '6667', '313', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '0', '1', '2018-05-18 19:40:22', '2018-05-24 00:03:39');
INSERT INTO `order_master` VALUES ('1526643818605918365', '部署测试三', '999', '313', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '0', '1', '2018-05-18 19:43:38', '2018-05-18 19:43:39');
INSERT INTO `order_master` VALUES ('1526644161774338213', '部署测试四', '999', '313', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '0', '1', '2018-05-18 19:49:21', '2018-05-24 00:03:35');
INSERT INTO `order_master` VALUES ('1526644362955428153', '部署测试五', '110', '5667', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '0', '1', '2018-05-18 19:52:43', '2018-05-24 00:03:34');
INSERT INTO `order_master` VALUES ('1526644510538539778', '部署测试6', '555', '888', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '0', '1', '2018-05-18 19:55:10', '2018-05-18 19:55:10');
INSERT INTO `order_master` VALUES ('1526644666851506529', '部署测试6', '999', '777', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '8.00', '0', '1', '2018-05-18 19:57:46', '2018-05-24 00:03:31');
INSERT INTO `order_master` VALUES ('1526644832835692955', '部署测试七', '99', '77', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '29.00', '0', '1', '2018-05-18 20:00:32', '2018-05-24 00:03:30');
INSERT INTO `order_master` VALUES ('1526644998503283496', '部署测试八', '8', '8', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '0', '1', '2018-05-18 20:03:18', '2018-05-24 00:03:29');
INSERT INTO `order_master` VALUES ('1526645405475278609', '部署测试九', '8', '8', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '8.00', '0', '1', '2018-05-18 20:10:05', '2018-05-24 00:03:27');
INSERT INTO `order_master` VALUES ('1526645707717228217', '部署测试十一', '8', '8', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '0', '1', '2018-05-18 20:15:07', '2018-05-18 20:15:08');
INSERT INTO `order_master` VALUES ('1527091569640492432', '6', '6', '6', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '14.00', '2', '1', '2018-05-24 00:06:09', '2018-05-24 00:06:29');
INSERT INTO `order_master` VALUES ('1527140242980868244', '张璐', '2', '2', 'oNYj90t6zskC1TapMMUw9Y6il46g', '14.00', '2', '1', '2018-05-24 13:37:23', '2018-05-24 13:37:33');
INSERT INTO `order_master` VALUES ('1527143075723864797', '张璐', '18214580554', '123', 'oNYj90t6zskC1TapMMUw9Y6il46g', '14.00', '2', '1', '2018-05-24 14:24:35', '2018-05-24 14:25:02');
INSERT INTO `order_master` VALUES ('1527144047940377162', 'test', '3433', '222', 'oNYj90tnYsbYha6wdiFZ4kj0t0sw', '10.00', '0', '1', '2018-05-24 14:40:47', '2018-05-24 14:40:48');

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='类目表';

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '热销榜', '-1', '2018-05-03 00:47:30', '2018-05-04 11:35:36');
INSERT INTO `product_category` VALUES ('2', '单人精彩套餐', '4', '2018-05-03 01:10:41', '2018-05-11 00:29:45');
INSERT INTO `product_category` VALUES ('3', '冰爽饮品限时特惠', '1', '2018-05-04 11:47:29', '2018-05-10 23:44:27');
INSERT INTO `product_category` VALUES ('18', '单人精彩套餐2', '2', '2018-05-11 14:29:43', '2018-05-11 14:29:54');
INSERT INTO `product_category` VALUES ('19', '女生最爱', '3', '2018-05-17 22:22:05', '2018-05-17 22:22:05');
INSERT INTO `product_category` VALUES ('20', '女生最爱', '3', '2018-05-17 22:26:49', '2018-05-17 22:26:49');
INSERT INTO `product_category` VALUES ('21', '女生最爱', '3', '2018-05-18 13:12:25', '2018-05-18 13:12:25');
INSERT INTO `product_category` VALUES ('22', '女生最爱', '3', '2018-05-18 13:14:45', '2018-05-18 13:14:45');

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT NULL COMMENT '0',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', '皮蛋粥', '3.00', '29', '很好喝的粥', 'http://www.baidu.com', '0', '1', '2018-05-18 13:14:46', '2018-05-18 13:14:46');
INSERT INTO `product_info` VALUES ('123457', '扁豆焖面', '14.00', '175', '很好吃的虾', 'http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-03 20:34:25', '2018-05-24 14:25:02');
INSERT INTO `product_info` VALUES ('123458', '红枣山药粥套餐', '29.00', '16', '红枣山药糙米粥', 'http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/114/h/114', '0', '2', '2018-05-04 11:38:25', '2018-05-18 20:37:06');
INSERT INTO `product_info` VALUES ('123459', '葱花饼', '10.00', '116', '还行吧', 'http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-04 11:40:40', '2018-05-24 14:40:47');
INSERT INTO `product_info` VALUES ('123461', '牛肉馅饼', '14.00', '114', '无', 'http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-04 11:41:30', '2018-05-13 21:51:16');
INSERT INTO `product_info` VALUES ('123462', '招牌猪肉白菜锅贴/10个', '17.00', '101', '招牌', 'http://fuss10.elemecdn.com/7/72/9a580c1462ca1e4d3c07e112bc035jpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-04 11:43:06', '2018-05-04 11:43:06');
INSERT INTO `product_info` VALUES ('123463', '南瓜粥', '9.00', '91', '甜粥', 'http://fuss10.elemecdn.com/8/a6/453f65f16b1391942af11511b7a90jpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-04 11:44:10', '2018-05-04 11:44:10');
INSERT INTO `product_info` VALUES ('123464', '红豆薏米美肤粥', '12.00', '86', '甜粥', 'http://fuss10.elemecdn.com/d/22/260bd78ee6ac6051136c5447fe307jpeg.jpeg?imageView2/1/w/114/h/114', '0', '-1', '2018-05-04 11:44:59', '2018-05-04 11:44:59');
INSERT INTO `product_info` VALUES ('123465', 'VC无限橙果汁', '8.00', '15', '爽', 'http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114', '0', '1', '2018-05-04 11:49:03', '2018-05-18 20:14:24');
INSERT INTO `product_info` VALUES ('1525964613131196402', '可乐鸡翅', '20.00', '20', '说点什么呢', 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1525964918&di=8a3a7535e0d12d891f16312ae1caee44&src=http://pic.58pic.com/58pic/14/27/23/33m58PICJ8b_1024.jpg', '0', '-1', '2018-05-10 23:03:33', '2018-05-10 23:09:31');
