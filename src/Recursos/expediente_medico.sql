-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2019 a las 23:51:24
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `expediente_medico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alergias`
--

CREATE TABLE IF NOT EXISTS `alergias` (
  `Descripcion` text COLLATE utf8_spanish2_ci,
  `ID` int(1) NOT NULL,
  `CURP` varchar(18) COLLATE utf8_spanish2_ci NOT NULL,
  `Alergia` varchar(30) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `alergias`
--

INSERT INTO `alergias` (`Descripcion`, `ID`, `CURP`, `Alergia`) VALUES
('Estornudos incontrolables.', 1, 'FUAN820323MGRNLT05', 'Polen'),
('hinchazón facial', 1, 'FOLN620313HSRLYX00', 'penicilina'),
('Hinchazón facial', 1, 'VABI820909HGRZLL07', 'Penicilina'),
('Hinchazón facial', 1, 'AABU841027HMCLSR03', 'Miel '),
('Hinchazón facial', 1, 'AECM820304HGRCMG01', 'Penicilina'),
('Amigdalitis', 1, 'HECL750205HGRRRS04', 'Paracetamol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cirugias`
--

CREATE TABLE IF NOT EXISTS `cirugias` (
  `CURP` varchar(18) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `CIRUGIA` text COLLATE utf8_spanish_ci NOT NULL,
  `HOSPITAL` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ID` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cirugias`
--

INSERT INTO `cirugias` (`CURP`, `FECHA`, `CIRUGIA`, `HOSPITAL`, `ID`) VALUES
('FUAN820323MGRNLT05', '24/03/2005', 'Apéndice', 'IMSS', 1),
('GANM780401HGRLVR06', '14/09/2008', 'Extracción de anginas', 'Hospital de los Ángeles', 1),
('FOAJ780210HGRLDR09', '14/10/1999', 'Fractura de brazo', 'IMSS', 1),
('CABL860422MVZSRZ18', '23/01/1999', 'Extracción de apéndice', 'ISSTE', 1),
('CABE830602HGRBTM06', '21/09/2001', 'Próstata', 'IMSS', 1),
('AECM820304HGRCMG01', '23/11/2001', 'Extracción de apéndice', 'Seguro Social', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expediente`
--

CREATE TABLE IF NOT EXISTS `expediente` (
  `CLUES` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `CURP` varchar(18) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `EDAD` int(11) NOT NULL,
  `SEXO` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `ESTADO_CIVIL` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `NACIONALIDAD` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `DIRECCION` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `CODIGO_POSTAL` int(11) NOT NULL,
  `TELEFONO` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `PESO` float NOT NULL,
  `ESTATURA` float NOT NULL,
  `TIPO_SANGRE` varchar(5) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `expediente`
--

INSERT INTO `expediente` (`CLUES`, `CURP`, `NOMBRE`, `EDAD`, `SEXO`, `ESTADO_CIVIL`, `NACIONALIDAD`, `DIRECCION`, `CODIGO_POSTAL`, `TELEFONO`, `PESO`, `ESTATURA`, `TIPO_SANGRE`) VALUES
('URTOO987456', 'FUAN820323MGRNLT05', 'Fuentes Almazan Natividad', 32, 'F', 'Casado', 'Mexicana', 'Venustiano Carranza #301 Centro', 54890, '6745009834', 68.8, 1.65, 'A-'),
('URTOO987456', 'FOLN620313HSRLYX00', 'Flores Leyva Noe', 28, 'F', 'Soltero', 'Mexicana', '3 Poniente #409. Acámbaro', 57489, '6114390087', 74.6, 1.8, 'O+'),
('URTOO987456', 'GANM780401HGRLVR06', 'Galarce Nava Mario Alberto', 54, 'F', 'Divorciado', 'Mexicana', 'Privada Rosas #201. San José', 15200, '4503699852', 75, 1.6, 'B+'),
('URTOO987456', 'FOAJ780210HGRLDR09', 'Flores Adame Jorge Luis', 43, 'F', 'Soltero', 'Mexicana', 'Privada Flores #101. Bugambilias', 74250, '2293016545', 69.8, 1.8, 'O-'),
('URTOO987456', 'VABI820909HGRZLL07', 'Vazquez Bailon Ioel', 23, 'F', 'Soltero', 'Mexicana', 'Benito Juárez #901. San Martín', 89526, '4782015874', 56, 1.7, 'A+'),
('URTOO987456', 'CABL860422MVZSRZ18', 'Casas Barojas Luz del Carmen', 43, 'F', 'Casado', 'Mexicana', 'Noria #201. Juaréz', 48523, '8561024682', 68, 1.6, 'A-'),
('URTOO987456', 'AABU841027HMCLSR03', 'Alcantara Basilio Uriel Gerardo', 37, 'F', 'Casado', 'Mexicana', 'Juaréz #901. Centro Sur', 52630, '7846932541', 59, 1.68, 'A-'),
('URTOO987456', 'CABE830602HGRBTM06', 'Cabrera Bautista Emeterio', 60, 'F', 'Viudo', 'Mexicana', 'Universidades #201. Árboledas', 58693, '7531598246', 70, 1.6, 'O-'),
('URTOO987456', 'GABO810802HGRRRM06', 'García Berruecos Omar', 26, 'F', 'Soltero', 'Mexicana', 'Árboledas #210. Siempre Viva', 47852, '1027893610', 60, 1.7, 'B-'),
('URTOO987456', 'AECM820304HGRCMG01', 'Acevedo Campos Miguel Ángel', 34, 'F', 'Divorciado', 'Mexicana', 'Camos #933. Reforma', 78410, '4423601581', 69.1, 1.7, 'O+'),
('URTOO987456', 'HECL750205HGRRRS04', 'Hernández Carbajal José Luis', 32, 'F', 'Soltero', 'Mexicana', 'Niños Héroes #331. Olivos', 74125, '8962541010', 69.8, 1.8, 'A-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE IF NOT EXISTS `medicamentos` (
  `ID_MED` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `CURP` varchar(18) COLLATE utf8_spanish_ci NOT NULL,
  `ID_PF` int(5) NOT NULL,
  `INICIO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `PROBLEMA` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `CONTROLADO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `GRAVEDAD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `MEDICAMENTO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `DOSIS` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `DURACION` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `PRESCRITA` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`ID_MED`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`ID_MED`, `CURP`, `ID_PF`, `INICIO`, `PROBLEMA`, `CONTROLADO`, `GRAVEDAD`, `MEDICAMENTO`, `DOSIS`, `DURACION`, `PRESCRITA`) VALUES
('AABU841027HMCLSR0310', 'AABU841027HMCLSR03', 1, '12/10/2010', 'Fiebre', 'Sí', 'Baja', 'Paracetamol', '1 c/ 6 hr', '3 días', 'Sí'),
('FOLN620313HSRLYX0020', 'FOLN620313HSRLYX00', 2, '13/02/2009', 'Infección estomacal', 'Sí', 'Media', 'Lansoprazol', '2 c/ 8 hr.', '5 días', 'No'),
('GABO810802HGRRRM0610', 'GABO810802HGRRRM06', 1, '12/05/2010', 'Gripe aviar', 'Sí', 'Media', 'Amantadina', '2 c/ 6 hr.', '8 días', 'No'),
('GABO810802HGRRRM0620', 'GABO810802HGRRRM06', 2, '12/09/2010', 'Tos', 'Sí', 'Baja', 'Tioxapol', '1 c/ 6 hr', '3 días', 'Sí');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_f`
--

CREATE TABLE IF NOT EXISTS `perfil_f` (
  `CURP` varchar(18) COLLATE utf8_spanish_ci NOT NULL,
  `ID_PF` int(4) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `IMC` float NOT NULL,
  PRIMARY KEY (`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `perfil_f`
--

INSERT INTO `perfil_f` (`CURP`, `ID_PF`, `FECHA`, `IMC`) VALUES
('GABO810802HGRRRM06', 1, '12/05/2010', 0.590278),
('GABO810802HGRRRM06', 2, '12/09/2010', 0.590278),
('AABU841027HMCLSR03', 1, '12/10/2010', 17.7551),
('FOLN620313HSRLYX00', 2, '13/02/2009', 8.28889),
('VABI820909HGRZLL07', 1, '21/08/2011', 18.375),
('FOLN620313HSRLYX00', 1, '25/09/2016', 8.28889);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `CEDULA_PROFECIONAL` int(8) NOT NULL,
  `TIPO_USUARIO` int(1) DEFAULT NULL,
  `CLUES` varchar(11) COLLATE utf8_spanish2_ci NOT NULL,
  `PASSWORD` varchar(16) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`CEDULA_PROFECIONAL`),
  UNIQUE KEY `CLUES` (`CLUES`,`PASSWORD`),
  KEY `Tipo_Usuario` (`TIPO_USUARIO`),
  KEY `CLUES_2` (`CLUES`),
  KEY `CLUES_3` (`CLUES`),
  KEY `Contraseña` (`PASSWORD`),
  KEY `Contraseña_2` (`PASSWORD`),
  KEY `Tipo_Usuario_2` (`TIPO_USUARIO`),
  FULLTEXT KEY `CLUES_4` (`CLUES`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CEDULA_PROFECIONAL`, `TIPO_USUARIO`, `CLUES`, `PASSWORD`) VALUES
(12345678, 3, 'ABCDE123456', 'ING12345'),
(48566511, 2, 'GTCHD598741', 'FEBRERO12'),
(87451200, 1, 'URTOO987456', '990212');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
