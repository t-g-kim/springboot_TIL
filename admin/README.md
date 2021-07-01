### admin project

~~~
CREATE TABLE `admin_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'index',
  `account` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `last_login_at` datetime DEFAULT NULL,
  `login_fail_count` int DEFAULT NULL,
  `password_updated_at` datetime DEFAULT NULL,
  `registered_at` datetime DEFAULT NULL,
  `un_registered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `content` text COLLATE utf8mb4_bin NOT NULL,
  `price` decimal(12,4) NOT NULL,
  `brand_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `registered_at` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `partner_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `arrival_date` datetime NOT NULL,
  `quantity` int DEFAULT NULL,
  `total_price` decimal(12,4) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `order_group_id` bigint NOT NULL,
  `item_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `order_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `order_type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `rev_address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `rev_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `payment_type` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_price` decimal(12,4) DEFAULT NULL,
  `total_quantity` int DEFAULT NULL,
  `order_at` datetime DEFAULT NULL,
  `arrival_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `partner` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `call_center` varchar(13) COLLATE utf8mb4_bin DEFAULT NULL,
  `partner_number` varchar(13) COLLATE utf8mb4_bin DEFAULT NULL,
  `business_number` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL,
  `ceo_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `category_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~

~~~
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'index',
  `account` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `phone_number` varchar(13) COLLATE utf8mb4_bin NOT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
~~~
