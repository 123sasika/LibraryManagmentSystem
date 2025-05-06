-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2025 at 10:00 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Author` varchar(100) NOT NULL,
  `Genre` varchar(100) NOT NULL,
  `ISBN` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `Title`, `Author`, `Genre`, `ISBN`) VALUES
('4', 'ML', 'sisil', '4', '4');

-- --------------------------------------------------------

--
-- Table structure for table `borrowbook`
--

CREATE TABLE `borrowbook` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Author` varchar(40) NOT NULL,
  `Genre` varchar(23) NOT NULL,
  `ISBN` varchar(25) NOT NULL,
  `BorrowerName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowbook`
--

INSERT INTO `borrowbook` (`ID`, `Title`, `Author`, `Genre`, `ISBN`, `BorrowerName`) VALUES
('3', 'Python', 'sunil', '1', '3', 'kal');

-- --------------------------------------------------------

--
-- Table structure for table `borrowdvd`
--

CREATE TABLE `borrowdvd` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Director` varchar(23) NOT NULL,
  `Duration` varchar(25) NOT NULL,
  `BorrowerName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customerregistration`
--

CREATE TABLE `customerregistration` (
  `First Name` varchar(100) NOT NULL,
  `Last Name` varchar(100) NOT NULL,
  `UserName` varchar(11) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerregistration`
--

INSERT INTO `customerregistration` (`First Name`, `Last Name`, `UserName`, `Password`) VALUES
('sasika', 'sasika', 'sasika123', '200');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Director` varchar(100) NOT NULL,
  `Duration` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`ID`, `Title`, `Director`, `Duration`) VALUES
('1', 'HCI', 'sasika', '3'),
('3', 'Python', 'kasun', '1'),
('4', 'ML', 'Sunil', '5');

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `ID` varchar(20) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `BorrowerName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `returndvd`
--

CREATE TABLE `returndvd` (
  `ID` varchar(20) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `BorrowerName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`(5));

--
-- Indexes for table `borrowbook`
--
ALTER TABLE `borrowbook`
  ADD PRIMARY KEY (`ID`(9));

--
-- Indexes for table `borrowdvd`
--
ALTER TABLE `borrowdvd`
  ADD PRIMARY KEY (`ID`(5));

--
-- Indexes for table `customerregistration`
--
ALTER TABLE `customerregistration`
  ADD PRIMARY KEY (`UserName`(5));

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`ID`(5));
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
