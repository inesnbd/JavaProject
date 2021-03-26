# Affichage de la table fruits
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fruits`;

CREATE TABLE `fruits` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fruit` varchar(11) DEFAULT NULL,
  `description` tinytext,
  `prix` float DEFAULT NULL,
  `quantites` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52552 DEFAULT CHARSET=latin1;

LOCK TABLES `fruits` WRITE;
/*!40000 ALTER TABLE `fruits` DISABLE KEYS */;

INSERT INTO `fruits` (`id`, `fruit`, `description`, `prix`, `quantites`)
VALUES
	(1,'melon','mexique',1.6,60),
	(2,'fraise','Du maroc',3,35),
	(3,'orange','Provient du jardin',2.24,50),
	(414,'hdbhsbfv','',79.8218,8),
	(994,'Poire','43',3,100),
	(3100,'fr','43',3,9);

/*!40000 ALTER TABLE `fruits` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table legumes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `legumes`;

CREATE TABLE `legumes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `legume` varchar(11) DEFAULT NULL,
  `description` tinytext,
  `prix` float DEFAULT NULL,
  `quantites` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11509 DEFAULT CHARSET=latin1;

LOCK TABLES `legumes` WRITE;
/*!40000 ALTER TABLE `legumes` DISABLE KEYS */;

INSERT INTO `legumes` (`id`, `legume`, `description`, `prix`, `quantites`)
VALUES
	(970,'Courgette','43',3,143),
	(2833,'tomate','43',3,134);

/*!40000 ALTER TABLE `legumes` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table produitlaitiers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `produitlaitiers`;

CREATE TABLE `produitlaitiers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `produitlaitiers` varchar(11) DEFAULT NULL,
  `description` tinytext,
  `prix` float DEFAULT NULL,
  `quantites` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50665 DEFAULT CHARSET=latin1;

LOCK TABLES `produitlaitiers` WRITE;
/*!40000 ALTER TABLE `produitlaitiers` DISABLE KEYS */;

INSERT INTO `produitlaitiers` (`id`, `produitlaitiers`, `description`, `prix`, `quantites`)
VALUES
	(34,'lait','très très bon',1.67,356),
	(557,'Yaourt','43',3,355);

/*!40000 ALTER TABLE `produitlaitiers` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table viandes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `viandes`;

CREATE TABLE `viandes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `viande` varchar(11) DEFAULT NULL,
  `description` tinytext,
  `prix` float DEFAULT NULL,
  `quantites` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87708 DEFAULT CHARSET=latin1;

LOCK TABLES `viandes` WRITE;
/*!40000 ALTER TABLE `viandes` DISABLE KEYS */;

INSERT INTO `viandes` (`id`, `viande`, `description`, `prix`, `quantites`)
VALUES
	(1,'boeuf','trop bon ',24.5,467),
	(485,'Poulet','43',3,382);

/*!40000 ALTER TABLE `viandes` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
