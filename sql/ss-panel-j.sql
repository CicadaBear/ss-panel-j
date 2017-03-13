# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.42-log)
# Database: ss-panel-j
# Generation Time: 2017-03-13 03:19:18 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table sp_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sp_config`;

CREATE TABLE `sp_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(128) NOT NULL,
  `value` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table sp_email_verify
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sp_email_verify`;

CREATE TABLE `sp_email_verify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `token` varchar(64) NOT NULL,
  `expire_at` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table sp_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sp_log`;

CREATE TABLE `sp_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(16) NOT NULL,
  `msg` text NOT NULL,
  `created_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ss_checkin_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_checkin_log`;

CREATE TABLE `ss_checkin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `checkin_at` int(11) NOT NULL,
  `traffic` double NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ss_invite_code
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_invite_code`;

CREATE TABLE `ss_invite_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ss_invite_code` WRITE;
/*!40000 ALTER TABLE `ss_invite_code` DISABLE KEYS */;

INSERT INTO `ss_invite_code` (`id`, `code`, `user_id`, `created_at`, `updated_at`)
VALUES
	(1,'tuW3Bxty43pAuxvV9fXL15P8H6ZphAue',1,'2017-03-09 19:12:30','2017-03-09 19:12:30'),
	(2,'zv6041t5tK5EaOOrsGnlw4HQTexYLBBA',1,'2017-03-09 19:12:30','2017-03-09 19:12:30'),
	(6,'l12sb2RxB9afyAcyPgR59PvSv9Lyn1bu',1,'2017-03-10 00:53:32','2017-03-10 00:53:32'),
	(7,'kl0cKaW5gxGTvwVrUFfZMSY6ObgX7K6F',1,'2017-03-10 00:54:20','2017-03-10 00:54:20'),
	(8,'5oA0Hps1zhQjhiBASE2VUQ73ORowxcf6',1,'2017-03-10 00:57:13','2017-03-10 00:57:13'),
	(9,'zpjXyZfhDKubNtbmGiXcCbZpCCWpHEMH',1,'2017-03-10 01:12:53','2017-03-10 01:12:53'),
	(10,'TyJVUswSy68g0PNfqUOg46whL0NyER81',1,'2017-03-10 01:12:53','2017-03-10 01:12:53'),
	(18,'IXUUZMuCflvZEg3UvOnHAv3AYcaXtfXw',3,'2017-03-10 02:13:17','2017-03-10 02:13:17'),
	(19,'j2iYJBLUkbIf1a3KW6CmT7LPgrFcygi6',3,'2017-03-10 02:13:17','2017-03-10 02:13:17'),
	(20,'yBYKtwptjazqvv9MBgIqng5FkTcw6ri9',3,'2017-03-10 02:14:52','2017-03-10 02:14:52'),
	(21,'s2EZ3kzKUMzro9RAeHOqbTrHsdlOjFQ8',3,'2017-03-10 02:14:52','2017-03-10 02:14:52'),
	(22,'p33TUXdbf0ATvFglQWX6jcoM03zN6EUj',3,'2017-03-10 02:14:52','2017-03-10 02:14:52'),
	(23,'s7eZtUmLEYuaKguYT5j9K0suzgO1hims',3,'2017-03-10 02:14:52','2017-03-10 02:14:52'),
	(301,'YYEG0aKhB0ypvyga9lzYK6o2jUGPdyg4',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(302,'xHjMcpaB0seXtcrAGAzaiXNekeJ2PxNr',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(303,'nyxvHI5tDAY7rBBmOxxjINX2SiDtxcnc',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(304,'lLJ7hL3k1p5hntwjWp1WnETFGbMUaY9k',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(305,'xHxGeJMYJ4FdXlSxRoT1Hm5voFvBOuEf',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(306,'6pMtmsaZwVK4HKrbh0q0xzZsiPlnW6yI',1,'2017-03-10 18:43:04','2017-03-10 18:43:04'),
	(307,'3mwgiakBQTHtql8LXpIncVJLi5jDjA46',1,'2017-03-10 18:43:05','2017-03-10 18:43:05'),
	(308,'sOvVHgyT8rrPBQh2Gn36FbGiwujLH4ui',1,'2017-03-10 18:43:05','2017-03-10 18:43:05'),
	(309,'s0KxerMedEWNBznsL7vupilqgMHesCEV',1,'2017-03-10 18:43:05','2017-03-10 18:43:05'),
	(310,'29QfktY0Cu86AjBe8MBTCLTqp9iXw9uk',1,'2017-03-10 18:43:05','2017-03-10 18:43:05'),
	(476,'kewtfLEOvZtYwWWchQVXgZNVCGqH2OLD',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(477,'AuSMCkG2tl0eCgRMw186f4f1NbMOoDFv',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(478,'phHcSQ231CagGHIaO2Q6BTCobcuEHy8E',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(479,'nY38qCLwGHuKEZdDXssoWu06eoumvSoi',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(480,'nly479C54iM68aiBqp5NRdKKZ5HCBgOP',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(481,'9rJQoAyy2HpRids69hmar190eZpPvr2n',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(482,'6LO6ALo8d7OIzaWCnsTr20iVvcQXgx5A',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(483,'a15lVg9Vp7vzBZofb1X5Y855JyUDvKO8',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(484,'cCvQzTHmR15smCqL4snVlWN9XzEw59pG',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(485,'bwjhJotMuNF7yN5L7MSgsnfaAlVrSytc',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(486,'0bfbuswYiO2j2PyqPtpz9EcOqZiq6Otu',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(487,'4k5gnVPpUtw3jBRhktoDt8zdzewpbr1X',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(488,'M3ttSvMBBmvrF2oQcSnPROsyIWNja0FI',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(489,'mQ1h1MwcgmlLkUAPo27jse54LVWBwM9k',0,'2017-03-11 20:43:00','2017-03-11 20:43:00'),
	(490,'iis5rBenpEBRxbU20ralzByi7WXTTGQQ',0,'2017-03-11 20:43:00','2017-03-11 20:43:00');

/*!40000 ALTER TABLE `ss_invite_code` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ss_node
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_node`;

CREATE TABLE `ss_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `type` int(3) NOT NULL,
  `server` varchar(128) NOT NULL,
  `method` varchar(64) NOT NULL,
  `custom_method` tinyint(1) NOT NULL DEFAULT '0',
  `traffic_rate` float NOT NULL DEFAULT '1',
  `info` varchar(128) NOT NULL,
  `status` varchar(128) NOT NULL,
  `offset` int(11) NOT NULL DEFAULT '0',
  `sort` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `ss_node` WRITE;
/*!40000 ALTER TABLE `ss_node` DISABLE KEYS */;

INSERT INTO `ss_node` (`id`, `name`, `type`, `server`, `method`, `custom_method`, `traffic_rate`, `info`, `status`, `offset`, `sort`)
VALUES
	(1,'Test',1,'127.0.0.1','aes-256-cfb',1,1,'info','status',0,0),
	(2,'test3',1,'127.0.0.1','rc4-md5',0,1,'info','status',0,0),
	(3,'test4',1,'127.0.0.1','rc4-md5',0,1,'desc','status',0,0),
	(4,'test5',1,'127.0.0.1','rc4-md5',0,1,'desc','status',0,0),
	(5,'test5',1,'127.0.0.1','rc4-md5',0,1,'desc','status',0,0),
	(6,'test5',1,'127.0.0.1','rc4-md5',0,1,'desc','status',0,0);

/*!40000 ALTER TABLE `ss_node` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ss_node_info_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_node_info_log`;

CREATE TABLE `ss_node_info_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node_id` int(11) NOT NULL,
  `uptime` float NOT NULL,
  `load` varchar(32) NOT NULL,
  `log_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ss_node_online_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_node_online_log`;

CREATE TABLE `ss_node_online_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node_id` int(11) NOT NULL,
  `online_user` int(11) NOT NULL,
  `log_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ss_password_reset
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ss_password_reset`;

CREATE TABLE `ss_password_reset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `token` varchar(128) NOT NULL,
  `init_time` int(11) NOT NULL,
  `expire_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) CHARACTER SET utf8mb4 NOT NULL,
  `email` varchar(32) NOT NULL,
  `pass` varchar(64) NOT NULL,
  `passwd` varchar(32) NOT NULL DEFAULT '',
  `t` int(11) NOT NULL DEFAULT '0',
  `u` bigint(20) NOT NULL,
  `d` bigint(20) NOT NULL,
  `transfer_enable` bigint(20) NOT NULL,
  `port` int(11) NOT NULL,
  `protocol` varchar(32) NOT NULL DEFAULT 'origin',
  `obfs` varchar(32) NOT NULL DEFAULT 'plain',
  `switch` tinyint(4) NOT NULL DEFAULT '1',
  `enable` tinyint(4) NOT NULL DEFAULT '1',
  `type` tinyint(4) NOT NULL DEFAULT '1',
  `last_get_gift_time` int(11) NOT NULL DEFAULT '0',
  `last_check_in_time` int(11) NOT NULL DEFAULT '0',
  `last_rest_pass_time` int(11) NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `invite_num` int(8) NOT NULL DEFAULT '0',
  `is_admin` int(2) NOT NULL DEFAULT '0',
  `ref_by` int(11) NOT NULL DEFAULT '0',
  `expire_time` int(11) NOT NULL DEFAULT '0',
  `method` varchar(64) NOT NULL DEFAULT 'rc4-md5',
  `is_email_verify` tinyint(4) NOT NULL DEFAULT '0',
  `reg_ip` varchar(128) NOT NULL DEFAULT '127.0.0.1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `port` (`port`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `user_name`, `email`, `pass`, `passwd`, `t`, `u`, `d`, `transfer_enable`, `port`, `protocol`, `obfs`, `switch`, `enable`, `type`, `last_get_gift_time`, `last_check_in_time`, `last_rest_pass_time`, `reg_date`, `invite_num`, `is_admin`, `ref_by`, `expire_time`, `method`, `is_email_verify`, `reg_ip`)
VALUES
	(1,'admin12346','jack@cicadabear.cc','f0a132','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1025,'origin','plain',1,1,1,0,0,0,'2017-03-04 12:43:27',3,1,0,0,'rc4-md5',0,'127.0.0.1'),
	(2,'Jack','cicadabear@163.com','f0a132','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1026,'origin','plain',0,1,0,0,0,0,'2017-03-10 01:48:54',5,0,0,0,'rc4-md5',0,'127.0.0.1'),
	(3,'JackLee','jiajia@cicadabear.cc','7IQ8Iw','96e79218965eb72c92a549dd5a330112',0,0,0,5368709120,1027,'origin','plain',0,1,0,0,0,0,'2017-03-10 02:07:27',0,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(4,'Jia','1@cicadabear.cc','BmxxXk','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1028,'origin','plain',0,1,0,0,0,0,'2017-03-10 02:22:31',5,0,3,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(9,'CicadaBear','123@cicadabear.cc','azRMDd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1029,'origin','plain',0,1,0,0,0,0,'2017-03-10 04:04:37',5,0,3,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(10,'CicadaBear','122@cicadabear.cc','LOJ8BE','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1030,'origin','plain',0,1,0,0,0,0,'2017-03-10 04:06:00',5,0,3,0,'rc4-md5',0,'127.0.0.1'),
	(12,'CicadaBear','124@cicadabear.cc','cBM7le','96e79218965eb72c92a549dd5a330112',0,0,0,5368709120,1031,'origin','plain',0,1,0,0,0,0,'2017-03-10 04:13:54',5,0,3,0,'rc4-md5',0,'127.0.0.1'),
	(13,'Jack0','jack0@cicadabear.cc','z1Uw03','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1032,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:10',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(14,'Jack1','jack1@cicadabear.cc','b6SQj1','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1033,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(17,'Jack4','jack4@cicadabear.cc','qTsni9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5,1036,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,1,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(18,'Jack5','jack5@cicadabear.cc','nBgdBt','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1037,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(19,'Jack6','jack6@cicadabear.cc','KnHMDu','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1038,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(20,'Jack7','jack7@cicadabear.cc','98WC9P','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1039,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(21,'Jack8','jack8@cicadabear.cc','XuLich','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1040,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(22,'Jack9','jack9@cicadabear.cc','qaLLxm','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1041,'origin','plain',0,1,0,0,0,0,'2017-03-11 16:02:11',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(23,'Jack10','jack10@cicadabear.cc','c5OMMg','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1042,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(24,'Jack11','jack11@cicadabear.cc','DKECxB','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1043,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(25,'Jack12','jack12@cicadabear.cc','wdUnEm','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1044,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(26,'Jack13','jack13@cicadabear.cc','iORbgz','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1045,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(27,'Jack14','jack14@cicadabear.cc','LUm5Sp','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1046,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(28,'Jack15','jack15@cicadabear.cc','kYkOVs','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1047,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(29,'Jack16','jack16@cicadabear.cc','XaLLe2','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1048,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(30,'Jack17','jack17@cicadabear.cc','UtwiPd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1049,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(31,'Jack18','jack18@cicadabear.cc','d6v95s','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1050,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(32,'Jack19','jack19@cicadabear.cc','dapl2o','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1051,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(33,'Jack20','jack20@cicadabear.cc','mGOi9S','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1052,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(34,'Jack21','jack21@cicadabear.cc','AvwFy8','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1053,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:14',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(35,'Jack22','jack22@cicadabear.cc','H8GVvh','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1054,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(36,'Jack23','jack23@cicadabear.cc','v26RuS','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1055,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(37,'Jack24','jack24@cicadabear.cc','DVma3B','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1056,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(38,'Jack25','jack25@cicadabear.cc','9n6OuY','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1057,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(39,'Jack26','jack26@cicadabear.cc','PCpicq','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1058,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(40,'Jack27','jack27@cicadabear.cc','G1ksZD','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1059,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(41,'Jack28','jack28@cicadabear.cc','kvtDwx','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1060,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(42,'Jack29','jack29@cicadabear.cc','cKmrmI','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1061,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(43,'Jack30','jack30@cicadabear.cc','qyiwH8','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1062,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(44,'Jack31','jack31@cicadabear.cc','mFfm3w','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1063,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(45,'Jack32','jack32@cicadabear.cc','sSXnc9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1064,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(46,'Jack33','jack33@cicadabear.cc','7jBcYo','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1065,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(47,'Jack34','jack34@cicadabear.cc','OKrdy3','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1066,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(48,'Jack35','jack35@cicadabear.cc','cGyUE1','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1067,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(49,'Jack36','jack36@cicadabear.cc','NzSBWk','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1068,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(50,'Jack37','jack37@cicadabear.cc','JKe07H','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1069,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(51,'Jack38','jack38@cicadabear.cc','4z5gNJ','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1070,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:15',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(52,'Jack39','jack39@cicadabear.cc','DlpClY','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1071,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(53,'Jack40','jack40@cicadabear.cc','ipBVU9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1072,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(54,'Jack41','jack41@cicadabear.cc','BZU3BE','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1073,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(55,'Jack42','jack42@cicadabear.cc','MPG7zO','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1074,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(56,'Jack43','jack43@cicadabear.cc','dBuXOD','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1075,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(57,'Jack44','jack44@cicadabear.cc','NSVQCV','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1076,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(58,'Jack45','jack45@cicadabear.cc','sSpzwr','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1077,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(59,'Jack46','jack46@cicadabear.cc','p5hxB8','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1078,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(60,'Jack47','jack47@cicadabear.cc','bnZKym','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1079,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(61,'Jack48','jack48@cicadabear.cc','s2vafN','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1080,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(62,'Jack49','jack49@cicadabear.cc','oZEmxZ','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1081,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(63,'Jack50','jack50@cicadabear.cc','zjlPHV','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1082,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(64,'Jack51','jack51@cicadabear.cc','NXTtFB','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1083,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(65,'Jack52','jack52@cicadabear.cc','ICzsUG','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1084,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(66,'Jack53','jack53@cicadabear.cc','LTowJH','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1085,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(67,'Jack54','jack54@cicadabear.cc','AGvwmd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1086,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(68,'Jack55','jack55@cicadabear.cc','M1wLVl','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1087,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(69,'Jack56','jack56@cicadabear.cc','NlnNsi','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1088,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(70,'Jack57','jack57@cicadabear.cc','iySJOi','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1089,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(71,'Jack58','jack58@cicadabear.cc','mr4qMq','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1090,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(72,'Jack59','jack59@cicadabear.cc','tk0qmK','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1091,'origin','plain',0,1,0,0,0,0,'2017-03-11 18:56:16',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(74,'Jack60','jack60@cicadabear.cc','glWQdS','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1092,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(75,'Jack61','jack61@cicadabear.cc','7cAPay','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1093,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(76,'Jack62','jack62@cicadabear.cc','ES3Y3Z','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1094,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(77,'Jack63','jack63@cicadabear.cc','cHzQxI','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1095,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(78,'Jack64','jack64@cicadabear.cc','tMWfuQ','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1096,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(79,'Jack65','jack65@cicadabear.cc','7j3KRM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1097,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(80,'Jack66','jack66@cicadabear.cc','sk9NRw','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1098,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(81,'Jack67','jack67@cicadabear.cc','U8G3pq','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1099,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(82,'Jack68','jack68@cicadabear.cc','mORUq6','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1100,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(83,'Jack69','jack69@cicadabear.cc','rmolid','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1101,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:41:24',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(84,'Jack296','jack296@cicadabear.cc','1kdFsT','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1102,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:00',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(85,'Jack297','jack297@cicadabear.cc','DXcZlF','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1103,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:00',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(86,'Jack298','jack298@cicadabear.cc','07sNVg','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1104,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:00',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(87,'Jack299','jack299@cicadabear.cc','opiNf7','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1105,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(88,'Jack300','jack300@cicadabear.cc','PxmmLh','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1106,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(89,'Jack311','jack311@cicadabear.cc','GRETbe','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1107,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(90,'Jack312','jack312@cicadabear.cc','dKeTXj','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1108,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(91,'Jack313','jack313@cicadabear.cc','McTssd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1109,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(92,'Jack314','jack314@cicadabear.cc','SLmTfz','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1110,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(93,'Jack315','jack315@cicadabear.cc','A7IM6i','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1111,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(94,'Jack366','jack366@cicadabear.cc','FLNf4I','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1112,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(95,'Jack367','jack367@cicadabear.cc','MA67Hp','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1113,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(96,'Jack368','jack368@cicadabear.cc','x3NBLd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1114,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(97,'Jack369','jack369@cicadabear.cc','6RGT5k','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1115,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(98,'Jack370','jack370@cicadabear.cc','0IedQq','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1116,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(99,'Jack371','jack371@cicadabear.cc','jnmbkF','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1117,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(100,'Jack372','jack372@cicadabear.cc','K5BYWp','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1118,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(101,'Jack373','jack373@cicadabear.cc','V6Lf5L','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1119,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(102,'Jack374','jack374@cicadabear.cc','KrxzLn','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1120,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(103,'Jack375','jack375@cicadabear.cc','awHVdt','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1121,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(104,'Jack376','jack376@cicadabear.cc','1cf4ct','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1122,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(105,'Jack377','jack377@cicadabear.cc','MRUPkX','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1123,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(106,'Jack378','jack378@cicadabear.cc','PFTIH9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1124,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(107,'Jack379','jack379@cicadabear.cc','GcwDiW','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1125,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(108,'Jack380','jack380@cicadabear.cc','OCiZWJ','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1126,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(109,'Jack381','jack381@cicadabear.cc','OZDEwG','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1127,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(110,'Jack382','jack382@cicadabear.cc','tdGeAn','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1128,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(111,'Jack383','jack383@cicadabear.cc','5UVQp0','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1129,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(112,'Jack384','jack384@cicadabear.cc','qeacNK','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1130,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(113,'Jack385','jack385@cicadabear.cc','oaxaxk','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1131,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(114,'Jack386','jack386@cicadabear.cc','uu7MdA','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1132,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(115,'Jack387','jack387@cicadabear.cc','bkAT7e','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1133,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(116,'Jack388','jack388@cicadabear.cc','zhZk3O','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1134,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(117,'Jack389','jack389@cicadabear.cc','sJPBiU','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1135,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:01',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(118,'Jack390','jack390@cicadabear.cc','a3A05A','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1136,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(119,'Jack391','jack391@cicadabear.cc','yqrQ9P','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1137,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(120,'Jack392','jack392@cicadabear.cc','rt8RXx','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1138,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(121,'Jack393','jack393@cicadabear.cc','oOQCq0','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1139,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(122,'Jack394','jack394@cicadabear.cc','iHHmir','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1140,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(123,'Jack395','jack395@cicadabear.cc','WDH9HL','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1141,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(124,'Jack396','jack396@cicadabear.cc','MPVqR2','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1142,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(125,'Jack397','jack397@cicadabear.cc','B3Cq5x','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1143,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(126,'Jack398','jack398@cicadabear.cc','SEVQiL','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1144,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(127,'Jack399','jack399@cicadabear.cc','TpOw5a','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1145,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(128,'Jack400','jack400@cicadabear.cc','ct1pZA','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1146,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(129,'Jack401','jack401@cicadabear.cc','2Hwb2U','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1147,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(130,'Jack402','jack402@cicadabear.cc','tythQx','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1148,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(131,'Jack403','jack403@cicadabear.cc','MWeh38','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1149,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(132,'Jack404','jack404@cicadabear.cc','zAOz6X','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1150,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(133,'Jack405','jack405@cicadabear.cc','EWsnqV','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1151,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(134,'Jack406','jack406@cicadabear.cc','SzGNp2','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1152,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(135,'Jack407','jack407@cicadabear.cc','lh1yF7','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1153,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(136,'Jack408','jack408@cicadabear.cc','5vZNWM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1154,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(137,'Jack409','jack409@cicadabear.cc','7bSbw9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1155,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(138,'Jack410','jack410@cicadabear.cc','NxVrTm','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1156,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(139,'Jack411','jack411@cicadabear.cc','Q6vcyB','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1157,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(140,'Jack412','jack412@cicadabear.cc','OzrlYm','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1158,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(141,'Jack413','jack413@cicadabear.cc','Z4KAdK','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1159,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(142,'Jack414','jack414@cicadabear.cc','tvbUQA','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1160,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(143,'Jack415','jack415@cicadabear.cc','na0goM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1161,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(144,'Jack426','jack426@cicadabear.cc','ovf2V9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1162,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(145,'Jack427','jack427@cicadabear.cc','qHCp8D','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1163,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(146,'Jack428','jack428@cicadabear.cc','eGQByv','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1164,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(147,'Jack429','jack429@cicadabear.cc','afMb8M','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1165,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(148,'Jack430','jack430@cicadabear.cc','e2fErc','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1166,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(149,'Jack431','jack431@cicadabear.cc','fllMwP','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1167,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(150,'Jack432','jack432@cicadabear.cc','sYLAsp','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1168,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:02',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(151,'Jack433','jack433@cicadabear.cc','32x3ee','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1169,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(152,'Jack434','jack434@cicadabear.cc','lp83Bn','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1170,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(153,'Jack435','jack435@cicadabear.cc','UbJtDz','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1171,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(154,'Jack436','jack436@cicadabear.cc','DR1IZJ','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1172,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(155,'Jack437','jack437@cicadabear.cc','3ZfaPd','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1173,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(156,'Jack438','jack438@cicadabear.cc','sywz5Q','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1174,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(157,'Jack439','jack439@cicadabear.cc','HskJsS','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1175,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(158,'Jack440','jack440@cicadabear.cc','vVC5rW','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1176,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(159,'Jack441','jack441@cicadabear.cc','JerStE','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1177,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(160,'Jack442','jack442@cicadabear.cc','vQzGvh','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1178,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(161,'Jack443','jack443@cicadabear.cc','4iTkqj','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1179,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(162,'Jack444','jack444@cicadabear.cc','RAiva4','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1180,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(163,'Jack445','jack445@cicadabear.cc','63oVai','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1181,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(164,'Jack446','jack446@cicadabear.cc','82ASRO','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1182,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(165,'Jack447','jack447@cicadabear.cc','mpsTl4','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1183,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(166,'Jack448','jack448@cicadabear.cc','iR4dGf','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1184,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(167,'Jack449','jack449@cicadabear.cc','VMxgVw','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1185,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(168,'Jack450','jack450@cicadabear.cc','Mr4sPN','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1186,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(169,'Jack451','jack451@cicadabear.cc','wMMRwy','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1187,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(170,'Jack452','jack452@cicadabear.cc','vbBjaj','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1188,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(171,'Jack453','jack453@cicadabear.cc','OzJwjW','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1189,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(172,'Jack454','jack454@cicadabear.cc','uCRrxj','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1190,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(173,'Jack455','jack455@cicadabear.cc','GsoRVt','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1191,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(174,'Jack456','jack456@cicadabear.cc','bzlFUy','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1192,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(175,'Jack457','jack457@cicadabear.cc','cFzQ4c','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1193,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(176,'Jack458','jack458@cicadabear.cc','kTjWUV','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1194,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(177,'Jack459','jack459@cicadabear.cc','CKg2Xk','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1195,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(178,'Jack460','jack460@cicadabear.cc','etu2I3','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1196,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(179,'Jack461','jack461@cicadabear.cc','HNI997','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1197,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(180,'Jack462','jack462@cicadabear.cc','odtog9','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1198,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(181,'Jack463','jack463@cicadabear.cc','58y9kA','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1199,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(182,'Jack464','jack464@cicadabear.cc','XcX1RO','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1200,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:03',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(183,'Jack465','jack465@cicadabear.cc','qQrWDw','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1201,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(184,'Jack466','jack466@cicadabear.cc','Wu1nae','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1202,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(185,'Jack467','jack467@cicadabear.cc','vUedLM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1203,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(186,'Jack468','jack468@cicadabear.cc','q2lUpq','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1204,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(187,'Jack469','jack469@cicadabear.cc','xuVcTf','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1205,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(188,'Jack470','jack470@cicadabear.cc','npNs5s','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1206,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(189,'Jack471','jack471@cicadabear.cc','lfRinw','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1207,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(190,'Jack472','jack472@cicadabear.cc','lgCD8U','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1208,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(191,'Jack473','jack473@cicadabear.cc','JZW4IM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1209,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(192,'Jack474','jack474@cicadabear.cc','pohlhM','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1210,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1'),
	(193,'Jack475','jack475@cicadabear.cc','qKtZ82','e10adc3949ba59abbe56e057f20f883e',0,0,0,5368709120,1211,'origin','plain',0,1,0,0,0,0,'2017-03-11 20:43:04',5,0,0,0,'rc4-md5',0,'0:0:0:0:0:0:0:1');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_token
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_token`;

CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(256) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` int(11) NOT NULL,
  `expire_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user_traffic_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_traffic_log`;

CREATE TABLE `user_traffic_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `u` int(11) NOT NULL,
  `d` int(11) NOT NULL,
  `node_id` int(11) NOT NULL,
  `rate` float NOT NULL,
  `traffic` varchar(32) NOT NULL,
  `log_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
