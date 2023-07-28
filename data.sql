DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(20) DEFAULT NULL,
                        `password` varchar(20) DEFAULT NULL,
                        `age` int(11) DEFAULT NULL,
                        `sex` char(1) DEFAULT NULL,
                        `email` varchar(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
                        `did` int(11) NOT NULL AUTO_INCREMENT,
                        `dept_name` varchar(20) DEFAULT NULL,
                        PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
                       `eid` int(11) NOT NULL AUTO_INCREMENT,
                       `emp_name` varchar(20) DEFAULT NULL,
                       `age` int(11) DEFAULT NULL,
                       `sex` char(1) DEFAULT NULL,
                       `email` varchar(20) DEFAULT NULL,
                       `did` int(11) DEFAULT NULL,
                       PRIMARY KEY (`eid`),
                       KEY `fk_did` (`did`),
                       CONSTRAINT `fk_did` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `dept` (`did`, `dept_name`) VALUES (1, 'A');
INSERT INTO `dept` (`did`, `dept_name`) VALUES (2, 'B');
INSERT INTO `dept` (`did`, `dept_name`) VALUES (3, 'C');
COMMIT;

BEGIN;
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (1, 'Jack', 24, 'M', '123@qq.com', 1);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (2, 'Mary', 23, 'F', '123@qq.com', 1);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (3, 'Tom', 25, 'M', '123@qq.com', 1);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (4, 'Bruce', 22, 'M', '123@qq.com', 2);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (5, 'Lucy', 23, 'F', '123@qq.com', 3);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (6, 'Jeny', 21, 'F', '123@qq.com', 2);
INSERT INTO `emp` (`eid`, `emp_name`, `age`, `sex`, `email`, `did`) VALUES (7, 'Bob', 24, 'M', '123@qq.com', 2);
COMMIT;