CREATE DATABASE  IF NOT EXISTS `reimbursement` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reimbursement`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: reimbursement
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `id` varchar(255) NOT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `fileroad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jurisdiction`
--

DROP TABLE IF EXISTS `jurisdiction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jurisdiction` (
  `I_UUID` varchar(255) NOT NULL,
  `JTYPE` varchar(255) DEFAULT NULL,
  `JSTATE` varchar(255) DEFAULT NULL,
  `USERTYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`I_UUID`),
  KEY `FK6BE58B81ED59144F` (`USERTYPE`),
  CONSTRAINT `FK6BE58B81ED59144F` FOREIGN KEY (`USERTYPE`) REFERENCES `usertype` (`UT_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jurisdiction`
--

LOCK TABLES `jurisdiction` WRITE;
/*!40000 ALTER TABLE `jurisdiction` DISABLE KEYS */;
/*!40000 ALTER TABLE `jurisdiction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorcost`
--

DROP TABLE IF EXISTS `majorcost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `majorcost` (
  `M_UUID` varchar(255) NOT NULL,
  `PROJECT` varchar(255) DEFAULT NULL,
  `MAJORCOSTTYPE` varchar(255) DEFAULT NULL,
  `MCOST` int(11) DEFAULT NULL,
  `MSTATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`M_UUID`),
  KEY `FKCEC0F0E6E3CE004D` (`PROJECT`),
  KEY `FKCEC0F0E6EB75245B` (`MAJORCOSTTYPE`),
  CONSTRAINT `FKCEC0F0E6EB75245B` FOREIGN KEY (`MAJORCOSTTYPE`) REFERENCES `majorcosttype` (`MT_UUID`),
  CONSTRAINT `FKCEC0F0E6E3CE004D` FOREIGN KEY (`PROJECT`) REFERENCES `project` (`P_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorcost`
--

LOCK TABLES `majorcost` WRITE;
/*!40000 ALTER TABLE `majorcost` DISABLE KEYS */;
INSERT INTO `majorcost` VALUES ('1','2','1',15,'a'),('2','1','2',10,'a'),('3','1','1',15,'a'),('8ac2a6425d353dd0015d353e979f0001','8ac2a6425d353dd0015d353e97750000','1',1,'a'),('8ac2a6425d353dd0015d353e97ae0002','8ac2a6425d353dd0015d353e97750000','3',2,'a'),('8ac2a6425d353dd0015d353e97ca0003','8ac2a6425d353dd0015d353e97750000','4',9,'a'),('8ac2a6425d353dd0015d353f37440005','8ac2a6425d353dd0015d353f371a0004','1',10,'a'),('8ac2a6425d353dd0015d353f38220006','8ac2a6425d353dd0015d353f371a0004','3',10,'a'),('8ac2a6425d3540ca015d3541bed70001','8ac2a6425d3540ca015d3541bea70000','1',30,'d'),('8ac2a6425d3540ca015d3541bef60002','8ac2a6425d3540ca015d3541bea70000','3',20,'d'),('8ac2a6425d3a55a8015d3a573ac00001','8ac2a6425d3a55a8015d3a573a680000','1',350,'a'),('8ac2a6425d3a55a8015d3a573ae60002','8ac2a6425d3a55a8015d3a573a680000','3',150,'a'),('8ac2a6425d3a5f5a015d3a606ec20001','8ac2a6425d3a5f5a015d3a606e820000','1',20,'A'),('8ac2a6425d3a5f5a015d3a606f2f0002','8ac2a6425d3a5f5a015d3a606e820000','3',20,'A'),('8ac2a6425d3a5f5a015d3a6108160004','8ac2a6425d3a5f5a015d3a6107d70003','1',10,'d'),('8ac2a6425d3a5f5a015d3a61096e0005','8ac2a6425d3a5f5a015d3a6107d70003','3',20,'d'),('8ac2a6425d3a5f5a015d3a6109bc0006','8ac2a6425d3a5f5a015d3a6107d70003','4',30,'d'),('8ac2a6425d3a66f5015d3a682ae30001','8ac2a6425d3a66f5015d3a682ab30000','1',20,'A'),('8ac2a6425d3a66f5015d3a682af50002','8ac2a6425d3a66f5015d3a682ab30000','3',30,'A'),('8ac2a6425d3a66f5015d3a68df790004','8ac2a6425d3a66f5015d3a68df3e0003','1',5,'D'),('8ac2a6425d3a66f5015d3a68df9f0005','8ac2a6425d3a66f5015d3a68df3e0003','3',5,'D'),('8ac2a6425d3a66f5015d3a68e1010007','8ac2a6425d3a66f5015d3a68e0d20006','1',5,'D'),('8ac2a6425d3a66f5015d3a68e22a0008','8ac2a6425d3a66f5015d3a68e0d20006','3',5,'D'),('8ac2a6425d3a69e6015d3a6aa35d0001','8ac2a6425d3a69e6015d3a6aa31d0000','1',10,'A'),('8ac2a6425d3a69e6015d3a6aa39b0002','8ac2a6425d3a69e6015d3a6aa31d0000','3',10,'A'),('8ac2a6425d3a69e6015d3a6aa3ba0003','8ac2a6425d3a69e6015d3a6aa31d0000','4',20,'A'),('8ac2a6435d3ef239015d3ef351b30001','8ac2a6425d3a5f5a015d3a6107d70003','1',20,'A'),('8ac2a6435d3ef239015d3ef351c90002','8ac2a6425d3a5f5a015d3a6107d70003','3',40,'A');
/*!40000 ALTER TABLE `majorcost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorcosttype`
--

DROP TABLE IF EXISTS `majorcosttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `majorcosttype` (
  `MT_UUID` varchar(255) NOT NULL,
  `MTID` varchar(255) DEFAULT NULL,
  `MTTYPE` varchar(255) DEFAULT NULL,
  `MTSTATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MT_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorcosttype`
--

LOCK TABLES `majorcosttype` WRITE;
/*!40000 ALTER TABLE `majorcosttype` DISABLE KEYS */;
INSERT INTO `majorcosttype` VALUES ('1','1','伙食费','a'),('2','2','住宿费','d'),('3','3','差旅费','a'),('4','4','逛街费','a');
/*!40000 ALTER TABLE `majorcosttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `P_UUID` varchar(255) NOT NULL,
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `P_NAME` varchar(255) DEFAULT NULL,
  `PRESUSER` varchar(255) DEFAULT NULL,
  `PTYPE` varchar(255) DEFAULT NULL,
  `PFIELD` varchar(255) DEFAULT NULL,
  `PSOURCE` varchar(255) DEFAULT NULL,
  `PCOSTIDP` int(11) DEFAULT NULL,
  `PCOSTPUB` int(11) DEFAULT NULL,
  `PBEGINTIME` datetime DEFAULT NULL,
  `PENDTIME` datetime DEFAULT NULL,
  `PSTATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`P_UUID`),
  KEY `FK185BD6F92EA7258B` (`PRESUSER`),
  KEY `comp_index` (`pid`),
  CONSTRAINT `FK185BD6F92EA7258B` FOREIGN KEY (`PRESUSER`) REFERENCES `user` (`U_UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('1',1,'种田','1','农业','农林产业','农业部',5,10,'2015-05-01 00:00:00','2015-05-01 00:00:00','a'),('2',2,'割草','1','农业','农林产业','农业部',5,10,'2015-05-01 00:00:00','2015-05-01 00:00:00','a'),('3',3,'试飞','1','农业','农林产业','农业部',5,10,'2015-05-01 00:00:00','2015-05-01 00:00:00','a'),('8ac2a6425d34cd53015d34cdc8990000',18,'das','1','das','sda','xda',25,25,'2017-05-01 00:00:00','2018-05-01 00:00:00','d'),('8ac2a6425d34cd53015d34cef8b10003',19,'冬瓜种植','1','农业','农林产业','农业部',25,25,'2016-05-01 00:00:00','2016-09-01 00:00:00','d'),('8ac2a6425d353dd0015d353e97750000',20,'asd','1','sda','sa','das',6,6,'2017-05-01 00:00:00','2018-05-01 00:00:00','d'),('8ac2a6425d353dd0015d353f371a0004',21,'gdfg','1','asd','da','zd',10,10,'2017-05-01 00:00:00','2018-05-01 00:00:00','A'),('8ac2a6425d3540ca015d3541bea70000',22,'东山种植地开启','1','农业','农林产业','农业部',40,10,'2014-05-06 00:00:00','2015-05-06 00:00:00','d'),('8ac2a6425d3a55a8015d3a573a680000',23,'冬瓜种植','1','农业','农林产业','农业部',120,380,'2016-05-01 00:00:00','2017-05-01 00:00:00','N'),('8ac2a6425d3a5f5a015d3a606e820000',24,'冬瓜皮制造','1','制造生产','产品加工','加工部',10,30,'2015-05-01 00:00:00','2016-08-01 00:00:00','A'),('8ac2a6425d3a5f5a015d3a6107d70003',25,'冬瓜皮销售第二季','1','销售','销售','销售部',10,50,'2016-05-01 00:00:00','2017-04-02 00:00:00','N'),('8ac2a6425d3a66f5015d3a682ab30000',26,'冬瓜皮售后服务','1','销售','销售','销售部',10,40,'2015-05-01 00:00:00','2016-05-01 00:00:00','W'),('8ac2a6425d3a66f5015d3a68df3e0003',27,'冬瓜皮售后回收','1','销售','销售','销售部',0,20,'2016-02-01 00:00:00','2016-05-01 00:00:00','D'),('8ac2a6425d3a66f5015d3a68e0d20006',28,'冬瓜皮售后回收','1','销售','销售','销售部',0,20,'2016-02-01 00:00:00','2016-05-01 00:00:00','D'),('8ac2a6425d3a69e6015d3a6aa31d0000',29,'冬瓜皮售后回收','1','销售','销售','销售部',20,20,'2016-05-01 00:00:00','2017-05-01 00:00:00','W'),('8ac2a6435d3ede2c015d3ede98650000',30,'sda','1','dasd','sdas','ddas',20,30,'2016-05-01 00:00:00','2017-05-01 00:00:00','W');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reimbursement`
--

DROP TABLE IF EXISTS `reimbursement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reimbursement` (
  `R_UUID` varchar(255) NOT NULL,
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `RDATE` datetime DEFAULT NULL,
  `RCOSTALL` int(11) DEFAULT NULL,
  `RSTATE` varchar(255) DEFAULT NULL,
  `PROJECT` varchar(255) DEFAULT NULL,
  `RUSER` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`R_UUID`),
  KEY `FKA2E1C518E3CE004D` (`PROJECT`),
  KEY `FKA2E1C518813592CD` (`RUSER`),
  KEY `comp_index` (`rid`),
  CONSTRAINT `FKA2E1C518813592CD` FOREIGN KEY (`RUSER`) REFERENCES `user` (`U_UUID`),
  CONSTRAINT `FKA2E1C518E3CE004D` FOREIGN KEY (`PROJECT`) REFERENCES `project` (`P_UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimbursement`
--

LOCK TABLES `reimbursement` WRITE;
/*!40000 ALTER TABLE `reimbursement` DISABLE KEYS */;
INSERT INTO `reimbursement` VALUES ('8ac2a6435d3edec8015d3edf22410000',1,'2017-07-14 10:13:17',10,'A','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3ee374015d3ee415290000',2,'2017-07-14 10:18:41',50,'D','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3ee551015d3ee5b1760000',3,'2017-07-14 10:20:27',20,'D','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3ee551015d3ee61f7d0003',4,'2017-07-14 10:18:41',30,'A','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3ee839015d3ee90c000000',5,'2017-07-14 10:24:07',10,'N','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3f12f0015d3f137a510000',6,'2017-07-14 11:10:27',7,'N','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3f12f0015d3f137e6a0004',7,'2017-07-14 11:10:28',7,'D','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3f12f0015d3f13d4850008',8,'2017-07-14 11:10:51',5,'D','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3f12f0015d3f141b87000a',9,'2017-07-14 11:10:51',10,'D','8ac2a6425d3a55a8015d3a573a680000',NULL),('8ac2a6435d3f12f0015d3f1443d0000c',10,'2017-07-14 11:10:51',7,'A','8ac2a6425d3a55a8015d3a573a680000',NULL);
/*!40000 ALTER TABLE `reimbursement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcost`
--

DROP TABLE IF EXISTS `subcost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcost` (
  `S_UUID` varchar(255) NOT NULL,
  `REIMBURSEMENT` varchar(255) DEFAULT NULL,
  `SUBCOSTTYPE` varchar(255) DEFAULT NULL,
  `SCOST` int(11) DEFAULT NULL,
  `SSTATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`S_UUID`),
  KEY `FKBB72D9ED23E10229` (`SUBCOSTTYPE`),
  KEY `FKBB72D9EDCE05844B` (`REIMBURSEMENT`),
  CONSTRAINT `FKBB72D9EDCE05844B` FOREIGN KEY (`REIMBURSEMENT`) REFERENCES `reimbursement` (`R_UUID`),
  CONSTRAINT `FKBB72D9ED23E10229` FOREIGN KEY (`SUBCOSTTYPE`) REFERENCES `subcosttype` (`ST_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcost`
--

LOCK TABLES `subcost` WRITE;
/*!40000 ALTER TABLE `subcost` DISABLE KEYS */;
INSERT INTO `subcost` VALUES ('8ac2a6435d3edec8015d3edf22670001','8ac2a6435d3edec8015d3edf22410000','8ac2a6435d3edbd7015d3edccecf0002',5,'A'),('8ac2a6435d3edec8015d3edf22860002','8ac2a6435d3edec8015d3edf22410000','8ac2a6435d3edbd7015d3edc61e70000',5,'A'),('8ac2a6435d3ee374015d3ee415780001','8ac2a6435d3ee374015d3ee415290000','8ac2a6435d3edbd7015d3edc910c0001',50,'A'),('8ac2a6435d3ee551015d3ee5b1960001','8ac2a6435d3ee551015d3ee5b1760000','8ac2a6435d3edbd7015d3edc910c0001',10,'A'),('8ac2a6435d3ee551015d3ee5b1c50002','8ac2a6435d3ee551015d3ee5b1760000','8ac2a6435d3edbd7015d3edc61e70000',10,'A'),('8ac2a6435d3ee551015d3ee61f9c0004','8ac2a6435d3ee551015d3ee61f7d0003','8ac2a6435d3edbd7015d3edccecf0002',10,'A'),('8ac2a6435d3ee551015d3ee621790005','8ac2a6435d3ee551015d3ee61f7d0003','8ac2a6435d3edbd7015d3edc910c0001',20,'A'),('8ac2a6435d3ee839015d3ee90c300001','8ac2a6435d3ee839015d3ee90c000000','8ac2a6435d3edbd7015d3edc910c0001',5,'A'),('8ac2a6435d3ee839015d3ee90c3f0002','8ac2a6435d3ee839015d3ee90c000000','8ac2a6435d3edbd7015d3edc61e70000',5,'A'),('8ac2a6435d3f12f0015d3f137aa00001','8ac2a6435d3f12f0015d3f137a510000','8ac2a6435d3edbd7015d3edc910c0001',1,'A'),('8ac2a6435d3f12f0015d3f137c9d0002','8ac2a6435d3f12f0015d3f137a510000','8ac2a6435d3ef239015d3ef29bee0000',4,'A'),('8ac2a6435d3f12f0015d3f137d1a0003','8ac2a6435d3f12f0015d3f137a510000','8ac2a6435d3edbd7015d3edc61e70000',2,'A'),('8ac2a6435d3f12f0015d3f137f460005','8ac2a6435d3f12f0015d3f137e6a0004','8ac2a6435d3edbd7015d3edc910c0001',1,'A'),('8ac2a6435d3f12f0015d3f137f870006','8ac2a6435d3f12f0015d3f137e6a0004','8ac2a6435d3ef239015d3ef29bee0000',4,'A'),('8ac2a6435d3f12f0015d3f137fb00007','8ac2a6435d3f12f0015d3f137e6a0004','8ac2a6435d3edbd7015d3edc61e70000',2,'A'),('8ac2a6435d3f12f0015d3f13d4a40009','8ac2a6435d3f12f0015d3f13d4850008','8ac2a6435d3edbd7015d3edccecf0002',5,'A'),('8ac2a6435d3f12f0015d3f141b96000b','8ac2a6435d3f12f0015d3f141b87000a','8ac2a6435d3edbd7015d3edccecf0002',10,'A'),('8ac2a6435d3f12f0015d3f1443e0000d','8ac2a6435d3f12f0015d3f1443d0000c','8ac2a6435d3edbd7015d3edccecf0002',1,'A'),('8ac2a6435d3f12f0015d3f1443ff000e','8ac2a6435d3f12f0015d3f1443d0000c','8ac2a6435d3edbd7015d3edc910c0001',2,'A'),('8ac2a6435d3f12f0015d3f144554000f','8ac2a6435d3f12f0015d3f1443d0000c','8ac2a6435d3ef239015d3ef29bee0000',2,'A'),('8ac2a6435d3f12f0015d3f1445730010','8ac2a6435d3f12f0015d3f1443d0000c','8ac2a6435d3edbd7015d3edc61e70000',2,'A');
/*!40000 ALTER TABLE `subcost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcosttype`
--

DROP TABLE IF EXISTS `subcosttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcosttype` (
  `ST_UUID` varchar(255) NOT NULL,
  `STSID` varchar(255) DEFAULT NULL,
  `MAJORCOSTTYPE` varchar(255) DEFAULT NULL,
  `STTYPE` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ST_UUID`),
  KEY `FKB191A2A7EB75245B` (`MAJORCOSTTYPE`),
  CONSTRAINT `FKB191A2A7EB75245B` FOREIGN KEY (`MAJORCOSTTYPE`) REFERENCES `majorcosttype` (`MT_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcosttype`
--

LOCK TABLES `subcosttype` WRITE;
/*!40000 ALTER TABLE `subcosttype` DISABLE KEYS */;
INSERT INTO `subcosttype` VALUES ('8ac2a6435d3edbd7015d3edc61e70000','1','3','路费','A'),('8ac2a6435d3edbd7015d3edc910c0001','2','3','参观费','A'),('8ac2a6435d3edbd7015d3edccecf0002','3','1','饮料费','A'),('8ac2a6435d3ef239015d3ef29bee0000','5','3','ceshifeiyong','A');
/*!40000 ALTER TABLE `subcosttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `U_UUID` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `UNAME` varchar(255) DEFAULT NULL,
  `UPASSWORD` varchar(255) DEFAULT NULL,
  `USTATE` varchar(255) DEFAULT NULL,
  `USERTYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`U_UUID`),
  KEY `FK27E3CBED59144F` (`USERTYPE`),
  KEY `comp_index` (`uid`),
  CONSTRAINT `FK27E3CBED59144F` FOREIGN KEY (`USERTYPE`) REFERENCES `usertype` (`UT_UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1',1,'ris','1314','a','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `UT_UUID` varchar(255) NOT NULL,
  `UTTYPE` varchar(255) DEFAULT NULL,
  `USTATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UT_UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES ('1','教师','a'),('8ac2a6435d3edbd7015d3edd33960003','管理员','a');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-14 11:13:48
