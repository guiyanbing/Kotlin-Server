#数据库创建
CREATE DATABASE `DaDa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

#用户表创建

use  dada;
#用户表创建
CREATE TABLE `user_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `user_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名（登录名）',
 `user_pwd` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码',
 `user_mobile` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号\n',
 `user_icon` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像\n',
 `user_real_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名\n',
 `user_identity_card` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证\n',
 `user_nick_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称\n',
 `user_gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
 `user_birthday` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '生日',
 `user_address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '居住地',
 `user_sign` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '个性签名\n',
 `push_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#购物车表创建
CREATE TABLE `cart_goods` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_count` int(11) DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 `goods_sku` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品分类创建
CREATE TABLE `category` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `category_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `category_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `parent_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品信息表创建
CREATE TABLE `goods_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `category_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_banner` text COLLATE utf8_unicode_ci,
 `goods_detail_one` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_detail_two` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_sales_count` int(11) DEFAULT NULL,
 `goods_stock_count` int(11) DEFAULT NULL,
 `goods_code` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_sku` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品sku表创建
CREATE TABLE `goods_sku` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_sku_title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_sku_content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#消息表创建
CREATE TABLE `message_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `msg_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#订单商品表创建
	CREATE TABLE `order_goods` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_count` int(11) DEFAULT NULL,
 `goods_sku` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `order_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#订单信息表创建
CREATE TABLE `order_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `user_id` int(11) DEFAULT NULL,
 `pay_type` int(11) DEFAULT NULL,
 `ship_id` int(11) DEFAULT NULL,
 `total_price` int(11) DEFAULT NULL,
 `order_status` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#地址管理表创建
	CREATE TABLE `ship_address` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `ship_user_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_user_mobile` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_is_default` int(11) DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


