### 인프런 강의

https://www.inflearn.com/course/backend-%EC%86%A1%EC%9E%90%EB%B0%94/dashboard



~~~
CREATE TABLE `web1`.`Board` (
  `boardSeq` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `contents` VARCHAR(45) NULL,
  `reg_date` DATETIME NULL,
  PRIMARY KEY (`boardSeq`));
~~~
~~~
INSERT INTO `Board` (`board_seq`, `title`, `contents`, `reg_date`)
VALUES
	(1, X'31EBB288ECA7B8', X'31EBB288ECA7B820EB93B1EBA19DEC9E85EB8B88EB8BA42E', '2021-06-22 23:00:06');

~~~

