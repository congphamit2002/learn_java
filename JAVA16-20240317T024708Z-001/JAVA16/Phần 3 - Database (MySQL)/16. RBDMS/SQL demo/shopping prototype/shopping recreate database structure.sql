-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: java13_shopping
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `MaDH` int(11) NOT NULL,
  `MaMH` int(11) NOT NULL,
  `MaKC` varchar(10) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaDH`,`MaMH`,`MaKC`),
  KEY `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH`),
  KEY `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH`),
  KEY `FK_CTDH_CTMH` (`MaMH`,`MaKC`),
  CONSTRAINT `FK_CTDH_CTMH` FOREIGN KEY (`MaMH`, `MaKC`) REFERENCES `chitietmathang` (`MaMH`, `MaKC`),
  CONSTRAINT `FK_CTDH_DH` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chitietmathang`
--

DROP TABLE IF EXISTS `chitietmathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietmathang` (
  `MaMH` int(11) NOT NULL,
  `MaKC` varchar(10) NOT NULL,
  `HinhAnh` varchar(255) NOT NULL,
  `GiaBan` double NOT NULL,
  `GiaMua` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaMH`,`MaKC`),
  KEY `fk_MatHang_has_KichCo_KichCo1_idx` (`MaKC`),
  KEY `fk_MatHang_has_KichCo_MatHang_idx` (`MaMH`),
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1` FOREIGN KEY (`MaKC`) REFERENCES `kichco` (`MaKC`),
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang` FOREIGN KEY (`MaMH`) REFERENCES `mathang` (`MaMH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chitiettinhtrangdonhang`
--

DROP TABLE IF EXISTS `chitiettinhtrangdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiettinhtrangdonhang` (
  `MaDH` int(11) NOT NULL,
  `MaTT` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  PRIMARY KEY (`MaDH`,`MaTT`),
  KEY `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1_idx` (`MaTT`),
  KEY `fk_DonHang_has_TinhTrangDonHang_DonHang1_idx` (`MaDH`),
  KEY `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV`),
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE,
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_DonHang1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`),
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1` FOREIGN KEY (`MaTT`) REFERENCES `tinhtrangdonhang` (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `MaCV` int(11) NOT NULL,
  `TenCV` varchar(255) NOT NULL,
  PRIMARY KEY (`MaCV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `MaDH` int(11) NOT NULL,
  `DiaChiGiaoHang` text NOT NULL,
  `SDTNguoiNhan` varchar(255) NOT NULL,
  `ThoiGianDatHang` datetime NOT NULL,
  `PhiVanChuyen` double NOT NULL,
  `TongTien` double NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaLHTT` int(11) NOT NULL,
  `GhiChu` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`MaDH`),
  KEY `fk_DonHang_NhanVien1_idx` (`MaNV`),
  KEY `fk_DonHang_KhachHang1_idx` (`MaKH`),
  KEY `fk_DonHang_LoaiHinhThanhToan1_idx` (`MaLHTT`),
  CONSTRAINT `fk_DonHang_KhachHang1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1` FOREIGN KEY (`MaLHTT`) REFERENCES `loaihinhthanhtoan` (`MaLHTT`),
  CONSTRAINT `fk_DonHang_NhanVien1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `MaDH` int(11) NOT NULL,
  `NgayXuatHoaDon` datetime DEFAULT NULL,
  `SoTienCanThanhToan` double DEFAULT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `fk_HoaDon_DonHang1_idx` (`MaDH`),
  CONSTRAINT `fk_HoaDon_DonHang1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `TenKH` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `DiaChi` text NOT NULL,
  `SDT` varchar(255) NOT NULL,
  `MXH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kichco`
--

DROP TABLE IF EXISTS `kichco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kichco` (
  `MaKC` varchar(10) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`MaKC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loaihang`
--

DROP TABLE IF EXISTS `loaihang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaihang` (
  `MaLH` int(11) NOT NULL,
  `TenLH` varchar(255) NOT NULL,
  PRIMARY KEY (`MaLH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loaihinhthanhtoan`
--

DROP TABLE IF EXISTS `loaihinhthanhtoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaihinhthanhtoan` (
  `MaLHTT` int(11) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mathang`
--

DROP TABLE IF EXISTS `mathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathang` (
  `MaMH` int(11) NOT NULL,
  `TenMH` varchar(255) NOT NULL,
  `MauSac` varchar(255) NOT NULL,
  `MaLH` int(11) NOT NULL,
  PRIMARY KEY (`MaMH`),
  KEY `fk_MatHang_LoaiHang1_idx` (`MaLH`),
  CONSTRAINT `FK_MatHang_LoaiHang` FOREIGN KEY (`MaLH`) REFERENCES `loaihang` (`MaLH`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL AUTO_INCREMENT,
  `TenNV` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `SDT` varchar(255) NOT NULL,
  `DiaChi` text NOT NULL,
  `MatKhau` varchar(255) NOT NULL,
  `MaCV` int(11) NOT NULL,
  PRIMARY KEY (`MaNV`),
  KEY `fk_NhanVien_ChucVu1_idx` (`MaCV`),
  CONSTRAINT `fk_NhanVien_ChucVu1` FOREIGN KEY (`MaCV`) REFERENCES `chucvu` (`MaCV`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tinhtrangdonhang`
--

DROP TABLE IF EXISTS `tinhtrangdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tinhtrangdonhang` (
  `MaTT` int(11) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-30 18:55:10
