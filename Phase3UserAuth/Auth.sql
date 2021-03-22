create database Auth;
use Auth;
CREATE TABLE `auth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY (`id`)
);
insert into auth (username, password) VALUES ("user", "pass");
insert into auth (username, password) VALUES ("philliam", "CR171C4L");
insert into auth (username, password) VALUES ("Totally Human", "Human words");