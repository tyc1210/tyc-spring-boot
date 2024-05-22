CREATE TABLE `adminOperateLog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operatorName` varchar(50) DEFAULT NULL,
  `optIp` varchar(32) DEFAULT NULL,
  `optTime` datetime DEFAULT NULL,
  `optType` varchar(50) DEFAULT NULL,
  `optModule` varchar(50) DEFAULT NULL,
  `optContent` longtext,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4