- ----------------------------
-- Table structure for t_organization_summary
-- ----------------------------
DROP TABLE IF EXISTS `t_organization_summary`;
CREATE TABLE `t_organization_summary` (
  `organizationCode` varchar(13) NOT NULL DEFAULT '',
  `record_time` date NOT NULL DEFAULT '0000-00-00',
  `abroad` bigint(9) DEFAULT NULL,
  `boke` bigint(9) DEFAULT NULL,
  `forum` bigint(9) DEFAULT NULL,
  `media` bigint(9) DEFAULT NULL,
  `news` bigint(9) DEFAULT NULL,
  `tieba` bigint(9) DEFAULT NULL,
  `twitter` bigint(9) DEFAULT NULL,
  `weibo` bigint(9) DEFAULT NULL,
  `weixin` bigint(9) DEFAULT NULL,
  PRIMARY KEY (`organizationCode`,`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单位网站类型数据汇总表';
