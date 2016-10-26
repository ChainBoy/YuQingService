-- ----------------------------
-- Table structure for t_monitor_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor_topic`;
CREATE TABLE `t_monitor_topic` (
  `topic_id` varchar(30) NOT NULL COMMENT '专题id',
  `topic_name` varchar(500) NOT NULL COMMENT '专题名称',
  `organization_code` varchar(11) NOT NULL COMMENT '单位编码',
  `sim_value` double DEFAULT NULL COMMENT '相似值',
  `spread_value` int(11) DEFAULT NULL COMMENT '扩散值',
  `opinion_value` int(11) DEFAULT NULL COMMENT '舆情值',
  `website_types` varchar(200) DEFAULT NULL COMMENT '网站类型',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_query_time` datetime DEFAULT NULL,
  `scope` int(11) DEFAULT NULL COMMENT '监控范围',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `query_express` text COMMENT '关键词',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题信息表';