

USE `rCAtrGDI3M`;

-- Dump della struttura di tabella rCAtrGDI3M.annuncio
DROP TABLE IF EXISTS `annuncio`;
CREATE TABLE IF NOT EXISTS `annuncio` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `contratto` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `data_pubblicazione` date DEFAULT NULL,
  `id_settore` bigint(11) NOT NULL,
  `id_sede` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sede` (`id_sede`),
  KEY `id_settore` (`id_settore`),
  CONSTRAINT `id_sede` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_settore` FOREIGN KEY (`id_settore`) REFERENCES `settore` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.annuncio: ~0 rows (circa)
/*!40000 ALTER TABLE `annuncio` DISABLE KEYS */;
/*!40000 ALTER TABLE `annuncio` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.azienda
DROP TABLE IF EXISTS `azienda`;
CREATE TABLE IF NOT EXISTS `azienda` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `logo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero_dipendenti` bigint(11) DEFAULT NULL,
  `anno_fondazione` date DEFAULT NULL,
  `settore` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.azienda: ~0 rows (circa)
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.candidatura
DROP TABLE IF EXISTS `candidatura`;
CREATE TABLE IF NOT EXISTS `candidatura` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `id_annuncio` bigint(11) NOT NULL,
  `id_utente` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente` (`id_utente`),
  KEY `id_annuncio` (`id_annuncio`),
  CONSTRAINT `id_annuncio` FOREIGN KEY (`id_annuncio`) REFERENCES `annuncio` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.candidatura: ~0 rows (circa)
/*!40000 ALTER TABLE `candidatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidatura` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.competenza
DROP TABLE IF EXISTS `competenza`;
CREATE TABLE IF NOT EXISTS `competenza` (
  `id` bigint(11) NOT NULL ,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `descrizione` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.competenza: ~0 rows (circa)
/*!40000 ALTER TABLE `competenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `competenza` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.esperienza
DROP TABLE IF EXISTS `esperienza`;
CREATE TABLE IF NOT EXISTS `esperienza` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nome_azienda` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.esperienza: ~0 rows (circa)
/*!40000 ALTER TABLE `esperienza` DISABLE KEYS */;
/*!40000 ALTER TABLE `esperienza` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.percorso_formativo
DROP TABLE IF EXISTS `percorso_formativo`;
CREATE TABLE IF NOT EXISTS `percorso_formativo` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `formazione` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `descrizione` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `formazione` (`formazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.percorso_formativo: ~0 rows (circa)
/*!40000 ALTER TABLE `percorso_formativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `percorso_formativo` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.sede
DROP TABLE IF EXISTS `sede`;
CREATE TABLE IF NOT EXISTS `sede` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `citta` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `regione` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `id_azienda` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_azienda` (`id_azienda`),
  CONSTRAINT `id_azienda` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.sede: ~0 rows (circa)
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.settore
DROP TABLE IF EXISTS `settore`;
CREATE TABLE IF NOT EXISTS `settore` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `descrizione` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.settore: ~0 rows (circa)
/*!40000 ALTER TABLE `settore` DISABLE KEYS */;
/*!40000 ALTER TABLE `settore` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.utente
DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cognome` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `cv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.utente: ~0 rows (circa)
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.utente_competenza
DROP TABLE IF EXISTS `utente_competenza`;
CREATE TABLE IF NOT EXISTS `utente_competenza` (
  `id` bigint(11) NOT NULL,
  `id_utente` bigint(11) NOT NULL,
  `id_competenza` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente_competenza` (`id_utente`),
  KEY `id_competenza` (`id_competenza`),
  CONSTRAINT `id_competenza` FOREIGN KEY (`id_competenza`) REFERENCES `competenza` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_competenza` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.utente_competenza: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_competenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_competenza` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.utente_esperienza
DROP TABLE IF EXISTS `utente_esperienza`;
CREATE TABLE IF NOT EXISTS `utente_esperienza` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `id_utente` bigint(11) NOT NULL,
  `id_esperienza` bigint(11) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_utente_esperienza` (`id_utente`),
  KEY `id_esperienza` (`id_esperienza`),
  CONSTRAINT `id_esperienza` FOREIGN KEY (`id_esperienza`) REFERENCES `esperienza` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_esperienza` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.utente_esperienza: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_esperienza` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_esperienza` ENABLE KEYS */;

-- Dump della struttura di tabella rCAtrGDI3M.utente_percorso
DROP TABLE IF EXISTS `utente_percorso`;
CREATE TABLE IF NOT EXISTS `utente_percorso` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `id_utente` bigint(11) NOT NULL,
  `id_percorso_formativo` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_percorso_formativo` (`id_percorso_formativo`),
  KEY `id_utente_percorso` (`id_utente`),
  CONSTRAINT `id_percorso_formativo` FOREIGN KEY (`id_percorso_formativo`) REFERENCES `percorso_formativo` (`id`) ON DELETE CASCADE,
  CONSTRAINT `id_utente_percorso` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dump dei dati della tabella rCAtrGDI3M.utente_percorso: ~0 rows (circa)
/*!40000 ALTER TABLE `utente_percorso` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_percorso` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

