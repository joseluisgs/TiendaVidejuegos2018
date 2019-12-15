-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 15-05-2018 a las 12:56:44
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda2018`
--
CREATE DATABASE IF NOT EXISTS `tienda2018` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `tienda2018`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--
-- Creación: 15-05-2018 a las 10:28:39
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE IF NOT EXISTS `administrador` (
  `nAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` text COLLATE latin1_spanish_ci NOT NULL,
  `password` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`nAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`nAdmin`, `usuario`, `password`) VALUES
(1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--
-- Creación: 15-05-2018 a las 10:29:49
--

DROP TABLE IF EXISTS `juegos`;
CREATE TABLE IF NOT EXISTS `juegos` (
  `nJuego` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE latin1_spanish_ci NOT NULL,
  `distribuidor` text COLLATE latin1_spanish_ci NOT NULL,
  `precio` double NOT NULL,
  `fecha` text COLLATE latin1_spanish_ci NOT NULL,
  `foto` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`nJuego`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`nJuego`, `nombre`, `distribuidor`, `precio`, `fecha`, `foto`) VALUES
(1, 'Zelda ', 'Nintendo', 50.5, '05-may-2017', 'zelda.jpg'),
(2, 'Uncharted 5', 'Sony', 55.5, '01-may-2018', 'uncharted.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineaventas`
--
-- Creación: 15-05-2018 a las 10:31:13
--

DROP TABLE IF EXISTS `lineaventas`;
CREATE TABLE IF NOT EXISTS `lineaventas` (
  `nVenta` int(11) NOT NULL,
  `nJuego` int(11) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `lineaventas`
--

INSERT INTO `lineaventas` (`nVenta`, `nJuego`, `precio`, `cantidad`) VALUES
(1, 1, 50.5, 1),
(1, 2, 55.5, 1),
(2, 1, 50.5, 3),
(3, 1, 50.5, 1),
(3, 2, 55.5, 2),
(4, 1, 50.5, 4),
(4, 2, 55.5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--
-- Creación: 15-05-2018 a las 10:32:50
--

DROP TABLE IF EXISTS `socios`;
CREATE TABLE IF NOT EXISTS `socios` (
  `nSocio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE latin1_spanish_ci NOT NULL,
  `correo` text COLLATE latin1_spanish_ci NOT NULL,
  `password` text COLLATE latin1_spanish_ci NOT NULL,
  `telefono` text COLLATE latin1_spanish_ci NOT NULL,
  `fecha` text COLLATE latin1_spanish_ci NOT NULL,
  `foto` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`nSocio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`nSocio`, `nombre`, `correo`, `password`, `telefono`, `fecha`, `foto`) VALUES
(1, 'Pepe Perez', 'pepe@pepe.com', '7c9e7c1494b2684ab7c19d6aff737e460fa9e98d5a234da1310c97ddf5691834', '56789', '05/05/1990', 'socio.jpg'),
(2, 'Ana Anaya', 'ana@ana.com', '24d4b96f58da6d4a8512313bbd02a28ebf0ca95dec6e4c86ef78ce7f01e788ac', '123456', '04/04/1991', 'foto.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--
-- Creación: 15-05-2018 a las 10:35:48
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE IF NOT EXISTS `ventas` (
  `nVenta` int(11) NOT NULL AUTO_INCREMENT,
  `nSocio` int(11) NOT NULL,
  `total` double NOT NULL,
  `fecha` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`nVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`nVenta`, `nSocio`, `total`, `fecha`) VALUES
(0, 0, 0, '0'),
(1, 1, 106, '09-05-18'),
(2, 1, 151.5, '09-05-18'),
(3, 1, 161.5, '09-05-18'),
(4, 2, 313, '15-05-18');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
