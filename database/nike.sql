-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2022-01-03 00:24:33
-- 服务器版本： 10.4.20-MariaDB
-- PHP 版本： 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `nike`
--

-- --------------------------------------------------------

--
-- 表的结构 `nike_order`
--

CREATE TABLE `nike_order` (
  `id` int(20) NOT NULL,
  `mid` int(20) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `cost_points` int(20) NOT NULL,
  `delivery_time` varchar(20) NOT NULL,
  `delivery_company` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `nike_order`
--

INSERT INTO `nike_order` (`id`, `mid`, `product_name`, `cost_points`, `delivery_time`, `delivery_company`) VALUES
(1, 1, 'Basketball', 50, '03-01-2022 21:04:30', 'Fast Delivery'),
(2, 1, 'AJ', 150, '05-01-2022 22:59:35', 'Fast Delivery'),
(3, 2, 'Basketball', 50, '05-01-2022 23:00:31', 'Fast Delivery');

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE `product` (
  `id` int(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `price` int(20) NOT NULL,
  `category` varchar(40) NOT NULL,
  `photo_path` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `category`, `photo_path`) VALUES
(1, 'AJ', 150, 'Shoes', ''),
(2, 'Basketball', 50, 'Sports', ''),
(3, 'Stephen Curry Jersey', 200, 'Jerseys', ''),
(4, 'Polos', 80, 'Clothing', ''),
(5, 'Shorts', 50, 'Clothing', '');

--
-- 转储表的索引
--

--
-- 表的索引 `nike_order`
--
ALTER TABLE `nike_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mid` (`mid`),
  ADD KEY `id` (`id`);

--
-- 表的索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `name` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
