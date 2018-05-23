# Host: localhost  (Version: 5.5.53)
# Date: 2018-04-08 15:44:14
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "car"
#

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ca_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "car"
#

/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'小型车'),(2,'中型车');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

#
# Structure for table "client"
#

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(255) NOT NULL DEFAULT '未知',
  `cl_tel` varchar(255) NOT NULL DEFAULT '00000000000',
  `cl_company` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "client"
#

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'未知','13251509668',0),(3,'李守政','13251509667',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

#
# Structure for table "company"
#

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(255) NOT NULL DEFAULT '未知',
  `co_adminname` varchar(255) DEFAULT '未知',
  `co_admintel` varchar(255) DEFAULT '未知',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='集团';

#
# Data for table "company"
#

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'哈尔滨工程大学1','李守政','13251509667'),(3,'青岛科技园','袁野','15269272958');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

#
# Structure for table "emploee"
#

DROP TABLE IF EXISTS `emploee`;
CREATE TABLE `emploee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `em_name` varchar(255) DEFAULT NULL,
  `em_password` varchar(255) DEFAULT NULL,
  `em_priv` int(11) NOT NULL DEFAULT '0',
  `em_cartype` int(11) NOT NULL DEFAULT '0',
  `em_tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13251509668 DEFAULT CHARSET=utf8;

#
# Data for table "emploee"
#

/*!40000 ALTER TABLE `emploee` DISABLE KEYS */;
INSERT INTO `emploee` VALUES (2013201308,'李骥龙','d224bf2035155c246e0ba06d310d72ca',0,1,'18846041454'),(2013201309,'李骥龙','d224bf2035155c246e0ba06d310d72ca',1,1,'18846041462');
/*!40000 ALTER TABLE `emploee` ENABLE KEYS */;

#
# Structure for table "ta_order"
#

DROP TABLE IF EXISTS `ta_order`;
CREATE TABLE `ta_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `or_cid` int(11) NOT NULL DEFAULT '0',
  `or_eid` int(11) NOT NULL DEFAULT '0',
  `or_time` varchar(255) DEFAULT NULL,
  `or_start` varchar(255) DEFAULT NULL,
  `or_end` varchar(255) DEFAULT NULL,
  `or_sgps` varchar(255) DEFAULT NULL,
  `or_egps` varchar(255) DEFAULT NULL,
  `or_price` float DEFAULT NULL,
  `or_state` int(11) DEFAULT NULL,
  `or_check` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "ta_order"
#

/*!40000 ALTER TABLE `ta_order` DISABLE KEYS */;
INSERT INTO `ta_order` VALUES (7,3,2013201309,'2018-04-27 08:11','哈工程','哈尔滨火车站','45.779407,126.69488','45.767005,126.638881',1222,1,1),(8,3,2013201309,'2018-04-19 03:02','哈尔滨工程大学','哈尔滨工业大学','45.779654,126.697308','45.752641,126.637292',12,1,0),(9,3,2013201309,'2018-04-20 08:01','哈工程','黑工程','45.779407,126.69488','39.88372,116.674054',1212,0,0),(10,3,2013201309,'2018-04-26 08:22','北京北站','北京机场','39.951655,116.359489','40.085848,116.608774',1245,0,0),(11,3,2013201309,'2018-04-21 08:22','哈工程','青岛大学','45.779407,126.69488','36.076293,120.424278',12,2,0),(12,3,2013201309,'2018-04-21 08:22','哈工程','青岛大学','45.779407,126.69488','36.076293,120.424278',12,1,0),(13,3,2013201309,'2018-04-21 08:22','哈工程','青岛大学','45.779407,126.69488','36.076293,120.424278',12,2,0),(14,3,2013201309,'2018-04-24 08:59','哈工程','哈师大','45.779407,126.69488','45.872344,126.566175',12,2,0),(15,3,2013201309,'2018-04-21 03:02','哈尔滨工程大学','哈尔滨工业大学','45.779654,126.697308','45.752641,126.637292',120,2,0),(17,3,2013201309,'2018-04-13 01:01','哈尔滨工业大学','哈尔滨工程大学','45.752641,126.637292','45.779654,126.697308',122,2,0),(18,3,2013201309,'2018-04-20 01:01','哈尔滨工程大学','哈尔滨工业大学','45.782506,126.688328','45.765042,126.639549',12,0,0);
/*!40000 ALTER TABLE `ta_order` ENABLE KEYS */;
