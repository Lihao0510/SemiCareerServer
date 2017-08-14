CREATE TABLE `sys_auths` (
  `auth_id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(20) NOT NULL,
  `auth_type` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`auth_id`),
  KEY `index_authname` (`auth_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10000;

ALTER TABLE sys_auths ADD UNIQUE KEY(auth_name, auth_type);

