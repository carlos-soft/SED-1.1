-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-08-2014 a las 21:43:23
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

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte`(idDoc int)
select a.nombre as alumno, d.nombre as docente, p.idPregunta, p.descripcion, res.answer, reg.comentario
from Docentes d
join Grupos g
join Alumnos a
join Registros reg
join Resultados res
join Preguntas p
join preguntasjoinevaluacion pe
join Evaluaciones e
where d.idDocente = idDoc and
	d.idDocente = g.idDocente and
	g.idGrupo = a.idGrupo and 
	a.idAlumno = reg.idAlumno and
	reg.idRegistro = res.idRegistro and
	res.idPregunta = p.idPregunta and
	p.idPregunta = pe.idPregunta and
	pe.idEvaluacion = e.idEvaluacion$$

DELIMITER ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=102 ;

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
(12, 2, 1, '14201183', 'VEGA GUZMAN ROSALIA GUADALUPE', 0),
(13, 2, 2, '13201118', 'ALCANTAR RODRIGUEZ ALEJANDRA', 0),
(14, 2, 2, '13201231', 'ALVAREZ SANCHEZ AGUSTIN', 0),
(15, 2, 2, '14201029', 'AVALOS GARCIA JUAN FELIPE', 0),
(16, 2, 2, '13201211', 'CERRITEÑO FERNANDEZ DANIELA ADAMARY', 0),
(17, 2, 2, '14201078', 'CHAVEZ DIAZ LUIS ALBERTO', 0),
(18, 2, 2, '13201219', 'GONZALEZ ARELLANO ANA KAREN', 0),
(19, 2, 2, '12201284', 'LOPEZ ORTEGA ANA JULIETA', 0),
(20, 2, 2, '13201255', 'ORTIZ RUIZ KAREN PAULINA', 0),
(21, 2, 2, '13201261', 'PIZANO ROSILES MELISSA GALILEA', 0),
(22, 2, 2, '13201245', 'ROCHA JUAREZ MARIA ALICIA', 0),
(23, 2, 2, '13201204', 'ROCHA SANDOVAL JOSEPH ANGEL', 0),
(24, 2, 2, '14201057', 'ZAMUDIO HERNANDEZ ERICK', 0),
(25, 7, 3, '14201074', 'ALVAREZ ZAMUDIO XIMENA ANAHI', 0),
(26, 7, 3, '14201080', 'CAMARGO GUZMAN CAROLINA', 0),
(27, 7, 3, '13201316', 'DELGADILLO ZAMUDIO BRYAN', 0),
(28, 7, 3, '14201180', 'ESCUTIA MILLAN JOSE', 0),
(29, 7, 3, '14201043', 'GONZALEZ ZAVALA JOSE JESUS', 0),
(30, 7, 3, '14201016', 'GUZMAN ORTEGA VERONICA DANIELA', 0),
(31, 7, 3, '14201017', 'GUZMAN ZAMUDIO ARANXA PALOMA', 0),
(32, 7, 3, '13201215', 'LARA CASTRO ERICK ISAI', 0),
(33, 7, 3, '14201010', 'LOPEZ ZAMORA YOELI', 0),
(34, 7, 3, '14201066', 'MORALES TINOCO LUIS JOSUE', 0),
(35, 7, 3, '14201070', 'OROZCO VARGAS JOANNA LIZZET', 0),
(36, 7, 3, '14201053', 'ORTIZ RAZO CESAR', 0),
(37, 7, 3, '14201052', 'ORTIZ RAZO MARIANA', 0),
(38, 7, 3, '14201044', 'PANIAGUA MOLINA DIEGO', 0),
(39, 7, 3, '12201140', 'PANTOJA CORTES ALMA ALHELI', 0),
(40, 7, 3, '14201039', 'PEREZ TORRES DANIEL', 0),
(41, 7, 3, '13201300', 'REYNA JUAREZ BRIAN', 0),
(42, 7, 3, '14201030', 'ROJAS GUERRERO DIEGO SEBASTIAN', 0),
(43, 7, 3, '14201019', 'ROSILES AGUILERA MARIANA', 0),
(44, 7, 3, '14201075', 'SALAZAR GARCIA ARANTZA', 0),
(45, 7, 3, '14201076', 'SALAZAR GARCIA KENIA ALONDRA', 0),
(46, 7, 3, '14201034', 'SANCHEZ VILLALOBOS VICTOR MANUEL', 0),
(47, 7, 3, '14201049', 'ZAMUDIO  AYLIN', 0),
(48, 7, 3, '14201058', 'ZAVALA ARRIAGA MONSERRAT', 0),
(49, 7, 3, '14201077', 'ZAVALA GARCIA JAASIEL', 0),
(50, 7, 3, '13201330', 'ZAVALA VARGAS ALEXAI', 0),
(51, 7, 3, '13201334', 'ZAVALA VARGAS HERIBERTO', 0),
(52, 7, 3, '13201327', 'ZAVALA VILLAGOMEZ CARLOS ALBERTO', 0),
(53, 2, 4, '14201089', 'ALCANTAR ZAVALA MARIA DOLORES', 0),
(54, 2, 4, '14201134', 'ANDRADE VALENCIA EDUARDO', 0),
(55, 2, 4, '14201121', 'ARREOLA PEREZ JOSUE', 0),
(56, 2, 4, '14201098', 'CHAVEZ ROSILES GABRIELA', 0),
(57, 2, 4, '14201189', 'ESPINOZA RICO BLANCA ERIKA', 0),
(58, 2, 4, '14201155', 'GONZALEZ MENDOZA BRENDA LISSETE', 0),
(59, 2, 4, '14201135', 'GONZALEZ RUIZ PAULINA', 0),
(60, 2, 4, '14201136', 'GONZALEZ RUIZ ROSA ADRIANA', 0),
(61, 2, 4, '14201169', 'GUZMAN ZAMUDIO ELENA', 0),
(62, 2, 4, '14201130', 'HERRERA RODRIGUEZ RICHARD', 0),
(63, 2, 4, '14201147', 'LEMUS DOMINGUEZ ALONSO DANIEL', 0),
(64, 2, 4, '14201140', 'LEMUS DOMINGUEZ JOSE RICARDO', 0),
(65, 2, 4, '14201172', 'LOPEZ GONZALEZ DENISCE', 0),
(66, 2, 4, '14201166', 'MARTINEZ GUZMAN MONTSERRAT', 0),
(67, 2, 4, '14201104', 'MARTINEZ MARTINEZ JESUS', 0),
(68, 2, 4, '14201131', 'MONREAL LARIOS SANDRA TERESA', 0),
(69, 2, 4, '14201178', 'MURILLO CABALLERO ADRIANA', 0),
(70, 2, 4, '14201181', 'PITO CONTRERAS MARIA ISABEL', 0),
(71, 2, 4, '14201120', 'PIZANO GARCIA JUAN CARLOS', 0),
(72, 2, 4, '14201095', 'RUIZ DIAZ PRISCILA', 0),
(73, 2, 4, '05201249', 'ZAVALA DIAZ LUCERO ANAHI', 0),
(74, 2, 5, '14201074', 'ALVAREZ ZAMUDIO XIMENA ANAHI', 0),
(75, 2, 5, '14201080', 'CAMARGO GUZMAN CAROLINA', 0),
(76, 2, 5, '13201316', 'DELGADILLO ZAMUDIO BRYAN', 0),
(77, 2, 5, '14201180', 'ESCUTIA MILLAN JOSE', 0),
(78, 2, 5, '14201043', 'GONZALEZ ZAVALA JOSE JESUS', 0),
(79, 2, 5, '14201016', 'GUZMAN ORTEGA VERONICA DANIELA', 0),
(80, 2, 5, '14201017', 'GUZMAN ZAMUDIO ARANXA PALOMA', 0),
(81, 2, 5, '13201215', 'LARA CASTRO ERICK ISAI', 0),
(82, 2, 5, '14201010', 'LOPEZ ZAMORA YOELI', 0),
(83, 2, 5, '14201066', 'MORALES TINOCO LUIS JOSUE', 0),
(84, 2, 5, '14201070', 'OROZCO VARGAS JOANNA LIZZET', 0),
(85, 2, 5, '14201053', 'ORTIZ RAZO CESAR', 0),
(86, 2, 5, '14201052', 'ORTIZ RAZO MARIANA', 0),
(87, 2, 5, '14201044', 'PANIAGUA MOLINA DIEGO', 0),
(88, 2, 5, '12201140', 'PANTOJA CORTES ALMA ALHELI', 0),
(89, 2, 5, '14201039', 'PEREZ TORRES DANIEL', 0),
(90, 2, 5, '13201300', 'REYNA JUAREZ BRIAN', 0),
(91, 2, 5, '14201030', 'ROJAS GUERRERO DIEGO SEBASTIAN', 0),
(92, 2, 5, '14201019', 'ROSILES AGUILERA MARIANA', 0),
(93, 2, 5, '14201075', 'SALAZAR GARCIA ARANTZA', 0),
(94, 2, 5, '14201076', 'SALAZAR GARCIA KENIA ALONDRA', 0),
(95, 2, 5, '14201034', 'SANCHEZ VILLALOBOS VICTOR MANUEL', 0),
(96, 2, 5, '14201049', 'ZAMUDIO  AYLIN', 0),
(97, 2, 5, '14201058', 'ZAVALA ARRIAGA MONSERRAT', 0),
(98, 2, 5, '14201077', 'ZAVALA GARCIA JAASIEL', 0),
(99, 2, 5, '13201330', 'ZAVALA VARGAS ALEXAI', 0),
(100, 2, 5, '13201334', 'ZAVALA VARGAS HERIBERTO', 0),
(101, 2, 5, '13201327', 'ZAVALA VILLAGOMEZ CARLOS ALBERTO', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE IF NOT EXISTS `docentes` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`idDocente`, `nombre`) VALUES
(1, 'LAURA DEL PILAR VEGA VEGA'),
(2, 'YAZMIN VAZQUEZ GUTIERREZ'),
(3, 'DIANA STEPHANIE CONTRERAS CONTRERAS'),
(4, 'LUIS ALFONSO LARA LOPEZ'),
(5, 'DIANA STEPHANIE CONTRERAS CONTRERAS');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `evaluaciones`
--

INSERT INTO `evaluaciones` (`idEvaluacion`, `fechaInicio`, `fechaFin`, `year`, `lenguaje`, `estado`) VALUES
(2, 'Enero', 'Marzo', 2014, 'Ingles', 'activada'),
(3, 'Abril', 'Agosto', 2014, 'Ingles', 'desactivada'),
(4, 'Julio', 'Octubre', 2014, 'Frances', 'desactivada'),
(5, 'Noviembre', 'Diciembre', 2014, 'Ingles', 'desactivada'),
(6, 'Diciembre', 'Diciembre', 2014, 'Frances', 'desactivada'),
(7, 'Enero', 'Enero', 2014, 'Frances', 'desactivada');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`idGrupo`, `nombre`, `idDocente`, `nivel`, `idEvaluacion`) VALUES
(1, '1SJA14', 1, 1, 2),
(2, '5KJA14', 2, 5, 2),
(3, '3KJA14', 3, 3, 7),
(4, '2SJA14', 4, 2, 2),
(5, '3KJA14', 3, 3, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

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
(30, 'lalolin ??', 'orden', 's', NULL),
(31, 'Carlos ???', 'desorden', 's', NULL),
(32, 'cuantos años ??', 'orden', 'n', NULL),
(33, 'méxico ??', 'orden', 'n', NULL);

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
(3, 2),
(4, 2),
(5, 2),
(10, 3),
(28, 2),
(29, 2),
(30, 2),
(31, 2),
(32, 5),
(33, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE IF NOT EXISTS `registros` (
  `idRegistro` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `comentario` longtext COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idRegistro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`idRegistro`, `idAlumno`, `comentario`) VALUES
(1, 2, 'adfsdf'),
(2, 3, 'pruebas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE IF NOT EXISTS `resultados` (
  `idResultados` int(11) NOT NULL AUTO_INCREMENT,
  `idRegistro` int(11) NOT NULL,
  `idPregunta` int(11) NOT NULL,
  `answer` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idResultados`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`idResultados`, `idRegistro`, `idPregunta`, `answer`) VALUES
(1, 1, 3, '10'),
(2, 1, 4, '10'),
(3, 1, 5, '9'),
(4, 1, 28, '9'),
(5, 1, 29, '8'),
(6, 1, 30, '6'),
(7, 1, 31, '9'),
(8, 2, 3, '10'),
(9, 2, 4, '7'),
(10, 2, 5, '10'),
(11, 2, 28, '6'),
(12, 2, 29, '7'),
(13, 2, 30, '7'),
(14, 2, 31, '6');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
