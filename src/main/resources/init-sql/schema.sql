/*
Date: 2016-06-01 23:44:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_test_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_user`;
CREATE TABLE `t_test_user` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `salary` DECIMAL(8,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('1', 'zyb', '123', '钟义彪', 25,2309.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('2','zy', '123', '钟杨', 25,3353.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('3', 'lk', '123', '李坤', 25,2309.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('4','pk', '123', '彭坤', 25,3353.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('5', 'wmt', '123', '吴明佗', 25,2309.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('6','sfx', '123', '尚福星', 26,3353.2, '2016-06-01 23:41:39');
INSERT INTO `t_test_user`(`id`,`account`,`password`,`name`,`age`,`salary`,`create_time`) VALUES ('7','lhl', '123', '刘湖龙', 25,3353.2, '2016-06-01 23:41:39');

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `permission` varchar(32) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `resource_type` int(1) DEFAULT NULL COMMENT '1.URL, 2.功能',
  `available` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('1', '首页', '/index', null, '1','1', '2016-06-01 23:41:39');
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('2', '用户新增', null, 'user:add', '2', '1','2016-06-02 09:42:17');
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('3', '用户删除', null, 'user:delete', '2', '1','2016-06-03 21:42:17');
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('4', '用户更新', null, 'user:update', '2', '1','2016-06-03 20:38:01');
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('5', '用户查询', null, 'user:view', '2', '1','2016-06-03 20:38:04');
INSERT INTO `t_permission`(`id`,`name`,`url`,`permission`,`resource_type`,`available`,`create_time`) VALUES ('6', '系数监控', '/mgmt/shutdown', null, '1', '1','2016-06-03 20:38:04');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `role` varchar(32) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `available` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role`(`id`,`role`,`description`,`available`,`create_time`) VALUES ('1', 'admin', '系统管理员','1','2016-06-01 23:41:11');
INSERT INTO `t_role`(`id`,`role`,`description`,`available`,`create_time`) VALUES ('2', 'boss', '餐厅老板', '1','2016-06-01 23:41:11');
INSERT INTO `t_role`(`id`,`role`,`description`,`available`,`create_time`) VALUES ('3', 'manager', '餐厅经理', '1','2016-06-01 23:41:11');
INSERT INTO `t_role`(`id`,`role`,`description`,`available`,`create_time`) VALUES ('4', 'staff', '餐厅员工', '1','2016-06-01 23:41:11');

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1', '1');
INSERT INTO `t_role_permission` VALUES ('2', '1', '2');
INSERT INTO `t_role_permission` VALUES ('3', '1', '3');
INSERT INTO `t_role_permission` VALUES ('4', '2', '4');
INSERT INTO `t_role_permission` VALUES ('5', '4', '5');
INSERT INTO `t_role_permission` VALUES ('6', '4', '2');
INSERT INTO `t_role_permission` VALUES ('7', '1', '4');
INSERT INTO `t_role_permission` VALUES ('8', '1', '6');
-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `available` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Admin','1','1','2016-06-01 23:35:17');
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('2', 'lance', 'e10adc3949ba59abbe56e057f20f883e', 'Lance', '1','1','2016-06-02 23:35:38');
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('3', 'tony', 'e10adc3949ba59abbe56e057f20f883e', 'Tony', '1','1','2016-06-02 23:35:38');
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('4', 'dave', 'e10adc3949ba59abbe56e057f20f883e', 'Dave', '1','1','2016-06-02 23:35:38');
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('5', 'key', 'e10adc3949ba59abbe56e057f20f883e', 'Key', '1','1','2016-06-02 23:35:38');
INSERT INTO `t_user`(`id`,`account`,`password`,`name`,`state`,`available`,`create_time`) VALUES ('6', 'tom', 'e10adc3949ba59abbe56e057f20f883e', 'tom', '1','1','2016-06-02 23:35:38');
-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` varchar(19) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '1', '2');
INSERT INTO `t_user_role` VALUES ('3', '2', '2');
INSERT INTO `t_user_role` VALUES ('4', '3', '3');
INSERT INTO `t_user_role` VALUES ('5', '4', '4');
INSERT INTO `t_user_role` VALUES ('6', '5', '4');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(19) NOT NULL COMMENT 'ID',
  `level_id` varchar(16) NOT NULL COMMENT '上级ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `user_img` varchar(64) DEFAULT NULL COMMENT '头像',
  `user_qq` varchar(16) DEFAULT NULL COMMENT 'QQ',
  `user_Wechat` varchar(16) DEFAULT NULL COMMENT '微信',
  'user_privi_id' varchar(19) NOT NULL COMMENT '权限用户id',
  `email` varchar(32) DEFAULT NULL COMMENT 'email',
  `create_by` varchar(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(20) NOT NULL,
  `update_date` datetime NOT NULL,
  `del_flag` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '', '奥特曼','img/userbg1.png', '864121541', '8451gh', '3','8412023@qq.con',  'zhangli', '2016-11-10 20:51:57', 'zhangli', '2016-11-10 20:52:04', 'N');
INSERT INTO `user_info` VALUES ('2', '1', '吴亦凡','img/userbg2.png', '786841212', '8yh4561', '4','684512@qq.con',  'zhangli', '2016-11-10 20:51:57', 'zhangli', '2016-11-10 20:52:04', 'N');
