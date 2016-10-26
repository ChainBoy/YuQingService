-- ----------------------------
-- Table structure for organizationMsg
-- ----------------------------
DROP TABLE IF EXISTS `organizationMsg`;
CREATE TABLE `organizationMsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organizationCode` varchar(255) DEFAULT NULL,
  `organizationName` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `lastQueryTime` datetime DEFAULT NULL,
  `subcategory` text COMMENT 'json格式关键词表达式',
  `version` varchar(200) DEFAULT NULL,
  `search_version` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `pretreatment` int(11) DEFAULT NULL,
  `queue_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='单位信息表';