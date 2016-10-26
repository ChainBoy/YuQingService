-- ----------------------------
-- Table structure for t_monitor_module_category
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor_module_category`;
CREATE TABLE `t_monitor_module_category` (
  `module_id` varchar(30) NOT NULL DEFAULT '' COMMENT '模块id',
  `module_name` varchar(300) NOT NULL COMMENT '模块名称',
  `organization_code` varchar(30) DEFAULT NULL COMMENT '单位编码',
  `module_type` int(11) DEFAULT NULL COMMENT '模块类型 1：大分类 2：子分类',
  `module_scope` int(11) DEFAULT NULL COMMENT '监测范围',
  `module_show` int(11) DEFAULT NULL COMMENT '是否首页展示 ‘0’：不展示；‘1’：展示',
  `websitetype` varchar(30) DEFAULT NULL COMMENT '网站类型',
  `category_id` varchar(30) DEFAULT NULL COMMENT '分类id',
  `topic_id` varchar(30) DEFAULT NULL,
  `spread_value` int(11) DEFAULT NULL,
  `opinion_value` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_query_time` datetime DEFAULT NULL COMMENT '最后查询时间',
  `processing` int(11) DEFAULT NULL COMMENT '是否正在处理 0：未处理 1：正在处理',
  `key_express` text COMMENT '关键词',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页模块分类专题信息表';