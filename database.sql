CREATE TABLE `clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `clients` (`name`, `phone`, `email`, `password`) VALUES ('Carlos', '8388888888', 'cbgomes@gmail.com', '1234');
