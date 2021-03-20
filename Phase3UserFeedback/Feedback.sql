create database Feedback;
use Feedback;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;

insert into feedback (comments, rating, user) VALUES ("Awesome", 10, "tim");
insert into feedback (comments, rating, user) VALUES ("Awesome 2", 10, "tim");
insert into feedback (comments, rating, user) VALUES ("Awesome 3", 10, "tim");