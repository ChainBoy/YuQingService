-- ----------------------------
-- Table structure for t_system_error_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_error_log`;
CREATE TABLE `t_system_error_log` (
  `log_id` varchar(32) NOT NULL COMMENT 'id',
  `system_id` varchar(10) NOT NULL COMMENT '系统id 1：数据上传 2：预处理 3：接口服务',
  `system_name` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(1000) DEFAULT NULL COMMENT '操作',
  `error_msg` text COMMENT '错误信息',
  `status` int(11) DEFAULT NULL COMMENT '0:未通知；1:已通知',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统错误日志表';
