-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gscdb
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `cad2examrel`
--

DROP TABLE IF EXISTS `cad2examrel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cad2examrel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `source` int NOT NULL COMMENT 'Candidate ''id''',
  `target` int NOT NULL COMMENT 'exam ''id''',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cad2examrel`
--

LOCK TABLES `cad2examrel` WRITE;
/*!40000 ALTER TABLE `cad2examrel` DISABLE KEYS */;
/*!40000 ALTER TABLE `cad2examrel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate` (
  `code` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `school` int NOT NULL,
  `class` int NOT NULL,
  `dob` date DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'ACTIVE',
  `gender` varchar(1) DEFAULT NULL,
  `exam` int DEFAULT NULL,
  `roll` int DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=967 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (291,'alfia parvin',6,7,NULL,'ACTIVE','F',25,1),(292,'Srimoyee Halder',6,7,NULL,'ACTIVE','F',25,2),(293,'Soumita Ghosh',6,7,NULL,'ACTIVE','F',25,3),(294,'Rwitam Bej',6,7,NULL,'ACTIVE','M',25,4),(295,'Mayukh Ghosh',6,7,NULL,'ACTIVE','M',25,5),(413,'Soham Chatterjee',6,6,NULL,'ACTIVE','M',25,1),(414,'rupam ghosh',6,6,NULL,'ACTIVE','M',25,2),(415,'kairav das',6,6,NULL,'ACTIVE','M',25,3),(416,'ayan ghosh',6,6,NULL,'ACTIVE','M',25,4),(417,'arijit patra',6,6,NULL,'ACTIVE','M',25,5),(418,'ranak banerjee',6,6,NULL,'ACTIVE','M',25,6),(419,'arpan das',6,6,NULL,'ACTIVE','M',25,7),(420,'soutrik ghosh',6,6,NULL,'ACTIVE','M',25,8),(421,'soham bhar',6,6,NULL,'ACTIVE','M',25,9),(422,'subhro das',6,6,NULL,'ACTIVE','M',25,10),(423,'asmit negel',6,6,NULL,'ACTIVE','M',25,11),(424,'soham ghosh',6,6,NULL,'ACTIVE','M',25,12),(425,'aditya biswas',6,6,NULL,'ACTIVE','M',25,13),(426,'ayush koley',6,6,NULL,'ACTIVE','M',25,14),(427,'debayan chakraborty (1)',6,6,NULL,'ACTIVE','M',25,15),(428,'koustav naskar',6,6,NULL,'ACTIVE','M',25,16),(429,'abhirup shit',6,6,NULL,'ACTIVE','M',25,17),(430,'wriddhiraj chakraborty',6,6,NULL,'ACTIVE','M',25,18),(431,'ayan banerjee',6,6,NULL,'ACTIVE','M',25,19),(432,'soumya patra',6,6,NULL,'ACTIVE','M',25,20),(433,'rohit mondal',6,6,NULL,'ACTIVE','M',25,21),(434,'minu pal',6,6,NULL,'ACTIVE','F',25,22),(435,'monorama polley',6,6,NULL,'ACTIVE','F',25,23),(436,'piyasa modak',6,6,NULL,'ACTIVE','F',25,24),(437,'piyansha adhikary',6,6,NULL,'ACTIVE','F',25,25),(438,'Aindrila barman',6,6,NULL,'ACTIVE','F',25,26),(439,'sayani nandi',6,6,NULL,'ACTIVE','F',25,27),(440,'Nibedita das',6,6,NULL,'ACTIVE','F',25,28),(441,'srijani santra',6,6,NULL,'ACTIVE','F',25,29),(442,'rittika dhar',6,6,NULL,'ACTIVE','F',25,30),(443,'ritisha banduri',6,6,NULL,'ACTIVE','F',25,31),(444,'krittika shee',6,6,NULL,'ACTIVE','F',25,32),(445,'samadrita sarkar',6,6,NULL,'ACTIVE','F',25,33),(446,'sanchita naskar',6,6,NULL,'ACTIVE','F',25,34),(447,'enakshi sen',6,6,NULL,'ACTIVE','F',25,35),(448,'debolina dey',6,6,NULL,'ACTIVE','F',25,36),(449,'soumi ghosh',6,6,NULL,'ACTIVE','F',25,37),(450,'adwitia polley',6,6,NULL,'ACTIVE','F',25,38),(451,'sudeshna mondal',6,6,NULL,'ACTIVE','F',25,39),(452,'shrijani nandy',6,6,NULL,'ACTIVE','F',25,40),(453,'kastturi pal',6,6,NULL,'ACTIVE','F',25,41),(454,'bristy ghosh',6,6,NULL,'ACTIVE','F',25,42),(455,'shirin khatun',6,6,NULL,'ACTIVE','F',25,43),(456,'eshani chatterjee',6,6,NULL,'ACTIVE','F',25,44),(457,'TITLY PRAMANIK',6,5,NULL,'ACTIVE','F',25,1),(458,'NAVOLINA PRAMANIK',6,5,NULL,'ACTIVE','F',25,2),(459,'APABRITA DAS',6,5,NULL,'ACTIVE','F',25,3),(460,'ABANTIKA GHOSH',6,5,NULL,'ACTIVE','F',25,4),(461,'SAYANTANI MAITY',6,5,NULL,'ACTIVE','F',25,5),(462,'NANDITA CHAKRABORTY',6,5,NULL,'ACTIVE','F',25,6),(463,'DEBOPRIYA ACHARYA',6,5,NULL,'ACTIVE','F',25,7),(464,'PARIMITA DAS',6,5,NULL,'ACTIVE','F',25,8),(465,'ADRIJA CHAKRABORTY',6,5,NULL,'ACTIVE','F',25,9),(466,'TIYASHA MANNA ',6,5,NULL,'ACTIVE','F',25,10),(467,'BHOOMIKA MALAKAR',6,5,NULL,'ACTIVE','F',25,11),(468,'DEBASMITA CHOWDHURY',6,5,NULL,'ACTIVE','F',25,12),(469,'SRIJITA BHOWMICK',6,5,NULL,'ACTIVE','F',25,13),(470,'CHIROSRI DEY',6,5,NULL,'ACTIVE','F',25,14),(471,'KONKANA SADHUKHAN',6,5,NULL,'ACTIVE','F',25,15),(472,'ANWESHA GHOSH',6,5,NULL,'ACTIVE','F',25,16),(473,'Sonaxi Bhattachariya',6,5,NULL,'ACTIVE','F',25,17),(474,'PRAGYA SASTRI',6,5,NULL,'ACTIVE','F',25,18),(475,'MANALI DAS',6,5,NULL,'ACTIVE','F',25,19),(476,'ANUSHKA SHEE',6,5,NULL,'ACTIVE','F',25,20),(477,'SHRAYOSI MUKHERJEE',6,5,NULL,'ACTIVE','F',25,21),(478,'SONAKSHI SEN',6,5,NULL,'ACTIVE','F',25,22),(479,'SHRANYA ROY',6,5,NULL,'ACTIVE','F',25,23),(480,'ADRISHA SAHA',6,5,NULL,'ACTIVE','F',25,24),(481,'ANINDITA MONDAL',6,5,NULL,'ACTIVE','F',25,25),(482,'TANIA BANDURI',6,5,NULL,'ACTIVE','F',25,26),(483,'SOUMILI BHATTACHARJEE',6,5,NULL,'ACTIVE','F',25,27),(484,'SOUMILI PAUL',6,5,NULL,'ACTIVE','F',25,28),(485,'SAMPURNA DEY',6,5,NULL,'ACTIVE','F',25,29),(486,'SHILPA BANERJEE',6,5,NULL,'ACTIVE','F',25,30),(487,'SHRISTI GHOSH',6,5,NULL,'ACTIVE','F',25,31),(488,'SONAKSHI CHAKRABORTY',6,5,NULL,'ACTIVE','F',25,32),(489,'UTTITHA BAIRAGI',6,5,NULL,'ACTIVE','F',25,33),(490,'SNEHASREE CHATTERJEE',6,5,NULL,'ACTIVE','F',25,34),(491,'TANISHA MULLICK',6,5,NULL,'ACTIVE','F',25,35),(492,'SRIJANI ROY',6,5,NULL,'ACTIVE','F',25,36),(493,'DIPAYAN MAJUMDAR',6,5,NULL,'ACTIVE','M',25,37),(494,'AGNIVA SENGUPTA',6,5,NULL,'ACTIVE','M',25,38),(495,'SOUMAJIT GHORUI',6,5,NULL,'ACTIVE','M',25,39),(496,'SHREYAN GHOSH',6,5,NULL,'ACTIVE','M',25,40),(497,'SOUMADEEP NASKAR',6,5,NULL,'ACTIVE','M',25,41),(498,'ANIK DEY',6,5,NULL,'ACTIVE','M',25,42),(499,'ROHIT MANNA',6,5,NULL,'ACTIVE','M',25,43),(500,'SK. MD. ARABUL ISLAM',6,5,NULL,'ACTIVE','M',25,44),(501,'AYUSH PAL',6,5,NULL,'ACTIVE','M',25,45),(502,'SAYAN GHOSH',6,5,NULL,'ACTIVE','M',25,46),(503,'RIKTAM SANA',6,8,NULL,'ACTIVE','M',25,1),(504,'SUMAN SANTRA',6,8,NULL,'ACTIVE','M',25,2),(505,'PALLAB DAS',6,8,NULL,'ACTIVE','M',25,3),(506,'UJAN BHUIYA',6,8,NULL,'ACTIVE','M',25,4),(507,'MD. ISRAFIL MOLLA',6,8,NULL,'ACTIVE','M',25,5),(508,'RUDRANIL HATI',6,8,NULL,'ACTIVE','M',25,6),(509,'DIPTA HALDAR',6,8,NULL,'ACTIVE','M',25,7),(510,'SASHRIK POLLEY',6,8,NULL,'ACTIVE','M',25,8),(511,'ARKAPRAVA DAS',6,8,NULL,'ACTIVE','M',25,9),(512,'RIBRO PATRA',6,8,NULL,'ACTIVE','M',25,10),(513,'SOUVIK MITRA',6,8,NULL,'ACTIVE','M',25,11),(514,'RITABRATA DAS',6,8,NULL,'ACTIVE','M',25,12),(515,'MD. MANISH SK.',6,8,NULL,'ACTIVE','M',25,13),(516,'SAIKAT GHOSH',6,8,NULL,'ACTIVE','M',25,14),(517,'UTSAB GHOSH',6,8,NULL,'ACTIVE','M',25,15),(518,'SOURANYA MANNA',6,8,NULL,'ACTIVE','M',25,16),(519,'PRITAM BHAT',6,8,NULL,'ACTIVE','M',25,17),(520,'JIT GHOSH',6,8,NULL,'ACTIVE','M',25,18),(521,'SAROLIPI GHOSH',6,8,NULL,'ACTIVE','F',25,19),(522,'DAITREE BHOWMICK',6,8,NULL,'ACTIVE','F',25,20),(523,'RITU SHAW',6,8,NULL,'ACTIVE','F',25,21),(524,'RIDDHIMA DAS',6,8,NULL,'ACTIVE','F',25,22),(525,'ANANYA DUTTA',6,8,NULL,'ACTIVE','F',25,23),(526,'BIDIPTA KONAR',6,8,NULL,'ACTIVE','F',25,24),(527,'DRISHA MISHRA',6,8,NULL,'ACTIVE','F',25,25),(528,'ISHA ACHARYA',6,8,NULL,'ACTIVE','F',25,26),(529,'MONALISA CHATTERJEE',6,3,NULL,'ACTIVE','F',25,1),(530,'SUCHITRA BISWAS',6,3,NULL,'ACTIVE','F',25,2),(531,'ADROVIKA DAS',6,3,NULL,'ACTIVE','F',25,3),(532,'MANAMI ROY',6,3,NULL,'ACTIVE','F',25,4),(533,'APARUPA DHAR',6,3,NULL,'ACTIVE','F',25,5),(534,'SUPARBA NASKAR',6,3,NULL,'ACTIVE','F',25,6),(535,'ANINDITA BANDURI',6,3,NULL,'ACTIVE','F',25,7),(536,'SAYANTI GHOSH',6,3,NULL,'ACTIVE','F',25,8),(537,'SOUMILI BHATTACHARJEE',6,3,NULL,'ACTIVE','F',25,9),(538,'SWASTIKA CHATTERJEE',6,3,NULL,'ACTIVE','F',25,10),(539,'RASMOYEE NASKAR',6,3,NULL,'ACTIVE','F',25,11),(540,'DIYA KARMAKAR',6,3,NULL,'ACTIVE','F',25,12),(541,'RITOSMITA SAMANTA',6,3,NULL,'ACTIVE','F',25,13),(542,'AHANA ROY',6,3,NULL,'ACTIVE','F',25,14),(543,'BARNINI MUKHERJEE',6,3,NULL,'ACTIVE','F',25,15),(544,'KOHELI CHOWDHURY',6,3,NULL,'ACTIVE','F',25,16),(545,'DEBANJALI PATRA',6,3,NULL,'ACTIVE','F',25,17),(546,'SOUJANYA DEBNATH',6,3,NULL,'ACTIVE','F',25,18),(547,'ANWITA GHOSH',6,3,NULL,'ACTIVE','F',25,19),(548,'SAMPRITI GHOSH',6,3,NULL,'ACTIVE','F',25,20),(549,'ATRI GHOSH',6,3,NULL,'ACTIVE','F',25,21),(550,'MANAMI GHOSH',6,3,NULL,'ACTIVE','F',25,22),(551,'RAI NASKAR',6,3,NULL,'ACTIVE','F',25,23),(552,'ISHANI GHOSH',6,3,NULL,'ACTIVE','F',25,24),(553,'KOUSHIKI DHOLEY',6,3,NULL,'ACTIVE','F',25,25),(554,'SHREYA KOLEY',6,3,NULL,'ACTIVE','F',25,26),(555,'BIDISHA KOLEY',6,3,NULL,'ACTIVE','F',25,27),(556,'SPRIHA KOLEY',6,3,NULL,'ACTIVE','F',25,28),(557,'AISHANI CHATTERJEE',6,3,NULL,'ACTIVE','F',25,29),(558,'SOUMI SARKAR',6,3,NULL,'ACTIVE','F',25,30),(559,'SOHINI CHATTERJEE',6,3,NULL,'ACTIVE','F',25,31),(560,'KOUSTAV BHUNIYA',6,3,NULL,'ACTIVE','M',25,32),(561,'SHIVAM DAS',6,3,NULL,'ACTIVE','M',25,33),(562,'PRIYAANSHU GHOSH',6,3,NULL,'ACTIVE','M',25,34),(563,'MANGALDEEP SHIT',6,3,NULL,'ACTIVE','M',25,35),(564,'SHREYAN PAN',6,3,NULL,'ACTIVE','M',25,36),(565,'RAJANYA SINHA',6,3,NULL,'ACTIVE','M',25,37),(566,'PRANTIK GARAI',6,3,NULL,'ACTIVE','M',25,38),(567,'SAYON GHOSH',6,3,NULL,'ACTIVE','M',25,39),(568,'RUPAYAN GHOSH ',6,3,NULL,'ACTIVE','M',25,40),(569,'SAPTARKI BHATTACHARYA',6,3,NULL,'ACTIVE','M',25,41),(570,'RICK GHOSH',6,3,NULL,'ACTIVE','M',25,42),(571,'SNEHANGSHU CHAKRABORTY',6,3,NULL,'ACTIVE','M',25,43),(572,'ABHAS KOLEY',6,3,NULL,'ACTIVE','M',25,44),(573,'OISRONU DAS',6,3,NULL,'ACTIVE','M',25,45),(574,'KOUSTAV DAS',6,3,NULL,'ACTIVE','M',25,46),(575,'AVIRAJ PARIJA',6,3,NULL,'ACTIVE','M',25,47),(576,'ARGHAJIT DAS',6,3,NULL,'ACTIVE','M',25,48),(577,'SOHAN ADHIKARI',6,3,NULL,'ACTIVE','M',25,49),(578,'REHAN GHOSH',6,3,NULL,'ACTIVE','M',25,50),(579,'SRITAM KARMAKAR',6,3,NULL,'ACTIVE','M',25,51),(580,'SK. SAKIBUR RAHAMAN',6,3,NULL,'ACTIVE','M',25,52),(581,'ANSHU ADHIKARY',6,3,NULL,'ACTIVE','M',25,53),(582,'PRADIPAN DEY',6,3,NULL,'ACTIVE','M',25,54),(583,'ANURAG SHEET',6,3,NULL,'ACTIVE','M',25,55),(584,'SUBHADEEP DALUI',6,3,NULL,'ACTIVE','M',25,56),(585,'ARNAB MAL',6,3,NULL,'ACTIVE','M',25,57),(586,'DEBABRATA MUDI',6,3,NULL,'ACTIVE','M',25,58),(587,'SUBHADIP SEN',6,3,NULL,'ACTIVE','M',25,59),(588,'AISHNIK CHATTERJEE',6,3,NULL,'ACTIVE','M',25,60),(589,'LAVITRA SARBAGNA',6,3,NULL,'ACTIVE','M',25,61),(590,'TANUSHREE DAS',6,2,NULL,'ACTIVE','F',25,1),(591,'MOUMITA MUKHERJEE',6,2,NULL,'ACTIVE','F',25,2),(592,'PRISHA DAS',6,2,NULL,'ACTIVE','F',25,3),(593,'AISHI MONDAL',6,2,NULL,'ACTIVE','F',25,4),(594,'TRIYASHA SANTRA ',6,2,NULL,'ACTIVE','F',25,5),(595,'SOUMITA MUKHERJEE',6,2,NULL,'ACTIVE','F',25,6),(596,'SOUPTIKA ROY',6,2,NULL,'ACTIVE','F',25,7),(597,'AISHANI PAN',6,2,NULL,'ACTIVE','F',25,8),(598,'SRIJANI NASKAR',6,2,NULL,'ACTIVE','F',25,9),(599,'SAMPRITI ROY',6,2,NULL,'ACTIVE','F',25,10),(600,'PUBALI CHATTERJEE',6,2,NULL,'ACTIVE','F',25,11),(601,'PRAPTI MAJHI',6,2,NULL,'ACTIVE','F',25,12),(602,'USHALI GOUTAM',6,2,NULL,'ACTIVE','F',25,13),(603,'BAISHALI CHAKRABORTY',6,2,NULL,'ACTIVE','F',25,14),(604,'PRIAM SANTRA',6,2,NULL,'ACTIVE','M',25,15),(605,'AVIRAJ GHOSH',6,2,NULL,'ACTIVE','M',25,16),(606,'MALLESH GOLUI',6,2,NULL,'ACTIVE','M',25,17),(607,'ARONNAK PAUL',6,2,NULL,'ACTIVE','M',25,18),(608,'RUDRA DHAR',6,2,NULL,'ACTIVE','M',25,19),(609,'SHRISH DARI',6,2,NULL,'ACTIVE','M',25,20),(610,'ANKAN SAMANTA',6,2,NULL,'ACTIVE','M',25,21),(611,'PRIYAM SHEET',6,2,NULL,'ACTIVE','M',25,22),(612,'PARSHAB ATTA',6,2,NULL,'ACTIVE','M',25,23),(613,'IFAJ UDDIN',6,2,NULL,'ACTIVE','M',25,24),(614,'SHREYAS DEY',6,2,NULL,'ACTIVE','M',25,25),(615,'KUSHAL SARKAR',6,2,NULL,'ACTIVE','M',25,26),(616,'SK. FAHIM SHIHAB',6,2,NULL,'ACTIVE','M',25,27),(617,'JISHAN CHAI',6,2,NULL,'ACTIVE','M',25,28),(618,'SUKRIT SEN',6,2,NULL,'ACTIVE','M',25,29),(619,'ADRITO MONDAL',6,2,NULL,'ACTIVE','M',25,30),(620,'RITAM NASKAR',6,2,NULL,'ACTIVE','M',25,31),(621,'SRISTI MALIK',6,4,NULL,'ACTIVE','F',25,1),(622,'ANUSKA BHAT',6,4,NULL,'ACTIVE','F',25,2),(623,'PRAGATI ROY',6,4,NULL,'ACTIVE','F',25,3),(624,'SHRUTI MALIK',6,4,NULL,'ACTIVE','F',25,4),(625,'SUBHANGI GHOSH',6,4,NULL,'ACTIVE','F',25,5),(626,'SUPARBA GHOSH',6,4,NULL,'ACTIVE','F',25,6),(627,'CHNANDRAMOULI POLLEY',6,4,NULL,'ACTIVE','F',25,7),(628,'TRISHA GHOSH',6,4,NULL,'ACTIVE','F',25,8),(629,'SRIJA MONDAL(1)',6,4,NULL,'ACTIVE','F',25,9),(630,'SAMADRITA PALIT',6,4,NULL,'ACTIVE','F',25,10),(631,'ARCHITA DAS',6,4,NULL,'ACTIVE','F',25,11),(632,'RISHITA DUTTA',6,4,NULL,'ACTIVE','F',25,12),(633,'DEVJANI DUTTA',6,4,NULL,'ACTIVE','F',25,13),(634,'AARUSHI PRAJAPATI',6,4,NULL,'ACTIVE','F',25,14),(635,'ADITI MUDI',6,4,NULL,'ACTIVE','F',25,15),(636,'SAYANI NASKAR',6,4,NULL,'ACTIVE','F',25,16),(637,'NAMRATA JALUI',6,4,NULL,'ACTIVE','F',25,17),(638,'ADRIJA PAL',6,4,NULL,'ACTIVE','F',25,18),(639,'SANNIDHYA SARKAR',6,4,NULL,'ACTIVE','F',25,19),(640,'MEGHA DEY',6,4,NULL,'ACTIVE','F',25,20),(641,'PIYUSHA MUKHERJEE',6,4,NULL,'ACTIVE','F',25,21),(642,'AARUSHI BASU RAY CHOWDHURY',6,4,NULL,'ACTIVE','F',25,22),(643,'CHIRASHREE BAG',6,4,NULL,'ACTIVE','F',25,23),(644,'AYUSHI JANA',6,4,NULL,'ACTIVE','F',25,24),(645,'DEBADRITA DUTTA',6,4,NULL,'ACTIVE','F',25,25),(646,'TRIDIPTA NASKAR',6,4,NULL,'ACTIVE','F',25,26),(647,'MITHI GHOSH',6,4,NULL,'ACTIVE','F',25,27),(648,'RAISA GHOSH',6,4,NULL,'ACTIVE','F',25,28),(649,'ADRITA GHOSH',6,4,NULL,'ACTIVE','F',25,29),(650,'KIRTICA DEY',6,4,NULL,'ACTIVE','F',25,30),(651,'SOUMILI DAS',6,4,NULL,'ACTIVE','F',25,31),(652,'SRIJITA GHOSH',6,4,NULL,'ACTIVE','F',25,32),(653,'DEBARGHYA GHOSH',6,4,NULL,'ACTIVE','M',25,33),(654,'SANKHAYAN GHOSH',6,4,NULL,'ACTIVE','M',25,34),(655,'ANIK MONDAL',6,4,NULL,'ACTIVE','M',25,35),(656,'SRIJAN SINGHA',6,4,NULL,'ACTIVE','M',25,36),(657,'SOURASHIS DAS',6,4,NULL,'ACTIVE','M',25,37),(658,'ARITRA NASKAR',6,4,NULL,'ACTIVE','M',25,38),(659,'SANDIPAN SARDAR',6,4,NULL,'ACTIVE','M',25,39),(660,'ANIRBAN SANTRA',6,4,NULL,'ACTIVE','M',25,40),(661,'SOURYAJIT GHOSH',6,4,NULL,'ACTIVE','M',25,41),(662,'SUBHAM KHANRA',6,4,NULL,'ACTIVE','M',25,42),(663,'ARKADEEP  DAS',6,4,NULL,'ACTIVE','M',25,43),(664,'SAYAN BANK',6,4,NULL,'ACTIVE','M',25,44),(665,'PRANJAL CHOWDHURI',6,4,NULL,'ACTIVE','M',25,45),(666,'ARIV DUTTA',6,4,NULL,'ACTIVE','M',25,46),(667,'PRIYAM BALLAV',6,4,NULL,'ACTIVE','M',25,47),(668,'SATIRTHA HAZRA',6,4,NULL,'ACTIVE','M',25,48),(669,'PRATYUSH NASKAR',6,4,NULL,'ACTIVE','M',25,49),(670,'ANUBRATA PAL',6,4,NULL,'ACTIVE','M',25,50),(671,'SHUBHAM DAS(1) ',6,4,NULL,'ACTIVE','M',25,51),(672,'ANKUSH MONDAL',6,4,NULL,'ACTIVE','M',25,52),(673,'ANIRUDDHA BHAT',6,4,NULL,'ACTIVE','M',25,53),(674,'SAMPURAN ACHARYA',6,4,NULL,'ACTIVE','M',25,54),(675,'PRASANNA PATRA',6,4,NULL,'ACTIVE','M',25,55),(676,'SRIJEET DEB',6,4,NULL,'ACTIVE','M',25,56),(677,'SK. ASAD HAQUE',6,4,NULL,'ACTIVE','M',25,57),(678,'UJAN GHOSH',6,4,NULL,'ACTIVE','M',25,58),(679,'ARITRA SANPUI',6,4,NULL,'ACTIVE','M',25,59),(680,'REHAN GHOSH',6,4,NULL,'ACTIVE','M',25,60),(681,'SAYANTAN MANNA',6,4,NULL,'ACTIVE','M',25,61),(682,'DIPANJAN GOSWAMI',6,4,NULL,'ACTIVE','M',25,62),(683,'ABHIRUP MONDAL',6,4,NULL,'ACTIVE','M',25,63),(684,'AISHI GHOSH',7,7,NULL,'ACTIVE','F',25,6),(685,'SNEHA KAMILA',7,7,NULL,'ACTIVE','F',25,7),(686,'KHUSHE MONDAL',7,7,NULL,'ACTIVE','F',25,8),(687,'MANALI MONDAL',7,7,NULL,'ACTIVE','F',25,9),(688,'RIYA SHAW',7,7,NULL,'ACTIVE','F',25,10),(689,'BELA SHAW',7,7,NULL,'ACTIVE','F',25,11),(690,'DISHA GHOSH',7,7,NULL,'ACTIVE','F',25,12),(691,'SRIJA NEGAL',7,7,NULL,'ACTIVE','F',25,13),(692,'RAIMA MIDDEY',7,7,NULL,'ACTIVE','F',25,14),(693,'ISHA MONDAL',7,6,NULL,'ACTIVE','F',25,45),(694,'RIMI RANA',7,6,NULL,'ACTIVE','F',25,46),(695,'DEBINA GHOSH',7,6,NULL,'ACTIVE','F',25,47),(696,'SURANJANA KALWAR',7,6,NULL,'ACTIVE','F',25,48),(697,'AINDRILA KUMAR',7,6,NULL,'ACTIVE','F',25,49),(698,'BISAKHA DAS',7,6,NULL,'ACTIVE','F',25,50),(699,'SUPRITI DUTTA',7,6,NULL,'ACTIVE','F',25,51),(700,'SREEJITA KOLEY',7,6,NULL,'ACTIVE','F',25,52),(701,'PRIYANKA PATRA',7,6,NULL,'ACTIVE','F',25,53),(702,'BEBY SHAW',7,8,NULL,'ACTIVE','F',25,27),(703,'SRIJANI MARIK',7,8,NULL,'ACTIVE','F',25,28),(704,'BRISHTI GHOSH',7,8,NULL,'ACTIVE','F',25,29),(705,'SABITA GHOSH',7,8,NULL,'ACTIVE','F',25,30),(706,'SATARUPA POREL',7,8,NULL,'ACTIVE','F',25,31),(707,'RIYA BASU',7,8,NULL,'ACTIVE','F',25,32),(708,'RUPSA SARKAR',7,8,NULL,'ACTIVE','F',25,33),(709,'ARATRIKA CHOWDHURI',7,8,NULL,'ACTIVE','F',25,34),(710,'DISHA GHOSH',7,8,NULL,'ACTIVE','F',25,35),(711,'ANKITA BHATAK',7,8,NULL,'ACTIVE','F',25,36),(712,'ANANYA GHOSH',7,8,NULL,'ACTIVE','F',25,37),(713,'RUPSA GHOSH',7,8,NULL,'ACTIVE','F',25,38),(714,'TRISHA GHOSH',7,8,NULL,'ACTIVE','F',25,39),(715,'RIMA GHOSH',7,8,NULL,'ACTIVE','F',25,40),(716,'SUBHASHREE PANDIT',7,8,NULL,'ACTIVE','F',25,41),(717,'NATASHA DAS',7,9,NULL,'ACTIVE','F',25,1),(718,'RIMI KOLEY',7,9,NULL,'ACTIVE','F',25,2),(719,'SUHANA MALIK',7,9,NULL,'ACTIVE','F',25,3),(720,'SURANGANA DAS',7,9,NULL,'ACTIVE','F',25,4),(721,'SHREYA GHOSH',7,7,NULL,'ACTIVE','F',25,15),(722,'utsav santra',8,8,NULL,'ACTIVE','M',25,42),(723,'barun das',5,6,NULL,'ACTIVE','M',25,54),(724,'rick negel',5,6,NULL,'ACTIVE','M',25,55),(725,'aditya pandit',5,7,NULL,'ACTIVE','M',25,16),(726,'aniket shaw',5,6,NULL,'ACTIVE','M',25,56),(727,'arnab paul',5,6,NULL,'ACTIVE','M',25,57),(728,'ANIK DOLUI',5,6,NULL,'ACTIVE','M',25,58),(729,'SATWIK GHOSH',5,6,NULL,'ACTIVE','M',25,59),(730,'ARGHO MANNA',5,6,NULL,'ACTIVE','M',25,60),(731,'RAJ THAPA',5,6,NULL,'ACTIVE','M',25,61),(732,'ARPAN FUSTI',5,6,NULL,'ACTIVE','M',25,62),(733,'SANDIP SAMANTA',5,6,NULL,'ACTIVE','M',25,63),(734,'PALLAB GHOSH',5,6,NULL,'ACTIVE','M',25,64),(735,'MAHIT SAMANTA',5,6,NULL,'ACTIVE','M',25,65),(736,'PALLAB MALIK',5,6,NULL,'ACTIVE','M',25,66),(737,'AVIJIT DAS',5,6,NULL,'ACTIVE','M',25,67),(738,'MOITRO PAL',5,6,NULL,'ACTIVE','M',25,68),(739,'PIYUSH BHATAK',5,6,NULL,'ACTIVE','M',25,69),(740,'RUPAM BHATTARCHARYA',5,6,NULL,'ACTIVE','M',25,70),(741,'AYAN GHOSH',5,6,NULL,'ACTIVE','M',25,71),(742,'SK. AKIF',5,5,NULL,'ACTIVE','M',25,47),(743,'ISHAN ROY',5,5,NULL,'ACTIVE','M',25,48),(744,'RAHUL ROY',5,5,NULL,'ACTIVE','M',25,49),(745,'PRIYANGSHU BASU',5,5,NULL,'ACTIVE','M',25,50),(746,'SHOURJO PAL',5,5,NULL,'ACTIVE','M',25,51),(747,'KIRAN PATRA',5,5,NULL,'ACTIVE','M',25,52),(748,'PRANJAL SAMANTA',5,5,NULL,'ACTIVE','M',25,53),(749,'SWARAJ DAS',5,5,NULL,'ACTIVE','M',25,54),(750,'ASISH DAS',5,5,NULL,'ACTIVE','M',25,55),(751,'RISHABH GHOSH',5,5,NULL,'ACTIVE','M',25,56),(752,'SATWIK DAS',5,5,NULL,'ACTIVE','M',25,57),(753,'SAYAN SAMANTA',5,5,NULL,'ACTIVE','M',25,58),(754,'RANGAN ADAK',5,8,NULL,'ACTIVE','M',25,43),(755,'AKASH KOLEY',5,8,NULL,'ACTIVE','M',25,44),(756,'SUBHAJIT GHOSH',5,8,NULL,'ACTIVE','M',25,45),(757,'ACHINTO GHOSH',5,8,NULL,'ACTIVE','M',25,46),(758,'SHANKAR GHOSH',5,8,NULL,'ACTIVE','M',25,47),(759,'PROLAY DAS',5,8,NULL,'ACTIVE','M',25,48),(760,'ROHIT RAUTH',5,8,NULL,'ACTIVE','M',25,49),(761,'SAKIL AKTAR KHAN',5,8,NULL,'ACTIVE','M',25,50),(762,'SK. NISATH ISLAM',5,8,NULL,'ACTIVE','M',25,51),(763,'SOHOM DAS',5,8,NULL,'ACTIVE','M',25,52),(764,'BIJOY SANTRA',5,8,NULL,'ACTIVE','M',25,53),(765,'JUNAID MOLLICK',5,8,NULL,'ACTIVE','M',25,54),(766,'DEPAM SADHUKHAN',5,7,NULL,'ACTIVE','M',25,17),(767,'SHAYAK SENGUPTA',5,7,NULL,'ACTIVE','M',25,18),(768,'BITTU MANNA',5,7,NULL,'ACTIVE','M',25,19),(769,'PRIYAM DAS',5,7,NULL,'ACTIVE','M',25,20),(770,'ISHAN SINGH',5,7,NULL,'ACTIVE','M',25,21),(771,'BARUN ROY',5,7,NULL,'ACTIVE','M',25,22),(772,'ANKAN KARAR',5,7,NULL,'ACTIVE','M',25,23),(773,'MAINAK DAS',5,7,NULL,'ACTIVE','M',25,24),(774,'AYAN SAHA',5,6,NULL,'ACTIVE','M',25,72),(775,'SAMARESH MONDAL',5,9,NULL,'ACTIVE','M',25,5),(776,'RUPAM MANNA',5,9,NULL,'ACTIVE','M',25,6),(777,'DEBMALYA GHOSH',5,9,NULL,'ACTIVE','M',25,7),(778,'SUMIT MONDAL',5,9,NULL,'ACTIVE','M',25,8),(779,'RUPANKAR GHOSH',5,9,NULL,'ACTIVE','M',25,9),(780,'RIDDHI CHAKRABORTY',5,9,NULL,'ACTIVE','M',25,10),(781,'ABHIJIT DEYALI',5,9,NULL,'ACTIVE','M',25,11),(782,'SATYAM GHOSH',5,9,NULL,'ACTIVE','M',25,12),(783,'SOUMIK MALIK',5,9,NULL,'ACTIVE','M',25,13),(784,'SOUVIK SEN',5,9,NULL,'ACTIVE','M',25,14),(785,'RUDRANIL GHOSH',5,10,NULL,'ACTIVE','M',25,1),(786,'SK. ASHIK',5,10,NULL,'ACTIVE','M',25,2),(787,'MEHEFUSH KHAN',5,10,NULL,'ACTIVE','M',25,3),(788,'diya das',10,2,NULL,'ACTIVE','F',25,32),(789,'faijal islam mondal',10,2,NULL,'ACTIVE','M',25,33),(790,'snigdha sharma',10,2,NULL,'ACTIVE','F',25,34),(791,'afrina khatun',10,2,NULL,'ACTIVE','F',25,35),(792,'nasrin khatun',10,2,NULL,'ACTIVE','F',25,36),(793,'adil ali sahana',10,2,NULL,'ACTIVE','M',25,37),(794,'iyaomin parvin',10,2,NULL,'ACTIVE','F',25,38),(795,'KULSUM KHATUN',10,2,NULL,'ACTIVE','F',25,39),(796,'SUMAIYA KHATUN ',10,2,NULL,'ACTIVE','F',25,40),(797,'dhiman singha',10,2,NULL,'ACTIVE','M',25,41),(798,'riyanshu panja',10,2,NULL,'ACTIVE','M',25,42),(799,'raghav biswas',10,3,NULL,'ACTIVE','M',25,62),(800,'rummana khatun',10,3,NULL,'ACTIVE','F',25,63),(801,'roshan prajapati',10,3,NULL,'ACTIVE','M',25,64),(802,'soumyajit dutta',10,3,NULL,'ACTIVE','M',25,65),(803,'sohini khatun',10,3,NULL,'ACTIVE','F',25,66),(804,'chandana malik',10,3,NULL,'ACTIVE','F',25,67),(805,'tutul gupta',10,3,NULL,'ACTIVE','F',25,68),(806,'aniruddha gupta',10,3,NULL,'ACTIVE','M',25,69),(807,'ramia khatun',10,3,NULL,'ACTIVE','F',25,70),(808,'soujanya jana',10,3,NULL,'ACTIVE','F',25,71),(809,'SAMRIN MONDAL ',10,4,NULL,'ACTIVE','F',25,64),(810,'addina parvin',10,4,NULL,'ACTIVE','F',25,65),(811,'alipsa khatun',10,4,NULL,'ACTIVE','F',25,66),(812,'babai kunai',10,4,NULL,'ACTIVE','M',25,67),(813,'jubaiya khatun',10,4,NULL,'ACTIVE','F',25,68),(814,'rima khatun',10,4,NULL,'ACTIVE','F',25,69),(815,'md. hammim hossain',10,4,NULL,'ACTIVE','M',25,70),(816,'nursha khatun',10,4,NULL,'ACTIVE','F',25,71),(817,'abdulla mondal',10,4,NULL,'ACTIVE','M',25,72),(818,'md. mijanur rahaman',10,4,NULL,'ACTIVE','M',25,73),(819,'Dipika Naskar',11,5,NULL,'ACTIVE','F',25,59),(820,'Disha saha',11,5,NULL,'ACTIVE','F',25,60),(821,'arifa khatun',11,5,NULL,'ACTIVE','F',25,61),(822,'afsana khatun',11,5,NULL,'ACTIVE','F',25,62),(823,'atreyi nag',11,5,NULL,'ACTIVE','F',25,63),(824,'farhana khatun',11,5,NULL,'ACTIVE','F',25,64),(825,'dipti pal',11,5,NULL,'ACTIVE','F',25,65),(826,'rina dutta',11,6,NULL,'ACTIVE','F',25,73),(827,'rupsa sarkar',11,6,NULL,'ACTIVE','F',25,74),(828,'ajija khatun',11,6,NULL,'ACTIVE','F',25,75),(829,'manika sadhukhan',11,6,NULL,'ACTIVE','F',25,76),(830,'rinki das',11,6,NULL,'ACTIVE','F',25,77),(831,'maryam molla',11,7,NULL,'ACTIVE','F',25,25),(832,'kaniz fatema',11,7,NULL,'ACTIVE','F',25,26),(833,'piyasha ray',11,7,NULL,'DELETED','F',25,27),(834,'trisha gayen',11,7,NULL,'DELETED','F',25,28),(835,'hena khatun',11,7,NULL,'DELETED','F',25,29),(836,'trishannita',11,7,NULL,'DELETED','F',25,30),(837,'piyasha ray',11,8,NULL,'ACTIVE','F',25,55),(838,'trisha gayen',11,8,NULL,'ACTIVE','F',25,56),(839,'hena khatun',11,8,NULL,'ACTIVE','F',25,57),(840,'trishannita',11,8,NULL,'ACTIVE','F',25,58),(841,'ankita ray',11,8,NULL,'ACTIVE','F',25,59),(842,'chaitali maity',11,8,NULL,'ACTIVE','F',25,60),(843,'souprika ghosh',11,8,NULL,'ACTIVE','F',25,61),(844,'sathi naskar',11,8,NULL,'ACTIVE','F',25,62),(845,'debi naskar',11,8,NULL,'ACTIVE','F',25,63),(846,'puja porel',11,8,NULL,'ACTIVE','F',25,64),(847,'samiya khatun',11,8,NULL,'ACTIVE','F',25,65),(848,'nargis khatun',11,9,NULL,'ACTIVE','F',25,15),(849,'rojina khatun',11,9,NULL,'ACTIVE','F',25,16),(850,'habiba khatun',11,9,NULL,'ACTIVE','F',25,17),(851,'sania khatun ',11,9,NULL,'ACTIVE','F',25,18),(852,'diposree gupta',11,9,NULL,'ACTIVE','F',25,19),(853,'kehkashan tabbasum',11,9,NULL,'ACTIVE','F',25,20),(854,'smita dutta',11,9,NULL,'ACTIVE','F',25,21),(855,'anisha khatun',11,5,NULL,'ACTIVE','F',25,66),(856,'nargis tarafdar',11,5,NULL,'ACTIVE','F',25,67),(857,'muskan khatun',11,5,NULL,'ACTIVE','F',25,68),(858,'ishika mondal',11,10,NULL,'ACTIVE','F',25,4),(859,'ipsita ballav',11,9,NULL,'ACTIVE','F',25,22),(860,'rai kumar',10,2,NULL,'ACTIVE','F',25,43),(861,'sk rumesha khatun',10,4,NULL,'ACTIVE','F',25,74),(862,'binoyanti mondal',10,4,NULL,'ACTIVE','F',25,75),(863,'soma boral',15,5,NULL,'ACTIVE','F',25,69),(864,'priya ghosh',13,5,NULL,'ACTIVE','F',25,70),(865,'ansura khatun',13,5,NULL,'ACTIVE','F',25,71),(866,'soumyadip ghosh',13,5,NULL,'ACTIVE','M',25,72),(867,'sridhar atta',13,10,NULL,'ACTIVE','M',25,5),(868,'priyanka boral',13,8,NULL,'ACTIVE','F',25,66),(869,'tisha basu',13,8,NULL,'ACTIVE','F',25,67),(870,'soumyajit pal',13,8,NULL,'ACTIVE','M',25,68),(871,'sameya boral',14,2,NULL,'ACTIVE','F',25,44),(872,'snigdha chakraborty',14,4,NULL,'ACTIVE','F',25,76),(873,'riju manna',13,6,NULL,'ACTIVE','M',25,78),(874,'soumyo mondal',5,5,NULL,'ACTIVE','M',25,73),(875,'biplob pal',16,9,NULL,'ACTIVE','M',25,23),(876,'sonkha barh',16,9,NULL,'ACTIVE','M',25,24),(877,'ronobir dey',5,6,NULL,'ACTIVE','M',25,79),(878,'aritra mandal',5,5,NULL,'ACTIVE','M',25,74),(879,'debraj nag',17,4,NULL,'ACTIVE','M',25,77),(880,'aarit das',18,4,NULL,'ACTIVE','M',25,78),(881,'ankush dolui',18,4,NULL,'ACTIVE','M',25,79),(882,'joyotirish sinha',18,2,NULL,'ACTIVE','F',25,45),(883,'soumili paul',18,3,NULL,'ACTIVE','F',25,72),(884,'jishnu bhar',6,6,NULL,'ACTIVE','M',25,80),(885,'najira khatun',11,5,NULL,'ACTIVE','F',25,75),(886,'juairiya nasrin',11,6,NULL,'ACTIVE','F',25,81),(887,'munia khatun',11,6,NULL,'ACTIVE','F',25,82),(888,'mafuja khatun',19,4,NULL,'ACTIVE','F',25,80),(889,'alisha khatun',19,4,NULL,'ACTIVE','F',25,81),(890,'monalisha sardar',19,4,NULL,'ACTIVE','F',25,82),(891,'kaifa khatun',19,4,NULL,'ACTIVE','F',25,83),(892,'srijita roy',19,4,NULL,'ACTIVE','F',25,84),(893,'joyshree ray',19,4,NULL,'ACTIVE','F',25,85),(894,'humayira khatun',19,4,NULL,'ACTIVE','F',25,86),(895,'sk jannatul firdous',19,4,NULL,'ACTIVE','F',25,87),(896,'sk farzan',19,4,NULL,'ACTIVE','M',25,88),(897,'md umair laskar',19,4,NULL,'ACTIVE','M',25,89),(898,'sk nowsim',19,4,NULL,'ACTIVE','M',25,90),(899,'sk abdulla ali',19,3,NULL,'ACTIVE','M',25,73),(900,'mohamin ali mallick',19,2,NULL,'ACTIVE','M',25,46),(901,'labani dutta',19,3,NULL,'ACTIVE','F',25,74),(902,'fatema khatun',19,3,NULL,'ACTIVE','F',25,75),(903,'sania aka khatun',19,3,NULL,'ACTIVE','F',25,76),(904,'yeasmina khatun ',19,3,NULL,'ACTIVE','F',25,77),(905,'rabia basri',19,3,NULL,'ACTIVE','F',25,78),(906,'sukaina khatun',19,2,NULL,'ACTIVE','F',25,47),(907,'sayeba khatun',19,2,NULL,'ACTIVE','F',25,48),(908,'sneha khatun',19,2,NULL,'ACTIVE','F',25,49),(909,'mariya khatun',19,2,NULL,'ACTIVE','F',25,50),(910,'sohan mollick',19,2,NULL,'ACTIVE','M',25,51),(911,'anushree roy',13,10,NULL,'ACTIVE','F',25,6),(912,'suniti mondal',13,10,NULL,'ACTIVE','F',25,7),(913,'ananya malik',13,10,NULL,'ACTIVE','F',25,8),(914,'sonali ghosh',13,10,NULL,'ACTIVE','F',25,9),(915,'hitabrata sabui',6,2,NULL,'ACTIVE','M',25,52),(916,'himangshu ghosh',6,3,NULL,'ACTIVE','M',25,79),(917,'soumojit dhara',20,4,NULL,'ACTIVE','M',25,91),(918,'ayush pal',20,4,NULL,'ACTIVE','M',25,92),(919,'priyojit ghosh',20,4,NULL,'ACTIVE','M',25,93),(920,'payel sen',20,4,NULL,'ACTIVE','F',25,94),(921,'sanchita majhi',20,4,NULL,'ACTIVE','F',25,95),(922,'ishani basu',20,4,NULL,'ACTIVE','F',25,96),(923,'neha ghosh',20,4,NULL,'ACTIVE','F',25,97),(924,'anewsa hazra',21,2,NULL,'ACTIVE','F',25,53),(925,'arna roy',21,2,NULL,'ACTIVE','F',25,54),(926,'arnab hazra',21,2,NULL,'ACTIVE','M',25,55),(927,'samriddha roy',21,2,NULL,'ACTIVE','M',25,56),(928,'adrish ghosh',21,2,NULL,'ACTIVE','M',25,57),(929,'ayush das',21,2,NULL,'ACTIVE','M',25,58),(930,'ahana das',21,3,NULL,'ACTIVE','F',25,80),(931,'adrika nandi',21,3,NULL,'ACTIVE','F',25,81),(932,'anushka nandi',21,3,NULL,'ACTIVE','F',25,82),(933,'ritika chai',21,3,NULL,'ACTIVE','F',25,83),(934,'anish kanjilal',21,3,NULL,'ACTIVE','M',25,84),(935,'anit gaunia',21,3,NULL,'ACTIVE','M',25,85),(936,'pritam dhang',21,3,NULL,'ACTIVE','M',25,86),(937,'sayan jana',21,4,NULL,'ACTIVE','M',25,98),(938,'sauransu mudi',21,4,NULL,'ACTIVE','M',25,99),(939,'sreyan biswas',21,4,NULL,'ACTIVE','M',25,100),(940,'arnab jha',21,4,NULL,'ACTIVE','M',25,101),(941,'rajdip ghosh',21,4,NULL,'ACTIVE','M',25,102),(942,'debarpan roy',21,5,NULL,'ACTIVE','M',25,77),(943,'ankan shee',21,5,NULL,'ACTIVE','M',25,76),(944,'souparna sarkar',21,5,NULL,'ACTIVE','M',25,78),(945,'anik choudhury',21,5,NULL,'ACTIVE','M',25,79),(946,'monojit hait',21,5,NULL,'ACTIVE','M',25,80),(947,'subhadip pan',21,5,NULL,'ACTIVE','M',25,81),(948,'piyasa das',21,4,NULL,'ACTIVE','F',25,103),(949,'araddha mahato',21,4,NULL,'ACTIVE','F',25,104),(950,'tania kar',21,4,NULL,'ACTIVE','F',25,105),(951,'oishani pal',21,4,NULL,'ACTIVE','F',25,106),(952,'biraj genree',5,2,NULL,'ACTIVE','M',25,59),(953,'soyel laskar',19,4,NULL,'ACTIVE','M',25,107),(954,'anshu haldar',6,5,NULL,'ACTIVE','M',25,82),(955,'sahil ghoshal',6,5,NULL,'ACTIVE','M',25,83),(956,'srija bagui',22,2,NULL,'ACTIVE','F',25,60),(957,'rai patra',22,2,NULL,'ACTIVE','F',25,61),(958,'soumodeep bagi',22,2,NULL,'ACTIVE','M',25,62),(959,'abhra polen',22,3,NULL,'ACTIVE','M',25,87),(960,'raj chakraborty',22,3,NULL,'ACTIVE','M',25,88),(961,'paromita ghosh',22,3,NULL,'ACTIVE','F',25,89),(962,'soumani chakraborty',22,3,NULL,'ACTIVE','F',25,90),(963,'sanghamitra palui',22,4,NULL,'ACTIVE','F',25,108),(964,'anindita pramanik',22,5,NULL,'ACTIVE','F',25,84),(965,'rubi nebu',22,5,NULL,'ACTIVE','F',25,85),(966,'oishik das',23,2,NULL,'ACTIVE','M',25,63);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmspage`
--

DROP TABLE IF EXISTS `cmspage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmspage` (
  `pageid` int NOT NULL DEFAULT '0',
  `pageName` varchar(45) NOT NULL,
  `pagePath` varchar(45) DEFAULT NULL,
  `createdon` varchar(45) DEFAULT NULL,
  `modifiedon` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pageid`,`pageName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmspage`
--

LOCK TABLES `cmspage` WRITE;
/*!40000 ALTER TABLE `cmspage` DISABLE KEYS */;
/*!40000 ALTER TABLE `cmspage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `classes` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `result_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (25,'Medha Sandhan Pariksha 2023','2023-09-10','2,3,4,5,6,7,8,9,10,11','ACTIVE',NULL);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam2venuerel`
--

DROP TABLE IF EXISTS `exam2venuerel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam2venuerel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `source` int DEFAULT NULL,
  `target` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam2venuerel`
--

LOCK TABLES `exam2venuerel` WRITE;
/*!40000 ALTER TABLE `exam2venuerel` DISABLE KEYS */;
INSERT INTO `exam2venuerel` VALUES (20,25,2);
/*!40000 ALTER TABLE `exam2venuerel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marksheet`
--

DROP TABLE IF EXISTS `marksheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marksheet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marks` int NOT NULL,
  `fullmarks` int NOT NULL,
  `cad2rollrel` int NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marksheet`
--

LOCK TABLES `marksheet` WRITE;
/*!40000 ALTER TABLE `marksheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `marksheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rollnumber`
--

DROP TABLE IF EXISTS `rollnumber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rollnumber` (
  `id` int NOT NULL,
  `rel_id` int DEFAULT NULL,
  `roll` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rollnumber`
--

LOCK TABLES `rollnumber` WRITE;
/*!40000 ALTER TABLE `rollnumber` DISABLE KEYS */;
/*!40000 ALTER TABLE `rollnumber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'First Half','1,2,3,4','11:00 AM',NULL);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  `contactno` varchar(45) DEFAULT NULL,
  `pocname` varchar(100) DEFAULT NULL,
  `picturepath` varchar(255) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'ACTIVE',
  `venue` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (5,'Garalgacha High School','Garalgacha, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(6,'Sri Ramakrishna Sishu Tirtha H.S','Dankuni, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(7,'Barijahaty Girls High School','Barijahaty, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(8,'Alipur Satish Chandra Pal HS','Kolkata',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(9,'Garalgacha Balika Vidyalaya ','Garalgacha, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(10,'Monoharpur Chamundamata Primary School','Monoharpur, Dankuni ',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(11,'Sree Ramkrishna Vidyashram Girls\' HS','Dankuni , Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(13,'Kalachara High School','Kalachara, Chanditala',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(14,'Kalachara Primary School','Kalachara, Chanditala',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(15,'Janai B.D.G Girls High School','Janai, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(16,'Jangalpara K.D High School','Jangalpara, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(17,'Lalbaba Sishu Ganoday','Dankuni, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(18,'Shishu Shikshyatan UNMES','Bally, Howrah',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(19,'Annapurna Primary School','Dankuni, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(20,'Brahmandanga Primary School','Brahmandanga, Chanditala',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(21,'Abhedananda Siksha Mandir','Dankuni, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(22,'Baliadanga Makhanlal Primary School','Beledganga, Barijahati',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2),(23,'Garalgacha High School (Primary)','Garalgacha, Hooghly',NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE',2);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `pk` int NOT NULL AUTO_INCREMENT,
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk`,`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'09001','Garalgacha Science Club','1af684b708734a3567dc844e62e3fd6ee3d5517cd199aa13b43b819ac4191d3d');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'ACTIVE',
  `address` varchar(255) DEFAULT NULL,
  `convenor` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `picture` varchar(45) DEFAULT 'school.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (2,'Garalgacha Balika Vidyalaya','09001','ACTIVE','Garalgacha, Chanditala, West Bengal, Pincode - 712708','Shekhar Chnadra Jana','9934554120','gbv.jpg');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-01 23:13:00
