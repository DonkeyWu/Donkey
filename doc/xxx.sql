CREATE TABLE t_cache (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `json_key` varchar(60) NOT NULL COMMENT '动作名称',
  `json_value` varchar(200) DEFAULT NULL COMMENT '动作含义',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='缓存';

alter table t_cache add index index_json_key(json_key) ;