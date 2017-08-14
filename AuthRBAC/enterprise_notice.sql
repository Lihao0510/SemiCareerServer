CREATE TABLE `enterprise_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_type` int(11) NOT NULL DEFAULT '0',
  `notice_date` datetime NOT NULL,
  `notice_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `notice_content` varchar(2000) COLLATE utf8_bin NOT NULL,
  `notice_author` varchar(20) COLLATE utf8_bin NOT NULL,
  `notice_pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COLLATE=utf8_bin