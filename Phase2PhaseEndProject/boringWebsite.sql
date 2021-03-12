CREATE DATABASE boringWebsite;
CREATE TABLE boringWebsite.user (
	id  int(11) AUTO_INCREMENT,
	username VARCHAR(256),
	password VARCHAR(256),
	PRIMARY KEY (`id`)
);