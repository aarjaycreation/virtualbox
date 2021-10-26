--
-- Database: `db`
--
create database db;

use db;
--
-- Table structure for table `chief`
--

CREATE TABLE IF NOT EXISTS `chief` (
  `C_Name` varchar(50) NOT NULL,
  `C_Password` varchar(50) DEFAULT NULL,
  `C_Designation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`C_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


--
-- Table structure for table `facoff`
--

CREATE TABLE IF NOT EXISTS `facoff` (
  `FO_Name` varchar(50) NOT NULL,
  `FO_Password` varchar(50) DEFAULT NULL,
  `FO_Designation` varchar(50) DEFAULT NULL,
  `Type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FO_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facoff`
-
--
-- Table structure for table `notice`
--

CREATE TABLE IF NOT EXISTS `notice` (
  `N_Name` varchar(50) NOT NULL,
  `YearBatch` varchar(50) DEFAULT NULL,
  `Notice` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`N_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

