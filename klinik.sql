-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2017 at 04:48 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `klinik`
--
CREATE DATABASE IF NOT EXISTS `klinik` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `klinik`;

-- --------------------------------------------------------

--
-- Table structure for table `antrean`
--

CREATE TABLE `antrean` (
  `id_antrean` int(11) NOT NULL,
  `id_pasien` int(11) NOT NULL,
  `tanggal_antrean` date NOT NULL,
  `keluhan` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `username` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `nomor_telpon` varchar(15) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`username`, `nama`, `password`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `status`, `pekerjaan`, `nomor_telpon`, `alamat`, `foto`) VALUES
('111qwqwTEST', 'ole', 'oleerer', 'hoeyyy', 'werwerwer', 'L', 'status', 'oleole', '987987', '232', 'hoey'),
('oiuoiu', 'ole', 'oleerer', 'hoeyyy', 'werwerwer', 'L', 'status', 'oleole', '987987', '232', 'hoey'),
('qwqwTEST', 'ole', 'oleerer', 'hoeyyy', 'werwerwer', 'L', 'status', 'oleole', '987987', '232', 'hoey'),
('TEST', 'ole', 'oleerer', 'hoeyyy', 'werwerwer', 'L', 'status', 'oleole', '987987', '232', 'hoey');

-- --------------------------------------------------------

--
-- Table structure for table `pasientest`
--

CREATE TABLE `pasientest` (
  `idPasien` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `gender` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasientest`
--

INSERT INTO `pasientest` (`idPasien`, `nama`, `gender`) VALUES
(1, 'dytra', 'gender');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pasientest`
--
ALTER TABLE `pasientest`
  ADD PRIMARY KEY (`idPasien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pasientest`
--
ALTER TABLE `pasientest`
  MODIFY `idPasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
