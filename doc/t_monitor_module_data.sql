
-- ----------------------------
-- Table structure for t_monitor_module_data
-- ----------------------------
DROP TABLE IF EXISTS `t_monitor_module_data`;
CREATE TABLE `t_monitor_module_data` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '帖子id',
  `moduleId` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT '模块id',
  `organizationCode` varchar(11) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '单位编码',
  `title` longtext COLLATE utf8mb4_unicode_ci COMMENT '标题',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  `url` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT 'url',
  `poTime` bigint(13) DEFAULT NULL COMMENT '发布时间',
  `author` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
  `source` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '来源',
  `addTime` bigint(13) DEFAULT NULL COMMENT '采集时间',
  `pr` int(1) DEFAULT NULL COMMENT '网站级别',
  `webSiteType` int(3) DEFAULT NULL COMMENT '网站类型',
  `webSite` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '网站',
  `positiveOrNegative` int(1) DEFAULT NULL COMMENT '正负面',
  `abroad` int(2) DEFAULT NULL COMMENT '是否境外',
  `spreadValue` int(10) DEFAULT NULL COMMENT '扩散值',
  `replay` int(10) DEFAULT NULL COMMENT '回复数',
  `t_view` int(10) DEFAULT NULL COMMENT '浏览数',
  `transer` int(10) DEFAULT NULL COMMENT '转发数',
  `praiseCount` int(10) DEFAULT NULL COMMENT '点赞数',
  `importanceDegree` int(10) DEFAULT NULL COMMENT '重要度',
  `opinionValue` int(10) DEFAULT NULL COMMENT '舆情值',
  `sensitiveValue` int(10) DEFAULT NULL COMMENT '敏感值',
  `administrativeId` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '区域代码',
  `titlePrint` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题指纹',
  `titleContentPrint` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题内容指纹',
  `subpoTime` bigint(13) DEFAULT NULL COMMENT '子发布时间',
  `subpraiseCount` int(10) DEFAULT NULL COMMENT '子点赞数',
  `subreplay` int(10) DEFAULT NULL COMMENT '子回复数',
  `subtranser` int(10) DEFAULT NULL COMMENT '子转发数',
  `domain` varchar(300) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`,`moduleId`),
  KEY `index_name` (`id`,`moduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='首页模块数据信息表';
