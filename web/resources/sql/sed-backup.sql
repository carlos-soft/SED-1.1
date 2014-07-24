-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-07-2014 a las 22:11:06
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sed`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `idEvaluacion` int(11) NOT NULL,
  `idGrupo` int(11) NOT NULL,
  `control` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `evaluado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `idEvaluacion`, `idGrupo`, `control`, `nombre`, `evaluado`) VALUES
(1, 2, 1, '14201150', 'CAMARENA CAMARENA ESTRELLA MADAI', 1),
(2, 2, 1, '14201156', 'CAMARENA GUZMAN ARACELI', 0),
(3, 2, 1, '14201173', 'CAMARENA MARTINEZ MARIANA', 0),
(4, 2, 1, '14201096', 'GARCIA LEMUS JOSE EDUARDO', 0),
(5, 2, 1, '14201177', 'GAYTAN ORTIZ ADRIANA', 0),
(6, 2, 1, '14201182', 'GORDILLO VIEYRA ELIUD DANIELA', 0),
(7, 2, 1, '14201164', 'GUZMAN DIAZ NANCY', 0),
(8, 2, 1, '14201165', 'HERNANDEZ ZAMUDIO JUAN LUIS', 0),
(9, 2, 1, '13201056', 'PEREZ TOLEDO SALMA', 0),
(10, 2, 1, '14201170', 'ROCHA JURADO LUIS RAFAEL', 0),
(11, 2, 1, '14201160', 'TOLEDO HERNANDEZ MA PALOMA', 0),
(12, 2, 1, '14201183', 'VEGA GUZMAN ROSALIA GUADALUPE', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE IF NOT EXISTS `docentes` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`idDocente`, `nombre`) VALUES
(1, 'LAURA DEL PILAR VEGA VEGA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluaciones`
--

CREATE TABLE IF NOT EXISTS `evaluaciones` (
  `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` varchar(20) NOT NULL,
  `fechaFin` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `lenguaje` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idEvaluacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `evaluaciones`
--

INSERT INTO `evaluaciones` (`idEvaluacion`, `fechaInicio`, `fechaFin`, `year`, `lenguaje`, `estado`) VALUES
(2, 'Enero', 'Marzo', 2014, 'Ingles', 'activada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE IF NOT EXISTS `grupos` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `idDocente` int(11) NOT NULL,
  `nivel` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  PRIMARY KEY (`idGrupo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`idGrupo`, `nombre`, `idDocente`, `nivel`, `idEvaluacion`) VALUES
(1, '1SJA14', 1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `idPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `respuestas` varchar(10) DEFAULT NULL,
  `banco` varchar(1) NOT NULL,
  `answer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`idPregunta`, `descripcion`, `respuestas`, `banco`, `answer`) VALUES
(2, 'El profesor es puntual ??', 'orden', 's', 'null'),
(3, 'El profesor falta el respeto a los alumnos ??', 'orden', 's', 'null'),
(4, 'El profesor viste de manera presentable ??', 'desorden', 's', 'null'),
(5, 'Hola Mundo ??', 'orden', 's', 'null'),
(8, 'soy marco ??', 'desorden', 'n', 'null'),
(10, 'malo malo ??', 'orden', 'n', 'null'),
(11, 'bueno bueno ??', 'orden', 's', 'null'),
(12, 'exito ??', 'desorden', 'n', 'null'),
(13, 'por favor ??', 'orden', 'n', 'null'),
(14, 'ya ??', 'orden', 'n', 'null'),
(18, 'que onda ??', 'desorden', 'n', 'null'),
(28, 'Que cosas ??', 'orden', 's', 'null'),
(29, 'Save Sabe ??', 'orden', 's', 'null'),
(30, 'lalolin ??', 'orden', 'n', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasjoinevaluacion`
--

CREATE TABLE IF NOT EXISTS `preguntasjoinevaluacion` (
  `idPregunta` int(11) NOT NULL,
  `idEvaluacion` int(11) NOT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `preguntasjoinevaluacion`
--

INSERT INTO `preguntasjoinevaluacion` (`idPregunta`, `idEvaluacion`) VALUES
(4, 2),
(10, 3),
(28, 2),
(29, 2),
(30, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
