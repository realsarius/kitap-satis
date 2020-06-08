-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- kitapsatis için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `kitapsatis` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `kitapsatis`;

-- tablo yapısı dökülüyor kitapsatis.address
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL DEFAULT 0,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.address: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.adminler
CREATE TABLE IF NOT EXISTS `adminler` (
  `admin_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `admin_email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `admin_sifre` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.adminler: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `adminler` DISABLE KEYS */;
INSERT INTO `adminler` (`admin_id`, `admin_email`, `admin_sifre`) VALUES
	(1, 'aydin@mail.com', '12345');
/*!40000 ALTER TABLE `adminler` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.category
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_adi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.category: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`category_id`, `category_adi`) VALUES
	(1, 'Psikoloji'),
	(2, 'Gerilim'),
	(3, 'Dram'),
	(4, 'Fantastik'),
	(5, 'Bilim kurgu'),
	(6, 'Polisiye');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_first_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `customer_last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.customer: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.kitaplar
CREATE TABLE IF NOT EXISTS `kitaplar` (
  `kitap_id` int(11) NOT NULL,
  `kitap_adi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kitap_yazari` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kitap_sayfa_sayisi` int(11) DEFAULT NULL,
  `kitap_cikis_tarihi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kitap_eklenme_tarihi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kitap_stok_sayisi` int(11) DEFAULT NULL,
  PRIMARY KEY (`kitap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.kitaplar: ~16 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kitaplar` DISABLE KEYS */;
INSERT INTO `kitaplar` (`kitap_id`, `kitap_adi`, `kitap_yazari`, `kitap_sayfa_sayisi`, `kitap_cikis_tarihi`, `kitap_eklenme_tarihi`, `kitap_stok_sayisi`) VALUES
	(1, 'Harry Potter ve Felsefe taşı', 'J. K. Rowling', 782, '26 haziran 1997', '12 Mayıs 2020', 3),
	(2, 'Harry Potter ve Sırlar Odası', 'J. K. Rowling', 316, '2 temmuz 1999', '12 Mayıs 2020', 4),
	(3, 'Harry Potter and the Prisoner of Azkaban', 'J. K. Rowling', 737, ' 8  temmuz 1999', '23 Mart 2020', 3),
	(4, 'Harry Potter ve Ateş Kadehi', 'J. K. Rowling', 768, '7 temmuz 2000', '12 Mayıs 2020', 4),
	(5, 'Harry Potter ve Zümrüdüanka Yoldaşlığı', 'J. K. Rowling', 598, '21 haziran 2003', '12 Mayıs 2020', 4),
	(6, 'Harry Potter ve Melez Presn', 'J. K. Rowling', 606, '16 Temmuz 2005', '12 Mayıs 2020', 4),
	(7, 'Harry Potter ve Ölümcül Kutsamalar', 'J. K. Rowling', 609, ' 21 Temmuz 2007', '12 Mayıs 2020', 5),
	(8, 'Suç ve Ceza', 'Fyodor Dostoyevski', 688, '1866', '12 Mayıs 2020', 10),
	(9, 'Sefiller', 'Victor Hugo', 1352, '1862', '12 Mayıs 2020', 7),
	(10, 'Notre Dame\'ın Kamburu', 'Victor Hugo', 952, '1832', '12 Mayıs 2020', 10),
	(11, 'Romeo ve Juliet', 'William Shakespeare', 856, '15.yüzyıl', '12 Mayıs 2020', 10),
	(12, 'Gazap Üzümleri', 'John Steinbeck', 875, '8 haziran 1939', ' 12 Mayıs 2020', 25),
	(13, 'Babalar ve Oğullar', 'Ivan Turgenyev', 756, '18 eylül 1862', '12 Mayıs 2020', 10),
	(14, 'Ana', 'Maksim Gorki', 758, '26 ekim 1917', '12 Mayıs 2020', 25),
	(15, 'Madame Bovary', 'Gustave Flaubert', 565, '12 ocak 1857', '12 Mayıs 2020', 20),
	(16, 'İki Şehrin Hikayesi ', 'Charles Dickens', 952, '1859', '12 Mayıs 2020', 10);
/*!40000 ALTER TABLE `kitaplar` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.language
CREATE TABLE IF NOT EXISTS `language` (
  `language_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `language_adi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.language: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`language_id`, `language_adi`) VALUES
	(1, 'Türkçe'),
	(2, 'İngilizce'),
	(3, 'İspanyolca'),
	(4, 'Arapça'),
	(5, 'Fransızca'),
	(6, 'Japonca'),
	(7, 'Almanca');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- tablo yapısı dökülüyor kitapsatis.yazar
CREATE TABLE IF NOT EXISTS `yazar` (
  `yazar_id` int(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `yazar_adi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `yazar_info` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`yazar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- kitapsatis.yazar: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yazar` DISABLE KEYS */;
INSERT INTO `yazar` (`yazar_id`, `yazar_adi`, `yazar_info`) VALUES
	(01, 'J. K. Rowling', 'Joanne Rowling, 31 Temmuz 1965\'te Chipping Sodburry, İngiltere\'de doğdu. Ailesiyle birlikte Bristol\'e, daha sonra da Chepstow\'a taşındı.Önemli eseri:Harry Potter serisi'),
	(02, 'Fyodor Dostoyevski', 'Doğum 11 Kasım 1821Moskova.Ölüm 9 Şubat 1881 (59 yaşında)Sankt-Peterburg, Rus İmparatorluğuMeslek Yazar, Askeri Mühendis.Milliyet RusDönem 1846–1881.Tür Roman Öykü'),
	(03, 'Victor Hugo', 'Victor Marie Hugo,Romantik akıma bağlı Fransız şair, romancı ve oyun yazarı. En büyük ve ünlü Fransız yazarlardan biri kabul edilir. Hugo\'nun Fransa\'daki edebi ünü ilk olarak şiirlerinden sonra da romanlarından gelir. Fransa dışında en çok Sefiller ve Not'),
	(04, 'William Shakespeare', 'William Shakespeare, İngiliz şair, oyun yazarı ve oyuncu. Çoklukla İngilizce dilinin en büyük yazarı ve dünyanın en iyi oyun yazarı olarak anılır. İngiltere\'nin ulusal şairi ve "Avon\'un Ozanı" olarak da bilinir'),
	(05, 'John Steinbeck', 'John Steinbeck, Amerikalı gerçekçi yazar. Eserlerinde genellikle İşçi yaşamını ve toplumsal sorunları dile getirdi. Gençliğinde bir zamanlar çalıştığı Salinas Vadisi onun eserleri için vazgeçilmez bir mekandır.'),
	(06, 'Ivan Turgenyev', 'İvan Sergeyeviç Turgenyev Rus şair, yazar, oyun yazarı, çevirmen.Doğum tarihi: 9 Kasım 1818.Eğitim: Humboldt Üniversitesi (1838–1841), Sankt-Peterburg Devlet Üniversitesi (1834–1837), Moskova Devlet Üniversitesi'),
	(07, 'Maksim Gorki', 'Aleksey Maksimoviç Peşkov, en çok bilinen adı ile Maksim Gorki, Sovyet Rus yazar, sosyalist gerçekçi yazımın öncüsü politik eylemci.Doğum tarihi: 28 Mart 1868,Dünya klasıkleri arsında eserleri bulunmaktadır.'),
	(08, 'Gustave Flaubert', 'Edebiyat eleştirmenleri tarafından modern romanın kurucusu kabul edilir. En tanınmış eseri, 19. yüzyıl toplumsal gerçekliğini çarpıcı biçimde aktaran ve dünya klasikleri arasına giren Madame Bovary\'dir.\r\n'),
	(09, 'Charles Dickens', 'Charles John Huffam Dickens, İngiliz yazar ve toplum eleştirmeni. En unutulmaz kurgusal karakterlerden bazılarını yaratmasının yanında Victoria devrinin en iyi romancısı olarak kabul edilir.');
/*!40000 ALTER TABLE `yazar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
