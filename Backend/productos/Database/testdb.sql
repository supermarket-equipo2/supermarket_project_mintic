-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 03-10-2022 a las 05:05:02
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `testdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `apellido`, `email`, `nombre`, `telefono`) VALUES
(2, 'Ortiz', 'or@gmail.com', 'Camila', 1234567),
(3, 'Ospina', 'os@gmail.com', 'Carlos', 1234),
(4, 'Ospina', 'os@gmail.com', 'Carlos', 1234),
(5, 'Acevedo', 'ac@gmail.com', 'Jesús', 1234),
(8, 'Gomez', 'carla@gmail.com', 'Carla', 0),
(10, 'Gomez', 'fer@gmail.com', 'Fernando', 1234),
(11, 'Lopez', 'juana@gmail.com', 'Juana', 1234),
(12, 'Fernandez', 'pat@sanmarino.com', 'Patricia', 12345),
(13, 'Ramirez', 'lor@gmail.com', 'Lorena', 2341),
(14, 'Hernandez', 'fran@gmail.com', 'Francisco', 1234),
(15, 'Duque', 'duque@gmail.com', 'Carlos', 2341),
(16, 'DaSilva', 'lula@gmail.com', 'Lula', 1234),
(17, 'Vélez', 'lau@gmail.com', 'Laura', 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_price` float DEFAULT NULL,
  `proveedor_producto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `cantidad_producto`, `product_name`, `product_price`, `proveedor_producto`) VALUES
(3, 400, 'Manzana', 2500, 'Mercado Éxito'),
(7, 100, 'Pera', 1000, 'Mercado Éxito'),
(8, 20, 'Piña', 3000, 'La 14'),
(9, 20, 'Papa', 2000, 'Carulla'),
(10, 40, 'Melocotón', 2000, 'Tienda'),
(14, 40, 'Yuca', 3000, 'Mercado Mayorista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products_types`
--

CREATE TABLE `products_types` (
  `product_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `types`
--

CREATE TABLE `types` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `products_types`
--
ALTER TABLE `products_types`
  ADD PRIMARY KEY (`product_id`,`type_id`),
  ADD KEY `FK37oi9y75xyuto7swus75uk6nx` (`type_id`);

--
-- Indices de la tabla `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `types`
--
ALTER TABLE `types`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `products_types`
--
ALTER TABLE `products_types`
  ADD CONSTRAINT `FK37oi9y75xyuto7swus75uk6nx` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  ADD CONSTRAINT `FKcndtbnudsnvdsmh9e6ggi66u1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
