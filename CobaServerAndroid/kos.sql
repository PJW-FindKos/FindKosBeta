
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: localhost
-- Waktu pembuatan: 24 Jun 2015 pada 04.42
-- Versi Server: 10.0.11-MariaDB
-- Versi PHP: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `u141379420_00000`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kos`
--

CREATE TABLE IF NOT EXISTS `kos` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `namaPemilik` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `alamat` text COLLATE utf8_unicode_ci NOT NULL,
  `harga` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `noHP` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `latitude` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `longitude` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fasilitas` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=21 ;

--
-- Dumping data untuk tabel `kos`
--

INSERT INTO `kos` (`id`, `namaPemilik`, `alamat`, `harga`, `noHP`, `latitude`, `longitude`, `fasilitas`) VALUES
(1, 'ANF KARYA', 'Sekitaran lokasi : Info kontrakan Sekitaran PLN,JEC,Gembiraloka.\r\n\r\nBERIKUT  ADALAH ALAMAT KANTOR CABANG KAMI\r\n\r\nBARAT UPN CONDONGCATUR RINGROAD UTARA  \r\n\r\nJl. Perumnas No. 1A Condongsari RT 01 RW 25 condong catur depok sleman, Yogyakarta (0274)- 660 4445 / (0274) - 486 983)/ (085799239800)\r\nPIN BBM 56DB14C1   WHATSAPP 085729872416', 'Harga : Rp.12.000.000/Tahun', '085799239800', '0', '0', 'Kamar tidur  : 2\r\nKamar mandi  : 1\r\nFasilitas : Dapur,Ruang Keluarga,Listrik 900Watt,Air Sumur,Keramik,Teras,Akses Mobil.\r\n'),
(2, 'ANF KARYA', 'Sekitaran lokasi : Info kontrakan Sekitaran Mercubuana,SADHAR,UNY.', 'Rp.34.000.000/Tahun', '0274881337', '', '', 'Dapur, Ruang Tamu, Garasi, Listrik 1300Watt, Air Sanyo, Keramik, Teras, Akses Mobil. Kamar Tidur : 6, Kamar mandi : 2.'),
(3, 'ANF KARYA', 'Sekitaran lokasi : Info kontrakan Sekitaran Terminal Condongcatur.', 'Rp.1.100.000-Rp1.400.000/Bulan', '08572987241', '', '', 'Dapur Bersama,Ruang Tamu,Jam Malam 22.00 WIB,Listrik Free, Keramik, AC, Wifi, Furnish(TV,Lemari,Kasur),Akses Mobil, kamar mandi dalam.\r\n'),
(4, 'ANF KARYA', 'Sekitaran lokasi : Info kontrakan Sekitaran Mercubuana,SADHAR,UNY.', 'Rp.18.000.000/Tahun', '08572987241', '', '', 'Kamar Tidur : 4\r\nKamar mandi : 2\r\nFasilitas : Dapur,Ruang Tamu,Listrik 1300Watt,Air Sanyo,Keramik,Akses Mobil.'),
(5, 'ANF KARYA', 'Info kontrakan Dekat OB', 'Rp. 550.000 Kamar mandi Luar(Min 3 bulan) -  Rp. 850.000 Kamar Mandi Dalam(Min 3 bulan)', '02746604445', '', '', 'Listrik iuran (100.000/Bulan), Dapur, Carport, Listrik Iuran, Akses Mobil.'),
(6, 'ANF KARYA', 'Info kontrakan Sekitaran Pasar Colombo,UGM,UNY.', 'nego', '08572987241', '', '', 'Kamar mandi : 2\r\nDapur,Ruang Tamu,Ruang Krluarga,Carport,Listrik 1300Watt,Air Sanyo,Keramik,Teras,Pagar,Akses Mobil.\r\n'),
(7, 'ANF KARYA', 'Info kontrakan Dekat UPN,YKPN,UII. ', 'Rp.500.000-650.000/bulan', '02746604445', '', '', 'Kamar tidur : Masih 2(3x4 km.dalam) 1(3X3 km.Luar).Kamar mandi : dalam/luar. Listrik, Keramik, Dapur,(Kasur, Almari Meja, Kursi)Carport, Teras, Akses Mobil, Bebas Jam Malam. '),
(8, 'ANF KARYA', 'Info kontrakan Sekitaran UPN.', 'Rp. 500.000/Bulan', '08572987241', '', '', 'Kamar Tidur : 1. Kamar mandi : Luar. Parkir Bersama, Listrik Free, Keramik, Isi (Lemari), Pagar, Akses Mobil.\r\n'),
(9, 'ANF KARYA', 'Info kontrakan Sekitaran Pamela 6.', 'Rp. 4.000.000/Tahun', '085729872416', '', '', 'Kamar Tidur : 2. Kamar mandi : Luar. Dapur Bersama, Parkir Bersama, Listrik Free, Keramik, Pagar, Akses Mobil.\r\n'),
(10, 'ANF KARYA', 'Info kontrakan Sekitaran AMP YKPN,Hyatt Hotel.', 'Rp.12.000.000/Tahun', '085729872416', '', '', 'Kamar Tidur : 3. Kamar mandi : 1. Ruang Tamu,Ruang Keluarga,Listrik 900Watt,Air Sanyo,Keramik,Akses Mobil'),
(11, 'ANF KARYA', 'Info kontrakan Sekitaran UNRIYO.', 'Rp. 13.000.000/Tahun', '085729872416', '', '', 'Kamar Tidur : 2. Kamar mandi : 1. Dapur, Ruang Tamu, Ruang Keluarga, Listrik 900Watt, Air Sumur, Keramik, Teras, Akses Mobil. '),
(12, 'ANF KARYA', 'Info kontrakan Sekitaran UNRIYO.', 'Rp. 12.500.000/Tahun', '085729872416', '', '', 'Kamar Tidur : 2. Kamar mandi : 1. Ruang Tamu, Ruang Keluarga, Listrik 900Watt, Air Sumur, Keramik, Teras, Akses Mobil. '),
(13, 'ANF KARYA', 'Info kontrakan Sekitaran UNRIYO.', 'Rp. 14.000.000/Tahun', '085729872416', '', '', 'Kamar Tidur : 2. Kamar mandi : 2. Dapur, Ruang Tamu, Ruang Keluarga, Carport, Listrik 900Watt, Air Sumur, Keramik, Teras, Akses Mobil. '),
(14, 'ANF KARYA', 'Info kontrakan Sekitaran Superindo, Pasar Colombo, UGM, UNY.', 'nego', '085729872416', '', '', 'Kamar Tidur :4. Kamar mandi : 2. Dapur, Ruang Tamu, Ruang Keluarga, Garasi, Listrik 1300Watt, Air Sumur, Keramik, Teras, Pagar, Akses Mobil.'),
(15, 'ANF KARYA', 'Info kontrakan Sekitaran INSTIPER,STTNAS.', '15.000.000/Tahun', '085729872416', '', '', 'Kamar tidur : 3. Kamar mandi : 1. Dapur, Ruang Tamu,Listrik 900watt,Air Sanyo, Keramik,Teras, Akses Mobil'),
(16, 'ANF KARYA', 'Info kontrakan Dekat Hotel Quality,INSTIPER. ', 'Rp.14.000.000/Tahun ', '085729872416', '', '', 'Kamar tidur : 2. Kamar mandi : 1. Dapur, Ruang Tamu,Ruang Keluarga,Listrik 900Watt,Air Sanyo,Keramik,Akses Mobil.'),
(17, 'ANF KARYA', 'Info kontrakan Dekat SADHAR,INSTIPER,STIE YKPN,FE UII', 'Rp.19.000.000/Tahun ', '085799239800', '', '', 'Kamar tidur : 3. Kamar mandi : 1. Dapur, Ruang Tamu,Ruang Keluarga,Listrik 2300Watt,Air Sanyo,Keramik,Akses Mobil.  '),
(18, 'ANF KARYA', 'Info kontrakan Sekitaran Pasar Colombo,UGM,UNY.', 'nego', '085729872416', '', '', 'Kamar Tidur : 3. Kamar mandi : 1. Dapur,Ruang Tamu,Garasi,Listrik 900Watt, Air Sumur,Keramik,Teras,Akses Motor'),
(19, 'ANF KARYA', 'Info kontrakan Sekitaran FE UII,AMIKOM,UPN.', 'Rp. 17.000.000/Tahun ', '085729872416', '', '', 'Kamar Tidur : 4. Kamar mandi : 1. Dapur,Ruang Tamu,Garasi,Listrik 900Watt,Air Sumur,Keramik,Teras,Akses Mobil'),
(20, 'ANF KARYA', 'Info kontrakan Sekitaran Jembatan Merah, Mercubuana, UGM, UNY.', 'Rp. 24.000.000/Tahun ', '085729872416', '', '', 'Kamar Tidur : 3 (3x4)/AC 2 Unit. Kamar mandi : 1. Dapur, Ruang Tamu, Ruang Keluarga, Garasi, Listrik Pulsa 900Watt, Air Sumur, Keramik,Teras, AC, Akses Mobil.\r\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
