CREATE TABLE `java-app`.`report_header` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `title` VARCHAR(200) NOT NULL,
                                            `type` VARCHAR(45) NOT NULL,
                                            `creation_date` DATETIME NOT NULL,
                                            `creation_user` INT NOT NULL,
                                            PRIMARY KEY (`id`));