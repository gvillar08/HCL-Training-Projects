create database users;
use users;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(255) default NULL,
  `pass` varchar(255) default NULL,
  PRIMARY KEY (`id`)
);
insert into user (`user`, `pass`) VALUES ("user", "pass");

CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
insert into task (`task`, `desc`, `start`, `end`, `email`, `severity`, `user_id`) VALUES 
("My First Task", "I gotta do this thing ASAP", '2021-03-21', '2021-03-22', "example@example.com", "High", 1);
insert into task (`task`, `desc`, `start`, `end`, `email`, `severity`, `user_id`) VALUES 
("My second Task", "I gotta do this thing later", '2021-03-21', '2021-03-22', "example@example.com", "High", 1);