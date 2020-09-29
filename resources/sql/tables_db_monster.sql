-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.20 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;





-- Dump della struttura del database monster
DROP DATABASE IF EXISTS `monster`;
CREATE DATABASE IF NOT EXISTS `monster` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `monster`;

-- Dump della struttura di tabella monster.azienda
DROP TABLE IF EXISTS `azienda`;
CREATE TABLE IF NOT EXISTS `azienda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `link` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero_dipendenti` bigint DEFAULT NULL,
  `anno_fondazione` date DEFAULT NULL,
  `settore` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.azienda: ~1 rows (circa)
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` (`id`, `nome`, `descrizione`, `link`, `email`, `password`, `logo`, `numero_dipendenti`, `anno_fondazione`, `settore`) VALUES
	(282, 'Proxima', 'azienda di consulenza informatica', 'proximainformatica.com', 'proxima@gmail.com', 'abc', NULL, 100, '2018-08-28', 'Informatica'),
	(283, 'Moretti Costruzione', 'azienda specializzata in costruzioni pubbliche', 'moretti.costruzioni', 'moretti@gmail.com', 'def', NULL, 300, '2016-09-28', 'Edilizia'),
	(284, 'San Raffaele', 'ospedale san raffaele di milano', 'ospedale.sanraffaele', 'o.raffaele@gmail.com', 'ghi', NULL, 500, '2013-09-28', 'Medico');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;


-- Dump della struttura di tabella monster.sede
DROP TABLE IF EXISTS `sede`;
CREATE TABLE IF NOT EXISTS `sede` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `citta` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `regione` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `id_azienda` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_azienda` (`id_azienda`),
  CONSTRAINT `id_azienda` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.sede: ~0 rows (circa)
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` (`id`, `citta`, `regione`, `id_azienda`) VALUES
	(201, 'Milano', 'Lombardia', 284),
	(202, 'Roma', 'Lazio', 282),
	(203, 'Napoli', 'Campania', 283);
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;


-- Dump della struttura di tabella monster.settore
DROP TABLE IF EXISTS `settore`;
CREATE TABLE IF NOT EXISTS `settore` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.settore: ~0 rows (circa)
/*!40000 ALTER TABLE `settore` DISABLE KEYS */;
INSERT INTO `settore` (`id`, `nome`, `descrizione`) VALUES
	(209, 'Edile', 'Settore edile specializzato nella costruzione di edifici pubblici'),
	(210, 'Informatico', 'Settore specializzato nello sviluppo software'),
	(211, 'Medico', 'Settore dedicato ad ogni lavoratore sanitario');
/*!40000 ALTER TABLE `settore` ENABLE KEYS */;


-- Dump della struttura di tabella monster.annuncio
DROP TABLE IF EXISTS `annuncio`;
CREATE TABLE IF NOT EXISTS `annuncio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contratto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `data_pubblicazione` date DEFAULT NULL,
  `id_settore` bigint NOT NULL,
  `id_sede` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sede` (`id_sede`),
  KEY `id_settore` (`id_settore`),
  CONSTRAINT `id_sede` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_settore` FOREIGN KEY (`id_settore`) REFERENCES `settore` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.annuncio: ~0 rows (circa)
/*!40000 ALTER TABLE `annuncio` DISABLE KEYS */;
INSERT INTO `annuncio` (`id`, `descrizione`, `contratto`, `data_pubblicazione`, `id_settore`, `id_sede`) VALUES
	(137, 'Infermiere Notturno', '6 mesi', '2020-09-28', 211, 201),
	(138, 'Operaio', '12 mesi', '2020-09-26', 209, 203),
	(139, 'Programmatore FrontEnd', 'Indeterminato', '2020-09-23', 210, 202);
/*!40000 ALTER TABLE `annuncio` ENABLE KEYS */;

-- Dump della struttura di tabella monster.utente
DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cognome` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `cv` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.utente: ~0 rows (circa)
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` (`id`, `nome`, `cognome`, `email`, `password`, `telefono`, `data_nascita`, `cv`) VALUES
	(235, 'cristhian', 'serafini', 'c.s@gmail.com', 'cris.sera', '1234567890', '2013-09-28', 'url'),
	(236, 'jefferson', 'serrano', 'j.s@gmail.com', 'jef.ser', '123456789', '2017-09-28', 'url');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;

-- Dump della struttura di tabella monster.candidatura
DROP TABLE IF EXISTS `candidatura`;
CREATE TABLE IF NOT EXISTS `candidatura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_annuncio` bigint NOT NULL,
  `id_utente` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente` (`id_utente`),
  KEY `id_annuncio` (`id_annuncio`),
  CONSTRAINT `id_annuncio` FOREIGN KEY (`id_annuncio`) REFERENCES `annuncio` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.candidatura: ~0 rows (circa)
/*!40000 ALTER TABLE `candidatura` DISABLE KEYS */;
INSERT INTO `candidatura` (`id`, `id_annuncio`, `id_utente`) VALUES
	(73, 137, 235),
	(74, 139, 236);
/*!40000 ALTER TABLE `candidatura` ENABLE KEYS */;

-- Dump della struttura di tabella monster.competenza
DROP TABLE IF EXISTS `competenza`;
CREATE TABLE IF NOT EXISTS `competenza` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.competenza: ~0 rows (circa)
/*!40000 ALTER TABLE `competenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `competenza` ENABLE KEYS */;

-- Dump della struttura di tabella monster.esperienza
DROP TABLE IF EXISTS `esperienza`;
CREATE TABLE IF NOT EXISTS `esperienza` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_azienda` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.esperienza: ~0 rows (circa)
/*!40000 ALTER TABLE `esperienza` DISABLE KEYS */;
/*!40000 ALTER TABLE `esperienza` ENABLE KEYS */;

-- Dump della struttura di tabella monster.percorso_formativo
DROP TABLE IF EXISTS `percorso_formativo`;
CREATE TABLE IF NOT EXISTS `percorso_formativo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `formazione` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `formazione` (`formazione`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.percorso_formativo: ~0 rows (circa)
/*!40000 ALTER TABLE `percorso_formativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `percorso_formativo` ENABLE KEYS */;



-- Dump della struttura di tabella monster.utente_competenza
DROP TABLE IF EXISTS `utente_competenza`;
CREATE TABLE IF NOT EXISTS `utente_competenza` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_utente` bigint NOT NULL,
  `id_competenza` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente_competenza` (`id_utente`),
  KEY `id_competenza` (`id_competenza`),
  CONSTRAINT `id_competenza` FOREIGN KEY (`id_competenza`) REFERENCES `competenza` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_competenza` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.utente_competenza: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_competenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_competenza` ENABLE KEYS */;

-- Dump della struttura di tabella monster.utente_esperienza
DROP TABLE IF EXISTS `utente_esperienza`;
CREATE TABLE IF NOT EXISTS `utente_esperienza` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_utente` bigint NOT NULL,
  `id_esperienza` bigint NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente_esperienza` (`id_utente`),
  KEY `id_esperienza` (`id_esperienza`),
  CONSTRAINT `id_esperienza` FOREIGN KEY (`id_esperienza`) REFERENCES `esperienza` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_esperienza` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.utente_esperienza: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_esperienza` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_esperienza` ENABLE KEYS */;

-- Dump della struttura di tabella monster.utente_percorso
DROP TABLE IF EXISTS `utente_percorso`;
CREATE TABLE IF NOT EXISTS `utente_percorso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_utente` bigint NOT NULL,
  `id_percorso_formativo` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_percorso_formativo` (`id_percorso_formativo`),
  KEY `id_utente_percorso` (`id_utente`),
  CONSTRAINT `id_percorso_formativo` FOREIGN KEY (`id_percorso_formativo`) REFERENCES `percorso_formativo` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_percorso` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella monster.utente_percorso: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_percorso` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_percorso` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
