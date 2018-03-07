DROP TABLE IF EXISTS mlscrm_customer;

CREATE TABLE mlscrm_customer (
  id int(10) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  name varchar(255) NOT NULL DEFAULT '',
  industry varchar(255) NOT NULL DEFAULT '' COMMENT '行业',
  rating int(10) NOT NULL COMMENT '评分',
  city_id int(10) NOT NULL DEFAULT 0 COMMENT '城市',
  owner_user_id int(10) NOT NULL DEFAULT 0,
  create_dt datetime NOT NULL COMMENT '建立时间',
  create_user_id int(10) NOT NULL COMMENT '建立人',
  deleted int(1) NOT NULL COMMENT '是否删除,1=正常,2=删除',
  locked int(1) NOT NULL COMMENT '是否锁定,1=正常,2=锁定',
  upd_user_id int(10) NOT NULL COMMENT '最新更新人',
  upd_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最新更新时间',
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='本表存放客户的相关信息';
