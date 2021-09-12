-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 12, 2021 at 07:24 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tna`
--

-- --------------------------------------------------------

--
-- Table structure for table `evidencijarada`
--

CREATE TABLE `evidencijarada` (
  `EvidencijaID` int(11) NOT NULL,
  `VrijemePocetka` time DEFAULT NULL,
  `VrijemeKraja` time DEFAULT NULL,
  `Datum` date NOT NULL,
  `UkupnoVrijemeRada` float DEFAULT NULL,
  `Prekovremeni` float DEFAULT NULL,
  `KorisnikID` int(11) NOT NULL,
  `StatusID` int(11) DEFAULT NULL,
  `InOut` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `evidencijarada`
--

INSERT INTO `evidencijarada` (`EvidencijaID`, `VrijemePocetka`, `VrijemeKraja`, `Datum`, `UkupnoVrijemeRada`, `Prekovremeni`, `KorisnikID`, `StatusID`, `InOut`) VALUES
(21, '11:13:11', '11:13:24', '2021-09-11', NULL, NULL, 2, NULL, 0),
(22, '11:13:16', '11:13:27', '2021-09-11', NULL, NULL, 1, NULL, 0),
(61, '17:21:27', '17:21:58', '2021-09-11', NULL, NULL, 1, NULL, 0),
(62, '17:22:01', '17:22:12', '2021-09-11', NULL, NULL, 2, NULL, 0),
(63, '17:22:05', '17:22:08', '2021-09-06', NULL, NULL, 3, NULL, 0),
(64, '17:22:15', '17:22:17', '2021-09-11', NULL, NULL, 1, NULL, 0),
(65, '17:22:21', '17:22:26', '2021-09-08', NULL, NULL, 3, NULL, 0),
(66, '17:22:28', '17:22:31', '2021-09-11', NULL, NULL, 2, NULL, 0),
(67, '17:22:33', '17:28:39', '2021-09-06', NULL, NULL, 1, NULL, 0),
(68, '17:23:20', '18:11:52', '2021-09-11', NULL, NULL, 3, NULL, 0),
(69, '17:28:45', '17:28:50', '2021-09-11', NULL, NULL, 1, NULL, 0),
(70, '17:28:53', '17:28:56', '2021-09-11', NULL, NULL, 2, NULL, 0),
(71, '18:06:43', '18:07:38', '2021-09-08', NULL, NULL, 2, NULL, 0),
(72, '18:07:54', '18:08:14', '2021-09-11', NULL, NULL, 2, NULL, 0),
(73, '18:10:03', '18:10:40', '2021-09-11', NULL, NULL, 2, NULL, 0),
(74, '18:10:46', '18:10:52', '2021-09-11', NULL, NULL, 1, NULL, 0),
(75, '18:12:38', '18:12:42', '2021-09-11', NULL, NULL, 1, NULL, 0),
(76, '18:15:34', '18:15:42', '2021-09-09', NULL, NULL, 2, NULL, 0),
(77, '18:15:54', '18:15:59', '2021-09-11', NULL, NULL, 1, NULL, 0),
(78, '18:16:37', '18:16:52', '2021-09-11', NULL, NULL, 1, NULL, 0),
(79, '18:16:45', '18:16:55', '2021-09-11', NULL, NULL, 2, NULL, 0),
(80, '18:24:22', '18:24:49', '2021-09-11', NULL, NULL, 1, NULL, 0),
(81, '18:28:04', '18:28:09', '2021-09-06', NULL, NULL, 1, NULL, 0),
(82, '18:33:03', '18:33:13', '2021-09-11', NULL, NULL, 2, NULL, 0),
(83, '18:33:38', '18:33:48', '2021-09-11', NULL, NULL, 2, NULL, 0),
(84, '18:34:36', '18:34:56', '2021-09-11', NULL, NULL, 1, NULL, 0),
(85, '18:35:12', '18:35:16', '2021-09-11', NULL, NULL, 2, NULL, 0),
(86, '18:37:04', '18:37:09', '2021-09-11', NULL, NULL, 2, NULL, 0),
(87, '19:29:45', '19:29:59', '2021-09-11', NULL, NULL, 2, NULL, 0),
(88, '19:30:10', '19:30:14', '2021-09-11', NULL, NULL, 2, NULL, 0),
(89, '00:04:18', '00:04:23', '2021-09-12', NULL, NULL, 1, NULL, 0),
(90, '13:16:01', '13:16:15', '2021-09-12', NULL, NULL, 3, NULL, 0),
(91, '13:16:10', '13:16:21', '2021-09-12', NULL, NULL, 1, NULL, 0),
(92, '13:18:02', '13:18:16', '2021-09-12', NULL, NULL, 3, NULL, 0),
(93, '13:21:16', '13:21:26', '2021-09-12', NULL, NULL, 3, NULL, 0),
(94, '13:24:04', '13:24:08', '2021-09-12', NULL, NULL, 3, NULL, 0),
(95, '17:13:52', '17:14:09', '2021-09-12', NULL, NULL, 1, NULL, 0),
(96, '17:23:12', '17:23:20', '2021-09-12', NULL, NULL, 1, NULL, 0),
(97, '17:24:00', '17:24:05', '2021-09-12', NULL, NULL, 3, NULL, 0),
(98, '17:43:52', '18:12:41', '2021-09-12', NULL, NULL, 1, NULL, 0),
(99, '18:12:58', '18:13:10', '2021-09-12', NULL, NULL, 1, NULL, 0),
(100, '18:14:39', NULL, '2021-09-12', NULL, NULL, 1, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `KorisnikID` int(11) NOT NULL,
  `CardID` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Ime` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Prezime` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KontaktBroj` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RoleID` int(11) NOT NULL,
  `RadnoMjestoID` int(11) NOT NULL,
  `Password` char(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`KorisnikID`, `CardID`, `Ime`, `Prezime`, `KontaktBroj`, `RoleID`, `RadnoMjestoID`, `Password`, `Email`, `IsDeleted`) VALUES
(1, '0007788651', 'Mate ', 'Matić', '+387 63 664 322', 1, 1, 'sifra123', 'mate@test.ba', b'1'),
(2, '0007787944', 'Jure', 'Jurić', NULL, 1, 2, 'sifra123', 'jure@test.ba', b'0'),
(3, '0007787946', 'Stipe', 'Stipić', '', 2, 3, 'sifra123', 'stipe@test.ba', b'0'),
(8, NULL, 'Ante', 'Antić', '+386 63 122 473', 3, 5, 'sifra123', 'ante@test.ba', b'0'),
(9, NULL, 'Ana', 'Anić', '', 3, 6, 'sifra123', 'ana@test.ba', b'0'),
(10, NULL, 'Marija', 'Marić', '', 3, 3, 'sifra123', 'marija@test.ba', b'0'),
(11, NULL, 'Ivo', 'Ivić', '', 3, 2, 'sifra234', 'ivo@test.ba', b'0'),
(12, NULL, 'Stipe', 'Jurić', '', 1, 4, 'sifra123', 'stipe@test.ba', b'0'),
(13, NULL, 'adssa', 'test', '', 2, 2, 'dsad', 'sada', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `radnomjesto`
--

CREATE TABLE `radnomjesto` (
  `RadnoMjestoID` int(11) NOT NULL,
  `ImeRadnogMjesta` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Satnica` float NOT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `radnomjesto`
--

INSERT INTO `radnomjesto` (`RadnoMjestoID`, `ImeRadnogMjesta`, `Satnica`, `IsDeleted`) VALUES
(1, 'Računovodstvo', 10, b'0'),
(2, 'Junior frontend developer', 11, b'0'),
(3, 'Projekt menadžer', 15, b'0'),
(4, 'Pravna služba', 10, b'0'),
(5, 'Tehnička podrška', 9, b'0'),
(6, 'Marketing', 10, b'0'),
(14, 'Testno', 15, b'1'),
(15, 'fdgfds', 45, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `RoleID` int(11) NOT NULL,
  `Rola` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`RoleID`, `Rola`) VALUES
(1, 'Superadmin'),
(2, 'Admin'),
(3, 'Korisnik');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `StatusID` int(11) NOT NULL,
  `Status` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `evidencijarada`
--
ALTER TABLE `evidencijarada`
  ADD PRIMARY KEY (`EvidencijaID`),
  ADD KEY `fkIdx_45` (`KorisnikID`),
  ADD KEY `fkIdx_48` (`StatusID`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`KorisnikID`),
  ADD UNIQUE KEY `CardID` (`CardID`),
  ADD KEY `fkIdx_39` (`RoleID`),
  ADD KEY `fkIdx_42` (`RadnoMjestoID`);

--
-- Indexes for table `radnomjesto`
--
ALTER TABLE `radnomjesto`
  ADD PRIMARY KEY (`RadnoMjestoID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RoleID`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`StatusID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evidencijarada`
--
ALTER TABLE `evidencijarada`
  MODIFY `EvidencijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `KorisnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `radnomjesto`
--
ALTER TABLE `radnomjesto`
  MODIFY `RadnoMjestoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `RoleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `StatusID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `evidencijarada`
--
ALTER TABLE `evidencijarada`
  ADD CONSTRAINT `FK_44` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnici` (`KorisnikID`),
  ADD CONSTRAINT `FK_47` FOREIGN KEY (`StatusID`) REFERENCES `status` (`StatusID`);

--
-- Constraints for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD CONSTRAINT `FK_38` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`),
  ADD CONSTRAINT `FK_41` FOREIGN KEY (`RadnoMjestoID`) REFERENCES `radnomjesto` (`RadnoMjestoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
