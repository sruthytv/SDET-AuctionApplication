# MySQL-Front 3.2  (Build 8.0)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

# Host: localhost    Database: auction_db
# ------------------------------------------------------
# Server version 5.1.43-community

#
# Table structure for table bidder
#

DROP TABLE IF EXISTS `bidder`;
CREATE TABLE `bidder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(27) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Item` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

#
# Dumping data for table bidder
#

INSERT INTO `bidder` VALUES (17,'yyyy','666','hhjk',888,'hh','phone');
INSERT INTO `bidder` VALUES (18,'ghhhh','555555','ghgjghjg',8900,'hkhhj','phone');
INSERT INTO `bidder` VALUES (19,'ttyyyg','8888','hvjhbh',666,'hbjjbhn','phone');
INSERT INTO `bidder` VALUES (20,'tyyyt','666','hvjhnh',7777,'hjnh','phone');
INSERT INTO `bidder` VALUES (21,'yttHJHJ','7787','hkhhh',777,'hnn','phone');
INSERT INTO `bidder` VALUES (22,'yttHJHJ','7787','hkhhh',777,'hnn','phone');
INSERT INTO `bidder` VALUES (23,'uitytu','6666','hjmnh',6666,'hjnn','phone');
INSERT INTO `bidder` VALUES (24,'bhnhjgnj','66787','hbnj',777,'bhnjj','phone');
INSERT INTO `bidder` VALUES (25,'gjyhyg','7667667','njhn',666,'hjk','phone');
INSERT INTO `bidder` VALUES (26,'ghhjh','6666','ghjn',666,'hnjhh','phone');
INSERT INTO `bidder` VALUES (27,'fghjbybhbty','5567668','fghjbg',676,'nhjhn','phone');
INSERT INTO `bidder` VALUES (28,'fnjgny','556565','hyjg',555,'ghbjbh','phone');
INSERT INTO `bidder` VALUES (29,'tbuy','6655656','ghjhbnh',667,'hghjh','phone');


#
# Table structure for table item
#

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Item` varchar(38) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;

#
# Dumping data for table item
#

INSERT INTO `item` VALUES (76,'phone');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
